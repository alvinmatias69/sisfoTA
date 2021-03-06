/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author alvinmatias69
 */
public class Database {
    private String server = "jdbc:mysql://localhost:3306/pbo";
    private String user = "root";
    private String pass = "";
    private Statement stmt;
    private Connection conn;
    
    public void connect(){
        try{
            conn = DriverManager.getConnection(server, user, pass);
            stmt = conn.createStatement();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean loginDosen(String kodeDosen, String password){
        String query = "select * from Dosen where kodeDosen = '" + kodeDosen + "' and password = '" + password + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        }catch (SQLException e){
            System.out.println("loginDosen " + e.getMessage());
            return false;
        }
    }
    
    public boolean loginMahasiswa(String nim, String password){
        String query = "select * from Mahasiswa where nim = '" + nim + "' and password = '" + password + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        }catch (SQLException e){
            System.out.println("loginMahasiswa " + e.getMessage());
            return false;
        }
    }
    
    public Dosen selectDosen(String kodeDosen){
        String query = "select * from Dosen where kodeDosen = '" + kodeDosen + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            Dosen d = new Dosen(rs.getString("kodeDosen"), rs.getString("nama"), rs.getString("alamat"), rs.getString("ttl"), rs.getString("gender"));
            return d;
        } catch (SQLException e){
            System.out.println("selectDosen " + e.getMessage());
            return null;
        }
    }
    
    public Mahasiswa selectMahasiswa(String nim){
        String query = "select * from Mahasiswa where nim = '" + nim + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            Mahasiswa m = new Mahasiswa(rs.getString("nim"), rs.getString("statusMahasiswa"), rs.getString("nama"), rs.getString("alamat"), rs.getString("ttl"), rs.getString("gender"));
            return m;
        }catch (SQLException e){
            System.out.println("selectMahasiswa " + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<KelompokTA> getAllKelompokTA(String kodeDosen){
        String query = "select * from KelompokTA where kodeDosen = '" + kodeDosen + "';";
        ArrayList<KelompokTA> kelompokTA = new ArrayList<KelompokTA>();
        try{
            ResultSet rs = stmt.executeQuery(query);
            if(! rs.next()){
                KelompokTA kel = new KelompokTA("");
                kelompokTA.add(kel);
            }else{
                do{
                    KelompokTA kel = new KelompokTA(rs.getString("topik"));
                    kel.setIdKelompok(rs.getInt("idKelompok"));
                    kelompokTA.add(kel);
                }while(rs.next());
            }
            return kelompokTA;
        }catch (SQLException e){
            System.out.println("getAllKelompokTA " + e.getMessage());
            return kelompokTA;
        }
    }
    
    public ArrayList<Mahasiswa> getAllMahasiswa(String topik){
        String query = "select * from Mahasiswa join KelompokTA using (idKelompok) where topik ='" + topik + "';";
        ArrayList<Mahasiswa> anggota = new ArrayList<Mahasiswa>();
        try{
            ResultSet rs = stmt.executeQuery(query);
            if(! rs.next()){
                Mahasiswa m = new Mahasiswa("", "", "", "", "", "");
                anggota.add(m);
            }else{
                do{
                    Mahasiswa m = new Mahasiswa(rs.getString("nim"), rs.getString("statusMahasiswa"), rs.getString("nama"), rs.getString("alamat"), rs.getString("ttl"), rs.getString("gender"));
                    anggota.add(m);
                }while(rs.next());
            }
            return anggota;
        }catch (SQLException e){
            System.out.println("getAllMahasiswa " + e.getMessage());
            return anggota;
        }
    }
    
    public ArrayList<Mahasiswa> getAllMahasiswabyId(int id){
        ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
        String query = "select * from Mahasiswa where idKelompok = '" + id + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            if(! rs.next()){
                Mahasiswa m = new Mahasiswa("", "", "", "", "", "");
                mhs.add(m);
            }else{
                do{
                    Mahasiswa m = new Mahasiswa(rs.getString("nim"), rs.getString("statusMahasiswa"), rs.getString("nama"), rs.getString("alamat"), rs.getString("ttl"), rs.getString("gender"));
                    mhs.add(m);
                }while(rs.next());
            }
            return mhs;
        }catch(SQLException e){
            System.out.println("getAllMahasiswabyId " + e.getMessage());
            return mhs;
        }
    }
    
    public TugasAkhir selectTugasAkhir(String nim){
        String query = "select * from TugasAkhir where nim = '" + nim + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            TugasAkhir ta = new TugasAkhir(rs.getString("judulTA"));
            return ta;
        } catch (SQLException e){
            System.out.println("selectTugasAKhir " + e.getMessage());
            return null;
        }
    }
    
    public void updateKelompokTA(int idKelompok, String nim) throws SQLException{
        String query;
        query = "update Mahasiswa set idKelompok = '" + idKelompok + "' where nim = '" + nim + "';";
        stmt.execute(query);
    }
    
    public void insertKelompokTA(KelompokTA kel, String kodeDosen) throws SQLException{
        String query = "insert into KelompokTA(topik, kodeDosen) values ('" + kel.getTopik() + "', '" + kodeDosen + "');";
        stmt.execute(query);
    }
    
    public void setPembimbing(String judulTA, String kodeDosen, int nomer) throws SQLException{
        String query = "update TugasAkhir set kodePembimbing" + nomer + " = '" + kodeDosen + "' where judulTA = '" + judulTA + "';";
        stmt.execute(query);
    }
    
    public void insertDosen(Dosen d) throws SQLException{
        String query = "insert into Dosen(kodeDosen, password, nama, alamat, ttl, gender) values ('" + d.getKodeDosen() + "', '" + d.getPassword() + "', '" + d.getNama() + "', '" + d.getAlamat() + "', '" + d.getTtl() + "', '" + d.getGender() + "');";
        stmt.execute(query);
    }
    
    public void insertTugasAkhir(TugasAkhir ta, String nim) throws SQLException{
        String query = "insert into TugasAkhir(judulTA, nim, kodePembimbing1, kodePembimbing2) values('" + ta.getJudul() + "', '" + nim + "', '', '');";
        stmt.execute(query);
    }
    
    public void updateTugasAkhir(String nim, String judul) throws SQLException{
        String query = "update TugasAkhir set judulTA = '" + judul + "' where nim = '" + nim + "';";
        stmt.execute(query);
    }
    
    public void dropKelompokTA(int idKelompok){
        String query = "delete from KelompokTA where idKelompok = '" + idKelompok + "';";
        try{
            stmt.execute(query);
        }catch(SQLException e){
            System.out.println("dropKelompok " + e.getMessage());
        }
    }
}
