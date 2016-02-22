/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDAO;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmService {

    private FilmDAO dao = new FilmDAO();

    public void ajouter(Film f) {
        dao.ajouter(f);
    }

    public void supprimer(Film f) {
        dao.supprimer(f);
    }

    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Film f) {
        dao.modifier(f);
    }

    public Film rechercherId(long id) {
        return dao.rechercherId(id);
    }

    public List<Film> rechercherTout() {
        return dao.rechercherTout();

    }
}
