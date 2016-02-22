/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.SaisonDAO;
import streaming.entity.Saison;

/**
 *
 * @author admin
 */
public class SaisonService {

    private SaisonDAO dao = new SaisonDAO();

    public void ajouter(Saison s) {
        dao.ajouter(s);
    }

    public void supprimer(Saison s) {
        dao.supprimer(s);
    }

    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Saison s) {
        dao.modifier(s);
    }

    public Saison rechercherId(long id) {
        return dao.rechercherId(id);
    }

    public List<Saison> rechercherTout() {
        return dao.rechercherTout();

    }

}
