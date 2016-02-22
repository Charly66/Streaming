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
public class Ensemble implements Collection, Affichable{

    int nbElements = 0;
    int indice = 0;
    Object tab[] = new Object[10];
    boolean trouve = false;

    public void ajouter(Object o) {
        int i = 0;
        while (i < nbElements && trouve == false) {
            if (tab[i] == o) {
                trouve = true;
                int indice = i;
            }
            i++;
        }

        if (trouve == false) {
            tab[nbElements] = o;
            nbElements++;
            System.out.println("Element " + o.getClass().getSimpleName() + " ajouté");
        } else {
            System.out.println("Element " + o.getClass().getSimpleName() + " non ajouté");
        }
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
