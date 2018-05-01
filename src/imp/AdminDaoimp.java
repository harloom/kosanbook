/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

import enity.Admin;
import error.AdminException;
import error.MemberException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import service.AdminDao;

/**
 *
 * @author Hx-loom
 */
public class AdminDaoimp implements AdminDao {

    private Connection connection;

    public AdminDaoimp(Connection connection) {
        this.connection = connection;
    }
    private final String all = "SELECT *FROM tbl_admin";
    private final String updateP = "UPDATE tbl_admin SET password=?, tgl_login = ? WHERE username=?";
    private final String loginHistory= "UPDATE tbl_admin SET tgl_login = ? WHERE username=?";
    @Override
    public void updateAdmin(Admin admin) throws AdminException {
        PreparedStatement statement = null;
            try {
        connection.setAutoCommit(false);
        statement = connection.prepareStatement(updateP);
            statement.setString(1, admin.getPasswod());
            statement.setString(2, admin.getTgl_login());
            statement.setString(3, admin.getUsername());

            statement.executeUpdate();
            connection.commit();
    } catch (SQLException ex) {
        try {
            connection.rollback();
            } 
            catch (SQLException e) {
            }
        throw  new AdminException(ex.getMessage());
        }
        finally{
            try {
                 
               connection.setAutoCommit(true);
            }
         catch (SQLException e) {
            }
            if (statement !=null) {
                      try{
                    statement.close();
                    } catch (SQLException ex){          
                 }  
            }
        }
    }

    @Override
    public List<Admin> listAdmin() throws AdminException {
        Statement statement = null;
        List<Admin> list = new ArrayList<Admin>();

        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultAdmin = statement.executeQuery(all);
            Admin admin1 = null;
            while (resultAdmin.next()) {
                admin1 = new Admin();
                admin1.setUsername(resultAdmin.getString("username"));
                admin1.setPasswod(resultAdmin.getString("password"));
                admin1.setTgl_login(resultAdmin.getString("tgl_login"));
                list.add(admin1);
                connection.commit();
            }
            return list;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new AdminException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);

            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void loginHistory(Admin admin) throws AdminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
