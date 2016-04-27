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
import View.EditTA;
import View.MenuMahasiswa;
import static com.sun.java.accessibility.util.AWTEventMonitor.addFocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Rachmi
 */
public class ControllerEditTA implements ActionListener, FocusListener{
    Database model;
    EditTA view;
    TugasAkhir ta;
    
    public ControllerEditTA(Database model) {
        this.model=model;
        view = new EditTA();
        view.setVisible(true);
        view.addListener((ActionListener) this);
        this.ta = null;
        
//        this.view.getEditJudul().addFocusListener((FocusListener) this);
        
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source.equals(view.getEditJudul())){
            String judul = view.getEditJudul();
            if(ta == null){
                TugasAkhir ta = new TugasAkhir(judul);
                Database db = new Database();
                view.setEditJudul(judul);
            }
        }
        if(source.equals(view.getBtnBack())){
            new ControllerMenuMahasiswa(model);
        }
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
