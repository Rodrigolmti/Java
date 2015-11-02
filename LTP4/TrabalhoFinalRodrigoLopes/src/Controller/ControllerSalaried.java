/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static database.SalariedSQL.consultEqualSignSalaried;
import static database.SalariedSQL.deleteSalaried;
import static database.SalariedSQL.insertSalaried;
import static database.SalariedSQL.searchAllSalaried;
import static database.SalariedSQL.searchSalaried;
import static database.SalariedSQL.updateDate;
import static database.SalariedSQL.updateDateExit;
import static database.SalariedSQL.updateSalaried;
import static database.VehicleSQL.cosultVehicleSign;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Salaried;

public class ControllerSalaried {

    /**
     * Insere um novo mensalista no banco
     * @param obj 
     */
    public static void insertSalariedCtr(Salaried obj) {
        try {
            insertSalaried(obj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /*Deleta um mensalista do banco*
     * 
     * @param code 
     */
    public static void deleteSalariedCtr(int code) {
        try {
            deleteSalaried(code);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Edita um mensalista do banco
     * @param sal 
     */
    public static void editSalariedCtr(Salaried sal) {
        try {
            updateSalaried(sal);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static void updateDateExitCtr(Timestamp date, int code) {
        try {
            updateDateExit(date,code);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSalaried.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Procura por um mensalista com o codigo informado
     * @param code
     * @return ResultSet result
     */
    public static ResultSet searchSalariedCodeCtr(int code) {
        try {
            ResultSet result = searchSalaried(code);
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    /**
     * Consulta um mensalista com a placa informada
     * @param sign
     * @return boolean
     */
    public static boolean consultSignSalariedCtr(String sign) {
        try {
            return cosultVehicleSign(sign);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    /**
     * Consulta se ja tem um mensalista com a placa informada
     * @param sign
     * @return boolean
     */
    public static boolean consultEqualSignSalariedCtr(String sign) {
        try {
            return consultEqualSignSalaried(sign);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    /**
     * Retorna todos os mensalista cadastrados no banco
     * @return ResultSet result
     */
    public static ResultSet returnAllSalariedCtr() {
        try {
            ResultSet result = searchAllSalaried();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSalaried.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
