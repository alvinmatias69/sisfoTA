/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Dosen;
import View.ShowKelompok;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alvinmatias69
 */
public class ControllerShowKelompok implements ActionListener, FocusListener{

    Dosen d;
    Database db;
    ShowKelompok view;
    
    public ControllerShowKelompok(Dosen d) {
        this.d = d;
        view = new ShowKelompok();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Show Kelompok");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnIndex())){
            int idx = Integer.parseInt(view.getTfNomor());
            d.getKelompokTA(idx).setAnggota(db.getAllMahasiswa(d.getKelompokTA(idx).getTopik()));
            String message = "ID Kelompok : " + d.getKelompokTA(idx).getIdKelompok() + "\n"
                           + "Topik       : " + d.getKelompokTA(idx).getTopik() + "\n"
                           + "Anggota\n";
            for(int i = 0; i < d.getKelompokTA(idx).getAllAnggota().size(); i++){
                message = message + "(" + d.getKelompokTA(idx).getAnggota(i).getNim() + ") " + 
                          d.getKelompokTA(idx).getAnggota(i).getNama() + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
        }else if (source.equals(view.getBtnIDKel())) {
            int id = Integer.parseInt(view.getTfNomor());
            d.getKelompokTAbyID(id).setAnggota(db.getAllMahasiswa(d.getKelompokTAbyID(id).getTopik()));
            String message = "ID Kelompok : " + d.getKelompokTAbyID(id).getIdKelompok() + "\n"
                           + "Topik       : " + d.getKelompokTAbyID(id).getTopik() + "\n"
                           + "Anggota\n";
            for(int i = 0; i < d.getKelompokTAbyID(id).getAllAnggota().size(); i++){
                message = message + "(" + d.getKelompokTAbyID(id).getAnggota(i).getNim() + ") " + 
                          d.getKelompokTAbyID(id).getAnggota(i).getNama() + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
        }else{
            new ControllerMenuDosen(d);
            view.dispose();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object source = e.getSource();
        if( (source.equals(view.getTfNomor())) && (this.view.getTfNomor() == "") ){
            JOptionPane.showMessageDialog(null, "Isi Index atau ID kelompok yang akan ditampilkan terlebih dahulu");
        }
    }
    
}
