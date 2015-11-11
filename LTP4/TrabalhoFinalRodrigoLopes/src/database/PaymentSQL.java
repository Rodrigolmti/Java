/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.ConnectionFactory.returnObjectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Payment;

/**
 *
 * @author rodrigo.martins
 */
public class PaymentSQL {

    private static final Connection objCon = returnObjectSQL();
    private static PreparedStatement objCons;
    private static ResultSet result;

    /* ============== PAYMENT INSERT ======================= */
    private static final String insert = "INSERT INTO PAGTO_MENSALISTA (CODIGO, MES_REFERENCIA, ANO_REFERENCIA, DATA_PAGTO, VALOR) VALUES (?,?,?,?,?)";
    /* ============== PAYMENT SEARCH ALL =================== */
    private static final String allPayment = "SELECT *FROM PAGTO_MENSALISTA";
    /* ============== PAYMENT CONSULT =================== */
    private static final String consultCodeMonth = "SELECT *FROM PAGTO_MENSALISTA WHERE NOPAGTO =? AND MES_REFERENCIA =?";
    /* ============== PAYMENT RETURN =================== */
    private static final String returnObjectWithCode = "SELECT *FROM PAGTO_MENSALISTA WHERE NOPAGTO =?";
    /* ============== PAYMENT RETURN =================== */
    private static final String searchPaymentWithCodePayment = "SELECT *FROM PAGTO_MENSALISTA WHERE NOPAGTO =? ORDER BY DATA_PAGTO";
    /* ============== PAYMENT RETURN =================== */
    private static final String searchPaymentWithCodPark = "SELECT *FROM PAGTO_MENSALISTA WHERE CODIGO =?";
    /* ============== PAYMENT UPDATE =================== */
    private static final String paymentUpdate = "UPDATE PAGTO_MENSALISTA SET MES_REFERENCIA =?, ANO_REFERENCIA =? WHERE NOPAGTO =?";
    /* ============== PAYMENT UPDATE =================== */
    private static final String deletePayment = "DELETE FROM PAGTO_MENSALISTA WHERE NOPAGTO =?";

    public static void insertPayment(Payment pay) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(insert);
            objCons.setInt(1, pay.getCodigo());
            objCons.setInt(2, pay.getMes_referencia());
            objCons.setInt(3, pay.getAno_referencia());
            objCons.setDate(4, pay.getData_pagto());
            objCons.setDouble(5, pay.getValor());
            objCons.execute();
            objCon.commit();
        } catch (SQLException e) {
            objCon.rollback();
            throw e;
        } finally {
            objCon.setAutoCommit(true);
        }
    }

    public static void updatePayment(Payment pay) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(paymentUpdate);
            objCons.setInt(1, pay.getMes_referencia());
            objCons.setInt(2, pay.getAno_referencia());
            objCons.setInt(3, pay.getNoPagto());
            objCons.execute();
            objCon.commit();
        } catch (SQLException e) {
            objCon.rollback();
            throw e;
        } finally {
            objCon.setAutoCommit(true);
        }
    }
    
    public static void deletePayment(int code) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(deletePayment);
        objSQL.setInt(1, code);
        objSQL.executeUpdate();
    }

    public static ResultSet returnAllPayment() throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(allPayment);
        return objSQL.executeQuery();
    }
    
    public static ResultSet searchPaymentWithCodePayment(int code) throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(searchPaymentWithCodePayment);
        objSQL.setInt(1, code);
        return objSQL.executeQuery();
    }
    
    public static ResultSet searchPaymentWithCodeSalaried(int code) throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(searchPaymentWithCodPark);
        objSQL.setInt(1, code);
        return objSQL.executeQuery();
    }

    public static boolean searchPaymentWithCodeMonth(int code, int month) throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(consultCodeMonth);
        objSQL.setInt(1, code);
        objSQL.setInt(2, month);
        ResultSet objResp = objSQL.executeQuery();
        return objResp.next();
    }

    public static Payment paymentReturnWithCodeObject(int code) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(returnObjectWithCode);
        objSQL.setInt(1, code);
        ResultSet resp = objSQL.executeQuery();

        if (resp.next()) {
            return new Payment(resp.getInt("NOPAGTO"),
                    resp.getInt("CODIGO"),
                    resp.getInt("MES_REFERENCIA"),
                    resp.getInt("ANO_REFERENCIA"),
                    resp.getDate("DATA_PAGTO"),
                    resp.getDouble("VALOR"));
        }
        return null;
    }
}
