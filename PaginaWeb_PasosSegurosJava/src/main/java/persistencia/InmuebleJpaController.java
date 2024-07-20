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
import logica.TipoInmueble;
import logica.EstadoInmueble;
import logica.Empleado;
import logica.Contrato;
import logica.Reservacion;
import java.util.ArrayList;
import java.util.List;
import logica.Inmueble;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class InmuebleJpaController implements Serializable {

    public InmuebleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public InmuebleJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }
    
    public void create(Inmueble inmueble) {
        if (inmueble.getReservacion() == null) {
            inmueble.setReservacion(new ArrayList<Reservacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoInmueble tipoInmueble = inmueble.getTipoInmueble();
            if (tipoInmueble != null) {
                tipoInmueble = em.getReference(tipoInmueble.getClass(), tipoInmueble.getIdTipoInmueble());
                inmueble.setTipoInmueble(tipoInmueble);
            }
            EstadoInmueble estadoInmueble = inmueble.getEstadoInmueble();
            if (estadoInmueble != null) {
                estadoInmueble = em.getReference(estadoInmueble.getClass(), estadoInmueble.getIdEstadoInmueble());
                inmueble.setEstadoInmueble(estadoInmueble);
            }
            Empleado empleado = inmueble.getEmpleado();
            if (empleado != null) {
                empleado = em.getReference(empleado.getClass(), empleado.getIdPersona());
                inmueble.setEmpleado(empleado);
            }
            Contrato contrato = inmueble.getContrato();
            if (contrato != null) {
                contrato = em.getReference(contrato.getClass(), contrato.getIdContrato());
                inmueble.setContrato(contrato);
            }
            List<Reservacion> attachedReservacion = new ArrayList<Reservacion>();
            for (Reservacion reservacionReservacionToAttach : inmueble.getReservacion()) {
                reservacionReservacionToAttach = em.getReference(reservacionReservacionToAttach.getClass(), reservacionReservacionToAttach.getIdReservacion());
                attachedReservacion.add(reservacionReservacionToAttach);
            }
            inmueble.setReservacion(attachedReservacion);
            em.persist(inmueble);
            if (tipoInmueble != null) {
                Inmueble oldInmuebleOfTipoInmueble = tipoInmueble.getInmueble();
                if (oldInmuebleOfTipoInmueble != null) {
                    oldInmuebleOfTipoInmueble.setTipoInmueble(null);
                    oldInmuebleOfTipoInmueble = em.merge(oldInmuebleOfTipoInmueble);
                }
                tipoInmueble.setInmueble(inmueble);
                tipoInmueble = em.merge(tipoInmueble);
            }
            if (estadoInmueble != null) {
                Inmueble oldInmuebleOfEstadoInmueble = estadoInmueble.getInmueble();
                if (oldInmuebleOfEstadoInmueble != null) {
                    oldInmuebleOfEstadoInmueble.setEstadoInmueble(null);
                    oldInmuebleOfEstadoInmueble = em.merge(oldInmuebleOfEstadoInmueble);
                }
                estadoInmueble.setInmueble(inmueble);
                estadoInmueble = em.merge(estadoInmueble);
            }
            if (empleado != null) {
                empleado.getInmueble().add(inmueble);
                empleado = em.merge(empleado);
            }
            if (contrato != null) {
                Inmueble oldInmuebleOfContrato = contrato.getInmueble();
                if (oldInmuebleOfContrato != null) {
                    oldInmuebleOfContrato.setContrato(null);
                    oldInmuebleOfContrato = em.merge(oldInmuebleOfContrato);
                }
                contrato.setInmueble(inmueble);
                contrato = em.merge(contrato);
            }
            for (Reservacion reservacionReservacion : inmueble.getReservacion()) {
                Inmueble oldInmuebleOfReservacionReservacion = reservacionReservacion.getInmueble();
                reservacionReservacion.setInmueble(inmueble);
                reservacionReservacion = em.merge(reservacionReservacion);
                if (oldInmuebleOfReservacionReservacion != null) {
                    oldInmuebleOfReservacionReservacion.getReservacion().remove(reservacionReservacion);
                    oldInmuebleOfReservacionReservacion = em.merge(oldInmuebleOfReservacionReservacion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inmueble inmueble) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inmueble persistentInmueble = em.find(Inmueble.class, inmueble.getIdInmueble());
            TipoInmueble tipoInmuebleOld = persistentInmueble.getTipoInmueble();
            TipoInmueble tipoInmuebleNew = inmueble.getTipoInmueble();
            EstadoInmueble estadoInmuebleOld = persistentInmueble.getEstadoInmueble();
            EstadoInmueble estadoInmuebleNew = inmueble.getEstadoInmueble();
            Empleado empleadoOld = persistentInmueble.getEmpleado();
            Empleado empleadoNew = inmueble.getEmpleado();
            Contrato contratoOld = persistentInmueble.getContrato();
            Contrato contratoNew = inmueble.getContrato();
            List<Reservacion> reservacionOld = persistentInmueble.getReservacion();
            List<Reservacion> reservacionNew = inmueble.getReservacion();
            if (tipoInmuebleNew != null) {
                tipoInmuebleNew = em.getReference(tipoInmuebleNew.getClass(), tipoInmuebleNew.getIdTipoInmueble());
                inmueble.setTipoInmueble(tipoInmuebleNew);
            }
            if (estadoInmuebleNew != null) {
                estadoInmuebleNew = em.getReference(estadoInmuebleNew.getClass(), estadoInmuebleNew.getIdEstadoInmueble());
                inmueble.setEstadoInmueble(estadoInmuebleNew);
            }
            if (empleadoNew != null) {
                empleadoNew = em.getReference(empleadoNew.getClass(), empleadoNew.getIdPersona());
                inmueble.setEmpleado(empleadoNew);
            }
            if (contratoNew != null) {
                contratoNew = em.getReference(contratoNew.getClass(), contratoNew.getIdContrato());
                inmueble.setContrato(contratoNew);
            }
            List<Reservacion> attachedReservacionNew = new ArrayList<Reservacion>();
            for (Reservacion reservacionNewReservacionToAttach : reservacionNew) {
                reservacionNewReservacionToAttach = em.getReference(reservacionNewReservacionToAttach.getClass(), reservacionNewReservacionToAttach.getIdReservacion());
                attachedReservacionNew.add(reservacionNewReservacionToAttach);
            }
            reservacionNew = attachedReservacionNew;
            inmueble.setReservacion(reservacionNew);
            inmueble = em.merge(inmueble);
            if (tipoInmuebleOld != null && !tipoInmuebleOld.equals(tipoInmuebleNew)) {
                tipoInmuebleOld.setInmueble(null);
                tipoInmuebleOld = em.merge(tipoInmuebleOld);
            }
            if (tipoInmuebleNew != null && !tipoInmuebleNew.equals(tipoInmuebleOld)) {
                Inmueble oldInmuebleOfTipoInmueble = tipoInmuebleNew.getInmueble();
                if (oldInmuebleOfTipoInmueble != null) {
                    oldInmuebleOfTipoInmueble.setTipoInmueble(null);
                    oldInmuebleOfTipoInmueble = em.merge(oldInmuebleOfTipoInmueble);
                }
                tipoInmuebleNew.setInmueble(inmueble);
                tipoInmuebleNew = em.merge(tipoInmuebleNew);
            }
            if (estadoInmuebleOld != null && !estadoInmuebleOld.equals(estadoInmuebleNew)) {
                estadoInmuebleOld.setInmueble(null);
                estadoInmuebleOld = em.merge(estadoInmuebleOld);
            }
            if (estadoInmuebleNew != null && !estadoInmuebleNew.equals(estadoInmuebleOld)) {
                Inmueble oldInmuebleOfEstadoInmueble = estadoInmuebleNew.getInmueble();
                if (oldInmuebleOfEstadoInmueble != null) {
                    oldInmuebleOfEstadoInmueble.setEstadoInmueble(null);
                    oldInmuebleOfEstadoInmueble = em.merge(oldInmuebleOfEstadoInmueble);
                }
                estadoInmuebleNew.setInmueble(inmueble);
                estadoInmuebleNew = em.merge(estadoInmuebleNew);
            }
            if (empleadoOld != null && !empleadoOld.equals(empleadoNew)) {
                empleadoOld.getInmueble().remove(inmueble);
                empleadoOld = em.merge(empleadoOld);
            }
            if (empleadoNew != null && !empleadoNew.equals(empleadoOld)) {
                empleadoNew.getInmueble().add(inmueble);
                empleadoNew = em.merge(empleadoNew);
            }
            if (contratoOld != null && !contratoOld.equals(contratoNew)) {
                contratoOld.setInmueble(null);
                contratoOld = em.merge(contratoOld);
            }
            if (contratoNew != null && !contratoNew.equals(contratoOld)) {
                Inmueble oldInmuebleOfContrato = contratoNew.getInmueble();
                if (oldInmuebleOfContrato != null) {
                    oldInmuebleOfContrato.setContrato(null);
                    oldInmuebleOfContrato = em.merge(oldInmuebleOfContrato);
                }
                contratoNew.setInmueble(inmueble);
                contratoNew = em.merge(contratoNew);
            }
            for (Reservacion reservacionOldReservacion : reservacionOld) {
                if (!reservacionNew.contains(reservacionOldReservacion)) {
                    reservacionOldReservacion.setInmueble(null);
                    reservacionOldReservacion = em.merge(reservacionOldReservacion);
                }
            }
            for (Reservacion reservacionNewReservacion : reservacionNew) {
                if (!reservacionOld.contains(reservacionNewReservacion)) {
                    Inmueble oldInmuebleOfReservacionNewReservacion = reservacionNewReservacion.getInmueble();
                    reservacionNewReservacion.setInmueble(inmueble);
                    reservacionNewReservacion = em.merge(reservacionNewReservacion);
                    if (oldInmuebleOfReservacionNewReservacion != null && !oldInmuebleOfReservacionNewReservacion.equals(inmueble)) {
                        oldInmuebleOfReservacionNewReservacion.getReservacion().remove(reservacionNewReservacion);
                        oldInmuebleOfReservacionNewReservacion = em.merge(oldInmuebleOfReservacionNewReservacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = inmueble.getIdInmueble();
                if (findInmueble(id) == null) {
                    throw new NonexistentEntityException("The inmueble with id " + id + " no longer exists.");
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
            Inmueble inmueble;
            try {
                inmueble = em.getReference(Inmueble.class, id);
                inmueble.getIdInmueble();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inmueble with id " + id + " no longer exists.", enfe);
            }
            TipoInmueble tipoInmueble = inmueble.getTipoInmueble();
            if (tipoInmueble != null) {
                tipoInmueble.setInmueble(null);
                tipoInmueble = em.merge(tipoInmueble);
            }
            EstadoInmueble estadoInmueble = inmueble.getEstadoInmueble();
            if (estadoInmueble != null) {
                estadoInmueble.setInmueble(null);
                estadoInmueble = em.merge(estadoInmueble);
            }
            Empleado empleado = inmueble.getEmpleado();
            if (empleado != null) {
                empleado.getInmueble().remove(inmueble);
                empleado = em.merge(empleado);
            }
            Contrato contrato = inmueble.getContrato();
            if (contrato != null) {
                contrato.setInmueble(null);
                contrato = em.merge(contrato);
            }
            List<Reservacion> reservacion = inmueble.getReservacion();
            for (Reservacion reservacionReservacion : reservacion) {
                reservacionReservacion.setInmueble(null);
                reservacionReservacion = em.merge(reservacionReservacion);
            }
            em.remove(inmueble);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inmueble> findInmuebleEntities() {
        return findInmuebleEntities(true, -1, -1);
    }

    public List<Inmueble> findInmuebleEntities(int maxResults, int firstResult) {
        return findInmuebleEntities(false, maxResults, firstResult);
    }

    private List<Inmueble> findInmuebleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inmueble.class));
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

    public Inmueble findInmueble(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inmueble.class, id);
        } finally {
            em.close();
        }
    }

    public int getInmuebleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inmueble> rt = cq.from(Inmueble.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
