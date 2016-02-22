/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.LienDAO;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public class LienService {

    private LienDAO dao = new LienDAO();

    public void ajouter(Lien l) {
        dao.ajouter(l);
    }

    public void supprimer(Lien l) {
        dao.supprimer(l);
    }

    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Lien l) {
        dao.modifier(l);
    }

    public Lien rechercherId(long id) {
        return dao.rechercherId(id);
    }

    public List<Lien> rechercherTout() {
        return dao.rechercherTout();

    }

}
