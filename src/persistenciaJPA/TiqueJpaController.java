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
import logicaDeNegocio.Tique;
import persistenciaJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author Choni
 */
public class TiqueJpaController implements Serializable {

    public TiqueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public TiqueJpaController() {
        emf = Persistence.createEntityManagerFactory("GuaraSoftPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tique tique) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tique);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tique tique) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tique = em.merge(tique);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tique.getIdComprobante();
                if (findTique(id) == null) {
                    throw new NonexistentEntityException("The tique with id " + id + " no longer exists.");
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
            Tique tique;
            try {
                tique = em.getReference(Tique.class, id);
                tique.getIdComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tique with id " + id + " no longer exists.", enfe);
            }
            em.remove(tique);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tique> findTiqueEntities() {
        return findTiqueEntities(true, -1, -1);
    }

    public List<Tique> findTiqueEntities(int maxResults, int firstResult) {
        return findTiqueEntities(false, maxResults, firstResult);
    }

    private List<Tique> findTiqueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tique.class));
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

    public Tique findTique(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tique.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiqueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tique> rt = cq.from(Tique.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
