/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheLogiqueMetier;

import java.util.List;
import javax.swing.JOptionPane;
import projetgl.coucheAccesDonnees.Admin;
import projetgl.coucheAccesDonnees.AdminDAO;
import projetgl.coucheAccesDonnees.Produit;
import projetgl.coucheAccesDonnees.ProduitDAO;

import javax.swing.JOptionPane;
import projetgl.coucheAccesDonnees.Animal;
import projetgl.coucheAccesDonnees.AnimalDAO;
import projetgl.coucheAccesDonnees.Produit;
import projetgl.coucheAccesDonnees.ProduitDAO;

/**
 *
 * @author BAKI
 */
public class GestionAnimal {
    



  private static AnimalDAO dao = new AnimalDAO();
    public static void addAnimal(String nom, String espece, int age, double poids, int proprietaireId) {
        if (nom.isEmpty() || espece.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "ne laisser pas un champ vide");
            throw new RuntimeException("Fields cannot be empty");
        }
        else if(poids <= 0 || age <= 0 || proprietaireId <= 0 ){
            JOptionPane.showMessageDialog(null, "mettez le poids et l'age et le id superieur a zero");
            throw new RuntimeException("mettez la quantite et le prix plus de zero");
        }
            
        
        Animal animal = new Animal( nom, espece, age, poids,proprietaireId);
        dao.insert(animal);
    }  
    
    
     public List<Animal> getAllAnimaux() {
        return dao.getAllAnimaux();
    }
}