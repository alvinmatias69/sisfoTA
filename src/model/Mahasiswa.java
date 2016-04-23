/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alvinmatias69
 */
public class Mahasiswa extends Orang{
    String nim;
    String status;
    TugasAkhir tugasAkhir;
    
    public Mahasiswa(String nama, String alamat, String ttl, String gender, String status, String nim) {
        super(nama, alamat, ttl, gender);
        this.status = status;
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public String getStatus() {
        return status;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public TugasAkhir getTugasAkhir(){
        return tugasAkhir;
    }
    
    public void createTA(String judul){
        tugasAkhir = new TugasAkhir(judul);
    }
    
    public void editJudul(String judul){
        tugasAkhir.setJudul(judul);
    }
}
