/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Serie;

/**
 *
 * @author admin
 */
public class SerieDAO {
    
     EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
    
    public void ajouter(Serie s){
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }
    public void supprimer(Serie s) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Serie s WHERE s.id=" + s.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Serie s) {
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }
    
    public Serie rechercherId(long id){
       return em.find(Serie.class, id);
    }
    
    public List<Serie> rechercherTout(){
        return em.createQuery("Select s FROM Serie s").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Serie s").executeUpdate();
        em.getTransaction().commit();
    }
    
}
