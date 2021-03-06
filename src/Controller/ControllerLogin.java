/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Dosen;
import Model.Mahasiswa;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alvinmatias69
 */
public class ControllerLogin implements ActionListener, FocusListener{
    Login view;
    Database db;
    
    public ControllerLogin(){
        db  = new Database();
        db.connect();
        view = new Login();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Login Sistem Informasi");
        this.view.getTfKode().addFocusListener(this);
        this.view.getTfPassword().addFocusListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source.equals(view.getBtnLoginDosen())){
            if(db.loginDosen(view.getKode(), view.getPassword())){
                Dosen d = new Dosen("","","","");
                d = db.selectDosen(view.getKode());
//                d.setTopikTA(db.getAllKelompokTA(view.getKode()));
                view.dispose();
                new ControllerMenuDosen(d);
            }else{
                JOptionPane.showMessageDialog(null, "Kode Dosen atau Password Salah, coba lagi");
            }
        }else{
            if(db.loginMahasiswa(view.getKode(), new String(view.getPassword()))){
                Mahasiswa m;
                m = db.selectMahasiswa(view.getKode());
//                if(m!=null){
//                    System.out.println("mhs ada");
//                }
                new ControllerMenuMahasiswa(m);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "NIM atau Password Salah, coba lagi");
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if(o.equals(this.view.getTfKode())){
            if(this.view.getKode().equals("")){
                JOptionPane.showMessageDialog(null, "Harap isi Kode Dosen / NIM");
            }
        }else{
            if( (new String(this.view.getPassword())).equals("") ){
                JOptionPane.showMessageDialog(null, "Harap isi Password");
            }
        }
    }
}
