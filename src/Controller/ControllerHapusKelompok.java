/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Dosen;
import View.HapusKelompok;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dian Dwi Arini
 */

public class ControllerHapusKelompok implements ActionListener, FocusListener {
    Database db;
    HapusKelompok view;
    Dosen d;
    public ControllerHapusKelompok(Dosen d){
        this.d=d;
        view = new HapusKelompok();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getbtnHapus())){
            int id=Integer.parseInt(view.getIdKel());
            d.removeKelompokTA(d.getKelompokTAbyID(id));
        }else if(source.equals(view.getBtnBack())){
            new ControllerMenuDosen(d);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if (o.equals(this.view.gettfIdKel())){
            if(this.view.gettfIdKel().equals("")){
                JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
            }
        }
    }
}
