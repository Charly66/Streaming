/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreDAO {
    
    EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
    
    public void ajouter(Genre g){
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
    }
    public void supprimer(Genre g) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Genre g WHERE g.id=" + g.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Genre g) {
        em.getTransaction().begin();
        em.merge(g);
        em.getTransaction().commit();
    }
    
    public Genre rechercherId(long id){
       return em.find(Genre.class, id);
    }
    
    public List<Genre> rechercherTout(){
        return em.createQuery("Select g FROM Genre g").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Genre g").executeUpdate();
        em.getTransaction().commit();
    }
    
}
