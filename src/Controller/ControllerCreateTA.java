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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author Rachmi
 */
public class ControllerCreateTA implements ActionListener, FocusListener{
    Database db;
    CreateTA view;
    TugasAkhir ta;
    Mahasiswa m;
    
    public ControllerCreateTA(Mahasiswa m){
        this.m = m;
        db = new Database();
        db.connect();
        view = new CreateTA();
        view.setVisible(true);
        view.addListener(this);
        this.ta=null;
        
//        this.view.getTfJudulTA().addFocusListener((FocusListener) this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source.equals(view.getBtnCreate())){
            String judul = view.getJudulTA();
            m.createTA(judul);
            try{
                db.insertTugasAkhir(m.getTugasAkhir(), m.getNim());
                view.showMessage(null, "Berhasil buat TA");
            }catch(SQLException er){
                System.out.println(er.getMessage());
                view.showMessage(null, "Gagal buat TA");
            }
        }
        new ControllerMenuMahasiswa(m);
        view.dispose();
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

