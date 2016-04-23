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
    private String topik;
    ArrayList<Mahasiswa> anggota;

    public KelompokTA(String topik) {
        this.topik = topik;
        anggota = new ArrayList();
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getTopik() {
        return topik;
    }
    
    public void addAnggota(Mahasiswa m){
        anggota.add(m);
    }
    
    public void removeAnggota (Mahasiswa m){
        anggota.remove(m);
    }
    
    public Mahasiswa getAnggota(String nim){
        int i = 0;
        while ( (i < anggota.size()) && (anggota.get(i).getNim() != nim) )
            i++;
        if( (anggota.get(i) != null) && (anggota.get(i).getNim() == nim) ){
            return anggota.get(i);
        }else{
            return null;
        }
    }
    
    public Mahasiswa getAnggota(int idx){
        return anggota.get(idx);
    }
}
