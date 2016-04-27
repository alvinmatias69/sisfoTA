/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Dosen;
import Model.KelompokTA;
import View.EditKelompok;
import View.MenuEdit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dian Dwi Arini
 */
public class ControllerEditKelompok implements ActionListener, FocusListener {
    Database db;
    EditKelompok view;
    KelompokTA k;
    Dosen d;
    
    public ControllerEditKelompok(Dosen d){
        this.d=d;
        view = new EditKelompok();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Edit Kelompok");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnEnter())){
            int id=Integer.parseInt(view.getTfidKel());
            if(d.getKelompokTAbyID(id) == (null)){
                view.showMessage(view, "Tidak ada ID "+ id);
            }else{
                new ControllerHapusAnggota(k);
            }
        }else if(source.equals(view.getBtnBack())){
            new ControllerMenuDosen(d);
        }
       view.dispose();
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if (o.equals(this.view.getTfidKel())){
            if(this.view.getTfidKel().equals("")){
                JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
            }
        }
    }
}
