/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static database.VehicleSQL.cosultVehicleSign;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.ParkingRegister;

/**
 *
 * @author rodri
 */
public class Generic {
    
    //Methods generic
    
    public static Object returnObject(Object obj) {
        return obj;
    }
    
    public static boolean verifyObject(Object obj) {

        if (obj != null) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Objeto não instanciado / selecione um veiculo!");
        return false;
    }
    
    //Methods vehicle entrace
    
    public static boolean consultSign(String sign) {

        try {
            if (cosultVehicleSign(sign)) {
                JOptionPane.showMessageDialog(null, "Ja existe um veiculo com a placa informada!");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParkingRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
