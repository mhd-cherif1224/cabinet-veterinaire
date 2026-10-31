/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import projetgl.coucheAccesDonnees.ProduitDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BAKI
 */
public class ProduitDAO {
    public void insert(Produit produit) {
        try {
            Connection conn = connectionBaseDonnee.getConnection();
            
            String sql = "INSERT INTO Produit (nom, quantite, prix) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produit.getNom());
            ps.setInt(2, produit.getQuantite());
            ps.setDouble(3, produit.getPrix());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertUtiliser(Produit produit) {
        try {
            Connection conn = connectionBaseDonnee.getConnection();
            
            String sql = "INSERT INTO ProduitUtiliser (nom, quantite, prix) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produit.getNom());
            ps.setInt(2, produit.getQuantite());
            ps.setDouble(3, produit.getPrix());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Produit> getAll() {
    List<Produit> produits = new ArrayList<>();

    String sql = "SELECT * FROM Produit";
    try {
        Connection conn = connectionBaseDonnee.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Produit a = new Produit(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getInt("quantite"),
                rs.getDouble("prix")
            );
            produits.add(a);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return produits;
}
    
    public List<Produit> getAllUtiliser() {
    List<Produit> produits = new ArrayList<>();

    String sql = "SELECT * FROM ProduitUtiliser";
    try {
        Connection conn = connectionBaseDonnee.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Produit a = new Produit(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getInt("quantite"),
                rs.getDouble("prix")
            );
            produits.add(a);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return produits;
}
    
    public boolean delete(int id) {
    String sql = "DELETE FROM produit WHERE id = ?";

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
    
    public boolean deleteUtiliser(int id) {
    String sql = "DELETE FROM produitUtiliser WHERE id = ?";

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


    public boolean deleteAllUtiliser() {
    String sql = "DELETE FROM produitutiliser";

    try (Connection conn = connectionBaseDonnee.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.executeUpdate();
        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    
    public double getTotalPrixUtiliser() {
    String sql = "SELECT SUM(prix * quantite) AS total FROM produitutiliser";

    try (Connection conn = connectionBaseDonnee.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            return rs.getDouble("total");
        }

        return 0.0;

    } catch (Exception e) {
        e.printStackTrace();
        return 0.0;
    }
}
   
}



