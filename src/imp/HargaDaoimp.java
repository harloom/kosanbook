/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

import enity.Harga;
import error.HargaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import service.HargaDao;

/**
 *
 * @author Hx-loom
 */
public class HargaDaoimp  implements HargaDao{
    private Connection connection;
    private String qry= "UPDATE tbl_harga SET ";
    private String  a ="50mbps=? ";
    private String  b =",30mbps=? ";
    private String  c =",20mbps=? ";
    private String  d =",vip=? ";
    private String  e =",standard=? ";
    private String  f =",kosong=? ";
    private final String  updateHargaalll = "UPDATE tbl_harga SET 50mbps =?, 30mbps=? ,20mbps=?"
            + ",vip=? , standard=? ,kosong=? ,tanggal_update=? WHERE id= ?";
    private final String getHarga = "SELECT *From tbl_harga";
    
     private final String getByid = "SELECT *FROM tbl_harga WHERE id = ? ";

    public HargaDaoimp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updateHargaall(Harga harga) throws HargaException {
                PreparedStatement statement =   null;

    try {
        connection.setAutoCommit(false);
        statement = connection.prepareStatement(updateHargaalll);
            statement.setInt(1, harga.getH50mbps());
            statement.setInt(2, harga.getH30mbps());
            statement.setInt(3, harga.getH20mbps());
            statement.setInt(4, harga.getHvip());
            statement.setInt(5, harga.getHstandard());
            statement.setInt(6, harga.getHkosong());
            statement.setString(7, harga.getTanggal_update());
            statement.setInt(8, harga.getId());
            statement.executeUpdate();
            connection.commit();
    } catch (SQLException ex) {
        try {
            connection.rollback();
            } 
            catch (SQLException e) {
            }
        throw  new HargaException(ex.getMessage());
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
    public List<Harga> selectallHarga() throws HargaException {
        Statement statement = null;
        List<Harga> listharga= new ArrayList<Harga>();
        
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultharga =statement.executeQuery(getHarga);
            Harga harga = null;
            while (resultharga.next())
            {
                harga = new Harga();
                harga.setH50mbps(resultharga.getInt("50mbps"));
                harga.setH30mbps(resultharga.getInt("30mbps"));
                harga.setH20mbps(resultharga.getInt("20mbps"));
                harga.setHvip(resultharga.getInt("vip"));
                harga.setHstandard(resultharga.getInt("standard"));
                harga.setHkosong(resultharga.getInt("kosong"));
                harga.setTanggal_update(resultharga.getString("tanggal_update"));
                listharga.add(harga);
                connection.commit();
            }          
            return listharga;


        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {            
        }

        throw new HargaException(e.getMessage());
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

    @Override
    public Harga getHarga(Integer id) throws HargaException{
        PreparedStatement statement = null;
        try {
              connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByid);
            statement.setInt(1, id);
//            kalo select pake resource
                //pake execute Query
            ResultSet result = statement.executeQuery();
            Harga harga = null;
            
            if (result.next()) {
                harga = new Harga();
                harga.setId(result.getInt("id"));
                harga.setH50mbps(result.getInt("50mbps"));
                harga.setH30mbps(result.getInt("30mbps"));
                harga.setH20mbps(result.getInt("20mbps"));
                harga.setHvip(result.getInt("vip"));
                harga.setHstandard(result.getInt("standard"));
                harga.setHkosong(result.getInt("kosong"));
                harga.setTanggal_update(result.getString("tanggal_update"));
                
            }else{
                 throw  new HargaException("Printah Gagal");
            }
               connection.commit();
            return harga;
           
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {            
            }
//            pake titik
             throw new HargaException(e.getMessage());
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
