/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;

public class contacto {
    conexion con;
    
    public contacto(){
        con = new conexion();
    }
    
    public Object[][] getContacto(){
        int registros = 0;
        try {
            String sql = "SELECT count(1) AS total FROM contacto";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        Object [][] datos = new Object[registros][6];
        try {
            String sql = "SELECT * FROM contacto ORDER BY idcontacto";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            int i=0;
            while (res.next()){
                int idcontacto = res.getInt("idcontacto");
                long cedula = res.getLong("cedula");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String direccion = res.getString("direccion");
                long celular = res.getLong("celular");
                datos [i][0] = idcontacto;
                datos [i][1] = cedula;
                datos [i][2] = nombre;
                datos [i][3] = apellido;
                datos [i][4] = direccion;
                datos [i][5] = celular;
                i++;            
            }
                res.close();
                
        } catch (Exception e) {
            System.err.println(e);
        }
        return datos;
    }
    
    public void AgregarContacto(long cedula, String nombre, String apellido, String direccion, long celular) {
        String sql = "INSERT INTO contacto(cedula, nombre, apellido, direccion, celular) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setLong(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion);
            ps.setLong(5, celular);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
