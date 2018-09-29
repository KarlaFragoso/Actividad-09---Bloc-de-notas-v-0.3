/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ViewBloc;
import Models.ModelBloc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ControllerBloc {
    
        
    
    ViewBloc viewbloc;
    ModelBloc modelbloc;
    ActionListener ac = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewbloc.jm_abrir)
                    abrir();
            else if(e.getSource() == viewbloc.jm_guardar)
                    guardar();
            else if (e.getSource() == viewbloc.jm_cifrar)
                    cifrar();
            else if(e.getSource() == viewbloc.jm_decifrar)
                descifrar();
        }
    };
    public ControllerBloc(ViewBloc viewbloc, ModelBloc modelbloc) {
        this.viewbloc = viewbloc;
        this.modelbloc = modelbloc;
        this.viewbloc.jm_guardar.addActionListener(ac);
        this.viewbloc.jm_abrir.addActionListener(ac);
        this.viewbloc.jm_cifrar.addActionListener(ac);
        this.viewbloc.jm_decifrar.addActionListener(ac);
        initComponents();
    }
    public void abrir(){
        modelbloc.openFile();
        leer();
    }
    public void leer(){
        modelbloc.readFile();
        viewbloc.jta_texto.setText(modelbloc.getMensaje());
    }
    public void cifrar(){
        modelbloc.setMensaje(viewbloc.jta_texto.getText());
        modelbloc.stringCifrado();
        viewbloc.jta_texto.setText(modelbloc.getCaesar());
    }
    public void descifrar(){
        modelbloc.setMensaje(viewbloc.jta_texto.getText());
        modelbloc.Cifrado2String();
        viewbloc.jta_texto.setText(modelbloc.getCaesar());
    }
    public void guardar(){
        modelbloc.setMensaje(viewbloc.jta_texto.getText());
        modelbloc.writeFile();
        viewbloc.jta_texto.setText("");
    }
    private void initComponents(){
        viewbloc.setVisible(true);
    }
}
