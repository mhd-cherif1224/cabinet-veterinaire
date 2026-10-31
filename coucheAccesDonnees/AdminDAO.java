/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author BAKI
 */
public class AdminDAO {
    public void insert(Admin admin) {
        try {
            Connection conn = connectionBaseDonnee.getConnection();
            
            String sql = "INSERT INTO Admin (adminName, passWord) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getAdminName());
            ps.setString(2, admin.getPassWord());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Admin> getAll() {
    List<Admin> admins = new ArrayList<>();

    String sql = "SELECT * FROM Admin";
    try {
        Connection conn = connectionBaseDonnee.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Admin a = new Admin(
                rs.getInt("id"),
                rs.getString("adminName"),
                rs.getString("passWord")
            );
            admins.add(a);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return admins;
}
    
    public boolean delete(int id) {
    String sql = "DELETE FROM Admin WHERE id = ?";

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


   public boolean check(String name, String pass) {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        conn = connectionBaseDonnee.getConnection();

        String sql = "SELECT 1 FROM admin WHERE adminName = ? AND passWord = ?";
        pst = conn.prepareStatement(sql);

        pst.setString(1, name);
        pst.setString(2, pass);

        rs = pst.executeQuery();

        return rs.next(); // true = admin exists

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
