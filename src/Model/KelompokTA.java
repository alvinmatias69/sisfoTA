/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author alvinmatias69
 */
public class KelompokTA {
    private int idKelompok;
    private String topik;
    private ArrayList<Mahasiswa> anggota;

    public KelompokTA(String topik) {
        this.topik = topik;
        this.idKelompok = 0;
        anggota = new ArrayList<Mahasiswa>();
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getTopik() {
        return topik;
    }

    public int getIdKelompok() {
        return idKelompok;
    }
    
    public void setIdKelompok(int id){
        this.idKelompok = id;
    }
    
    public void addAnggota(Mahasiswa m){
        anggota.add(m);
    }
    
    public void removeAnggota (Mahasiswa m){
        anggota.remove(m);        
    }

    public void setAnggota(ArrayList<Mahasiswa> anggota) {
        this.anggota = (ArrayList<Mahasiswa>)anggota.clone();
    }
    
    public ArrayList<Mahasiswa> getAllAnggota(){
        return anggota;
    }
    
    public Mahasiswa getAnggota(String nim){
        int i = 0;
        int found = -1;
        while ( (i < anggota.size()) && (found == -1) ){
            if(anggota.get(i).getNim().equals(nim)){
                found = i;
            }
            i++;
        }
//        System.out.println(found);
        if( found != -1 ){
            return anggota.get(found);
        }else{
            return null;
        }
    }
    
    public Mahasiswa getAnggota(int idx){
        return anggota.get(idx);
    }
}
