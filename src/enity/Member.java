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
public class Member {
private String nama;
private String jenis_kelamin;
private String alamat; 
private Integer sewa;
private String no_hp;
private String tipe_kamar;
private String tipe_wifi;
private Integer total;
private String tanggal_masuk;
private String expire;
private Integer id_member;

    public Member() {
        
    }

    public Member(String nama, String jenis_kelamin, String alamat, Integer sewa, String no_hp, String tipe_kamar, String tipe_wifi, Integer total, String tanggal_masuk, String expire, Integer id_member) {
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.sewa = sewa;
        this.no_hp = no_hp;
        this.tipe_kamar = tipe_kamar;
        this.tipe_wifi = tipe_wifi;
        this.total = total;
        this.tanggal_masuk = tanggal_masuk;
        this.expire = expire;
        this.id_member = id_member;
    }

    public Integer getId_member() {
        return id_member;
    }

    public void setId_member(Integer id_member) {
        this.id_member = id_member;
    }


    
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getSewa() {
        return sewa;
    }

    public void setSewa(Integer sewa) {
        this.sewa = sewa;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getTipe_kamar() {
        return tipe_kamar;
    }

    public void setTipe_kamar(String tipe_kamar) {
        this.tipe_kamar = tipe_kamar;
    }

    public String getTipe_wifi() {
        return tipe_wifi;
    }

    public void setTipe_wifi(String tipe_wifi) {
        this.tipe_wifi = tipe_wifi;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nama);
        hash = 53 * hash + Objects.hashCode(this.jenis_kelamin);
        hash = 53 * hash + Objects.hashCode(this.alamat);
        hash = 53 * hash + Objects.hashCode(this.sewa);
        hash = 53 * hash + Objects.hashCode(this.no_hp);
        hash = 53 * hash + Objects.hashCode(this.tipe_kamar);
        hash = 53 * hash + Objects.hashCode(this.tipe_wifi);
        hash = 53 * hash + Objects.hashCode(this.total);
        hash = 53 * hash + Objects.hashCode(this.tanggal_masuk);
        hash = 53 * hash + Objects.hashCode(this.expire);
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
        final Member other = (Member) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.jenis_kelamin, other.jenis_kelamin)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        if (!Objects.equals(this.no_hp, other.no_hp)) {
            return false;
        }
        if (!Objects.equals(this.tipe_kamar, other.tipe_kamar)) {
            return false;
        }
        if (!Objects.equals(this.tipe_wifi, other.tipe_wifi)) {
            return false;
        }
        if (!Objects.equals(this.tanggal_masuk, other.tanggal_masuk)) {
            return false;
        }
        if (!Objects.equals(this.expire, other.expire)) {
            return false;
        }
        if (!Objects.equals(this.sewa, other.sewa)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }
    
    
    
}
