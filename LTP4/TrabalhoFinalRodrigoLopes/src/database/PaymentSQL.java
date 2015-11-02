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
    
    public static ResultSet searchAllPayment() throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(allPayment);
        return objSQL.executeQuery();
    }
}
