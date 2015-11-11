/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static database.ParkingSQL.deletePark;
import static database.ParkingSQL.insertPark;
import static database.ParkingSQL.parkReturnWithCodeObject;
import static database.ParkingSQL.returnAllParkings;
import static database.ParkingSQL.searchWithCnpjPark;
import static database.ParkingSQL.searchWithCodePark;
import static database.ParkingSQL.updatePark;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Parking;

public class ControllPark {
    
    /**
     * Insere um novo estacionamento no banco
     * @param obj 
     */
    public static void insertParkingCtr(Parking obj) {
    
        try {
            insertPark(obj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Deleta um estacionamento no banco
     * @param code 
     */
    public static void deleteParkingCtr(int code) {
        try {
            deletePark(code);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Edita um estacionamento no banco
     * @param obj 
     */
    public static void editParkingCtr(Parking obj) {
        try {
            updatePark(obj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Retorna todos os estacionamentos cadastrados no banco
     * @return ResultSet result
     */
    public static ResultSet returnAllParkingsCtr() {
        try {
            ResultSet result = returnAllParkings();
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    /**
     * Consulta um estacionamento pelo CNPJ
     * @param cnpj
     * @return boolean
     */
    public static boolean searchWithCnpjParkCtr(String cnpj) {
        try {   
            return searchWithCnpjPark(cnpj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    /**
     * Procura por um estacionamento com o codigo informado
     * @param code
     * @return ResultSet result
     */
    public static ResultSet searchWithCodeParkCtr(int code) {
        try {
            ResultSet result = searchWithCodePark(code);
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    /**
     * Returna um estacionamento com o codigo informado, caso ache!
     * @param code
     * @return Parking obj
     */
    public static Parking parkReturnWithCodeObjectCtr(int code) {
        try {
            Parking park = parkReturnWithCodeObject(code);
            return park;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
