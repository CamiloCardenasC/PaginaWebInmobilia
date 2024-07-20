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
import logica.Cliente;
import logica.Inmueble;
import logica.Reservacion;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class ReservacionJpaController implements Serializable {

    public ReservacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ReservacionJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }

    public void create(Reservacion reservacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = reservacion.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getIdPersona());
                reservacion.setCliente(cliente);
            }
            Inmueble inmueble = reservacion.getInmueble();
            if (inmueble != null) {
                inmueble = em.getReference(inmueble.getClass(), inmueble.getIdInmueble());
                reservacion.setInmueble(inmueble);
            }
            em.persist(reservacion);
            if (cliente != null) {
                cliente.getReservacion().add(reservacion);
                cliente = em.merge(cliente);
            }
            if (inmueble != null) {
                inmueble.getReservacion().add(reservacion);
                inmueble = em.merge(inmueble);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reservacion reservacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reservacion persistentReservacion = em.find(Reservacion.class, reservacion.getIdReservacion());
            Cliente clienteOld = persistentReservacion.getCliente();
            Cliente clienteNew = reservacion.getCliente();
            Inmueble inmuebleOld = persistentReservacion.getInmueble();
            Inmueble inmuebleNew = reservacion.getInmueble();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getIdPersona());
                reservacion.setCliente(clienteNew);
            }
            if (inmuebleNew != null) {
                inmuebleNew = em.getReference(inmuebleNew.getClass(), inmuebleNew.getIdInmueble());
                reservacion.setInmueble(inmuebleNew);
            }
            reservacion = em.merge(reservacion);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getReservacion().remove(reservacion);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getReservacion().add(reservacion);
                clienteNew = em.merge(clienteNew);
            }
            if (inmuebleOld != null && !inmuebleOld.equals(inmuebleNew)) {
                inmuebleOld.getReservacion().remove(reservacion);
                inmuebleOld = em.merge(inmuebleOld);
            }
            if (inmuebleNew != null && !inmuebleNew.equals(inmuebleOld)) {
                inmuebleNew.getReservacion().add(reservacion);
                inmuebleNew = em.merge(inmuebleNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reservacion.getIdReservacion();
                if (findReservacion(id) == null) {
                    throw new NonexistentEntityException("The reservacion with id " + id + " no longer exists.");
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
            Reservacion reservacion;
            try {
                reservacion = em.getReference(Reservacion.class, id);
                reservacion.getIdReservacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reservacion with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = reservacion.getCliente();
            if (cliente != null) {
                cliente.getReservacion().remove(reservacion);
                cliente = em.merge(cliente);
            }
            Inmueble inmueble = reservacion.getInmueble();
            if (inmueble != null) {
                inmueble.getReservacion().remove(reservacion);
                inmueble = em.merge(inmueble);
            }
            em.remove(reservacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reservacion> findReservacionEntities() {
        return findReservacionEntities(true, -1, -1);
    }

    public List<Reservacion> findReservacionEntities(int maxResults, int firstResult) {
        return findReservacionEntities(false, maxResults, firstResult);
    }

    private List<Reservacion> findReservacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reservacion.class));
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

    public Reservacion findReservacion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reservacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reservacion> rt = cq.from(Reservacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
