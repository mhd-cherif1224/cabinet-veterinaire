package projetgl.coucheLogiqueMetier;

import java.util.List;
import javax.swing.JOptionPane;
import projetgl.coucheAccesDonnees.RendezVous;
import projetgl.coucheAccesDonnees.RendezVousDAO;

/**
 *
 * @author BAKI
 */
public class GestiondesRendezVous {

    private static RendezVousDAO dao = new RendezVousDAO();

    public static void addRendezVous(String date, String heure,String tache, int animalId) {

        if (date.isEmpty() || heure.isEmpty() || tache.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ne laissez pas un champ vide");
            throw new RuntimeException("Fields cannot be empty");
        }
        else if (animalId <= 0) {
            JOptionPane.showMessageDialog(null, "L'ID de l'animal doit être supérieur à zéro");
            throw new RuntimeException("Invalid animal ID");
        }

        RendezVous rv = new RendezVous(date, heure,tache, animalId);
        dao.insert(rv);
    }
    
    
    public List<RendezVous> getAllRendezVous() {
        return dao.getAllRendezVous();
    }

    public boolean deleteRendezVous(int id) {
        return dao.delete(id);
    }
}
