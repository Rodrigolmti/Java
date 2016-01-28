/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase.vips;

import data.Vips;
import static dataBase.connection.returnObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class updateVip {
    
    private static final Connection objCon = returnObj();   
    private static PreparedStatement objCons;
    private static ResultSet result;
    private static final String updateVip = "UPDATE vips SET sapphire = ?, esmeralda = ?, diamante = ? WHERE nome =?"; 
    
    public static void updateVip(Vips vip) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(updateVip);
            objCons.setString(1, vip.getSapphireTime());
            objCons.setString(2, vip.getNome());
            objCons.setString(2, vip.getEsmeraldaTime());
            objCons.setString(2, vip.getDiamanteTime());
            objCons.execute();
            objCon.commit();
        } catch (SQLException e) {
            objCon.rollback();
            throw e;
        } finally {
            objCon.setAutoCommit(true);
        }
    }
    
}
