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
import logica.TipoContrato;
import logica.Inmobiliaria;
import logica.Inmueble;
import logica.Cliente;
import logica.Contrato;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class ContratoJpaController implements Serializable {

    public ContratoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ContratoJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }

    public void create(Contrato contrato) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoContrato tipoContrato = contrato.getTipoContrato();
            if (tipoContrato != null) {
                tipoContrato = em.getReference(tipoContrato.getClass(), tipoContrato.getIdTipoContrato());
                contrato.setTipoContrato(tipoContrato);
            }
            Inmobiliaria inmobiliaria = contrato.getInmobiliaria();
            if (inmobiliaria != null) {
                inmobiliaria = em.getReference(inmobiliaria.getClass(), inmobiliaria.getIdInmobiliaria());
                contrato.setInmobiliaria(inmobiliaria);
            }
            Inmueble inmueble = contrato.getInmueble();
            if (inmueble != null) {
                inmueble = em.getReference(inmueble.getClass(), inmueble.getIdInmueble());
                contrato.setInmueble(inmueble);
            }
            Cliente cliente = contrato.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getIdPersona());
                contrato.setCliente(cliente);
            }
            em.persist(contrato);
            if (tipoContrato != null) {
                Contrato oldContratoOfTipoContrato = tipoContrato.getContrato();
                if (oldContratoOfTipoContrato != null) {
                    oldContratoOfTipoContrato.setTipoContrato(null);
                    oldContratoOfTipoContrato = em.merge(oldContratoOfTipoContrato);
                }
                tipoContrato.setContrato(contrato);
                tipoContrato = em.merge(tipoContrato);
            }
            if (inmobiliaria != null) {
                inmobiliaria.getContrato().add(contrato);
                inmobiliaria = em.merge(inmobiliaria);
            }
            if (inmueble != null) {
                Contrato oldContratoOfInmueble = inmueble.getContrato();
                if (oldContratoOfInmueble != null) {
                    oldContratoOfInmueble.setInmueble(null);
                    oldContratoOfInmueble = em.merge(oldContratoOfInmueble);
                }
                inmueble.setContrato(contrato);
                inmueble = em.merge(inmueble);
            }
            if (cliente != null) {
                cliente.getContrato().add(contrato);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contrato contrato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contrato persistentContrato = em.find(Contrato.class, contrato.getIdContrato());
            TipoContrato tipoContratoOld = persistentContrato.getTipoContrato();
            TipoContrato tipoContratoNew = contrato.getTipoContrato();
            Inmobiliaria inmobiliariaOld = persistentContrato.getInmobiliaria();
            Inmobiliaria inmobiliariaNew = contrato.getInmobiliaria();
            Inmueble inmuebleOld = persistentContrato.getInmueble();
            Inmueble inmuebleNew = contrato.getInmueble();
            Cliente clienteOld = persistentContrato.getCliente();
            Cliente clienteNew = contrato.getCliente();
            if (tipoContratoNew != null) {
                tipoContratoNew = em.getReference(tipoContratoNew.getClass(), tipoContratoNew.getIdTipoContrato());
                contrato.setTipoContrato(tipoContratoNew);
            }
            if (inmobiliariaNew != null) {
                inmobiliariaNew = em.getReference(inmobiliariaNew.getClass(), inmobiliariaNew.getIdInmobiliaria());
                contrato.setInmobiliaria(inmobiliariaNew);
            }
            if (inmuebleNew != null) {
                inmuebleNew = em.getReference(inmuebleNew.getClass(), inmuebleNew.getIdInmueble());
                contrato.setInmueble(inmuebleNew);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getIdPersona());
                contrato.setCliente(clienteNew);
            }
            contrato = em.merge(contrato);
            if (tipoContratoOld != null && !tipoContratoOld.equals(tipoContratoNew)) {
                tipoContratoOld.setContrato(null);
                tipoContratoOld = em.merge(tipoContratoOld);
            }
            if (tipoContratoNew != null && !tipoContratoNew.equals(tipoContratoOld)) {
                Contrato oldContratoOfTipoContrato = tipoContratoNew.getContrato();
                if (oldContratoOfTipoContrato != null) {
                    oldContratoOfTipoContrato.setTipoContrato(null);
                    oldContratoOfTipoContrato = em.merge(oldContratoOfTipoContrato);
                }
                tipoContratoNew.setContrato(contrato);
                tipoContratoNew = em.merge(tipoContratoNew);
            }
            if (inmobiliariaOld != null && !inmobiliariaOld.equals(inmobiliariaNew)) {
                inmobiliariaOld.getContrato().remove(contrato);
                inmobiliariaOld = em.merge(inmobiliariaOld);
            }
            if (inmobiliariaNew != null && !inmobiliariaNew.equals(inmobiliariaOld)) {
                inmobiliariaNew.getContrato().add(contrato);
                inmobiliariaNew = em.merge(inmobiliariaNew);
            }
            if (inmuebleOld != null && !inmuebleOld.equals(inmuebleNew)) {
                inmuebleOld.setContrato(null);
                inmuebleOld = em.merge(inmuebleOld);
            }
            if (inmuebleNew != null && !inmuebleNew.equals(inmuebleOld)) {
                Contrato oldContratoOfInmueble = inmuebleNew.getContrato();
                if (oldContratoOfInmueble != null) {
                    oldContratoOfInmueble.setInmueble(null);
                    oldContratoOfInmueble = em.merge(oldContratoOfInmueble);
                }
                inmuebleNew.setContrato(contrato);
                inmuebleNew = em.merge(inmuebleNew);
            }
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getContrato().remove(contrato);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getContrato().add(contrato);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = contrato.getIdContrato();
                if (findContrato(id) == null) {
                    throw new NonexistentEntityException("The contrato with id " + id + " no longer exists.");
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
            Contrato contrato;
            try {
                contrato = em.getReference(Contrato.class, id);
                contrato.getIdContrato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contrato with id " + id + " no longer exists.", enfe);
            }
            TipoContrato tipoContrato = contrato.getTipoContrato();
            if (tipoContrato != null) {
                tipoContrato.setContrato(null);
                tipoContrato = em.merge(tipoContrato);
            }
            Inmobiliaria inmobiliaria = contrato.getInmobiliaria();
            if (inmobiliaria != null) {
                inmobiliaria.getContrato().remove(contrato);
                inmobiliaria = em.merge(inmobiliaria);
            }
            Inmueble inmueble = contrato.getInmueble();
            if (inmueble != null) {
                inmueble.setContrato(null);
                inmueble = em.merge(inmueble);
            }
            Cliente cliente = contrato.getCliente();
            if (cliente != null) {
                cliente.getContrato().remove(contrato);
                cliente = em.merge(cliente);
            }
            em.remove(contrato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contrato> findContratoEntities() {
        return findContratoEntities(true, -1, -1);
    }

    public List<Contrato> findContratoEntities(int maxResults, int firstResult) {
        return findContratoEntities(false, maxResults, firstResult);
    }

    private List<Contrato> findContratoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contrato.class));
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

    public Contrato findContrato(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contrato.class, id);
        } finally {
            em.close();
        }
    }

    public int getContratoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contrato> rt = cq.from(Contrato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
