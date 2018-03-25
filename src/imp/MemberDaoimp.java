/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

import enity.Member;
import error.MemberException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import service.Service_member_dao;

/**
 *
 * @author Hx-loom
 */
public class MemberDaoimp implements Service_member_dao{
private Connection connection; 
private final String insertMember ="INSERT INTO tbl_member (nama,jenis_kelamin,alamat,sewa,nohp,"
        + "tipe_kamar,tipe_wifi,total,tanggal_masuk,expire) VALUE (?,?,?,?,?,?,?,?,?,?)";
private final String getall = "SELECT *From tbl_member";

    public MemberDaoimp(Connection connection) {
        this.connection = connection;
    }



    @Override
    public void insertMember(Member member) throws MemberException {
        PreparedStatement statement =   null;
        
    try {
        connection.setAutoCommit(false);
        statement = connection.prepareStatement(insertMember);
        statement.setString(1, member.getNama());
        statement.setString(2, member.getJenis_kelamin());
        statement.setString(3, member.getAlamat());
        statement.setInt(4, member.getSewa());
        statement.setString(5, member.getNo_hp());
        statement.setString(6, member.getTipe_kamar());
        statement.setString(7, member.getTipe_wifi());
        statement.setInt(8, member.getTotal());
        statement.setString(9, member.getTanggal_masuk());
        statement.setString(10, member.getExpire());
        statement.executeUpdate();
         connection.commit();
    } catch (SQLException ex) {
        try {
            connection.rollback();
        } catch (SQLException e) {
        }
        throw  new MemberException(ex.getMessage());
    }finally
    {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
        }
            if (statement !=null) {
                      try
                    {
                        statement.close();
                    } catch (SQLException ex){          
                   }  
            }
        }             
    }    

    @Override
    public List<Member> selectallmember() throws MemberException {
         Statement statement = null;
        List<Member> list = new ArrayList<Member>();
        
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result =statement.executeQuery(getall);
           
            Member member = null;
            while (result.next())
            {
                member = new Member();
                member.setId_member(result.getInt("id_member"));
                member.setNama(result.getString("nama"));
                member.setJenis_kelamin(result.getString("jenis_kelamin"));
                member.setAlamat(result.getString("alamat"));
                member.setSewa(result.getInt("sewa"));
                member.setNo_hp(result.getString("nohp"));
                member.setTipe_kamar(result.getString("tipe_kamar"));
                member.setTipe_wifi(result.getString("tipe_wifi"));
                member.setTotal(result.getInt("total"));
                member.setTanggal_masuk(result.getString("tanggal_masuk"));
                member.setExpire(result.getString("expire"));
                list.add(member);
                connection.commit();
            }              

            return list;
           
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {            
            }
//            pake titik
             throw new MemberException(e.getMessage());
       } finally{
                try {
                 connection.setAutoCommit(true);
                 
                    } catch (SQLException ex) {
                    }
                 if (statement !=null) {
                     try {
                            statement.close();
                             } 
                     catch (SQLException e) {       
              }
            }     
        }
    }
    
}
