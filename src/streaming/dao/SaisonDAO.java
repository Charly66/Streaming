/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Saison;

/**
 *
 * @author admin
 */
public class SaisonDAO {
    
     EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
    
    public void ajouter(Saison s){
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }
    public void supprimer(Saison s) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Saison s WHERE s.id=" + s.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Saison s) {
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }
    
    public Saison rechercherId(long id){
       return em.find(Saison.class, id);
    }
    
    public List<Saison> rechercherTout(){
        return em.createQuery("Select s FROM Saison s").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Saison s").executeUpdate();
        em.getTransaction().commit();
    }
    
}
