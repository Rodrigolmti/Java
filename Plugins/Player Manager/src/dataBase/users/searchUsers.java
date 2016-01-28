/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase.users;

import static dataBase.connection.returnObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class searchUsers {
 
    private static final Connection objCon = returnObj();  
    private static final String searchVips = "SELECT id,username,ip FROM authme"; 
    
     public static ResultSet returnAllUsers() throws SQLException{
        PreparedStatement objSQL
            = objCon.prepareStatement(searchVips);
        return objSQL.executeQuery();
    }
    
}
