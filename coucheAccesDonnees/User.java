/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;


public class User {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private String email;
    private int telephone;
    private String motDePasse;
    private String type;

    public User(int id,String nom, String prenom, String sexe, String adresse,
                       String email, int telephone, String motDePasse, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.type = type;
    }
    
    public User(String nom, String prenom, String sexe, String adresse,
                       String email, int telephone, String motDePasse, String type) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.type = type;
    }

    // getters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getSexe() { return sexe; }
    public String getAdresse() { return adresse; }
    public String getEmail() { return email; }
    public int getTelephone() { return telephone; }
    public String getMotDePasse() { return motDePasse; }
    public String getType() { return type; }
}
