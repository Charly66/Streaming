/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import streaming.entity.Episode;
import streaming.entity.Film;
import streaming.entity.Genre;
import streaming.entity.Lien;
import streaming.entity.Pays;
import streaming.entity.Realisateur;
import streaming.entity.Saison;
import streaming.entity.Serie;
import streaming.service.DBService;
import streaming.service.EpisodeService;
import streaming.service.FilmService;
import streaming.service.GenreService;
import streaming.service.LienService;
import streaming.service.PaysService;
import streaming.service.RealisateurService;
import streaming.service.SaisonService;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
public class StreamingTest {

    private LienService lienService = new LienService();
    private EpisodeService episodeService = new EpisodeService();
    private SaisonService saisonService = new SaisonService();
    private SerieService serieService = new SerieService();
    private FilmService filmService = new FilmService();
    private GenreService genreService = new GenreService();
    private PaysService paysService = new PaysService();
    private RealisateurService realService = new RealisateurService();

    // @Before
    public void testAjoutDonnées() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();

        // Creation genres
        Genre[] genre = {new Genre(1L, "Action"), new Genre(2L, "Fantastique"), new Genre(3L, "Policier"),
            new Genre(4L, "Romance"), new Genre(5L, "Animation"), new Genre(6L, "Comédie")};
        for (Genre g : genre) {
            genreService.ajouter(g);
        }

        // Creation pays
        Pays[] pays = {new Pays(1L, "France"), new Pays(2L, "USA"), new Pays(3L, "UK"), new Pays(4L, "Espagne"), new Pays(5L, "Nouvelle-Zelande")};
        for (Pays p : pays) {
            paysService.ajouter(p);
        }

        // Creation realisateur
        Realisateur[] real = {new Realisateur(1L, "Coen", "Joel"), new Realisateur(2L, "Coen", "Ethan"), new Realisateur(3L, "Jackson", "Peter"),
            new Realisateur(4L, "Tarantino", "Quentin"), new Realisateur(5L, "Maiwenn", "")};
        for (Realisateur r : real) {
            realService.ajouter(r);
        }

