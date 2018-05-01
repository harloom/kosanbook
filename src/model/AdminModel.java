/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import enity.Admin;
import error.AdminException;
import java.sql.SQLException;
import java.util.List;
import service.AdminDao;

/**
 *
 * @author Hx-loom
 */
public class AdminModel {
//    private String username;

    private String password;
    private String tgl_update;

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTgl_update() {
        return tgl_update;
    }

    public void setTgl_update(String tgl_update) {
        this.tgl_update = tgl_update;
    }

    public void updatePassword() throws AdminException, SQLException {
        /////////////////////////////update password ///////////////////////////
        String[][] admin = new String[1][3];
        AdminDao dao = Database.getAdminDao();
        List<Admin> n = dao.listAdmin();
        for (Admin a : n) {
            admin[0][0] = a.getUsername();
            admin[0][1] = a.getPasswod();
            admin[0][2] = a.getTgl_login();
            a.setPasswod(password);
            a.setTgl_login(tgl_update);
            a.setUsername(admin[0][0]);
            dao.updateAdmin(a);
        }

    }

}
