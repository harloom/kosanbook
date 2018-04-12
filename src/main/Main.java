/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.Database;
import enity.Harga;
import enity.Member;
import error.HargaException;
//import enity.Member;
import error.MemberException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import service.HargaDao;
import service.Service_member_dao;
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
        
        


//
// for (Harga valueHarga:list)
// {
////     System.out.println("50Mbps = "+valueHarga.getH50mbps());
////     System.out.println("30Mbps = "+valueHarga.getH30mbps());
////     System.out.println("20Mbps = "+valueHarga.getH20mbps());
////     System.out.println("vip = "+valueHarga.getHvip());
////     System.out.println("standard = "+valueHarga.getHstandard());
////     System.out.println("kosong = "+valueHarga.getHkosong());
//         
// }
// int tp = 0;
// Service_member_dao member=Database.getMemberDao();
// List<Member> cari = member.cariMember("");
// String[] array = null;
//
// String output = "";
//for( Member ss : cari ){
//    String nama = ss.getNama().toString();
//    String total = ss.getTotal().toString();
//    String ex = ss.getExpire().toString();
//    output += nama+" "+total+" "+ex+"\n";
    
//}
//System.out.println(output);

//{
//
//    tp+=value.getTotal();
//    
//}
//      StringBuffer sb = new StringBuffer(Integer.toString(tp));
//      if(sb.length()>=0 && sb.length()<=6){
//            sb.insert(3, ".");
//      }else if(sb.length()==7){
//          sb.insert(5, ".");
//      }else if(sb.length()==8){
//          sb.insert(2, ".");
//          sb.insert(6, ".");
//      }else if(sb.length()==9){
//          sb.insert(3, ".");
//          sb.insert(7, ".");
//      }else if(sb.length()==10){
//           sb.insert(1, ".");
//          sb.insert(5, ".");
//          sb.insert(9, ".");
//   
//      }
//    
//      System.out.println(sb); 
//System.out.println(tp);
//HargaDao upharga = Database.getHargaDao();
//Harga harga =  upharga.getHarga(1);
//harga.setH50mbps(120000);
//upharga.updateHargaall(harga);


    }
    
}
