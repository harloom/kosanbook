/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

    import com.mysql.jdbc.Driver;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;

/**
 *
 * @author Nanda Eranata
 */
public class konekbyNanda {
    
    static Connection koneksi;
    public static Connection getConnection(){
        try{
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_kosanbook","root","");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Database belum terkoneksi !");
        }
        return koneksi;
    }
    
}
