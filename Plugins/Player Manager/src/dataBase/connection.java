/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author macbookpro
 */
public class connection {
 
    private static Connection objCon;   
    
    public void createConnection() throws SQLException {
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            objCon = DriverManager.getConnection("jdbc:mysql://143.202.36.41:3306/matheuscorreasoa", "matheuscorreasoa", "q91Xi4j5Zm");
        
            System.out.println("Connection OK!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        
    }
    
    public static void closeConnection() throws SQLException {
        objCon.close();
    }
    
    public static Connection returnObj() {
        return objCon;
    }
}
