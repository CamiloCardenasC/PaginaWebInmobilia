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
import logica.Permisos;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class PermisosJpaController implements Serializable {

    public PermisosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public PermisosJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }

    public void create(Permisos permisos) {
        if (permisos.getEmpleados() == null) {
            permisos.setEmpleados(new ArrayList<Empleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleado> attachedEmpleados = new ArrayList<Empleado>();
            for (Empleado empleadosEmpleadoToAttach : permisos.getEmpleados()) {
                empleadosEmpleadoToAttach = em.getReference(empleadosEmpleadoToAttach.getClass(), empleadosEmpleadoToAttach.getIdPersona());
                attachedEmpleados.add(empleadosEmpleadoToAttach);
            }
            permisos.setEmpleados(attachedEmpleados);
            em.persist(permisos);
            for (Empleado empleadosEmpleado : permisos.getEmpleados()) {
                empleadosEmpleado.getPermisos().add(permisos);
                empleadosEmpleado = em.merge(empleadosEmpleado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Permisos permisos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Permisos persistentPermisos = em.find(Permisos.class, permisos.getIdPermisos());
            List<Empleado> empleadosOld = persistentPermisos.getEmpleados();
            List<Empleado> empleadosNew = permisos.getEmpleados();
            List<Empleado> attachedEmpleadosNew = new ArrayList<Empleado>();
            for (Empleado empleadosNewEmpleadoToAttach : empleadosNew) {
                empleadosNewEmpleadoToAttach = em.getReference(empleadosNewEmpleadoToAttach.getClass(), empleadosNewEmpleadoToAttach.getIdPersona());
                attachedEmpleadosNew.add(empleadosNewEmpleadoToAttach);
            }
            empleadosNew = attachedEmpleadosNew;
            permisos.setEmpleados(empleadosNew);
            permisos = em.merge(permisos);
            for (Empleado empleadosOldEmpleado : empleadosOld) {
                if (!empleadosNew.contains(empleadosOldEmpleado)) {
                    empleadosOldEmpleado.getPermisos().remove(permisos);
                    empleadosOldEmpleado = em.merge(empleadosOldEmpleado);
                }
            }
            for (Empleado empleadosNewEmpleado : empleadosNew) {
                if (!empleadosOld.contains(empleadosNewEmpleado)) {
                    empleadosNewEmpleado.getPermisos().add(permisos);
                    empleadosNewEmpleado = em.merge(empleadosNewEmpleado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = permisos.getIdPermisos();
                if (findPermisos(id) == null) {
                    throw new NonexistentEntityException("The permisos with id " + id + " no longer exists.");
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
            Permisos permisos;
            try {
                permisos = em.getReference(Permisos.class, id);
                permisos.getIdPermisos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The permisos with id " + id + " no longer exists.", enfe);
            }
            List<Empleado> empleados = permisos.getEmpleados();
            for (Empleado empleadosEmpleado : empleados) {
                empleadosEmpleado.getPermisos().remove(permisos);
                empleadosEmpleado = em.merge(empleadosEmpleado);
            }
            em.remove(permisos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Permisos> findPermisosEntities() {
        return findPermisosEntities(true, -1, -1);
    }

    public List<Permisos> findPermisosEntities(int maxResults, int firstResult) {
        return findPermisosEntities(false, maxResults, firstResult);
    }

    private List<Permisos> findPermisosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Permisos.class));
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

    public Permisos findPermisos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Permisos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPermisosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Permisos> rt = cq.from(Permisos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
