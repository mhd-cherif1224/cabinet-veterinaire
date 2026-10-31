/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;


public class RendezVous {

    private int id;
    private String date;   // you can change to LocalDate if you want
    private String heure;  // or LocalTime
    private int animalId;
    private String tache;
    

    // Constructor WITH id (for reading from DB)
    public RendezVous(int id, String date, String heure,String tache, int animalId) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.animalId = animalId;
        this.tache = tache;
    }

    // Constructor WITHOUT id (for inserting into DB)
    public RendezVous(String date, String heure,String tache, int animalId) {
        this.date = date;
        this.heure = heure;
        this.animalId = animalId;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }
    public String getTache() {
        return tache;
    }

    public int getAnimalId() {
        return animalId;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
    public void setTache(String tache) {
        this.tache = tache;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}
