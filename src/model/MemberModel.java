/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import enity.Member;
import error.MemberException;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import service.Service_member_dao;

/**
 *
 * @author Hx-loom
 */
public class MemberModel {
    
    private int kodeid ;
    private  String nama;
    private  String jeniskelamin;
    private  String ad;
    private  String nohp;
    private  Integer ls;
    private  String tipe_kamar;
    private  String kode_wifi;
    private  String tglmasuk;
    private String tglexpire;
    private Integer total;
    
    


    public String getTglexpire() {
        return tglexpire;
    }

    public void setTglexpire(String tglexpire) {
        this.tglexpire = tglexpire;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    

    public int getKodeid() {
        return kodeid;
    }

    public void setKodeid(int kodeid) {
        this.kodeid = kodeid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public Integer getLs() {
        return ls;
    }

    public void setLs(Integer ls) {
        this.ls = ls;
    }

    public String getTipe_kamar() {
        return tipe_kamar;
    }

    public void setTipe_kamar(String tipe_kamar) {
        this.tipe_kamar = tipe_kamar;
    }

    public String getKode_wifi() {
        return kode_wifi;
    }

    public void setKode_wifi(String kode_wifi) {
        this.kode_wifi = kode_wifi;
    }

    public String getTglmasuk() {
        return tglmasuk;
    }

    public void setTglmasuk(String tglmasuk) {
        this.tglmasuk = tglmasuk;
    }

    
    

    
    public void insertMember() throws SQLException, MemberException{
        Service_member_dao dao =Database.getMemberDao();
        Member member =new Member();
        member.setNama(nama);
        member.setJenis_kelamin(jeniskelamin);
        member.setAlamat(ad);
        member.setNo_hp(nohp);
        member.setSewa(ls);
        member.setTipe_kamar(tipe_kamar);
        member.setTipe_wifi(kode_wifi);
        member.setTotal(total);
        member.setTanggal_masuk(tglmasuk);
        member.setExpire(tglexpire);
        dao.insertMember(member);
      
    }

    
    
}
