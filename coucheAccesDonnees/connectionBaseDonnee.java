/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetgl.coucheAccesDonnees;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionBaseDonnee{

    private static final String URL = "jdbc:mysql://localhost:3306/gl_tp_projet_db"; // your database name
    private static final String USER = "root"; // default user in WAMP
    private static final String PASSWORD = ""; // leave empty if no password

    private static Connection connection;

    public static Connection getConnection() {
    try {
        if (connection == null || connection.isClosed()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected!");
        }
    } catch (SQLException | ClassNotFoundException e) {
        System.err.println("Connection error: " + e.getMessage());
    }

    return connection;
}

}