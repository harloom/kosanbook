/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import enity.Harga;
import error.HargaException;
import java.sql.SQLException;
import service.HargaDao;

/**
 *
 * @author Hx-loom
 */
public class HargaModel {
    private int id;
    private int h50;
    private int h30;
    private int h20;
    private int hvip;
    private int hstd;
    private int hkosong;
    private String tanggal_up;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getH50() {
        return h50;
    }

    public void setH50(int h50) {
        this.h50 = h50;
    }

    public int getH30() {
        return h30;
    }

    public void setH30(int h30) {
        this.h30 = h30;
    }

    public int getH20() {
        return h20;
    }

    public void setH20(int h20) {
        this.h20 = h20;
    }

    public int getHvip() {
        return hvip;
    }

    public void setHvip(int hvip) {
        this.hvip = hvip;
    }

    public int getHstd() {
        return hstd;
    }

    public void setHstd(int hstd) {
        this.hstd = hstd;
    }

    public int getHkosong() {
        return hkosong;
    }

    public void setHkosong(int hkosong) {
        this.hkosong = hkosong;
    }

    public String getTanggal_up() {
        return tanggal_up;
    }

    public void setTanggal_up(String tanggal_up) {
        this.tanggal_up = tanggal_up;
    }
    
    
    public void updateHarga() throws SQLException,HargaException{
        HargaDao upharga = Database.getHargaDao();
        Harga harga =  upharga.getHarga(1);
        harga.setH50mbps(h50);
        harga.setH30mbps(h30);
        harga.setH20mbps(h20);
        harga.setHvip(hvip);
        harga.setHstandard(hstd);
        harga.setHkosong(hkosong);
        harga.setId(1);
        upharga.updateHargaall(harga);
        
    }
    
}
