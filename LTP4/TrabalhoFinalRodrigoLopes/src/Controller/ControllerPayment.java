/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static database.PaymentSQL.deletePayment;
import static database.PaymentSQL.insertPayment;
import static database.PaymentSQL.paymentReturnWithCodeObject;
import static database.PaymentSQL.returnAllPayment;
import static database.PaymentSQL.searchPaymentWithCodeMonth;
import static database.PaymentSQL.searchPaymentWithCodePayment;
import static database.PaymentSQL.searchPaymentWithCodeSalaried;
import static database.PaymentSQL.updatePayment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Payment;

/**
 *
 * @author rodrigo.martins
 */
public class ControllerPayment {

    public static void insertPaymentCtr(Payment obj) {
        try {
            insertPayment(obj);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatePaymentCtr(Payment obj) {
        try {
            updatePayment(obj);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deletePaymentCtr(int code) {
        try {
            deletePayment(code);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet searchPaymentWithCodeSalariedCtr(int code) {
        try {
            return searchPaymentWithCodeSalaried(code);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet searchPaymentWithCodePaymentCtr(int code) {
        try {
            return searchPaymentWithCodePayment(code);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet returnAllPaymentCtr() {
        try {
            ResultSet result = returnAllPayment();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean searchPaymentWithCodeMonthCtr(int code, int month) {
        try {
            return searchPaymentWithCodeMonth(code, month);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Payment paymentReturnWithCodeObjectCtr(int code) {
        try {
            return paymentReturnWithCodeObject(code);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
