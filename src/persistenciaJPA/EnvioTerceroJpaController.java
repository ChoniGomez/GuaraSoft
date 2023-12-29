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
import logicaDeNegocio.EnvioTercero;
import persistenciaJPA.exceptions.NonexistentEntityException;

/**
 *
 * @author Choni
 */
public class EnvioTerceroJpaController implements Serializable {

    public EnvioTerceroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EnvioTerceroJpaController() {
        emf = Persistence.createEntityManagerFactory("GuaraSoftPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EnvioTercero envioTercero) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(envioTercero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EnvioTercero envioTercero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            envioTercero = em.merge(envioTercero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = envioTercero.getId();
                if (findEnvioTercero(id) == null) {
                    throw new NonexistentEntityException("The envioTercero with id " + id + " no longer exists.");
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
            EnvioTercero envioTercero;
            try {
                envioTercero = em.getReference(EnvioTercero.class, id);
                envioTercero.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The envioTercero with id " + id + " no longer exists.", enfe);
            }
            em.remove(envioTercero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EnvioTercero> findEnvioTerceroEntities() {
        return findEnvioTerceroEntities(true, -1, -1);
    }

    public List<EnvioTercero> findEnvioTerceroEntities(int maxResults, int firstResult) {
        return findEnvioTerceroEntities(false, maxResults, firstResult);
    }

    private List<EnvioTercero> findEnvioTerceroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EnvioTercero.class));
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

    public EnvioTercero findEnvioTercero(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EnvioTercero.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnvioTerceroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EnvioTercero> rt = cq.from(EnvioTercero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
