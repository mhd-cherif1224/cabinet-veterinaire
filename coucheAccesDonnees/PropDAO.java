package projetgl.coucheAccesDonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PropDAO {

    // INSERT
    public void insert(Prop p) {
        try {
            Connection conn = connectionBaseDonnee.getConnection();

            String sql = "INSERT INTO proprietaires (nom, telephone, adresse) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNom());
            ps.setString(2, p.getTelephone());
            ps.setString(3, p.getAdresse());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET ALL
    public List<Prop> getAll() {
        List<Prop> list = new ArrayList<>();

        String sql = "SELECT * FROM proprietaires";

        try {
            Connection conn = connectionBaseDonnee.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Prop p = new Prop(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("telephone"),
                        rs.getString("adresse")
                );

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM proprietaires WHERE id = ?";

        try {
            Connection conn = connectionBaseDonnee.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Prop getById(int id) {
        Prop p = null;
        String sql = "SELECT * FROM proprietaires WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectionBaseDonnee.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                p = new Prop();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setTelephone(rs.getString("telephone"));
                p.setAdresse(rs.getString("adresse"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return p;
    }
}
