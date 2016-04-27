/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;

import Controller.ControllerLogin;
import Model.Database;
import Model.Dosen;
import java.sql.SQLException;

/**
 *
 * @author alvinmatias69
 */
public class SisfoTA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Dosen d = new Dosen("6969", "aman", "mat", "bandung", "14 Mei", "pria");
        Database db = new Database();
        db.connect();
        new ControllerLogin();
    }
    
}
