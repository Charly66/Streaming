/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Realisateur;

/**
 *
 * @author admin
 */
public class RealisateurDAO {
    
     EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
    
    public void ajouter(Realisateur r){
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
    }
    public void supprimer(Realisateur r) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Realisateur r WHERE r.id=" + r.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Realisateur r) {
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();
    }
    
    public Realisateur rechercherId(long id){
       return em.find(Realisateur.class, id);
    }
    
    public List<Realisateur> rechercherTout(){
        return em.createQuery("Select r FROM Realisateur r").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Realisateur r").executeUpdate();
        em.getTransaction().commit();
    }
    
}
