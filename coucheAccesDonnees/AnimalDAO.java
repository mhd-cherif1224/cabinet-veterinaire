/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BAKI
 */
public class AnimalDAO {
    

    public void insert(Animal animal) {
        try {
            Connection conn = connectionBaseDonnee.getConnection();
            
            String sql = "INSERT INTO animaux (nom, espece,age, poids_kg, proprietaireId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, animal.getNom());
            ps.setString(2, animal.getEspece());
            ps.setInt(3, animal.getAge());
            ps.setDouble(4, animal.getPoidsKg());
            ps.setInt(5, animal.getProprietaireId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
   public List<Animal> getAllAnimaux() {
    List<Animal> animaux = new ArrayList<>();

    String sql = "SELECT * FROM Animaux";
    try {
        Connection conn = connectionBaseDonnee.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Animal a = new Animal(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("espece"),
                rs.getInt("age"),
                rs.getDouble("poids_kg"),
                rs.getInt("proprietaireId")
            );
            animaux.add(a);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return animaux;
}
   
    public boolean delete(int id) {
    String sql = "DELETE FROM animaux WHERE id = ?";

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
    public Animal getById(int id) {
        String sql = "SELECT * FROM animaux WHERE id = ?";

        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = connectionBaseDonnee.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Animal a = new Animal();
                a.setId(rs.getInt("id"));
                a.setNom(rs.getString("nom"));
                a.setEspece(rs.getString("espece"));
                a.setAge(rs.getInt("age"));
                a.setPoidsKg(rs.getDouble("poids_kg"));
                a.setProprietaireId(rs.getInt("proprietaireid"));  // foreign key
                return a;
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ex) {}
            try { if (ps != null) ps.close(); } catch (Exception ex) {}
            try { } catch (Exception ex) {}
        }
    }

//    if (conn != null) conn.close(); 

        public boolean update(int id, String nom, String espece, int age, double poids) {
    String sql = "UPDATE Animal SET nom=?, espece=?, age=?, poids=? WHERE id=?";

    try (Connection conn = connectionBaseDonnee.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, nom);
        pst.setString(2, espece);
        pst.setInt(3, age);
        pst.setDouble(4, poids);
        pst.setInt(5, id);

        return pst.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

   
}

