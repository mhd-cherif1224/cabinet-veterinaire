/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public int insert(User u) {
        String sql = "INSERT INTO Utilisateur (nom, prenom, sexe, adresse, email, telephone, motDePasse, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = connectionBaseDonnee.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getSexe());
            pst.setString(4, u.getAdresse());
            pst.setString(5, u.getEmail());
            pst.setInt(6, u.getTelephone());
            pst.setString(7, u.getMotDePasse());
            pst.setString(8, u.getType());
            

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // error
    }
    
    
    
    public List<User> getAll() {
    List<User> users = new ArrayList<>();

    String sql = "SELECT id, nom, prenom, sexe, email, telephone, adresse, motDePasse, type FROM utilisateur";

    try {
        Connection conn = connectionBaseDonnee.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            User a = new User(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("sexe"),
                rs.getString("adresse"),
                rs.getString("email"),
                rs.getInt("telephone"),
                rs.getString("motDePasse"),
                rs.getString("type")
                    
                    
                    
            );
            users.add(a);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return users;
}
    
    public boolean delete(int id) {
    String sql = "DELETE FROM utilisateur WHERE id = ?";

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

    public boolean check(String name, String pass, String type) {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        conn = connectionBaseDonnee.getConnection();

        String sql = "SELECT 1 FROM Utilisateur WHERE nom = ? AND motDePasse = ? AND type = ?";
        pst = conn.prepareStatement(sql);

        pst.setString(1, name);
        pst.setString(2, pass);
        pst.setString(3, type);

        rs = pst.executeQuery();

        return rs.next(); // true

    } catch (Exception e) {
        e.printStackTrace();
        return false;

    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (pst != null) pst.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
}
    
    


}



