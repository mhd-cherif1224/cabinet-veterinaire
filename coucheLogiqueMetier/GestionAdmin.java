package projetgl.coucheLogiqueMetier;

import java.util.List;
import javax.swing.JOptionPane;
import projetgl.coucheAccesDonnees.Admin;
import projetgl.coucheAccesDonnees.AdminDAO;

public class GestionAdmin {
    private static AdminDAO dao = new AdminDAO();

    public static void addAdmin(String name, String pass) {
        if (name.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ne laisser pas un champ vide");
            throw new RuntimeException("Fields cannot be empty");
            
        }
        Admin admin = new Admin(name, pass);
        dao.insert(admin);
    }
    
    public boolean verifierAccess(String name, String pass){
        if (name.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ne laisser pas un champ vide");
            throw new RuntimeException("Fields cannot be empty");
            
        }
        
        AdminDAO dao = new AdminDAO();
        
        if(dao.check(name, pass)){
            return true;
            
            
        }else{
            return false;
        }
    }
    
    public List<Admin> getAllAdmins() {
        return dao.getAll();
    }
    
    
    
}

