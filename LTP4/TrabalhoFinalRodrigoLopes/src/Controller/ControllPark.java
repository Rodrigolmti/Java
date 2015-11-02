/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static database.ParkingSQL.cosultParkCnpj;
import static database.ParkingSQL.deletePark;
import static database.ParkingSQL.insertPark;
import static database.ParkingSQL.parkReturnObject;
import static database.ParkingSQL.searchAllParkings;
import static database.ParkingSQL.searchPark;
import static database.ParkingSQL.updatePark;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Parking;

/**
 *
 * @author rodrigo.martins
 */
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
    public static ResultSet searchAllParkingCtr() {
        try {
            ResultSet result = searchAllParkings();
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
    public static boolean consultCnpjCtr(String cnpj) {
        try {   
            return cosultParkCnpj(cnpj);
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
    public static ResultSet searchParkCodeCtr(int code) {
        try {
            ResultSet result = searchPark(code);
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
    public static Parking parkReturnObjectCtr(int code) {
        try {
            Parking park = parkReturnObject(code);
            return park;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
