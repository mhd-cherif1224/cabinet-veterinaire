/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DocteurDAO {

    public void insert(Docteur d) {
        String sql = "INSERT INTO Docteur (nom, prenom, sexe, address, mail, num, motdepasse) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = connectionBaseDonnee.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, d.getNom());
            pst.setString(2, d.getPrenom());
            pst.setString(3, d.getSexe());
            pst.setString(4, d.getAddress());
            pst.setString(5, d.getMail());
            pst.setInt(6, d.getNum());
            pst.setString(7, d.getMotdePasse());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
