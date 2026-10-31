/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;

public class Prop {
    private int id;
    private String nom;
    private String telephone;
    private String adresse;
    
    public Prop(){
    }

    public Prop(int id, String nom, String telephone, String adresse) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Prop(String nom, String telephone, String adresse) {
        this.nom = nom;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getTelephone() { return telephone; }
    public String getAdresse() { return adresse; }

    
     public void setId(int id) { this.id = id; }
    public void setNom(String n) { this.nom = n; }
    public void setTelephone(String t) { this.telephone = t; }
    public void setAdresse(String a) { this.adresse = a; }
}
