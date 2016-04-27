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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Rachmi
 */
public class ControllerCreateTA {
    Database model;
    CreateTA view;
    TugasAkhir ta;
    
    public ControllerCreateTA(Database model){
        this.model=model;
        view = new CreateTA();
        view.setVisible(true);
        view.addListener((ActionListener) this);
        this.ta=null;
        
        this.view.getTfJudulTA().addFocusListener((FocusListener) this);
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source.equals(view.getBtnCreate())){
            String judul = view.getJudulTA();
            if(ta == null){
                TugasAkhir ta = new TugasAkhir(judul);
                Database db = new Database();
                view.setJudulTA("");
            } else {
                ta.setJudul(judul);
            }
        }
        if(source.equals(view.getBtnBack())){
            new ControllerMenuMahasiswa(model);
            view.dispose();
        }
    }
}

