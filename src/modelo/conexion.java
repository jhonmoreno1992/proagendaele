/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {
    public static String bd = "agenda";
    public static String user = "root";
    public static String password = "jhon2772";
    public static String url = "jdbc:mariadb://localhost:3306/"+bd;
    
    Connection con;
    
    public conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            if (con!=null){
                System.out.println("Conexion a Base de datos " + bd);
                //JOptionPane.showMessageDialog(null, "Conexion a Base de datos " + bd);
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void desconectar(){
        con = null;
    }
}
