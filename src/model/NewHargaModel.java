/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import enity.Harga;
import enity.Newharga;
import error.HargaException;
import java.sql.SQLException;
import service.HargaDao;
import service.NewHargaDao;

/**
 *
 * @author Hx-loom
 */
public class NewHargaModel {
    private String kode_h;
    private Integer harga;
    private Integer jumlah_max;
    private String tgl_update;

    public String getKode_h() {
        return kode_h;
    }

    public void setKode_h(String kode_h) {
        this.kode_h = kode_h;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getJumlah_max() {
        return jumlah_max;
    }

    public void setJumlah_max(Integer jumlah_max) {
        this.jumlah_max = jumlah_max;
    }

    public String getTgl_update() {
        return tgl_update;
    }

    public void setTgl_update(String tgl_update) {
        this.tgl_update = tgl_update;
    }
    
    

    
    
    
    public void updateHarga() throws SQLException,HargaException{
        NewHargaDao upharga = Database.getNewHargaDao();
        Newharga oharga =  upharga.getHarga("vip");
        oharga.setHarga(harga);
        oharga.setJumlah_max(jumlah_max);
        oharga.setTgl_update(tgl_update);
        oharga.setKode_h(kode_h);
        upharga.updateHargaall(oharga);
        
    }
    
}
