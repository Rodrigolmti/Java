/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase.keys;

import static dataBase.connection.returnObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class deleteKey {
 
    private static final Connection objCon = returnObj();  
    private static final String deleteKey = "DELETE FROM `keys` WHERE `key` = ?"; 
    
    public static void deleteKey(String key) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(deleteKey);
        objSQL.setString(1, key);
        objSQL.executeUpdate();
    }
    
}
