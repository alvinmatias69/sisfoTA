/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.*;
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
}
