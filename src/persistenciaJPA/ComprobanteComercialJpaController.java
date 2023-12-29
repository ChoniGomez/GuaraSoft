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
import logicaDeNegocio.ComprobanteComercial;
import persistenciaJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author Choni
 */
public class ComprobanteComercialJpaController implements Serializable {

    public ComprobanteComercialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ComprobanteComercialJpaController() {
        emf = Persistence.createEntityManagerFactory("GuaraSoftPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComprobanteComercial comprobanteComercial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(comprobanteComercial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComprobanteComercial comprobanteComercial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            comprobanteComercial = em.merge(comprobanteComercial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = comprobanteComercial.getIdComprobante();
                if (findComprobanteComercial(id) == null) {
                    throw new NonexistentEntityException("The comprobanteComercial with id " + id + " no longer exists.");
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
            ComprobanteComercial comprobanteComercial;
            try {
                comprobanteComercial = em.getReference(ComprobanteComercial.class, id);
                comprobanteComercial.getIdComprobante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comprobanteComercial with id " + id + " no longer exists.", enfe);
            }
            em.remove(comprobanteComercial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ComprobanteComercial> findComprobanteComercialEntities() {
        return findComprobanteComercialEntities(true, -1, -1);
    }

    public List<ComprobanteComercial> findComprobanteComercialEntities(int maxResults, int firstResult) {
        return findComprobanteComercialEntities(false, maxResults, firstResult);
    }

    private List<ComprobanteComercial> findComprobanteComercialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComprobanteComercial.class));
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

    public ComprobanteComercial findComprobanteComercial(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComprobanteComercial.class, id);
        } finally {
            em.close();
        }
    }

    public int getComprobanteComercialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComprobanteComercial> rt = cq.from(ComprobanteComercial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
