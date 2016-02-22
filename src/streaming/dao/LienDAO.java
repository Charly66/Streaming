/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienDAO {
    
     EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
    
    public void ajouter(Lien l){
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
    }
    public void supprimer(Lien l) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Lien l WHERE l.id=" + l.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Lien l) {
        em.getTransaction().begin();
        em.merge(l);
        em.getTransaction().commit();
    }
    
    public Lien rechercherId(long id){
       return em.find(Lien.class, id);
    }
    
    public List<Lien> rechercherTout(){
        return em.createQuery("Select l FROM Lien l").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Lien l").executeUpdate();
        em.getTransaction().commit();
    }
    
}
