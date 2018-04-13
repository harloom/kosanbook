/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.Database;
import enity.Harga;
import enity.Member;
import enity.Newharga;
import error.HargaException;
//import enity.Member;
import error.MemberException;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import service.HargaDao;
import service.NewHargaDao;
import service.Service_member_dao;
import sound.Hime;
import view.ViewMain;

/**
 *
 * @author Hx-loom
 */
public class Main {

    /**
     * @param args the command line arguments
     */        
    
    public static void main(String[] args) throws SQLException, MemberException, HargaException {
        

        
        
        SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run(){
            try {

                ViewMain view = new ViewMain();
       
                
                view.setVisible(true);
            } catch (SQLException e) {
                
            } catch (MemberException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
            
    });
        
       

////cetak harga
//NewHargaDao daolist = Database.getNewHargaDao();
// List<Newharga> list = daolist.selectallHarga();
//        for (Newharga n : list) {
//        System.out.println(n.getKode_h()+"\t"+n.getHarga());
//            
//        }

//update
//NewHargaDao dao = Database.getNewHargaDao();
//Newharga  n = dao.getHarga("vip");
//n.setHarga(10);
//n.setJumlah_max(10);
//n.setTgl_update("2017/12/20");
//dao.updateHargaall(n);



    }
    
}
