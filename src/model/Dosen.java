/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author alvinmatias69
 */
public class Dosen extends Orang{
    private String kodeDosen;
    private ArrayList<KelompokTA> topikTA;

    public Dosen(String kodeDosen, String nama, String alamat, String ttl, String gender) {
        super(nama, alamat, ttl, gender);
        this.kodeDosen = kodeDosen;
        topikTA = new ArrayList();
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        this.kodeDosen = kodeDosen;
    }
    
    public void createKelompokTA(String topik){
        KelompokTA kel = new KelompokTA(topik);
        topikTA.add(kel);
    }
    
    public KelompokTA getKelompokTA(String topik){
        int i = 0;
        while ((i < topikTA.size()) && (topikTA.get(i).getTopik() != topik))
            i++;
        if ( (topikTA.get(i) != null) && (topikTA.get(i).getTopik().equals(topik))){
            return topikTA.get(i);
        } else{
            return null;
        }
    }
    
    public KelompokTA getKelompokTA(int idx){
        return topikTA.get(idx);
    }
    
    public void removeKelompokTA(KelompokTA kel){
        topikTA.remove(kel);
    }
}
