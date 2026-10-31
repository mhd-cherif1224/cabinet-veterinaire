/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheLogiqueMetier;

import projetgl.coucheAccesDonnees.Crew;
import projetgl.coucheAccesDonnees.CrewDAO;
import projetgl.coucheAccesDonnees.Docteur;
import projetgl.coucheAccesDonnees.DocteurDAO;

/**
 *
 * @author BAKI
 */
public class GestionCrew {
    private static CrewDAO ddao = new CrewDAO();

    public static void addCrew(String nom, String prenom, String sexe, String Address, String mail, int num, String motdePasse) {
        
        Crew c = new Crew(nom, prenom, sexe, Address, mail, num, motdePasse);
        ddao.insert(c);
    }
}
