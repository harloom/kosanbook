/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import enity.Admin;
import error.AdminException;

import error.MemberException;
import java.util.List;

/**
 *
 * @author Hx-loom
 */
public interface AdminDao {
    
    public void updateAdmin(Admin admin) throws AdminException;
     public List<Admin> listAdmin() throws  AdminException;  
     public void loginHistory (Admin admin) throws AdminException;
}
