/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class MyConnect {
    public static Connection myConnect(){
        try {
            String cnnString = "jdbc:sqlserver://localhost:1433;database=FastJob";
//            String username = "long";
//            String password = "Goboi123";
            String username ="long";
            String password ="Goboi123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cnn = DriverManager.getConnection(cnnString, username, password);
            return cnn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Khong ket noi database");
        }
        return null;
    }
   
}
