/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import imp.HargaDaoimp;
import imp.MemberDaoimp;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.HargaDao;
import service.Service_member_dao;
import sound.Hime;

/**
 *
 * @author Hx-loom
 */
public class Database {

    private static Connection connection;
    private static Service_member_dao memberDao;
    private static HargaDao hargaDao;
    private static Hime sound = new Hime();

    public static Connection getConnection() throws SQLException, IOException {

        String url = "jdbc:mysql://localhost:3306/db_kosanbook?zeroDateTimeBehavior=convertToNull";
//       String user =  JOptionPane.showInputDialog("Silahkan masukan userXampp");
//       String pass = JOptionPane.showInputDialog("Silahkan masukan passXampp");
        String user = "root";
        String pass = "";
        try {
            if (connection == null) {
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setUrl(url);
                dataSource.setUser(user);
                dataSource.setPassword(pass);
                connection = dataSource.getConnection();

            }
        } catch (SQLException e) {
            sound.soundErr();
            JOptionPane.showMessageDialog(null, "Koneksi DataBase Belum Hidup");
            Desktop.getDesktop().open(new File("C:\\xampp\\xampp-control.exe"));
        }
        return connection;
    }

    public static Service_member_dao getMemberDao() throws SQLException {
        if (memberDao == null) {
            try {
                memberDao = new MemberDaoimp(getConnection());
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return memberDao;
    }

    public static HargaDao getHargaDao() throws SQLException {
        if (hargaDao == null) {
            try {
                hargaDao = new HargaDaoimp(getConnection());
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return hargaDao;
    }

}
