
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projetgl.coucheAccesDonnees;


/**
 *
 * @author BAKI
 */
public class Produit {

    private int id;
    private String nom;
    private int quantite;
    private double prix;

    public Produit(int id, String nom, int quantite , double prix ) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Produit( String nom, int quantite , double prix ) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    
}

