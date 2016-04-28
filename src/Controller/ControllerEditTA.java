/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Mahasiswa;
import Model.TugasAkhir;
import View.CreateTA;
import View.EditTA;
import View.MenuMahasiswa;
import static com.sun.java.accessibility.util.AWTEventMonitor.addFocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rachmi
 */
public class ControllerEditTA implements ActionListener, FocusListener{
    Database db;
    Mahasiswa m;
    EditTA view;
    TugasAkhir ta;
    
    public ControllerEditTA(Mahasiswa m) {
        this.m=m;
        db = new Database();
        db.connect();
        view = new EditTA();
        view.setVisible(true);
        view.addListener((ActionListener) this);
        this.ta = null;
//        this.view.getEditJudul().addFocusListener((FocusListener) this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source.equals(view.getBtnSave())){
            String judul = view.getEditJudul();
            m.editJudul(judul);
            try {
                db.updateTugasAkhir(m.getNim(), judul);
                view.showMessage(null, "Judul berhasil diganti");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(source.equals(view.getBtnBack())){
            new ControllerMenuMahasiswa(m);
            view.dispose();
        }
}

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
