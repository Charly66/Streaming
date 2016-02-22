/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.GenreDAO;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreService {

    private GenreDAO dao = new GenreDAO();

    public void ajouter(Genre g) {
        dao.ajouter(g);
    }

    public void supprimer(Genre g) {
        dao.supprimer(g);
    }

    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Genre g) {
        dao.modifier(g);
    }

    public Genre rechercherId(long id) {
        return dao.rechercherId(id);
    }

    public List<Genre> rechercherTout() {
        return dao.rechercherTout();

    }

}
