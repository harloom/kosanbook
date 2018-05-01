/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.Database;
import enity.Admin;
import enity.Harga;
import error.AdminException;
import error.HargaException;
//import enity.Member;
import error.MemberException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import service.AdminDao;
import service.HargaDao;
import service.Service_member_dao;
import sound.Hime;
import view.Login;
import view.ViewMain;

/**
 *
 * @author Hx-loom
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, MemberException, HargaException, AdminException {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Database cek = new Database();
                try {
                    cek.getConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                //                ViewMain view = new ViewMain();
                Login login = new Login();
                login.setVisible(true);
            }

        });

//        
//    Cetak Admin   
//AdminDao daolist = Database.getAdminDao();
// List<Admin> aa = daolist.listAdmin();
//        for (Admin n : aa) {
//        System.out.println(n.getUsername()+"\t"+n.getPasswod());
//            
//        }
//cetak harga
//update
//

/////////////////////////////update password ///////////////////////////
//String[][] admin = new String[1][3];
//AdminDao dao = Database.getAdminDao();
//List<Admin>  n = dao.listAdmin();
//for(Admin a:n){
//    admin[0][0] = a.getUsername();
//    admin[0][1] = a.getPasswod();
//    admin[0][2] =a.getTgl_login();
//    a.setPasswod("ilham");
//    a.setTgl_login("2017/12/20");
//    a.setUsername( admin[0][0]);
//    dao.updateAdmin(a);
//}
//        for(int i = 0 ;i <1 ; i++){
//            for(int j = 0 ; j<3; j++){
//                System.out.println(admin[i][j]);
//            }
//        }
/////////////////////////////////////////
//n.setHarga(10);
//n.setJumlah_max(10);
//n.setTgl_update("2017/12/20");
//dao.updateHargaall(n);
    }
    


}
