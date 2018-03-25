/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import imp.HargaDaoimp;
import imp.MemberDaoimp;


import java.sql.Connection;
import java.sql.SQLException;
import service.HargaDao;
import service.Service_member_dao;


/**
 *
 * @author Hx-loom
 */
public class Database {
    private static Connection connection ;
    private static Service_member_dao memberDao;
    private static HargaDao hargaDao;

    public static Connection getConnection() throws SQLException{
     String url = "jdbc:mysql://localhost:3306/db_kosanbook?zeroDateTimeBehavior=convertToNull";
    String pass = "";
    String user = "root";
    if (connection == null) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(pass);
        connection  = dataSource.getConnection() ;
    }
        return  connection;
        
    }

    public static Service_member_dao getMemberDao() throws SQLException
    {
        if (memberDao  == null )
        {
            memberDao = new MemberDaoimp(getConnection());
        }
        
        return  memberDao;
    }
    
    public static HargaDao getHargaDao() throws SQLException
    {
        if(hargaDao == null)
        {
            hargaDao = new HargaDaoimp(getConnection());
        }
        return  hargaDao;
    }
        
    
}
