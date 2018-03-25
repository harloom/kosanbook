/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import enity.Harga;
import error.HargaException;
import error.MemberException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.MemberModel;
import service.HargaDao;
import view.ViewMain;

/**
 *
 * @author Hx-loom
 */
public class MemberController {
    private MemberModel model;

    public void setModel(MemberModel model) {
        this.model = model;
    }
    

    public void insertMember(ViewMain inputmember) throws SQLException, HargaException {
        
         HargaDao harga = Database.getHargaDao();
        List<Harga> list = harga.selectallHarga();
        int hrgv50 = list.get(0).getH50mbps();
        int hrgv30 = list.get(0).getH30mbps();
        int hrgv20 = list.get(0).getH20mbps();
        int hrgvip = list.get(0).getHvip();
        int hrgstd = list.get(0).getHstandard();
        int hrgempty = list.get(0).getHkosong();
        //tipe Kamar 
        JRadioButton vip = inputmember.getRadiobVip();
        JRadioButton stand = inputmember.getRadiobStandard();
        JRadioButton kosong = inputmember.getRadiobEmpty();        
         // akhir tipe kamar        
         
//         tipe Wifi
        JRadioButton v50 = inputmember.getRadiob50();
        JRadioButton v30 = inputmember.getRadiob30();
        JRadioButton v20 = inputmember.getRadiob30();        
         // akhir tipe wifi  
          JRadioButton lk = inputmember.getRadiobLaki();
        JRadioButton pr = inputmember.getRadiobperempuan();
         
        String nama = inputmember.getValueNama().getText();
        String alamat = inputmember.getValueAlamat().getText();       
        String ls =inputmember.getValueSewa().getText();
//        convert lama sew;
        Integer lamasewa = Integer.parseInt(ls);     
        String nohp =  inputmember.getValueNohp().getText();
        String tipe_kamar = "";
        String wifi = "";
        String jk="";
        Integer totalkamar = null,totalinternet= null,totalkesuruhan;
        if(lk.isSelected())
        {
            jk ="Pria";
        }else if(pr.isSelected())
        {
                jk="Wanita";
        }else{
            JOptionPane.showMessageDialog(inputmember, "Silahkan Pilih Jenis Kelamin");
        }
        

        
        if(vip.isSelected()){
            tipe_kamar = "VIP";
            totalkamar = lamasewa*hrgvip;
        }else if(stand.isSelected()){
            tipe_kamar = "Standar";
            totalkamar = lamasewa*hrgstd;
        } else if(kosong.isSelected()){
            tipe_kamar = "Kosong";
            totalkamar = lamasewa*hrgempty;
        } else{ 
        JOptionPane.showMessageDialog(inputmember, "Silahkan Pilih Tipe Kamar");
        }
        
        if(v50.isSelected()){
           wifi = "50Mbps";
          totalinternet = lamasewa*hrgv50;
        }else if(v30.isSelected()){
            wifi = "30Mbps";
           totalinternet = lamasewa*hrgv30;
        } else if(v20.isSelected()){
            wifi = "20Mbps";
           totalinternet = lamasewa*hrgv20;
        } else{ 
            wifi = "Tidak  Berlangganan";
            totalinternet = lamasewa*0;
        }
            // taggal 
    Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String cyear = Integer.toString(year);
        int mont = (now.get(Calendar.MONTH) + 1);
        String cmont = Integer.toString(mont);
       int day  =  (now.get(Calendar.DATE) );
        String cday = Integer.toString(day);
        String date = cyear +"/"+cmont+"/"+cday;
        
Calendar ex = Calendar.getInstance();
ex.add(Calendar.MONTH, lamasewa);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
String exdate = sdf.format(ex.getTime());


//perjumlahan
totalkesuruhan = totalinternet+totalkamar;


        //validation field kosong
        if(nama.trim().equals("")){
           JOptionPane.showMessageDialog(inputmember, "Silahkan Inputkan Nama ,Master");
         } else if(alamat.trim().equals("")){
              JOptionPane.showMessageDialog(inputmember, "Alamat Belum Di Isi , Master");
        }else if(lamasewa < 1 ){
              JOptionPane.showMessageDialog(inputmember, "Lama Sewa Masih Kosong, Master");
        }else if (nohp.length()>12){
              JOptionPane.showMessageDialog(inputmember, "No Handphone tidak boleh lebih dari 12 digit, Master");
        }else{
           model.setNama(nama);
           model.setJeniskelamin(jk);
           model.setAd(alamat);
           model.setNohp(nohp);
           model.setLs(lamasewa);
           model.setTipe_kamar(tipe_kamar);
           model.setTotal(totalkesuruhan);
           model.setKode_wifi(wifi);
           model.setTglmasuk(date);
           model.setTglexpire(exdate);
           
            try {
                model.insertMember();
                  JOptionPane.showMessageDialog(inputmember, "Data Berhasil Tersimpan");

            } catch (Throwable throwable) {
                 JOptionPane.showMessageDialog(inputmember, new Object[] {"Terjadi Error Dalam Sistem Silahkan Hubungin Developer",throwable.getMessage()});
            }
        }
        
           }
    
  public void count(ViewMain inputmember) throws SQLException, HargaException
  {
      
      HargaDao harga = Database.getHargaDao();
        List<Harga> list = harga.selectallHarga();
        int hrgv50 = list.get(0).getH50mbps();
        int hrgv30 = list.get(0).getH30mbps();
        int hrgv20 = list.get(0).getH20mbps();
        int hrgvip = list.get(0).getHvip();
        int hrgstd = list.get(0).getHstandard();
        int hrgempty = list.get(0).getHkosong();
        //tipe Kamar 
        JRadioButton vip = inputmember.getRadiobVip();
        JRadioButton stand = inputmember.getRadiobStandard();
        JRadioButton kosong = inputmember.getRadiobEmpty();        
         // akhir tipe kamar        
         
//         tipe Wifi
        JRadioButton v50 = inputmember.getRadiob50();
        JRadioButton v30 = inputmember.getRadiob30();
        JRadioButton v20 = inputmember.getRadiob30(); 
        String tipe_kamar = "";
        String wifi = "";
        Integer totalkamar = null,totalinternet= null,totalkesuruhan;

        String ls =inputmember.getValueSewa().getText();
//        convert lama sew;
        Integer lamasewa = Integer.parseInt(ls); 
              if(vip.isSelected()){
      
            totalkamar = lamasewa*hrgvip;
        }else if(stand.isSelected()){

            totalkamar = lamasewa*hrgstd;
        } else if(kosong.isSelected()){

            totalkamar = lamasewa*hrgempty;
        } else{ 
        JOptionPane.showMessageDialog(inputmember, "Silahkan Pilih Tipe Kamar");
        }
        
        if(v50.isSelected()){

          totalinternet = lamasewa*hrgv50;
        }else if(v30.isSelected()){

           totalinternet = lamasewa*hrgv30;
        } else if(v20.isSelected()){
   
           totalinternet = lamasewa*hrgv20;
        } else{ 
  
            totalinternet = lamasewa*0;
          
        }
        
        //perjumlahan
            totalkesuruhan = totalinternet+totalkamar;
            inputmember.getOutputTotal().setText("Rp. "+Integer.toString(totalkesuruhan));
    }
    
    
    
    
    }


