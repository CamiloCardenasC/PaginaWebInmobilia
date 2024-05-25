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
import java.util.List;
import logica.Cargo;
import logica.Empleado;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class CargoJpaController implements Serializable {

    public CargoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public CargoJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }

    public void create(Cargo cargo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleado = cargo.getEmpleado();
            if (empleado != null) {
                empleado = em.getReference(empleado.getClass(), empleado.getIdPersona());
                cargo.setEmpleado(empleado);
            }
            em.persist(cargo);
            if (empleado != null) {
                Cargo oldCargoOfEmpleado = empleado.getCargo();
                if (oldCargoOfEmpleado != null) {
                    oldCargoOfEmpleado.setEmpleado(null);
                    oldCargoOfEmpleado = em.merge(oldCargoOfEmpleado);
                }
                empleado.setCargo(cargo);
                empleado = em.merge(empleado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cargo cargo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargo persistentCargo = em.find(Cargo.class, cargo.getIdCargo());
            Empleado empleadoOld = persistentCargo.getEmpleado();
            Empleado empleadoNew = cargo.getEmpleado();
            if (empleadoNew != null) {
                empleadoNew = em.getReference(empleadoNew.getClass(), empleadoNew.getIdPersona());
                cargo.setEmpleado(empleadoNew);
            }
            cargo = em.merge(cargo);
            if (empleadoOld != null && !empleadoOld.equals(empleadoNew)) {
                empleadoOld.setCargo(null);
                empleadoOld = em.merge(empleadoOld);
            }
            if (empleadoNew != null && !empleadoNew.equals(empleadoOld)) {
                Cargo oldCargoOfEmpleado = empleadoNew.getCargo();
                if (oldCargoOfEmpleado != null) {
                    oldCargoOfEmpleado.setEmpleado(null);
                    oldCargoOfEmpleado = em.merge(oldCargoOfEmpleado);
                }
                empleadoNew.setCargo(cargo);
                empleadoNew = em.merge(empleadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cargo.getIdCargo();
                if (findCargo(id) == null) {
                    throw new NonexistentEntityException("The cargo with id " + id + " no longer exists.");
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
            Cargo cargo;
            try {
                cargo = em.getReference(Cargo.class, id);
                cargo.getIdCargo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargo with id " + id + " no longer exists.", enfe);
            }
            Empleado empleado = cargo.getEmpleado();
            if (empleado != null) {
                empleado.setCargo(null);
                empleado = em.merge(empleado);
            }
            em.remove(cargo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cargo> findCargoEntities() {
        return findCargoEntities(true, -1, -1);
    }

    public List<Cargo> findCargoEntities(int maxResults, int firstResult) {
        return findCargoEntities(false, maxResults, firstResult);
    }

    private List<Cargo> findCargoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cargo.class));
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

    public Cargo findCargo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cargo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cargo> rt = cq.from(Cargo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
