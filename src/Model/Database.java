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
            return false;
        }
    }
    
    public boolean loginMahasiswa(String nim, String password){
        String query = "select * from Mahasiswa where nim = '" + nim + "' and password = '" + password + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        }catch (SQLException e){
            return false;
        }
    }
    
    public Dosen selectDosen(String kodeDosen){
        String query = "select * from Dosen where kodeDosen = '" + kodeDosen + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            Dosen d = new Dosen(rs.getString("kodeDosen"), rs.getString("nama"), rs.getString("alamat"), rs.getString("ttl"), rs.getString("gender"));
            return d;
        } catch (SQLException e){
            return null;
        }
    }
    
    public Mahasiswa selectMahasiswa(String nim){
        String query = "select * from Mahasiswa where nim = '" + nim + "';";
        try{
            ResultSet rs = stmt.executeQuery(query);
            Mahasiswa m = new Mahasiswa(rs.getString("nim"), rs.getString("status"), rs.getString("nama"), rs.getString("alamat"), rs.getString("ttl"), rs.getString("gender"));
            return m;
        }catch (SQLException e){
            return null;
        }
    }
    
    public ArrayList<KelompokTA> getAllKelompokTA(String kodeDosen){
        String query = "select * from KelompokTA where kodeDosen = '" + kodeDosen + "';";
        ArrayList<KelompokTA> kelompokTA = new ArrayList();
        try{
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                KelompokTA kel = new KelompokTA(rs.getString("topik"));
                kel.setIdKelompok(rs.getInt("idKelompok"));
                kelompokTA.add(kel);
            }
            return kelompokTA;
        }catch (SQLException e){
            return null;
        }
    }
    
    public ArrayList<Mahasiswa> getAllMahasiswa(String topik){
        String query = "select * from Mahasiswa where topik ='" + topik + "';";
        ArrayList<Mahasiswa> anggota = new ArrayList();
        try{
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Mahasiswa m = new Mahasiswa(rs.getString("nim"), rs.getString("status"), rs.getString("nama"), rs.getString("alamat"), rs.getString("ttl"), rs.getString("gender"));
                anggota.add(m);
            }
            return anggota;
        }catch (SQLException e){
            return null;
        }
    }
    
    public void updateKelompokt(int idKelompok, String nim) throws SQLException{
        String query;
        if(idKelompok == -1){
            query = "update Mahasiswa set idKelompok ='' where nim = '" + nim +"';";
        } else{
            query = "update Mahasiswa set idKelompok = '" + idKelompok + "' where nim = '" + nim + "';";
        }
        stmt.execute(query);
    }
}
