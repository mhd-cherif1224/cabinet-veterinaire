// ===== CLASS: RendezVousDAO =====
package projetgl.coucheAccesDonnees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RendezVousDAO {

    // INSERT
    public void insert(RendezVous r) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = connectionBaseDonnee.getConnection();
            String sql = "INSERT INTO rendezvous (date_rdv, heure_rdv,tache, animalId) VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, r.getDate());
            ps.setString(2, r.getHeure());
            ps.setString(3, r.getTache());
            ps.setInt(4, r.getAnimalId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // SELECT ALL
    public List<RendezVous> getAllRendezVous() {
        List<RendezVous> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = connectionBaseDonnee.getConnection();
            String sql = "SELECT * FROM rendezvous";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                RendezVous r = new RendezVous(
                    rs.getInt("id"),
                    rs.getString("date_rdv"),
                    rs.getString("heure_rdv"),
                    rs.getString("tache"),
                        
                    rs.getInt("animalId")
                );
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    // DELETE
    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = connectionBaseDonnee.getConnection();
            String sql = "DELETE FROM rendezvous WHERE id = ?";
            pst = conn.prepareStatement(sql);

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // GET NEXT RDV (important for your "swivel" button)
    public RendezVous getNext(int currentId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectionBaseDonnee.getConnection();
            String sql = "SELECT * FROM rendezvous WHERE id > ? ORDER BY id LIMIT 1";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, currentId);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new RendezVous(
                    rs.getInt("id"),
                    rs.getString("date_rdv"),
                    rs.getString("heure_rdv"),
                    rs.getString("tache"), 
                    rs.getInt("animalId")
                );
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
   public RendezVous getPrevious(int currentId) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = connectionBaseDonnee.getConnection();
        String sql = "SELECT * FROM rendezvous WHERE id < ? ORDER BY id DESC LIMIT 1";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, currentId);

        rs = ps.executeQuery();

        if (rs.next()) {
            return new RendezVous(
                rs.getInt("id"),
                rs.getString("date_rdv"),
                rs.getString("heure_rdv"),
                rs.getString("tache"),
                rs.getInt("animalId")
            );
        }

        return null;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

}
