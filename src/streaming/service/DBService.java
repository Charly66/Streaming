/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

/**
 *
 * @author admin
 */
public class DBService {

    public void deleteAll() {

        new LienService().supprimerTout();
        new EpisodeService().supprimerTout();
        new SaisonService().supprimerTout();
        new SerieService().supprimerTout();
        new FilmService().supprimerTout();
        new GenreService().supprimerTout();
        new PaysService().supprimerTout();
        new RealisateurService().supprimerTout();
        
        System.out.println("Base de données supprimée");

    }

}
