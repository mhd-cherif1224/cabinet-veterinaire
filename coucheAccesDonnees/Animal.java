/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;



public class Animal {
    private int id;
    private String nom;
    private String espece;
    private int age;
    private double poidsKg;
    private int proprietaireId;

    public Animal(){
    }
    // Constructor WITH id (for reading from DB)
    public Animal(int id, String nom, String espece, int age, double poidsKg, int proprietaireId) {
        this.id = id;
        this.nom = nom;
        this.espece = espece;
        this.age = age;
        this.poidsKg = poidsKg;
        this.proprietaireId = proprietaireId;
    }

    // Constructor WITHOUT id (for inserting into DB)
    public Animal(String nom, String espece, int age, double poidsKg, int proprietaireId) {
        this.nom = nom;
        this.espece = espece;
        this.age = age;
        this.poidsKg = poidsKg;
        this.proprietaireId = proprietaireId;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEspece() {
        return espece;
    }

    public int getAge() {
        return age;
    }

    public double getPoidsKg() {
        return poidsKg;
    }

    public int getProprietaireId() {
        return proprietaireId;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPoidsKg(double poidsKg) {
        this.poidsKg = poidsKg;
    }

    public void setProprietaireId(int proprietaireId) {
        this.proprietaireId = proprietaireId;
    }
}
