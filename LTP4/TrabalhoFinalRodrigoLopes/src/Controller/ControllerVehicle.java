/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static database.VehicleSQL.countVehicle;
import static database.VehicleSQL.countWithDatesNotSalaried;
import static database.VehicleSQL.countWithDatesSalaried;
import static database.VehicleSQL.countWithDatesTotal;
import static database.VehicleSQL.insertVehicle;
import static database.VehicleSQL.returnAllVehicles;
import static database.VehicleSQL.returnVehiclesWithCodePark;
import static database.VehicleSQL.updateSalariedExitDate;
import static database.VehicleSQL.updateVehicleExit;
import static database.VehicleSQL.vehicleReturnWithCodeObject;
import static database.VehicleSQL.verifyVehicleExitEntrace;
import java.sql.Date;
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

    public static void updateSalariedExitDateCtr(int code, Timestamp date) {
        try {
            updateSalariedExitDate(code, date);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    /**
     * Retorna todos os veiculos no banco de dados
     *
     * @param code
     * @return ResultSet
     */
    public static ResultSet returnAllVehiclesCtr(int code) {
        try {
            return returnAllVehicles(code);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public static boolean verifyVehicleExitEntraceCtr(String sign, int code) {
        try {
            return verifyVehicleExitEntrace(sign,code);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ResultSet returnVehiclesWithCodeParkCtr(int code) {
        try {
            return returnVehiclesWithCodePark(code);
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
    public static Vehicle vehicleReturnWithCodeObjectCtr(int code) {
        try {
            Vehicle car = vehicleReturnWithCodeObject(code);
            return car;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    /**
     * Retorna a quantidade de veiculos no banco de dados
     *
     * @return int count
     */
    public static int countVehicleCtr() {
        try {
            return countVehicle();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    /**
     * Faz a soma total de valores recebidos
     *
     * @param one
     * @param two
     * @return
     */
    public static float countWithDatesTotalCtr(Date one, Date two) {
        try {
            return countWithDatesTotal(one, two);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    /**
     * Faz a soma dos valores de veiculos horistas
     *
     * @param one
     * @param two
     * @return
     */
    public static float CountWithDatesNotSalariedCtr(Date one, Date two) {
        try {
            return countWithDatesNotSalaried(one, two);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    /**
     * Faz a soma dos valores de veiculos mensalistas
     *
     * @param one
     * @param two
     * @return
     */
    public static float CountWithDatesSalariedCtr(Date one, Date two) {
        try {
            return countWithDatesSalaried(one, two);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }
}
