package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import logica.Usuario;
import logica.Reservacion;
import java.util.ArrayList;
import java.util.List;
import logica.Cliente;
import logica.Contrato;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ClienteJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }
    
    public void create(Cliente cliente) {
    if (cliente.getReservacion() == null) {
        cliente.setReservacion(new ArrayList<Reservacion>());
    }
    if (cliente.getContrato() == null) {
        cliente.setContrato(new ArrayList<Contrato>());
    }

    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();

        // Crear y persistir el Usuario asociado
        Usuario usuario = cliente.getUsuario();
        if (usuario != null) {
            em.persist(usuario);
            em.flush(); // Asegura que el ID del Usuario sea generado
            cliente.setUsuario(usuario);
        }

        // Adjuntar Reservaciones
        List<Reservacion> attachedReservacion = new ArrayList<>();
        for (Reservacion reservacion : cliente.getReservacion()) {
            reservacion = em.getReference(reservacion.getClass(), reservacion.getIdReservacion());
            attachedReservacion.add(reservacion);
        }
        cliente.setReservacion(attachedReservacion);
        
        // Adjuntar Contratos
        List<Contrato> attachedContrato = new ArrayList<>();
        for (Contrato contrato : cliente.getContrato()) {
            contrato = em.getReference(contrato.getClass(), contrato.getIdContrato());
            attachedContrato.add(contrato);
        }
        cliente.setContrato(attachedContrato);

        // Persistir el Cliente
        em.persist(cliente);
        
        // Actualizar referencias bidireccionales
        if (usuario != null) {
            Cliente oldClienteOfUsuario = usuario.getCliente();
            if (oldClienteOfUsuario != null) {
                oldClienteOfUsuario.setUsuario(null);
                oldClienteOfUsuario = em.merge(oldClienteOfUsuario);
            }
            usuario.setCliente(cliente);
            usuario = em.merge(usuario);
        }

        for (Reservacion reservacion : cliente.getReservacion()) {
            Cliente oldClienteOfReservacion = reservacion.getCliente();
            reservacion.setCliente(cliente);
            reservacion = em.merge(reservacion);
            if (oldClienteOfReservacion != null) {
                oldClienteOfReservacion.getReservacion().remove(reservacion);
                oldClienteOfReservacion = em.merge(oldClienteOfReservacion);
            }
        }

        for (Contrato contrato : cliente.getContrato()) {
            Cliente oldClienteOfContrato = contrato.getCliente();
            contrato.setCliente(cliente);
            contrato = em.merge(contrato);
            if (oldClienteOfContrato != null) {
                oldClienteOfContrato.getContrato().remove(contrato);
                oldClienteOfContrato = em.merge(oldClienteOfContrato);
            }
        }

        em.getTransaction().commit();
    } catch (Exception e) {
        if (em != null && em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace(); // Manejar o relanzar la excepción según sea necesario
    } finally {
        if (em != null) {
            em.close();
        }
    }
}

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdPersona());
            Usuario usuarioOld = persistentCliente.getUsuario();
            Usuario usuarioNew = cliente.getUsuario();
            List<Reservacion> reservacionOld = persistentCliente.getReservacion();
            List<Reservacion> reservacionNew = cliente.getReservacion();
            List<Contrato> contratoOld = persistentCliente.getContrato();
            List<Contrato> contratoNew = cliente.getContrato();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getIdUsuario());
                cliente.setUsuario(usuarioNew);
            }
            List<Reservacion> attachedReservacionNew = new ArrayList<Reservacion>();
            for (Reservacion reservacionNewReservacionToAttach : reservacionNew) {
                reservacionNewReservacionToAttach = em.getReference(reservacionNewReservacionToAttach.getClass(), reservacionNewReservacionToAttach.getIdReservacion());
                attachedReservacionNew.add(reservacionNewReservacionToAttach);
            }
            reservacionNew = attachedReservacionNew;
            cliente.setReservacion(reservacionNew);
            List<Contrato> attachedContratoNew = new ArrayList<Contrato>();
            for (Contrato contratoNewContratoToAttach : contratoNew) {
                contratoNewContratoToAttach = em.getReference(contratoNewContratoToAttach.getClass(), contratoNewContratoToAttach.getIdContrato());
                attachedContratoNew.add(contratoNewContratoToAttach);
            }
            contratoNew = attachedContratoNew;
            cliente.setContrato(contratoNew);
            cliente = em.merge(cliente);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.setCliente(null);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                Cliente oldClienteOfUsuario = usuarioNew.getCliente();
                if (oldClienteOfUsuario != null) {
                    oldClienteOfUsuario.setUsuario(null);
                    oldClienteOfUsuario = em.merge(oldClienteOfUsuario);
                }
                usuarioNew.setCliente(cliente);
                usuarioNew = em.merge(usuarioNew);
            }
            for (Reservacion reservacionOldReservacion : reservacionOld) {
                if (!reservacionNew.contains(reservacionOldReservacion)) {
                    reservacionOldReservacion.setCliente(null);
                    reservacionOldReservacion = em.merge(reservacionOldReservacion);
                }
            }
            for (Reservacion reservacionNewReservacion : reservacionNew) {
                if (!reservacionOld.contains(reservacionNewReservacion)) {
                    Cliente oldClienteOfReservacionNewReservacion = reservacionNewReservacion.getCliente();
                    reservacionNewReservacion.setCliente(cliente);
                    reservacionNewReservacion = em.merge(reservacionNewReservacion);
                    if (oldClienteOfReservacionNewReservacion != null && !oldClienteOfReservacionNewReservacion.equals(cliente)) {
                        oldClienteOfReservacionNewReservacion.getReservacion().remove(reservacionNewReservacion);
                        oldClienteOfReservacionNewReservacion = em.merge(oldClienteOfReservacionNewReservacion);
                    }
                }
            }
            for (Contrato contratoOldContrato : contratoOld) {
                if (!contratoNew.contains(contratoOldContrato)) {
                    contratoOldContrato.setCliente(null);
                    contratoOldContrato = em.merge(contratoOldContrato);
                }
            }
            for (Contrato contratoNewContrato : contratoNew) {
                if (!contratoOld.contains(contratoNewContrato)) {
                    Cliente oldClienteOfContratoNewContrato = contratoNewContrato.getCliente();
                    contratoNewContrato.setCliente(cliente);
                    contratoNewContrato = em.merge(contratoNewContrato);
                    if (oldClienteOfContratoNewContrato != null && !oldClienteOfContratoNewContrato.equals(cliente)) {
                        oldClienteOfContratoNewContrato.getContrato().remove(contratoNewContrato);
                        oldClienteOfContratoNewContrato = em.merge(oldClienteOfContratoNewContrato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getIdPersona();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario = cliente.getUsuario();
            if (usuario != null) {
                usuario.setCliente(null);
                usuario = em.merge(usuario);
            }
            List<Reservacion> reservacion = cliente.getReservacion();
            for (Reservacion reservacionReservacion : reservacion) {
                reservacionReservacion.setCliente(null);
                reservacionReservacion = em.merge(reservacionReservacion);
            }
            List<Contrato> contrato = cliente.getContrato();
            for (Contrato contratoContrato : contrato) {
                contratoContrato.setCliente(null);
                contratoContrato = em.merge(contratoContrato);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
