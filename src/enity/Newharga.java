/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.util.Objects;

/**
 *
 * @author Hx-loom
 */
public class Newharga {
    private String kode_h;
    private Integer harga;
    private Integer jumlah_max; 
    private String tgl_update  ; 

    public Newharga(String kode_h, Integer harga, Integer jumlah_max, String tgl_update) {
        this.kode_h = kode_h;
        this.harga = harga;
        this.jumlah_max = jumlah_max;
        this.tgl_update = tgl_update;
    }
    
    public Newharga(){
        
    }


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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.kode_h);
        hash = 79 * hash + Objects.hashCode(this.harga);
        hash = 79 * hash + Objects.hashCode(this.jumlah_max);
        hash = 79 * hash + Objects.hashCode(this.tgl_update);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Newharga other = (Newharga) obj;
        if (!Objects.equals(this.kode_h, other.kode_h)) {
            return false;
        }
        if (!Objects.equals(this.tgl_update, other.tgl_update)) {
            return false;
        }
        if (!Objects.equals(this.harga, other.harga)) {
            return false;
        }
        if (!Objects.equals(this.jumlah_max, other.jumlah_max)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