        // Creation film
        Film f = new Film(1L, "Django", "---", 2012L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Action'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='USA'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Tarantino'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(2L, "Kill Bill", "---", 2003L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Action'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='USA'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Tarantino'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(3L, "Kill Bill 2", "---", 2004L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Action'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='USA'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Tarantino'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(4L, "Jackie Brown", "---", 1997L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Action'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='USA'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Tarantino'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(5L, "Sin City", "---", 2005L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Fantastique'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='USA'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Tarantino'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(6L, "Bad Taste", "---", 1987L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Fantastique'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='Nouvelle-Zelande'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Jackson'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(7L, "Braindead", "---", 1992L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Fantastique'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='Nouvelle-Zelande'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Jackson'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(8L, "Le Hobbit", "---", 2015L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Fantastique'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='Nouvelle-Zelande'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Jackson'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(9L, "Polisse", "---", 2011L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Policier'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='France'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Maiwenn'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(10L, "Big Lebowski", "---", 1998L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Comédie'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='USA'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Coen' and g.prenom='Joel'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Coen' and g.prenom='Ethan'").getSingleResult());
        filmService.ajouter(f);

        f = new Film(11L, "Ave Cesar", "---", 2016L);
        f.setGenre((Genre) em.createQuery("SELECT g FROM Genre g WHERE g.nom='Comédie'").getSingleResult());
        f.setPays((Pays) em.createQuery("SELECT g FROM Pays g WHERE g.nom='USA'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Coen' and g.prenom='Joel'").getSingleResult());
        f.getRealisateurs().add((Realisateur) em.createQuery("SELECT g FROM Realisateur g WHERE g.nom='Coen' and g.prenom='Ethan'").getSingleResult());
        filmService.ajouter(f);

    }

    // @Test
    public void requete0a1() {
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println("\n---------------------\n");
        System.out.println("Requete 0 : Liste de tous les genres");
        List<Genre> genres = em.createQuery("SELECT g FROM Genre g").getResultList();
        System.out.println(genres);
        System.out.println("\n---------------------\n");
        System.out.println("Requete 0 bis : Liste des films de genre Action");
        System.out.println(em.createQuery("SELECT f FROM Film f LEFT JOIN f.genre g WHERE g.nom='Action'").getResultList());
        System.out.println("\n---------------------\n");
        System.out.println("Requete 1 : Liste des films par ordre chronologique");
        System.out.println(em.createQuery("SELECT f FROM Film f ORDER BY f.anneeProd").getResultList());
        System.out.println("\n---------------------\n");
    }

    @Test
    public void requete2() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 2 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        assertEquals(6L, em.createQuery("SELECT COUNT(g) FROM Genre g").getSingleResult());
    }

    @Test
    public void requete3() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 3 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        assertEquals(1, em.createQuery("SELECT f FROM Film f JOIN f.pays p WHERE p.nom='France'").getResultList().size());
    }

    @Test
    public void requete4() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 4 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT f FROM Film f JOIN f.genre g WHERE g.nom='Fantastique' ORDER BY f.titre ASC").getResultList());
    }

    @Test
    public void requete5() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 5 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT f FROM Film f WHERE f.genre=(SELECT g.id FROM Genre g WHERE g.nom='Fantastique') ORDER BY f.titre ASC").getResultList());
    }

    @Test
    public void requete6() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 6 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT DISTINCT f FROM Film f JOIN f.realisateurs r JOIN f.genre g WHERE r.nom='Coen' AND g.nom='Comédie' ORDER BY f.anneeProd").getResultList());
    }

    @Test
    public void requete7() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 7 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT f FROM Film f WHERE f.genre.nom!='Action'").getResultList());
    }

    @Test
    public void requete8() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 8 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT f FROM Film f JOIN f.genre g JOIN f.pays p WHERE p.nom='Nouvelle-Zelande' AND g.nom<>'Fantastique'").getResultList());
    }

    @Test
    public void requete9() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 9 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT COUNT(f) FROM Film f JOIN f.pays p JOIN f.realisateurs r JOIN f.genre g WHERE p.nom='Nouvelle-Zelande' AND g.nom<>'Fantastique' AND r.nom='Jackson'").getSingleResult());
    }

    @Test
    public void requete10a() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 10a :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery(" SELECT f "
                + "                         FROM Film f "
                + "                             WHERE f.id IN (SELECT f.id FROM Film f JOIN f.realisateurs r WHERE r.prenom='Joel') "
                + "                                     AND f.id IN (SELECT f.id FROM Film f JOIN f.realisateurs r WHERE r.prenom='Ethan')").getResultList());
    }

    @Test
    public void requete10b() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 10b :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT f FROM Film f JOIN f.realisateurs r WHERE r.prenom='Joel' INTERSECT SELECT f FROM Film f JOIN f.realisateurs r WHERE r.prenom='Ethan'").getResultList());
    }

    @Test
    public void requete11() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 11 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT f1 FROM Film f1 JOIN f1.realisateurs r WHERE r.nom='Jackson' AND f1.anneeProd=(SELECT MIN (f2.anneeProd) FROM Film f2)").getResultList());
    }

    @Test
    public void requete12() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 12 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        System.out.println(em.createQuery("SELECT AVG (f.anneeProd) FROM Film f").getSingleResult());
    }

    @Test
    public void requete13() {
        System.out.println("\n---------------------\n");
        System.out.println("Requete 13 :");
        EntityManager em = Persistence.createEntityManagerFactory("StreamingPU").createEntityManager();
        Collection<Object[]> coll = em.createQuery("SELECT COUNT(f),r FROM Film f JOIN f.realisateurs r GROUP BY r ORDER BY COUNT(f)").getResultList();
        System.out.println("Nombre de films :");
        for(Object o[] : coll){
            System.out.println(o[0]+" de "+((Realisateur)o[1]).getPrenom()+" "+((Realisateur)o[1]).getNom());
        }
    }
    
    @Test
    public void testblabla(){
            
            }



// @Test
public void testRechercherTout() {
        new LienService().rechercherTout();
        new EpisodeService().rechercherTout();
        new SaisonService().rechercherTout();
        new SerieService().rechercherTout();
        new FilmService().rechercherTout();
        new GenreService().rechercherTout();
        new PaysService().rechercherTout();
        new RealisateurService().rechercherTout();

        new DBService().deleteAll();
    }

}
