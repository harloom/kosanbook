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
import service.HargaDao;
import service.Service_member_dao;

/**
 *
 * @author Hx-loom
 */
public class Main {

    /**
     * @param args the command line arguments
     */        
    
    public static void main(String[] args) throws SQLException, MemberException, HargaException {
        int sewa = 10;
    Calendar now = Calendar.getInstance();
        int year = (now.get(Calendar.YEAR));
        String cyear = Integer.toString(year);
        int mont = (now.get(Calendar.MONTH) + 1);
        String cmont = Integer.toString(mont);
       int day  =  (now.get(Calendar.DATE) );
        String cday = Integer.toString(day);
        String date = cyear +"/"+cmont+"/"+cday;
        

 
Calendar ex = Calendar.getInstance();
ex.add(Calendar.MONTH, sewa);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
String exdate = sdf.format(ex.getTime());

        
        System.out.println(date);
        System.out.println("+++++");
        System.out.println(exdate);
        
        
        HargaDao harga = Database.getHargaDao();
 List<Harga> list = harga.selectallHarga();

 for (Harga valueHarga:list)
 {
//     System.out.println("50Mbps = "+valueHarga.getH50mbps());
//     System.out.println("30Mbps = "+valueHarga.getH30mbps());
//     System.out.println("20Mbps = "+valueHarga.getH20mbps());
//     System.out.println("vip = "+valueHarga.getHvip());
//     System.out.println("standard = "+valueHarga.getHstandard());
//     System.out.println("kosong = "+valueHarga.getHkosong());

     

     
 }
//int hrgv50 = list.get(0).getH50mbps();
//int hrgv30 = list.get(0).getH30mbps();
//int hrgv20 = list.get(0).getH20mbps();
//
//
//        System.out.println(hrgv50);
 
 
       
//        
// Service_member_dao dao = Database.getMemberDao();
// Member member = new Member();
//member.setNama("Ilhamaja");
//member.setJenis_kelamin("Laki-Laki");
//member.setAlamat("Metro");
//member.setSewa(sewa);
//member.setNo_hp("08230711530");
//member.setTipe_kamar("VIP");
//member.setTipe_wifi("100Mbps");
//member.setTotal(8000000);
//member.setTanggal_masuk(date);
//member.setExpire(exdate);
//dao.insertMember(member);
  
        
        // TODO code application logic here
        // memanggil service

//        member.setDate(date);
//        dao.insertMember(member);
    }
    
}
