/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alvinmatias69
 */
public class TugasAkhir {
    String judul;
    Dosen pembimbing[];

    public TugasAkhir(String judul) {
        this.judul = judul;
        pembimbing = new Dosen[2];
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public void setPembimbing(Dosen d, int i){
        pembimbing[i] = d;
    }
    
    public Dosen getPembimbing(String kodeDosen){
        if((pembimbing[1] != null) && (pembimbing[1].getKodeDosen().equals(kodeDosen))){
            return pembimbing[1];
        }else{
            return pembimbing[2];
        }
    }
    
    public Dosen getPembimbing(int i){
        return pembimbing[i];
    }
}
