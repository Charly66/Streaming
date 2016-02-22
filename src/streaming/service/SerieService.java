/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.SerieDAO;
import streaming.entity.Serie;

/**
 *
 * @author admin
 */
public class SerieService {

    private SerieDAO dao = new SerieDAO();

    public void ajouter(Serie s) {
        dao.ajouter(s);
    }

    public void supprimer(Serie s) {
        dao.supprimer(s);
    }

    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Serie s) {
        dao.modifier(s);
    }

    public Serie rechercherId(long id) {
        return dao.rechercherId(id);
    }

    public List<Serie> rechercherTout() {
        return dao.rechercherTout();

    }

}
