/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheLogiqueMetier;


import java.util.List;
import javax.swing.JOptionPane;
import projetgl.coucheAccesDonnees.AdminDAO;
import projetgl.coucheAccesDonnees.User;
import projetgl.coucheAccesDonnees.UserDAO;

public class GestionUser {
    private static UserDAO dao = new UserDAO();

    public static void addUser(String nom, String prenom, String sexe,String Address,String mail, int num, String motdePasse, String type) {
        if (nom.isEmpty() || prenom.isEmpty() || sexe.isEmpty() || Address.isEmpty() || mail.isEmpty() || motdePasse.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "ne laisser pas un champ vide");
            throw new RuntimeException("Fields cannot be empty");
        }
        User U = new User(nom, prenom, sexe, Address, mail, num, motdePasse, type);
        dao.insert(U);
    }
    
    
    
    public boolean verifierAccess(String name, String pass, String type){
        if (name.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ne laisser pas un champ vide");
            throw new RuntimeException("Fields cannot be empty");
            
        }
        
        UserDAO dao = new UserDAO();
        
        if(dao.check(name, pass ,type)){
            
            return true;
            
            
        }else{
            return false;
        }
    }
    
    public List<User> getAllUsers() {
        return dao.getAll();
    }
    
}


