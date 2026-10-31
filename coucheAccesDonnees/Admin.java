package projetgl.coucheAccesDonnees;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author BAKI
 */
public class Admin {

    private int id;
    private String adminName;
    private String passWord;

    public Admin(int id, String adminName, String passWord) {
        this.id = id;
        this.adminName = adminName;
        this.passWord = passWord;
    }

    public Admin(String adminName, String passWord) {
        this.adminName = adminName;
        this.passWord = passWord;
    }

    public int getId() { return id; }
    public String getAdminName() { return adminName; }
    public String getPassWord() { return passWord; }

    public void setId(int id) { this.id = id; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
    public void setPassWord(String passWord) { this.passWord = passWord; }
}

