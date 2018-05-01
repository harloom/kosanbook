/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.util.Objects;

/**
 *
 * @author Hx-loom
 */
public class Admin {
   private String username;
   private String Passwod = null;
   private String tgl_login;

    public Admin(String username, String Passwod, String tgl_login) {
        this.username = username;
        this.Passwod = Passwod;
        this.tgl_login = tgl_login;
    }

   public Admin(){
       
   }
   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswod() {
        return Passwod;
    }

    public void setPasswod(String Passwod) {
        this.Passwod = Passwod;
    }

    public String getTgl_login() {
        return tgl_login;
    }

    public void setTgl_login(String tgl_login) {
        this.tgl_login = tgl_login;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.username);
        hash = 17 * hash + Objects.hashCode(this.Passwod);
        hash = 17 * hash + Objects.hashCode(this.tgl_login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.Passwod, other.Passwod)) {
            return false;
        }
        if (!Objects.equals(this.tgl_login, other.tgl_login)) {
            return false;
        }
        return true;
    }
   
}
