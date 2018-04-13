/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import enity.Newharga;
import error.HargaException;
import java.util.List;

/**
 *
 * @author Hx-loom
 */
public interface NewHargaDao {
    public void updateHargaall(Newharga harga) throws HargaException;
//    public void updateDataharga(Harga harga) throws HargaException;
    public  Newharga  getHarga(String id) throws HargaException;
    public List<Newharga> selectallHarga() throws  HargaException;  
}
