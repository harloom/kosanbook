/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

import enity.Harga;
import enity.Newharga;
import error.HargaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import service.NewHargaDao;

/**
 *
 * @author Hx-loom
 */
public class NewHargaDaoimp  implements NewHargaDao{
    private Connection connection;
    private final String  updateHargaalll = "UPDATE tbl_hargaa SET harga =? , jumlah_max=? ,tgl_update=?  WHERE kode_h= ?";
    private final String getHarga = "SELECT *From tbl_hargaa";
    
     private final String getByid = "SELECT *FROM tbl_hargaa WHERE kode_h = ? ";

    public NewHargaDaoimp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updateHargaall(Newharga harga) throws HargaException {
                PreparedStatement statement =   null;

    try {
        connection.setAutoCommit(false);
        statement = connection.prepareStatement(updateHargaalll);
            statement.setInt(1, harga.getHarga());
            statement.setInt(2, harga.getJumlah_max());
            statement.setString(3, harga.getTgl_update());
            statement.setString(4, harga.getKode_h() );
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
    public List<Newharga> selectallHarga() throws HargaException {
        Statement statement = null;
        List<Newharga> listharga= new ArrayList<Newharga>();
        
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultharga =statement.executeQuery(getHarga);
            Newharga harga = null;
            while (resultharga.next())
            {
                harga = new Newharga();
                harga.setKode_h(resultharga.getString("kode_h"));
                harga.setHarga(resultharga.getInt("harga"));
                harga.setJumlah_max(resultharga.getInt("jumlah_max"));
                harga.setTgl_update(resultharga.getString("tgl_update"));
                
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
    public Newharga getHarga(String id) throws HargaException{
        PreparedStatement statement = null;
        try {
              connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByid);
            statement.setString(1, id);
//            kalo select pake resource
                //pake execute Query
            ResultSet result = statement.executeQuery();
            Newharga harga = null;
            
            if (result.next()) {
                harga = new Newharga();
                harga.setKode_h(result.getString("kode_h"));
                harga.setHarga(result.getInt("harga"));
                harga.setJumlah_max(result.getInt("jumlah_max"));
                harga.setTgl_update(result.getString("tgl_update"));
                
            }else{
                 throw  new HargaException("Harga Gagal Di Update");
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
