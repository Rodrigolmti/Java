/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase.vips;

import static dataBase.connection.returnObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author macbookpro
 */
public class searchVip {
    
    private static final Connection objCon = returnObj();   
    private static PreparedStatement objCons;
    private static ResultSet result;
    private static final String searchVips = "SELECT * FROM vips"; 
    
     public static ResultSet returnAllVips() throws SQLException{
        PreparedStatement objSQL
            = objCon.prepareStatement(searchVips);
        return objSQL.executeQuery();
    }
}
