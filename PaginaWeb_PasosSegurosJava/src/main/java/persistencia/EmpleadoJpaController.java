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
import logica.Cargo;
import logica.Inmobiliaria;
import logica.Usuario;
import logica.Inmueble;
import java.util.ArrayList;
import java.util.List;
import logica.Permisos;
import java.util.HashSet;
import java.util.Set;
import logica.Empleado;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author kmilo
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public EmpleadoJpaController(){
        emf = Persistence.createEntityManagerFactory("PaginaWeb_PasosSeguros_PU");
    }
    
    public void create(Empleado empleado) {
        if (empleado.getInmueble() == null) {
            empleado.setInmueble(new ArrayList<Inmueble>());
        }
        if (empleado.getPermisos() == null) {
            empleado.setPermisos(new HashSet<Permisos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargo cargo = empleado.getCargo();
            if (cargo != null) {
                cargo = em.getReference(cargo.getClass(), cargo.getIdCargo());
                empleado.setCargo(cargo);
            }
            Inmobiliaria inmobiliaria = empleado.getInmobiliaria();
            if (inmobiliaria != null) {
                inmobiliaria = em.getReference(inmobiliaria.getClass(), inmobiliaria.getIdInmobiliaria());
                empleado.setInmobiliaria(inmobiliaria);
            }
            Usuario usuario = empleado.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getIdUsuario());
                empleado.setUsuario(usuario);
            }
            List<Inmueble> attachedInmueble = new ArrayList<Inmueble>();
            for (Inmueble inmuebleInmuebleToAttach : empleado.getInmueble()) {
                inmuebleInmuebleToAttach = em.getReference(inmuebleInmuebleToAttach.getClass(), inmuebleInmuebleToAttach.getIdInmueble());
                attachedInmueble.add(inmuebleInmuebleToAttach);
            }
            empleado.setInmueble(attachedInmueble);
            Set<Permisos> attachedPermisos = new HashSet<Permisos>();
            for (Permisos permisosPermisosToAttach : empleado.getPermisos()) {
                permisosPermisosToAttach = em.getReference(permisosPermisosToAttach.getClass(), permisosPermisosToAttach.getIdPermisos());
                attachedPermisos.add(permisosPermisosToAttach);
            }
            empleado.setPermisos(attachedPermisos);
            em.persist(empleado);
            if (cargo != null) {
                Empleado oldEmpleadoOfCargo = cargo.getEmpleado();
                if (oldEmpleadoOfCargo != null) {
                    oldEmpleadoOfCargo.setCargo(null);
                    oldEmpleadoOfCargo = em.merge(oldEmpleadoOfCargo);
                }
                cargo.setEmpleado(empleado);
                cargo = em.merge(cargo);
            }
            if (inmobiliaria != null) {
                inmobiliaria.getEmpleado().add(empleado);
                inmobiliaria = em.merge(inmobiliaria);
            }
            if (usuario != null) {
                Empleado oldEmpleadoOfUsuario = usuario.getEmpleado();
                if (oldEmpleadoOfUsuario != null) {
                    oldEmpleadoOfUsuario.setUsuario(null);
                    oldEmpleadoOfUsuario = em.merge(oldEmpleadoOfUsuario);
                }
                usuario.setEmpleado(empleado);
                usuario = em.merge(usuario);
            }
            for (Inmueble inmuebleInmueble : empleado.getInmueble()) {
                Empleado oldEmpleadoOfInmuebleInmueble = inmuebleInmueble.getEmpleado();
                inmuebleInmueble.setEmpleado(empleado);
                inmuebleInmueble = em.merge(inmuebleInmueble);
                if (oldEmpleadoOfInmuebleInmueble != null) {
                    oldEmpleadoOfInmuebleInmueble.getInmueble().remove(inmuebleInmueble);
                    oldEmpleadoOfInmuebleInmueble = em.merge(oldEmpleadoOfInmuebleInmueble);
                }
            }
            for (Permisos permisosPermisos : empleado.getPermisos()) {
                permisosPermisos.getEmpleados().add(empleado);
                permisosPermisos = em.merge(permisosPermisos);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getIdPersona());
            Cargo cargoOld = persistentEmpleado.getCargo();
            Cargo cargoNew = empleado.getCargo();
            Inmobiliaria inmobiliariaOld = persistentEmpleado.getInmobiliaria();
            Inmobiliaria inmobiliariaNew = empleado.getInmobiliaria();
            Usuario usuarioOld = persistentEmpleado.getUsuario();
            Usuario usuarioNew = empleado.getUsuario();
            List<Inmueble> inmuebleOld = persistentEmpleado.getInmueble();
            List<Inmueble> inmuebleNew = empleado.getInmueble();
            Set<Permisos> permisosOld = persistentEmpleado.getPermisos();
            Set<Permisos> permisosNew = empleado.getPermisos();
            if (cargoNew != null) {
                cargoNew = em.getReference(cargoNew.getClass(), cargoNew.getIdCargo());
                empleado.setCargo(cargoNew);
            }
            if (inmobiliariaNew != null) {
                inmobiliariaNew = em.getReference(inmobiliariaNew.getClass(), inmobiliariaNew.getIdInmobiliaria());
                empleado.setInmobiliaria(inmobiliariaNew);
            }
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getIdUsuario());
                empleado.setUsuario(usuarioNew);
            }
            List<Inmueble> attachedInmuebleNew = new ArrayList<Inmueble>();
            for (Inmueble inmuebleNewInmuebleToAttach : inmuebleNew) {
                inmuebleNewInmuebleToAttach = em.getReference(inmuebleNewInmuebleToAttach.getClass(), inmuebleNewInmuebleToAttach.getIdInmueble());
                attachedInmuebleNew.add(inmuebleNewInmuebleToAttach);
            }
            inmuebleNew = attachedInmuebleNew;
            empleado.setInmueble(inmuebleNew);
            Set<Permisos> attachedPermisosNew = new HashSet<Permisos>();
            for (Permisos permisosNewPermisosToAttach : permisosNew) {
                permisosNewPermisosToAttach = em.getReference(permisosNewPermisosToAttach.getClass(), permisosNewPermisosToAttach.getIdPermisos());
                attachedPermisosNew.add(permisosNewPermisosToAttach);
            }
            permisosNew = attachedPermisosNew;
            empleado.setPermisos(permisosNew);
            empleado = em.merge(empleado);
            if (cargoOld != null && !cargoOld.equals(cargoNew)) {
                cargoOld.setEmpleado(null);
                cargoOld = em.merge(cargoOld);
            }
            if (cargoNew != null && !cargoNew.equals(cargoOld)) {
                Empleado oldEmpleadoOfCargo = cargoNew.getEmpleado();
                if (oldEmpleadoOfCargo != null) {
                    oldEmpleadoOfCargo.setCargo(null);
                    oldEmpleadoOfCargo = em.merge(oldEmpleadoOfCargo);
                }
                cargoNew.setEmpleado(empleado);
                cargoNew = em.merge(cargoNew);
            }
            if (inmobiliariaOld != null && !inmobiliariaOld.equals(inmobiliariaNew)) {
                inmobiliariaOld.getEmpleado().remove(empleado);
                inmobiliariaOld = em.merge(inmobiliariaOld);
            }
            if (inmobiliariaNew != null && !inmobiliariaNew.equals(inmobiliariaOld)) {
                inmobiliariaNew.getEmpleado().add(empleado);
                inmobiliariaNew = em.merge(inmobiliariaNew);
            }
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.setEmpleado(null);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                Empleado oldEmpleadoOfUsuario = usuarioNew.getEmpleado();
                if (oldEmpleadoOfUsuario != null) {
                    oldEmpleadoOfUsuario.setUsuario(null);
                    oldEmpleadoOfUsuario = em.merge(oldEmpleadoOfUsuario);
                }
                usuarioNew.setEmpleado(empleado);
                usuarioNew = em.merge(usuarioNew);
            }
            for (Inmueble inmuebleOldInmueble : inmuebleOld) {
                if (!inmuebleNew.contains(inmuebleOldInmueble)) {
                    inmuebleOldInmueble.setEmpleado(null);
                    inmuebleOldInmueble = em.merge(inmuebleOldInmueble);
                }
            }
            for (Inmueble inmuebleNewInmueble : inmuebleNew) {
                if (!inmuebleOld.contains(inmuebleNewInmueble)) {
                    Empleado oldEmpleadoOfInmuebleNewInmueble = inmuebleNewInmueble.getEmpleado();
                    inmuebleNewInmueble.setEmpleado(empleado);
                    inmuebleNewInmueble = em.merge(inmuebleNewInmueble);
                    if (oldEmpleadoOfInmuebleNewInmueble != null && !oldEmpleadoOfInmuebleNewInmueble.equals(empleado)) {
                        oldEmpleadoOfInmuebleNewInmueble.getInmueble().remove(inmuebleNewInmueble);
                        oldEmpleadoOfInmuebleNewInmueble = em.merge(oldEmpleadoOfInmuebleNewInmueble);
                    }
                }
            }
            for (Permisos permisosOldPermisos : permisosOld) {
                if (!permisosNew.contains(permisosOldPermisos)) {
                    permisosOldPermisos.getEmpleados().remove(empleado);
                    permisosOldPermisos = em.merge(permisosOldPermisos);
                }
            }
            for (Permisos permisosNewPermisos : permisosNew) {
                if (!permisosOld.contains(permisosNewPermisos)) {
                    permisosNewPermisos.getEmpleados().add(empleado);
                    permisosNewPermisos = em.merge(permisosNewPermisos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleado.getIdPersona();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            Cargo cargo = empleado.getCargo();
            if (cargo != null) {
                cargo.setEmpleado(null);
                cargo = em.merge(cargo);
            }
            Inmobiliaria inmobiliaria = empleado.getInmobiliaria();
            if (inmobiliaria != null) {
                inmobiliaria.getEmpleado().remove(empleado);
                inmobiliaria = em.merge(inmobiliaria);
            }
            Usuario usuario = empleado.getUsuario();
            if (usuario != null) {
                usuario.setEmpleado(null);
                usuario = em.merge(usuario);
            }
            List<Inmueble> inmueble = empleado.getInmueble();
            for (Inmueble inmuebleInmueble : inmueble) {
                inmuebleInmueble.setEmpleado(null);
                inmuebleInmueble = em.merge(inmuebleInmueble);
            }
            Set<Permisos> permisos = empleado.getPermisos();
            for (Permisos permisosPermisos : permisos) {
                permisosPermisos.getEmpleados().remove(empleado);
                permisosPermisos = em.merge(permisosPermisos);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
