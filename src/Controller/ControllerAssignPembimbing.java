/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Dosen;
import Model.Mahasiswa;
import View.AssignPembimbing;
import View.Login;
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
 * @author alvinmatias69
 */
public class ControllerAssignPembimbing implements ActionListener, FocusListener{
    Dosen d;
    AssignPembimbing view;
    Database db;

    public ControllerAssignPembimbing(Dosen d) {
        this.d = d;
        view = new AssignPembimbing();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Login Sistem Informasi");
        this.view.getTfId().addFocusListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnAssign())){
            db.selectMahasiswa(view.getNim()).getTugasAkhir().setPembimbing(d, view.getId());
            try {
                db.setPembimbing(db.selectMahasiswa(view.getNim()).getTugasAkhir().getJudul(), d.getKodeDosen(), view.getId());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAssignPembimbing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }
    
    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if(o.equals(this.view.getNim())){
            if(this.view.getNim().equals("")){
                JOptionPane.showMessageDialog(null, "Harap isi Kode Dosen / NIM");
            }
        }
    }
}
