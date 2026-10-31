package projetgl.coucheLogiqueMetier;

import java.util.List;
import javax.swing.JOptionPane;
import projetgl.coucheAccesDonnees.Prop;
import projetgl.coucheAccesDonnees.PropDAO;

public class GestiondesProprietaire {

    private static PropDAO dao = new PropDAO();

    public static void addProp(String nom, String telephone, String adresse) {

        // Vérification des champs vides
        if (nom.isEmpty() || telephone.isEmpty() || adresse.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ne laissez pas un champ vide.");
            throw new RuntimeException("Champs vides");
        }

        // Vérification du téléphone (ex: doit être numérique)
        if (!telephone.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Le numéro de téléphone doit être numérique.");
            throw new RuntimeException("Téléphone invalide");
        }

        // Création de l'objet
        Prop p = new Prop(nom, telephone, adresse);

        // Insertion
        dao.insert(p);
    }
    
    public List<Prop> getAllProps() {
        return dao.getAll();
    }

    public boolean deleteProp(int id) {
        return dao.delete(id);
    }
}
