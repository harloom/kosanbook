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
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.MemberModel;
import service.HargaDao;
import sound.Hime;
import view.Edit;
import view.ViewMain;

/**
 *
 * @author Hx-loom
 */
public class MemberController {

    private MemberModel model;
    Hime sound = new Hime();

    public void setModel(MemberModel model) {
        this.model = model;
    }

    // deklarasi variable api public
    int hrgv50;
    int hrgv30;
    int hrgv20;
    int hrgvip;
    int hrgstd;
    int hrgempty;

    // Untuk Variable harga class lain
    public int getHrgv50() {
        return hrgv50;
    }

    public int getHrgv30() {
        return hrgv30;
    }

    public int getHrgv20() {
        return hrgv20;
    }

    public int getHrgvip() {
        return hrgvip;
    }

    public int getHrgstd() {
        return hrgstd;
    }

    public int getHrgempty() {
        return hrgempty;
    }
    

    //
    public void apiHarga() throws SQLException, HargaException {
        HargaDao harga = Database.getHargaDao();
        List<Harga> list = harga.selectallHarga();
        hrgv50 = list.get(0).getH50mbps();
        hrgv30 = list.get(0).getH30mbps();
        hrgv20 = list.get(0).getH20mbps();
        hrgvip = list.get(0).getHvip();
        hrgstd = list.get(0).getHstandard();
        hrgempty = list.get(0).getHkosong();
    }
    
    public void apiMember(){
        
    }

