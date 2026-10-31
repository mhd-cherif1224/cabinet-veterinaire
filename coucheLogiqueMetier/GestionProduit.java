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

/**
 *
 * @author BAKI
 */
public class GestionProduit {
    



  private static ProduitDAO dao = new ProduitDAO();

    public static void addProduit(String nom, int quantite, double prix) {
        if (nom.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ne laisser pas un champ vide");
            throw new RuntimeException("Fields cannot be empty");
        }
        else if(quantite <= 0 || prix <= 0 ){
            JOptionPane.showMessageDialog(null, "mettez la quantite et le prix plus de zero");
            throw new RuntimeException("mettez la quantite et le prix plus de zero");
        }
            
        
        Produit produit = new Produit(nom, quantite, prix);
        dao.insert(produit);
    }    


        public static void addProduitUtiliser(String nom, int quantite, double prix) {
            if (nom.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ne laisser pas un champ vide");
                throw new RuntimeException("Fields cannot be empty");
            }
            else if(quantite <= 0 || prix <= 0 ){
                JOptionPane.showMessageDialog(null, "mettez la quantite et le prix plus de zero");
                throw new RuntimeException("mettez la quantite et le prix plus de zero");
            }


            Produit produit = new Produit(nom, quantite, prix);
            dao.insertUtiliser(produit);
        }    

        public void eraseProduitUtiliser() {
            dao.deleteAllUtiliser(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        public boolean deleteProduit(int id){
            
             if (dao.deleteUtiliser(id)){
                 return true;
             }else{
                 return false;
             }
            
            
        }
        
        public List<Produit> getAllProducts() {
        return dao.getAll();
    }

    public List<Produit> getAllUtiliser() {
        return dao.getAllUtiliser();
    }

    public double getTotalUtiliser() {
        return dao.getTotalPrixUtiliser();
    }
    

    public boolean deleteProduct(int id) {
        return dao.delete(id);
    }
}
