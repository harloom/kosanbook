/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import enity.Harga;
import error.HargaException;

import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.HargaModel;
import service.HargaDao;
import view.ViewMain;

/**
 *
 * @author Hx-loom
 */
public class HargaController {
    private HargaModel hargaModel;

    public void setHargaModel(HargaModel hargaModel) {
        this.hargaModel = hargaModel;
    }
public void updateharga(ViewMain viewMain) throws HargaException,SQLException  {

        
        
        Integer vip = Integer.parseInt(viewMain.getIvip().getText());
        Integer std = Integer.parseInt(viewMain.getIstd().getText());
        Integer kosong = Integer.parseInt(viewMain.getIemp().getText());
        Integer h50 = Integer.parseInt(viewMain.getIh50().getText());
        Integer h30 = Integer.parseInt(viewMain.getIh30().getText());
        Integer h20 = Integer.parseInt(viewMain.getIh20().getText());

        
//        tanggal 
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String cyear = Integer.toString(year);
        int mont = (now.get(Calendar.MONTH) + 1);
        String cmont = Integer.toString(mont);
       int day  =  (now.get(Calendar.DATE) );
        String cday = Integer.toString(day);
        String tanggal_up = cyear +"/"+cmont+"/"+cday;
               
  
             hargaModel.setHvip(vip);
             hargaModel.setHstd(std);
             hargaModel.setHkosong(kosong);
             hargaModel.setH50(h50);   
             hargaModel.setH30(h30);
             hargaModel.setH20(h20);
             hargaModel.setTanggal_up(tanggal_up);
            try {
                hargaModel.updateHarga();
                 JOptionPane.showMessageDialog(viewMain, "Harga Berhasil Di Ubah");

            } catch (Throwable e) {
                 JOptionPane.showMessageDialog(viewMain, "Data gagal ke Di Ubah , Silahkan Hubungi Dev");
            }
      
    }


    public void selectdata(ViewMain viewMain  ) throws SQLException, HargaException{
                //ambil data dari database
        HargaDao hh = Database.getHargaDao();    
        Harga harga =  hh.getHarga(1);
        Integer datah50mbps = harga.getH50mbps();
        Integer datah30mbps = harga.getH30mbps();
        Integer datah20mbps = harga.getH20mbps();
        Integer datahvip = harga.getHvip();
        Integer datahstd = harga.getHstandard();
        Integer datahkos = harga.getHkosong();
        
        //set value ke from
        viewMain.getIh50().setText(Integer.toString(datah50mbps));
        viewMain.getIh30().setText(Integer.toString(datah30mbps));
        viewMain.getIh20().setText(Integer.toString(datah20mbps));
        viewMain.getIvip().setText(Integer.toString(datahvip));
        viewMain.getIstd().setText(Integer.toString(datahstd));
        viewMain.getIemp().setText(Integer.toString(datahkos));
        
    }

}
