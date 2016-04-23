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
public class Mahasiswa extends Orang{
    String nim;
    String status;
    String password;
    TugasAkhir tugasAkhir;

    public Mahasiswa(String nim, String status, String nama, String alamat, String ttl, String gender) {
        super(nama, alamat, ttl, gender);
        this.nim = nim;
        this.status = status;
    }

    public Mahasiswa(String nim, String status, String password, String nama, String alamat, String ttl, String gender) {
        super(nama, alamat, ttl, gender);
        this.nim = nim;
        this.status = status;
        this.password = password;
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
