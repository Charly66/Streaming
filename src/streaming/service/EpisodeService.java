/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.EpisodeDAO;
import streaming.entity.Episode;

/**
 *
 * @author admin
 */
public class EpisodeService {

    private EpisodeDAO dao = new EpisodeDAO();

    public void ajouter(Episode f) {
        dao.ajouter(f);
    }

    public void supprimer(Episode f) {
        dao.supprimer(f);
    }

    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Episode f) {
        dao.modifier(f);
    }

    public Episode rechercherId(long id) {
        return dao.rechercherId(id);
    }

    public List<Episode> rechercherTout() {
        return dao.rechercherTout();

    }

}
