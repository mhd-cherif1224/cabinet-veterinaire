/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;



public class Crew {
      private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String address;
    private String mail;
    private int num;
    private String motdePasse;

    public Crew() {
        // empty constructor
    }

    public Crew(String nom, String prenom, String sexe, String address, String mail, int num, String motdePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.address = address;
        this.mail = mail;
        this.num = num;
        this.motdePasse = motdePasse;
    }

    // Getters & Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public int getNum() { return num; }
    public void setNum(int num) { this.num = num; }

    public String getMotdePasse() { return motdePasse; }
    public void setMotdePasse(String motdePasse) { this.motdePasse = motdePasse; }
}
