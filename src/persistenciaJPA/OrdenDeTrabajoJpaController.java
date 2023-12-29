/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenciaJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logicaDeNegocio.OrdenDeTrabajo;
import persistenciaJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author Choni
 */
public class OrdenDeTrabajoJpaController implements Serializable {

    public OrdenDeTrabajoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public OrdenDeTrabajoJpaController() {
        emf = Persistence.createEntityManagerFactory("GuaraSoftPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OrdenDeTrabajo ordenDeTrabajo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ordenDeTrabajo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OrdenDeTrabajo ordenDeTrabajo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ordenDeTrabajo = em.merge(ordenDeTrabajo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ordenDeTrabajo.getIdOrdenDeTrabajo();
                if (findOrdenDeTrabajo(id) == null) {
                    throw new NonexistentEntityException("The ordenDeTrabajo with id " + id + " no longer exists.");
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
            OrdenDeTrabajo ordenDeTrabajo;
            try {
                ordenDeTrabajo = em.getReference(OrdenDeTrabajo.class, id);
                ordenDeTrabajo.getIdOrdenDeTrabajo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenDeTrabajo with id " + id + " no longer exists.", enfe);
            }
            em.remove(ordenDeTrabajo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OrdenDeTrabajo> findOrdenDeTrabajoEntities() {
        return findOrdenDeTrabajoEntities(true, -1, -1);
    }

    public List<OrdenDeTrabajo> findOrdenDeTrabajoEntities(int maxResults, int firstResult) {
        return findOrdenDeTrabajoEntities(false, maxResults, firstResult);
    }

    private List<OrdenDeTrabajo> findOrdenDeTrabajoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrdenDeTrabajo.class));
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

    public OrdenDeTrabajo findOrdenDeTrabajo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrdenDeTrabajo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenDeTrabajoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrdenDeTrabajo> rt = cq.from(OrdenDeTrabajo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
