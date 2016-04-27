/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Dosen;
import View.BuatKelTA;
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
 * @author Dian Dwi Arini
 */
public class ControllerBuatKelompok implements ActionListener, FocusListener {
    Database db;
    BuatKelTA view;
    Dosen d;
    
    public ControllerBuatKelompok(Dosen d){
        this.d=d;
        db = new Database();
        db.connect();
        view = new BuatKelTA();
        view.setVisible(true);
        view.addListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnBuat())){
            d.createKelompokTA(view.getTopik());
            try {
                if(d.getKelompokTA(0).getTopik().equals("")){
                    d.getKelompokTA(0).setTopik(view.getTopik());
                    d.getKelompokTA(0).setIdKelompok(1);
                }
                db.insertKelompokTA(d.getKelompokTA(view.getTopik()), d.getKodeDosen());
                JOptionPane.showMessageDialog(null, "Kelompok Berhasil Dibuat");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kelompok Gagal Dibuat");
            }
            
        }else if (source.equals(view.getBtnBack())){
            new ControllerMenuDosen(d);
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
