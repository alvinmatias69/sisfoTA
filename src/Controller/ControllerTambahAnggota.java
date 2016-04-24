/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Dosen;
import Model.KelompokTA;
import Model.Mahasiswa;
import View.TambahAnggota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dian Dwi Arini
 */
public class ControllerTambahAnggota implements ActionListener, FocusListener {
    TambahAnggota view;
    Database db;
    KelompokTA k;
    Mahasiswa m;
    public ControllerTambahAnggota(Database db){
        db = new Database();
        TambahAnggota view = new TambahAnggota();
        view.setVisible(true);
        view.addListener(this);
        this.m=null;
        this.view.getTfNIM().addFocusListener(this);
    }
    public ControllerTambahAnggota(Database db, Dosen d){
        TambahAnggota view = new TambahAnggota();
        view.setVisible(true);
        view.addListener(this);
        this.m=m;
        view.setNIM(m.getNim());
        view.getBtnAdd().setText("Tambah");
        view.setTitle("Tambah Anggota");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnAdd())){
            String topik;
            if(db.getAllMahasiswa(topik)){
                    view.showMessage(view, "NIM "+view.getNIM()+" sudah ada");
                }else {
                    db.editAnggota(view.getNIM(), k.getNomor());
                }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if (o.equals(this.view.getTfNIM())){
            if(this.view.getTfNIM().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
            }
        }
    }
}