    public void insertMember(ViewMain inputmember) throws SQLException, HargaException {

        apiHarga();
        //tipe Kamar 
        JRadioButton vip = inputmember.getRadiobVip();
        JRadioButton stand = inputmember.getRadiobStandard();
        JRadioButton kosong = inputmember.getRadiobEmpty();
        // akhir tipe kamar        

//         tipe Wifi
        JRadioButton v50 = inputmember.getRadiob50();
        JRadioButton v30 = inputmember.getRadiob30();
        JRadioButton v20 = inputmember.getRadiob20();
        // akhir tipe wifi  
        JRadioButton lk = inputmember.getRadiobLaki();
        JRadioButton pr = inputmember.getRadiobperempuan();

        String nama = inputmember.getValueNama().getText();
        String alamat = inputmember.getValueAlamat().getText();
        String ls = inputmember.getValueSewa().getText();
        String nohp = inputmember.getValueNohp().getText();
        String tipe_kamar = "";
        String wifi = "";
        String jk = "";

        ///// validtation
        if (nama.trim().equals("")) {
            sound.soundErr();
            JOptionPane.showMessageDialog(inputmember, "Silahkan Inputkan Nama ,Master");
            inputmember.getValueNama().setBorder(BorderFactory.createLineBorder(Color.red));
        } else if (ls.length() < 1) {
            sound.soundErr();
            JOptionPane.showMessageDialog(inputmember, "Form Lama Sewa Masih Kosong!");
            inputmember.getValueSewa().setBorder(BorderFactory.createLineBorder(Color.red));
//            return;
        } else if (alamat.trim().equals("")) {
            sound.soundErr();
            JOptionPane.showMessageDialog(inputmember, "Alamat Belum Di Isi , Master");
            inputmember.getValueAlamat().setBorder(BorderFactory.createLineBorder(Color.red));
        } else if (nohp.length() < 1) {
            sound.soundErr();
            JOptionPane.showMessageDialog(inputmember, "Form No Handphone Masih Kosong!");
            inputmember.getValueNohp().setBorder(BorderFactory.createLineBorder(Color.red));
        } else if (nohp.length() < 12) {
            sound.soundErr();
            JOptionPane.showMessageDialog(inputmember, "No Handphone harus 12 digit, Master");
            inputmember.getValueNohp().setBorder(BorderFactory.createLineBorder(Color.red));
        } else if (!nohp.contains("8")) {
            sound.soundErr();
            JOptionPane.showMessageDialog(inputmember, "Format Salah,Masterr");
            inputmember.getValueNohp().setBorder(BorderFactory.createLineBorder(Color.red));
        } else {
            Integer lamasewa = Integer.parseInt(ls);
//        convert lama sew;

            Integer totalkamar = null,
                    totalinternet = null,
                    totalkesuruhan = null;

            if (lk.isSelected()) {
                jk = "Pria";
            } else if (pr.isSelected()) {
                jk = "Wanita";
            } else {
                sound.soundErr();
                JOptionPane.showMessageDialog(inputmember, "Silahkan Pilih Jenis Kelamin");
                return;
            }

            if (vip.isSelected()) {
                tipe_kamar = "VIP";
                totalkamar = lamasewa * hrgvip;
            } else if (stand.isSelected()) {
                tipe_kamar = "Standar";
                totalkamar = lamasewa * hrgstd;
            } else if (kosong.isSelected()) {
                tipe_kamar = "Kosong";
                totalkamar = lamasewa * hrgempty;
            } else {
                sound.soundErr();
                JOptionPane.showMessageDialog(inputmember, "Silahkan Pilih Tipe Kamar");
                return;
            }

            if (v50.isSelected()) {
                wifi = "50Mbps";
                totalinternet = lamasewa * hrgv50;
            } else if (v30.isSelected()) {
                wifi = "30Mbps";
                totalinternet = lamasewa * hrgv30;
            } else if (v20.isSelected()) {
                wifi = "20Mbps";
                totalinternet = lamasewa * hrgv20;
            } else {
                wifi = "Tidak  Berlangganan";
                totalinternet = lamasewa * 0;
            }
            // taggal 
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            String cyear = Integer.toString(year);
            int mont = (now.get(Calendar.MONTH) + 1);
            String cmont = Integer.toString(mont);
            int day = (now.get(Calendar.DATE));
            String cday = Integer.toString(day);
            String date = cyear + "/" + cmont + "/" + cday;

            Calendar ex = Calendar.getInstance();
            ex.add(Calendar.MONTH, lamasewa);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String exdate = sdf.format(ex.getTime());

            //perjumlahan
            totalkesuruhan = totalinternet + totalkamar;

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
                JOptionPane.showMessageDialog(inputmember, new Object[]{"Terjadi Error Dalam Sistem Silahkan Hubungin Developer", throwable.getMessage()});
                sound.soundErr();
            }
        }
    }

    public void count(ViewMain inputmember) throws SQLException, HargaException {
        apiHarga();

        //tipe Kamar 
        JRadioButton vip = inputmember.getRadiobVip();
        JRadioButton stand = inputmember.getRadiobStandard();
        JRadioButton kosong = inputmember.getRadiobEmpty();
        // akhir tipe kamar        

        // tipe Wifi
        JRadioButton v50 = inputmember.getRadiob50();
        JRadioButton v30 = inputmember.getRadiob30();
        JRadioButton v20 = inputmember.getRadiob20();
        String tipe_kamar = "";
        String wifi = "";
        Integer totalkamar = null, totalinternet = null, totalkesuruhan = null;

        String ls = inputmember.getValueSewa().getText();
        if (ls.length() < 1) {
            JOptionPane.showMessageDialog(inputmember, "Silahkan Inputkan Sewa ,Master");
            inputmember.getValueSewa().setBorder(BorderFactory.createLineBorder(Color.red));
            return;
        }
//        convert lama sew;
        Integer lamasewa = Integer.parseInt(ls);
        if (vip.isSelected()) {
            totalkamar = lamasewa * hrgvip;
        } else if (stand.isSelected()) {
            totalkamar = lamasewa * hrgstd;
        } else if (kosong.isSelected()) {
            totalkamar = lamasewa * hrgempty;
        } else {
            totalkamar = 0;
            JOptionPane.showMessageDialog(inputmember, "Silahkan Pilih Tipe Kamar");

        }

        if (v50.isSelected()) {
            totalinternet = lamasewa * hrgv50;
        } else if (v30.isSelected()) {
            totalinternet = lamasewa * hrgv30;
        } else if (v20.isSelected()) {
            totalinternet = lamasewa * hrgv20;
        } else {
            totalinternet = lamasewa * 0;
        }

        //perjumlahan
        totalkesuruhan = totalinternet + totalkamar;
        inputmember.getOutputTotal().setText(Integer.toString(totalkesuruhan));
    }

    public void resetForm(ViewMain view) {
        view.getValueNama().setText("");
        view.getValueNama().requestFocus();
        view.getValueAlamat().setText("");
        view.getValueNohp().setText("");
        view.getValueSewa().setText("");
        view.getOutputTotal().setText("");
        view.getBg1().clearSelection();
        view.getBg2().clearSelection();
        view.getBg3().clearSelection();
        //set border
        view.getValueNama().setBorder(BorderFactory.createLineBorder(Color.white));
        view.getValueAlamat().setBorder(BorderFactory.createLineBorder(Color.white));
        view.getValueNohp().setBorder(BorderFactory.createLineBorder(Color.white));
        view.getValueSewa().setBorder(BorderFactory.createLineBorder(Color.white));
    }

    public void setColorValidation(ViewMain view) {
        if (view.getValueNama().getText().isEmpty() || view.getValueAlamat().getText().isEmpty()
                || view.getValueSewa().getText().isEmpty() || view.getValueNohp().getText().isEmpty()
                || !(view.getValueNohp().getText().contains("8"))) {

            view.getValueNama().setBorder(BorderFactory.createLineBorder(Color.red));
            view.getValueAlamat().setBorder(BorderFactory.createLineBorder(Color.red));
            view.getValueNohp().setBorder(BorderFactory.createLineBorder(Color.red));
            view.getValueSewa().setBorder(BorderFactory.createLineBorder(Color.red));

            if (view.getValueNama().getText().length() > 0) {
                view.getValueNama().setBorder(BorderFactory.createLineBorder(Color.green));
            }
            if (view.getValueAlamat().getText().length() > 0) {
                view.getValueAlamat().setBorder(BorderFactory.createLineBorder(Color.green));
            }
            if (view.getValueSewa().getText().length() > 0) {
                view.getValueSewa().setBorder(BorderFactory.createLineBorder(Color.green));
            }
            if (view.getValueNohp().getText().length() == 12 && view.getValueNohp().getText().contains("8")) {
                view.getValueNohp().setBorder(BorderFactory.createLineBorder(Color.green));
            }
        }
    }

    ///////////////////////////////////////////from edit table/////////////////////////////
    public void setDateincrement(int dateincrement) {
        this.dateincrement = dateincrement;
    }
    int dateincrement = 0;
     int[] tmpsewa = new int[1];
    public void editCekTotal(Edit edit) throws SQLException, HargaException, ParseException {
        apiHarga();
        //tipe Kamar 
        JRadioButton vip = edit.getRadiobVip();
        JRadioButton stand = edit.getRadiobStandard();
        JRadioButton kosong = edit.getRadiobEmpty();
        // akhir tipe kamar        

        // tipe Wifi
        JRadioButton v50 = edit.getRadiob50();
        JRadioButton v30 = edit.getRadiob30();
        JRadioButton v20 = edit.getRadiob20();
        String tipe_kamar = "";
        String wifi = "";
        Integer totalkamar = null, totalinternet = null, totalkesuruhan = null;

        String ls = edit.getValueSewa().getText();
        if (ls.length() < 1) {
            edit.getValueSewa().setBorder(BorderFactory.createLineBorder(Color.red));
            return;
        } else {
            edit.getValueSewa().setBorder(BorderFactory.createLineBorder(Color.green));
        }
//        convert lama sew;
        Integer lamasewa = Integer.parseInt(ls);
        if (vip.isSelected()) {
            totalkamar = lamasewa * hrgvip;
        } else if (stand.isSelected()) {
            totalkamar = lamasewa * hrgstd;
        } else if (kosong.isSelected()) {
            totalkamar = lamasewa * hrgempty;
        } else {
            totalkamar = 0;
            JOptionPane.showMessageDialog(edit, "Silahkan Pilih Tipe Kamar");

        }

        if (v50.isSelected()) {
            totalinternet = lamasewa * hrgv50;
        } else if (v30.isSelected()) {
            totalinternet = lamasewa * hrgv30;
        } else if (v20.isSelected()) {
            totalinternet = lamasewa * hrgv20;
        } else {
            totalinternet = lamasewa * 0;
        }

        //simpan data tmp sewa ke array 0 arraydi definisakna 1 saja karena tidak akan di assigment lagi

        String[] tmpDate = new String[1];
        if (dateincrement == 0) {
            tmpsewa[0] = lamasewa;
            dateincrement = 1;
            
        }
        // hasil lama sewa untuk tanggal
            int hs = lamasewa-tmpsewa[0] ;
            System.out.println("date "+dateincrement);
            System.out.println("hasil "+hs);
            System.err.println("tmpSewa = " + tmpsewa[0] );


        String convert_date = edit.getValueBatas().getText();
        String hasil_convert_date = convert_date.replaceAll("-", "/");
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(hasil_convert_date);
        Calendar ex = Calendar.getInstance();
        ex.setTime(date);
        ex.add(Calendar.MONTH, hs);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String exdate = sdf.format(ex.getTime());

        //perjumlahan
        totalkesuruhan = totalinternet + totalkamar;
        edit.getValueOuput().setText("RP. " + Integer.toString(totalkesuruhan));
        edit.getValueBatas().setText(exdate);
    }
    
    
}
