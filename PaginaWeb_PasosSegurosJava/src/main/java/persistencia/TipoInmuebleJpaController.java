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
import logica.Inmueble;
import logica.TipoInmueble;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class TipoInmuebleJpaController implements Serializable {

    public TipoInmuebleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TipoInmuebleJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }
    
    public void create(TipoInmueble tipoInmueble) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inmueble inmueble = tipoInmueble.getInmueble();
            if (inmueble != null) {
                inmueble = em.getReference(inmueble.getClass(), inmueble.getIdInmueble());
                tipoInmueble.setInmueble(inmueble);
            }
            em.persist(tipoInmueble);
            if (inmueble != null) {
                TipoInmueble oldTipoInmuebleOfInmueble = inmueble.getTipoInmueble();
                if (oldTipoInmuebleOfInmueble != null) {
                    oldTipoInmuebleOfInmueble.setInmueble(null);
                    oldTipoInmuebleOfInmueble = em.merge(oldTipoInmuebleOfInmueble);
                }
                inmueble.setTipoInmueble(tipoInmueble);
                inmueble = em.merge(inmueble);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoInmueble tipoInmueble) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoInmueble persistentTipoInmueble = em.find(TipoInmueble.class, tipoInmueble.getIdTipoInmueble());
            Inmueble inmuebleOld = persistentTipoInmueble.getInmueble();
            Inmueble inmuebleNew = tipoInmueble.getInmueble();
            if (inmuebleNew != null) {
                inmuebleNew = em.getReference(inmuebleNew.getClass(), inmuebleNew.getIdInmueble());
                tipoInmueble.setInmueble(inmuebleNew);
            }
            tipoInmueble = em.merge(tipoInmueble);
            if (inmuebleOld != null && !inmuebleOld.equals(inmuebleNew)) {
                inmuebleOld.setTipoInmueble(null);
                inmuebleOld = em.merge(inmuebleOld);
            }
            if (inmuebleNew != null && !inmuebleNew.equals(inmuebleOld)) {
                TipoInmueble oldTipoInmuebleOfInmueble = inmuebleNew.getTipoInmueble();
                if (oldTipoInmuebleOfInmueble != null) {
                    oldTipoInmuebleOfInmueble.setInmueble(null);
                    oldTipoInmuebleOfInmueble = em.merge(oldTipoInmuebleOfInmueble);
                }
                inmuebleNew.setTipoInmueble(tipoInmueble);
                inmuebleNew = em.merge(inmuebleNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoInmueble.getIdTipoInmueble();
                if (findTipoInmueble(id) == null) {
                    throw new NonexistentEntityException("The tipoInmueble with id " + id + " no longer exists.");
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
            TipoInmueble tipoInmueble;
            try {
                tipoInmueble = em.getReference(TipoInmueble.class, id);
                tipoInmueble.getIdTipoInmueble();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoInmueble with id " + id + " no longer exists.", enfe);
            }
            Inmueble inmueble = tipoInmueble.getInmueble();
            if (inmueble != null) {
                inmueble.setTipoInmueble(null);
                inmueble = em.merge(inmueble);
            }
            em.remove(tipoInmueble);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoInmueble> findTipoInmuebleEntities() {
        return findTipoInmuebleEntities(true, -1, -1);
    }

    public List<TipoInmueble> findTipoInmuebleEntities(int maxResults, int firstResult) {
        return findTipoInmuebleEntities(false, maxResults, firstResult);
    }

    private List<TipoInmueble> findTipoInmuebleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoInmueble.class));
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

    public TipoInmueble findTipoInmueble(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoInmueble.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoInmuebleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoInmueble> rt = cq.from(TipoInmueble.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
