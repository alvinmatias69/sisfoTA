/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Mahasiswa;
import View.CreateTA;
import View.EditTA;
import View.MenuMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rachmi
 */
public class ControllerMenuMahasiswa {
    Database model;
    MenuMahasiswa view;
    
    public ControllerMenuMahasiswa(Database model){
        this.model=model;
        view = new MenuMahasiswa();
        view.setVisible(true);
        view.addListener((ActionListener) this);
    }
     public void actionPerformed(ActionEvent e){
         Object source = e.getSource();
         if(source.equals(view.getBtnCreateTA())){
             new ControllerCreateTA(model);
         }else if(source.equals(view.getBtnEdit())){
             new ControllerEditTA(model);
         }
     }
}
