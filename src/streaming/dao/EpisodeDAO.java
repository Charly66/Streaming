/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Episode;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class EpisodeDAO {
    
     EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
    
    public void ajouter(Episode e){
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    public void supprimer(Episode e) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Episode e WHERE e.id=" + e.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Episode e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }
    
    public Episode rechercherId(long id){
       return em.find(Episode.class, id);
    }
    
    public List<Episode> rechercherTout(){
        return em.createQuery("Select e FROM Episode e").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Episode e").executeUpdate();
        em.getTransaction().commit();
    }
    
}
