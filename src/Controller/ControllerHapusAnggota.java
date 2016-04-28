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
import View.HapusAnggota;
import View.MenuEdit;
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
public class ControllerHapusAnggota implements ActionListener, FocusListener {

    Database db;
    MenuEdit view;
//    KelompokTA k;
    int id;
    Dosen d;

    public ControllerHapusAnggota(int id, Dosen d) {
//        this.k = k;
        this.id = id;
        this.d = d;
        db = new Database();
        db.connect();
        this.d.getKelompokTAbyID(id).setAnggota(db.getAllMahasiswa(this.d.getKelompokTAbyID(id).getTopik()));
        view = new MenuEdit();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Edit Kelompok");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnHapus())) {
            String nim = view.getNIM();
            if (d.getKelompokTAbyID(id).getAnggota(nim) == (null)) {
                view.showMessage(view, "NIM " + nim + " tidak terdaftar di kelompok tersebut");
            } else {
                d.getKelompokTAbyID(id).removeAnggota(d.getKelompokTAbyID(id).getAnggota(nim));
                try {
                    db.updateKelompokTA(-1, nim);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerHapusAnggota.class.getName()).log(Level.SEVERE, null, ex);
                }
                view.showMessage(view, "NIM " + nim + " berhasil dihapus");
            }
        } else if (source.equals(view.getBtnTambah())) {
            String nim = view.getNIM();
            d.getKelompokTAbyID(id).setAnggota(db.getAllMahasiswa(d.getKelompokTAbyID(id).getTopik()));
            if (db.selectMahasiswa(nim) != null){
                if (d.getKelompokTAbyID(id).getAnggota(nim) == null) {
                    d.getKelompokTAbyID(id).addAnggota(db.selectMahasiswa(nim));
                    try {
                        db.updateKelompokTA(id, nim);
                        view.showMessage(null, "Berhasil menambahkan Anggota");
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerHapusAnggota.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    view.showMessage(view, "NIM " + nim + " sudah terdaftar");
                }
            } else{
                view.showMessage(view, "NIM " + nim + " tidak ada dalam database");
            }
        } else if (source.equals(view.getBtnBack())) {
            new ControllerEditKelompok(d);
            view.dispose();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if (o.equals(this.view.getTfNIM())) {
            if (this.view.getTfNIM().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
            }
        }
    }
}
