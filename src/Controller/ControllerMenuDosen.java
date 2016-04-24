/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MenuDosen;
import Model.*;
import View.Login;
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

    public ControllerMenuDosen(Dosen d){
        this.d = d;
        view = new MenuDosen();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Menu Dosen");
        if(d.getKelompokTA(0) == null){
            view.getBtnEdit().setVisible(false);
            view.getBtnShow().setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnBuat())){
            //inisiasi controller buat kelompok TA
        } else if(source.equals(view.getBtnEdit())){
            //inisiasi controller edit kelompok TA
        } else if(source.equals(view.getBtnSet())){
            //inisiasi controller set pembimbing
        } else if(source.equals(view.getBtnShow())){
            new ControllerShowKelompok(d);
        } else{
            new Login();
        }
        view.dispose();
    }
}
