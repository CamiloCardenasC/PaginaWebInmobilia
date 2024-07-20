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
import logica.EstadoInmueble;
import logica.Inmueble;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class EstadoInmuebleJpaController implements Serializable {

    public EstadoInmuebleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public EstadoInmuebleJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }
    
    public void create(EstadoInmueble estadoInmueble) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inmueble inmueble = estadoInmueble.getInmueble();
            if (inmueble != null) {
                inmueble = em.getReference(inmueble.getClass(), inmueble.getIdInmueble());
                estadoInmueble.setInmueble(inmueble);
            }
            em.persist(estadoInmueble);
            if (inmueble != null) {
                EstadoInmueble oldEstadoInmuebleOfInmueble = inmueble.getEstadoInmueble();
                if (oldEstadoInmuebleOfInmueble != null) {
                    oldEstadoInmuebleOfInmueble.setInmueble(null);
                    oldEstadoInmuebleOfInmueble = em.merge(oldEstadoInmuebleOfInmueble);
                }
                inmueble.setEstadoInmueble(estadoInmueble);
                inmueble = em.merge(inmueble);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadoInmueble estadoInmueble) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadoInmueble persistentEstadoInmueble = em.find(EstadoInmueble.class, estadoInmueble.getIdEstadoInmueble());
            Inmueble inmuebleOld = persistentEstadoInmueble.getInmueble();
            Inmueble inmuebleNew = estadoInmueble.getInmueble();
            if (inmuebleNew != null) {
                inmuebleNew = em.getReference(inmuebleNew.getClass(), inmuebleNew.getIdInmueble());
                estadoInmueble.setInmueble(inmuebleNew);
            }
            estadoInmueble = em.merge(estadoInmueble);
            if (inmuebleOld != null && !inmuebleOld.equals(inmuebleNew)) {
                inmuebleOld.setEstadoInmueble(null);
                inmuebleOld = em.merge(inmuebleOld);
            }
            if (inmuebleNew != null && !inmuebleNew.equals(inmuebleOld)) {
                EstadoInmueble oldEstadoInmuebleOfInmueble = inmuebleNew.getEstadoInmueble();
                if (oldEstadoInmuebleOfInmueble != null) {
                    oldEstadoInmuebleOfInmueble.setInmueble(null);
                    oldEstadoInmuebleOfInmueble = em.merge(oldEstadoInmuebleOfInmueble);
                }
                inmuebleNew.setEstadoInmueble(estadoInmueble);
                inmuebleNew = em.merge(inmuebleNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = estadoInmueble.getIdEstadoInmueble();
                if (findEstadoInmueble(id) == null) {
                    throw new NonexistentEntityException("The estadoInmueble with id " + id + " no longer exists.");
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
            EstadoInmueble estadoInmueble;
            try {
                estadoInmueble = em.getReference(EstadoInmueble.class, id);
                estadoInmueble.getIdEstadoInmueble();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadoInmueble with id " + id + " no longer exists.", enfe);
            }
            Inmueble inmueble = estadoInmueble.getInmueble();
            if (inmueble != null) {
                inmueble.setEstadoInmueble(null);
                inmueble = em.merge(inmueble);
            }
            em.remove(estadoInmueble);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadoInmueble> findEstadoInmuebleEntities() {
        return findEstadoInmuebleEntities(true, -1, -1);
    }

    public List<EstadoInmueble> findEstadoInmuebleEntities(int maxResults, int firstResult) {
        return findEstadoInmuebleEntities(false, maxResults, firstResult);
    }

    private List<EstadoInmueble> findEstadoInmuebleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadoInmueble.class));
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

    public EstadoInmueble findEstadoInmueble(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadoInmueble.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoInmuebleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadoInmueble> rt = cq.from(EstadoInmueble.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
