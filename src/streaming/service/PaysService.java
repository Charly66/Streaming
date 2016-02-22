/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.PaysDAO;
import streaming.entity.Pays;

/**
 *
 * @author admin
 */
public class PaysService {

    private PaysDAO dao = new PaysDAO();

    public void ajouter(Pays p) {
        dao.ajouter(p);
    }

    public void supprimer(Pays p) {
        dao.supprimer(p);
    }

    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Pays p) {
        dao.modifier(p);
    }

    public Pays rechercherId(long id) {
        return dao.rechercherId(id);
    }

    public List<Pays> rechercherTout() {
        return dao.rechercherTout();

    }

}
