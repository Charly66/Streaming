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
public interface Collection {
    
    public void ajouter(Object o);
    public void supprimer(Object o);
    public int taille();
    public Object getObject(int i);
}
