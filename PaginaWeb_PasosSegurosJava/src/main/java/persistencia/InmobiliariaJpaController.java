/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import logica.Empleado;
import java.util.ArrayList;
import java.util.List;
import logica.Contrato;
import logica.Inmobiliaria;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class InmobiliariaJpaController implements Serializable {

    public InmobiliariaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public InmobiliariaJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }
    
    public void create(Inmobiliaria inmobiliaria) {
        if (inmobiliaria.getEmpleado() == null) {
            inmobiliaria.setEmpleado(new ArrayList<Empleado>());
        }
        if (inmobiliaria.getContrato() == null) {
            inmobiliaria.setContrato(new ArrayList<Contrato>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleado> attachedEmpleado = new ArrayList<Empleado>();
            for (Empleado empleadoEmpleadoToAttach : inmobiliaria.getEmpleado()) {
                empleadoEmpleadoToAttach = em.getReference(empleadoEmpleadoToAttach.getClass(), empleadoEmpleadoToAttach.getIdPersona());
                attachedEmpleado.add(empleadoEmpleadoToAttach);
            }
            inmobiliaria.setEmpleado(attachedEmpleado);
            List<Contrato> attachedContrato = new ArrayList<Contrato>();
            for (Contrato contratoContratoToAttach : inmobiliaria.getContrato()) {
                contratoContratoToAttach = em.getReference(contratoContratoToAttach.getClass(), contratoContratoToAttach.getIdContrato());
                attachedContrato.add(contratoContratoToAttach);
            }
            inmobiliaria.setContrato(attachedContrato);
            em.persist(inmobiliaria);
            for (Empleado empleadoEmpleado : inmobiliaria.getEmpleado()) {
                Inmobiliaria oldInmobiliariaOfEmpleadoEmpleado = empleadoEmpleado.getInmobiliaria();
                empleadoEmpleado.setInmobiliaria(inmobiliaria);
                empleadoEmpleado = em.merge(empleadoEmpleado);
                if (oldInmobiliariaOfEmpleadoEmpleado != null) {
                    oldInmobiliariaOfEmpleadoEmpleado.getEmpleado().remove(empleadoEmpleado);
                    oldInmobiliariaOfEmpleadoEmpleado = em.merge(oldInmobiliariaOfEmpleadoEmpleado);
                }
            }
            for (Contrato contratoContrato : inmobiliaria.getContrato()) {
                Inmobiliaria oldInmobiliariaOfContratoContrato = contratoContrato.getInmobiliaria();
                contratoContrato.setInmobiliaria(inmobiliaria);
                contratoContrato = em.merge(contratoContrato);
                if (oldInmobiliariaOfContratoContrato != null) {
                    oldInmobiliariaOfContratoContrato.getContrato().remove(contratoContrato);
                    oldInmobiliariaOfContratoContrato = em.merge(oldInmobiliariaOfContratoContrato);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inmobiliaria inmobiliaria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inmobiliaria persistentInmobiliaria = em.find(Inmobiliaria.class, inmobiliaria.getIdInmobiliaria());
            List<Empleado> empleadoOld = persistentInmobiliaria.getEmpleado();
            List<Empleado> empleadoNew = inmobiliaria.getEmpleado();
            List<Contrato> contratoOld = persistentInmobiliaria.getContrato();
            List<Contrato> contratoNew = inmobiliaria.getContrato();
            List<Empleado> attachedEmpleadoNew = new ArrayList<Empleado>();
            for (Empleado empleadoNewEmpleadoToAttach : empleadoNew) {
                empleadoNewEmpleadoToAttach = em.getReference(empleadoNewEmpleadoToAttach.getClass(), empleadoNewEmpleadoToAttach.getIdPersona());
                attachedEmpleadoNew.add(empleadoNewEmpleadoToAttach);
            }
            empleadoNew = attachedEmpleadoNew;
            inmobiliaria.setEmpleado(empleadoNew);
            List<Contrato> attachedContratoNew = new ArrayList<Contrato>();
            for (Contrato contratoNewContratoToAttach : contratoNew) {
                contratoNewContratoToAttach = em.getReference(contratoNewContratoToAttach.getClass(), contratoNewContratoToAttach.getIdContrato());
                attachedContratoNew.add(contratoNewContratoToAttach);
            }
            contratoNew = attachedContratoNew;
            inmobiliaria.setContrato(contratoNew);
            inmobiliaria = em.merge(inmobiliaria);
            for (Empleado empleadoOldEmpleado : empleadoOld) {
                if (!empleadoNew.contains(empleadoOldEmpleado)) {
                    empleadoOldEmpleado.setInmobiliaria(null);
                    empleadoOldEmpleado = em.merge(empleadoOldEmpleado);
                }
            }
            for (Empleado empleadoNewEmpleado : empleadoNew) {
                if (!empleadoOld.contains(empleadoNewEmpleado)) {
                    Inmobiliaria oldInmobiliariaOfEmpleadoNewEmpleado = empleadoNewEmpleado.getInmobiliaria();
                    empleadoNewEmpleado.setInmobiliaria(inmobiliaria);
                    empleadoNewEmpleado = em.merge(empleadoNewEmpleado);
                    if (oldInmobiliariaOfEmpleadoNewEmpleado != null && !oldInmobiliariaOfEmpleadoNewEmpleado.equals(inmobiliaria)) {
                        oldInmobiliariaOfEmpleadoNewEmpleado.getEmpleado().remove(empleadoNewEmpleado);
                        oldInmobiliariaOfEmpleadoNewEmpleado = em.merge(oldInmobiliariaOfEmpleadoNewEmpleado);
                    }
                }
            }
            for (Contrato contratoOldContrato : contratoOld) {
                if (!contratoNew.contains(contratoOldContrato)) {
                    contratoOldContrato.setInmobiliaria(null);
                    contratoOldContrato = em.merge(contratoOldContrato);
                }
            }
            for (Contrato contratoNewContrato : contratoNew) {
                if (!contratoOld.contains(contratoNewContrato)) {
                    Inmobiliaria oldInmobiliariaOfContratoNewContrato = contratoNewContrato.getInmobiliaria();
                    contratoNewContrato.setInmobiliaria(inmobiliaria);
                    contratoNewContrato = em.merge(contratoNewContrato);
                    if (oldInmobiliariaOfContratoNewContrato != null && !oldInmobiliariaOfContratoNewContrato.equals(inmobiliaria)) {
                        oldInmobiliariaOfContratoNewContrato.getContrato().remove(contratoNewContrato);
                        oldInmobiliariaOfContratoNewContrato = em.merge(oldInmobiliariaOfContratoNewContrato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = inmobiliaria.getIdInmobiliaria();
                if (findInmobiliaria(id) == null) {
                    throw new NonexistentEntityException("The inmobiliaria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inmobiliaria inmobiliaria;
            try {
                inmobiliaria = em.getReference(Inmobiliaria.class, id);
                inmobiliaria.getIdInmobiliaria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inmobiliaria with id " + id + " no longer exists.", enfe);
            }
            List<Empleado> empleado = inmobiliaria.getEmpleado();
            for (Empleado empleadoEmpleado : empleado) {
                empleadoEmpleado.setInmobiliaria(null);
                empleadoEmpleado = em.merge(empleadoEmpleado);
            }
            List<Contrato> contrato = inmobiliaria.getContrato();
            for (Contrato contratoContrato : contrato) {
                contratoContrato.setInmobiliaria(null);
                contratoContrato = em.merge(contratoContrato);
            }
            em.remove(inmobiliaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inmobiliaria> findInmobiliariaEntities() {
        return findInmobiliariaEntities(true, -1, -1);
    }

    public List<Inmobiliaria> findInmobiliariaEntities(int maxResults, int firstResult) {
        return findInmobiliariaEntities(false, maxResults, firstResult);
    }

    private List<Inmobiliaria> findInmobiliariaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inmobiliaria.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Inmobiliaria findInmobiliaria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inmobiliaria.class, id);
        } finally {
            em.close();
        }
    }

    public int getInmobiliariaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inmobiliaria> rt = cq.from(Inmobiliaria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
