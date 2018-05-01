/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import enity.Admin;
import error.AdminException;
import java.awt.Desktop;
import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.AdminModel;
import service.AdminDao;
import view.Login;
import view.ViewMain;

/**
 *
 * @author Hx-loom
 */
public class AdminController {

    private AdminModel adminModel;

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    public void upPasswod(ViewMain viewMain) throws SQLException, AdminException {

        //disimpan ke dalam variable
        String txtpasswordLama = viewMain.getTxtPasswordLama().getText();
        String txtPasswordBaru = viewMain.getTxtPasswordBaru().getText();
        String validPass = viewMain.getTxtValidPassword().getText();

        //        tanggal 
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String cyear = Integer.toString(year);
        int mont = (now.get(Calendar.MONTH) + 1);
        String cmont = Integer.toString(mont);
        int day = (now.get(Calendar.DATE));
        String cday = Integer.toString(day);
        String tanggal_up = cyear + "/" + cmont + "/" + cday;

        //ambil data password lama
        String lPassword = null;
        AdminDao daolist = Database.getAdminDao();
        List<Admin> aa = daolist.listAdmin();
        for (Admin n : aa) {
            lPassword = n.getPasswod();
        }
        if (txtpasswordLama.isEmpty() || txtPasswordBaru.isEmpty() || validPass.isEmpty()) {
            JOptionPane.showMessageDialog(viewMain, "Silahkan Isi Form Telebih Dahulu");
        } else if (txtpasswordLama == null ? lPassword != null : !txtpasswordLama.equals(lPassword)) {
            JOptionPane.showMessageDialog(viewMain, "Password  Lama Anda Salah");
        } else if (txtPasswordBaru == null ? validPass != null : !txtPasswordBaru.equals(validPass)) {
            JOptionPane.showMessageDialog(viewMain, "Konfimasi Password tidak Sama ");
        } else {
            adminModel.setPassword(validPass);
            adminModel.setTgl_update(tanggal_up);
            try {
                int dialogBtn = JOptionPane.YES_NO_OPTION;
                int dialogResIult = JOptionPane.showConfirmDialog(viewMain, "Apakah Anda Ingin Mengganti Password?", "PERINGATAN", dialogBtn);

                if (dialogResIult == 0) {
                    //true condition
                    adminModel.updatePassword();
                    JOptionPane.showMessageDialog(viewMain, "Password berhasil Di ubah \n Silahkan Login ulang ");
                    viewMain.dispose();
                    Login log = new Login();
                    log.setVisible(true);
//                     Desktop.getDesktop().open(new File("D:\\Tugas prototype\\kosanbook\\dist\\Pmember1.jar"));
                } else {
                    //false condition
                }

            } catch (Throwable e) {
                JOptionPane.showMessageDialog(viewMain, "Data gagal ke Di Ubah , Silahkan Hubungi Dev");
            }
        }

    }

}
