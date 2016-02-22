/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming;

/**
 *
 * @author admin
 */
class Personne {
    
    private String nom;
    private String prenom;
    private double solde;
    private byte age;
    
    public Personne(String nom,String prenom,double solde,byte age){
        this.nom = nom;
        this.prenom = prenom;
        this.solde = solde;
        this.age = age;
    }
    public Personne(String nom,String prenom,Long solde,String age){
        this.nom = nom;
        this.prenom = prenom;
        this.solde = (double) solde;
        this.age = Byte.parseByte(age);
    }
    
    public String toString(){
        return "Nom : " +nom +"\nPrénom : " + prenom +"\nSolde du compte : " + solde + " €\nAge : " + age;
    }
}
