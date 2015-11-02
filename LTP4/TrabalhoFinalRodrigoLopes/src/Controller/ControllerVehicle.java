/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static database.VehicleSQL.countVehicle;
import static database.VehicleSQL.insertVehicle;
import static database.VehicleSQL.searchAllVehicles;
import static database.VehicleSQL.updateSalariedExit;
import static database.VehicleSQL.updateVehicleExit;
import static database.VehicleSQL.vehicleExit;
import static database.VehicleSQL.vehicleReturnObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Vehicle;

public class ControllerVehicle {

    /**
     * Insere um veiculo no banco
     *
     * @param obj
     */
    public static void insertVehicleCtr(Vehicle obj) {
        try {
            insertVehicle(obj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Edita um veiculo no banco
     *
     * @param obj
     */
    public static void editVehicleCtr(Vehicle obj) {
        try {
            updateVehicleExit(obj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void updateSalariedExitCtr(int code, Timestamp date, double price) {
        try {
            updateSalariedExit(code, date, price);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Retorna todos os veiculos no banco de dados
     *
     * @return ResultSet
     */
    public static ResultSet searchAllVehicleCtr() {
        ResultSet result;
        try {
            result = searchAllVehicles();
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    /**
     * Retorna um veiculo em objeto
     *
     * @param code
     * @return Parking obj
     */
    public static Vehicle vehicleReturnObjCtr(int code) {
        try {
            Vehicle car = vehicleReturnObject(code);
            return car;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public static boolean vehicleExitCtr(String sign) {
        try {
            return vehicleExit(sign);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Retorna a quantidade de veiculos no banco de dados
     *
     * @return int count
     */
    public static int countVehicleCtr() {
        try {
            int count = countVehicle();
            return count;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }
}
