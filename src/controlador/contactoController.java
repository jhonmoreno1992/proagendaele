/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contacto;
import vista.frmcontacto;

/**
 *
 * @author usuario
 */
public class contactoController implements ActionListener {

    public final contacto modeloContacto;
    public final frmcontacto vistaContacto;
    Object[][] datosContacto;
    int fila = -1;

    public contactoController(contacto modeloContacto, frmcontacto vistaContacto) {
        this.modeloContacto = modeloContacto;
        this.vistaContacto = vistaContacto;
        this.vistaContacto.btnguardar.addActionListener(this);
        this.vistaContacto.btnlimpiar.addActionListener(this);
        
    }
    
    public void updateTable(){
        Object[] columna = {"ID", "CEDULA", "NOMBRE", "APELLIDO", "DIRECCION", "CELULAR"};
        datosContacto = modeloContacto.getContacto();
        DefaultTableModel datos = new DefaultTableModel(datosContacto, columna);
        vistaContacto.tbcontacto.setModel(datos);
          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //metodos guardar, modificar y limpiar
        if(e.getSource() == vistaContacto.btnguardar){
            long cedula, celular = 0;
            String nombre = vistaContacto.txtnombre.getText();
            String apellido = vistaContacto.txtapellido.getText();
            String direccion = vistaContacto.txtdireccion.getText();
            if(vistaContacto.txtcedula.getText().isEmpty() ||
               nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty()
               || vistaContacto.txtcelular.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Falta datos");
            }else{
                cedula = Long.parseLong(vistaContacto.txtcedula.getText());
                celular = Long.parseLong(vistaContacto.txtcelular.getText());
                modeloContacto.AgregarContacto(cedula, nombre, apellido, direccion, celular);
                JOptionPane.showMessageDialog(null,"Registro Guardado");
                this.updateTable();
            } 
            
        }
    }

}
