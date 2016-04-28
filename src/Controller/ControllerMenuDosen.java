/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MenuDosen;
import Model.*;
import View.Login;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author alvinmatias69
 */
public class ControllerMenuDosen  implements ActionListener{
    Dosen d;
    MenuDosen view;
    Database db;

    public ControllerMenuDosen(Dosen d){
        this.d = d;
        db = new Database();
        db.connect();
        view = new MenuDosen();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Menu Dosen");
        this.d.setTopikTA(db.getAllKelompokTA(this.d.getKodeDosen()));
//        this.d.emptyKelompokTA();
//        this.d.setTopikTA(db.getAllKelompokTA(this.d.getKodeDosen()));
        if(d.getKelompokTA(0).getTopik().equals("")){
            view.getBtnEdit().setVisible(false);
            view.getBtnShow().setVisible(false);
            view.getBtnDelKelompok().setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnBuat())){
            new ControllerBuatKelompok(d);
        } else if(source.equals(view.getBtnEdit())){
            new ControllerEditKelompok(d);
        } else if(source.equals(view.getBtnSet())){
            new ControllerAssignPembimbing(d);
        } else if(source.equals(view.getBtnShow())){
            new ControllerShowKelompok(d);
        } else if(source.equals(view.getBtnDelKelompok())){
            new ControllerHapusKelompok(d);
        } else{
            new ControllerLogin();
        }
        view.dispose();
    }
}
