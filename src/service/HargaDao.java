/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import enity.Harga;
import enity.Member;
import error.HargaException;
import error.MemberException;
import java.util.List;

/**
 *
 * @author Hx-loom
 */
public interface HargaDao {
    
    /**
     *
     * @param harga
     * @throws error.HargaException
     * @throws error.HargaException
     * @throws error.HargaException

     */
    public void updateHargaall(Harga harga) throws HargaException;
//    public void updateDataharga(Harga harga) throws HargaException;
    public  Harga  getHarga(Integer id) throws HargaException;
    public List<Harga> selectallHarga() throws  HargaException;  

    
}
