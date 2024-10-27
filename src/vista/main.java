/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelo.conexion;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            frmlogin login = new frmlogin();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            conexion con = new conexion();
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

    }

}
