/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmDAO {
    
    EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
    
    public void ajouter(Film f){
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }
    public void supprimer(Film f) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Film f WHERE f.id=" + f.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Film f) {
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }
    
    public Film rechercherId(long id){
        //return (Forum) em.createQuery("Select f FROM Forum f WHERE f.id="+id);
       return em.find(Film.class, id);
    }
    
    public List<Film> rechercherTout(){
        return em.createQuery("Select f FROM Film f").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Film f ").executeUpdate();
        em.getTransaction().commit();
    }
    
}
