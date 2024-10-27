/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
public class usuario {
    conexion con;

    public usuario(){
        con = new conexion();
    }
    
    public boolean validarUsuario(String username, String password){
        try {
            String sql = "SELECT * FROM usuario WHERE usuario=? AND password=?";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println();
            return true;
        }
    }
}
