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
import logica.Contrato;
import logica.TipoContrato;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class TipoContratoJpaController implements Serializable {

    public TipoContratoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TipoContratoJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }
    
    public void create(TipoContrato tipoContrato) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contrato contrato = tipoContrato.getContrato();
            if (contrato != null) {
                contrato = em.getReference(contrato.getClass(), contrato.getIdContrato());
                tipoContrato.setContrato(contrato);
            }
            em.persist(tipoContrato);
            if (contrato != null) {
                TipoContrato oldTipoContratoOfContrato = contrato.getTipoContrato();
                if (oldTipoContratoOfContrato != null) {
                    oldTipoContratoOfContrato.setContrato(null);
                    oldTipoContratoOfContrato = em.merge(oldTipoContratoOfContrato);
                }
                contrato.setTipoContrato(tipoContrato);
                contrato = em.merge(contrato);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoContrato tipoContrato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoContrato persistentTipoContrato = em.find(TipoContrato.class, tipoContrato.getIdTipoContrato());
            Contrato contratoOld = persistentTipoContrato.getContrato();
            Contrato contratoNew = tipoContrato.getContrato();
            if (contratoNew != null) {
                contratoNew = em.getReference(contratoNew.getClass(), contratoNew.getIdContrato());
                tipoContrato.setContrato(contratoNew);
            }
            tipoContrato = em.merge(tipoContrato);
            if (contratoOld != null && !contratoOld.equals(contratoNew)) {
                contratoOld.setTipoContrato(null);
                contratoOld = em.merge(contratoOld);
            }
            if (contratoNew != null && !contratoNew.equals(contratoOld)) {
                TipoContrato oldTipoContratoOfContrato = contratoNew.getTipoContrato();
                if (oldTipoContratoOfContrato != null) {
                    oldTipoContratoOfContrato.setContrato(null);
                    oldTipoContratoOfContrato = em.merge(oldTipoContratoOfContrato);
                }
                contratoNew.setTipoContrato(tipoContrato);
                contratoNew = em.merge(contratoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoContrato.getIdTipoContrato();
                if (findTipoContrato(id) == null) {
                    throw new NonexistentEntityException("The tipoContrato with id " + id + " no longer exists.");
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
            TipoContrato tipoContrato;
            try {
                tipoContrato = em.getReference(TipoContrato.class, id);
                tipoContrato.getIdTipoContrato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoContrato with id " + id + " no longer exists.", enfe);
            }
            Contrato contrato = tipoContrato.getContrato();
            if (contrato != null) {
                contrato.setTipoContrato(null);
                contrato = em.merge(contrato);
            }
            em.remove(tipoContrato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoContrato> findTipoContratoEntities() {
        return findTipoContratoEntities(true, -1, -1);
    }

    public List<TipoContrato> findTipoContratoEntities(int maxResults, int firstResult) {
        return findTipoContratoEntities(false, maxResults, firstResult);
    }

    private List<TipoContrato> findTipoContratoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoContrato.class));
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

    public TipoContrato findTipoContrato(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoContrato.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoContratoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoContrato> rt = cq.from(TipoContrato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
