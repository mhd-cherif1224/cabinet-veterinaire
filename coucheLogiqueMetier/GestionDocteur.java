/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheLogiqueMetier;

import projetgl.coucheAccesDonnees.Docteur;
import projetgl.coucheAccesDonnees.DocteurDAO;
import projetgl.coucheAccesDonnees.User;
import projetgl.coucheAccesDonnees.UserDAO;

/**
 *
 * @author BAKI
 */
public class GestionDocteur {
     private static DocteurDAO ddao = new DocteurDAO();

    public static void addDocteur(String nom, String prenom, String sexe, String Address, String mail, int num, String motdePasse) {
        
        Docteur d = new Docteur(nom, prenom, sexe, Address, mail, num, motdePasse);
        ddao.insert(d);
    }
}
