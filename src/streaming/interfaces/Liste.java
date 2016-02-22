/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.interfaces;

/**
 *
 * @author admin
 */
public class Liste implements Collection, Affichable{

    int nbElements = 0;
    Object tab[] = new Object[10];

    public void ajouter(Object o) {
            tab[nbElements] = o;
            nbElements++;
    }

    public int taille() {
        return nbElements;
    }

    public Object getObject(int i) {
        return tab[i];
    }

    @Override
    public void supprimer(Object o) {
    }

    @Override
    public void afficher() {
        for(int i =0;i<nbElements;i++)
            System.out.println(tab[i] + "; ");
    }
}
