/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase.keys;

import static dataBase.connection.returnObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class searchKeys {
    
    private static final Connection objCon = returnObj();   
    private static PreparedStatement objCons;
    private static ResultSet result;
    private static final String searchKeys = "SELECT *FROM `keys`"; 
    private static final String searchWithKey = "SELECT *FROM `keys` WHERE `key` = ?";
    
     public static ResultSet returnAllKeys() throws SQLException{
        PreparedStatement objSQL
            = objCon.prepareStatement(searchKeys);
        return objSQL.executeQuery();
    }
     
    public static ResultSet searchWithKey(String key) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(searchWithKey);
        objSQL.setString(1, key);
        ResultSet objResp = objSQL.executeQuery();
        return objSQL.executeQuery();
    }

    
}
