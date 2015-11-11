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
import java.sql.Timestamp;
import model.Salaried;

/**
 *
 * @author rodrigo.martins
 */
public class SalariedSQL {
    
    private static final Connection objCon = returnObjectSQL();
    private static PreparedStatement objCons;
    private static ResultSet result;
    
    /* ============== SALARIED INSERT ======================== */
    private static final String insertSalaried = "INSERT INTO MENSALISTA (COD_ESTACIONAMENTO, NOME, TELEFONE, PLACA, DATA_ENTRADA) VALUES (?,?,?,?,CURRENT_TIMESTAMP)";
    /* ============== SALARIED SEARCH ======================== */
    private static final String searchSalaried = "SELECT *FROM MENSALISTA WHERE CODIGO = ?";
    /* ============== SALARIED SEARCH ======================== */
    private static final String searchSalariedWithName = "SELECT * FROM MENSALISTA WHERE NOME LIKE ? AND COD_ESTACIONAMENTO =? ORDER BY NOME";
    /* ============== SALARIED SEARCH SIGN =================== */
    private static final String searchSign = "SELECT *FROM MENSALISTA WHERE PLACA = ?";
    /* ============== SALARIED SEARCH SIGN =================== */
    private static final String searchSignCod = "SELECT *FROM MENSALISTA WHERE PLACA = ?";
    /* ============== SALARIED SEARCH ======================== */
    private static final String allSalaried = "SELECT *FROM MENSALISTA WHERE COD_ESTACIONAMENTO =?";
    /* ============== SALARIED UPDATE ======================== */
    private static final String updateSalaried = "UPDATE MENSALISTA SET NOME =?, TELEFONE =?, PLACA =? WHERE CODIGO =?";
    /* ============== SALARIED UPDATE ======================== */
    private static final String updateDate = "UPDATE MENSALISTA SET DATA_SAIDA =? WHERE PLACA =?";
    /* ============== SALARIED UPDATE ======================== */
    private static final String updateDateExit = "UPDATE MENSALISTA SET DATA_SAIDA =? WHERE CODIGO =?";
    /* ============== SALARIED DELETE ======================== */
    private static final String deleteSalaried = "DELETE FROM MENSALISTA WHERE CODIGO =?";
    
    
    /**
     * Insert Salaried on dataBase
     * @param objSal
     * @throws SQLException 
     */
    public static void insertSalaried(Salaried objSal) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(insertSalaried);
            objCons.setInt(1, objSal.getCod_estacionameto());
            objCons.setString(2, objSal.getNome());
            objCons.setString(3, objSal.getTelefone());
            objCons.setString(4, objSal.getPlaca());
            objCons.execute();
            objCon.commit();
        } catch (SQLException e) {
            objCon.rollback();
            throw e;
        } finally {
            objCon.setAutoCommit(true);
        }
    }

    /**
     * Edita o mensalista no banco
     * @param objSal
     * @throws SQLException 
     */
    public static void updateSalaried(Salaried objSal) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(updateSalaried);
            objCons.setString(1, objSal.getNome());
            objCons.setString(2, objSal.getTelefone());
            objCons.setString(3, objSal.getPlaca());
            objCons.setInt(4, objSal.getCodigo());
            objCons.execute();
            objCon.commit();
        } catch (SQLException e) {
            objCon.rollback();
            throw e;
        } finally {
            objCon.setAutoCommit(true);
        }
    }
    
    /**
     * Edita o campo hora de saida no mensalista
     * @param date
     * @param sign
     * @throws SQLException 
     */
    public static void updateDate(Timestamp date, String sign) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(updateDate);
            objCons.setTimestamp(1, date);
            objCons.setString(2, sign);
            objCons.execute();
            objCon.commit();
        } catch (SQLException e) {
            objCon.rollback();
            throw e;
        } finally {
            objCon.setAutoCommit(true);
        }
    }
    
    public static void updateDateExit(Timestamp date, int code) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(updateDateExit);
            objCons.setTimestamp(1, date);
            objCons.setInt(2, code);
            objCons.execute();
            objCon.commit();
        } catch (SQLException e) {
            objCon.rollback();
            throw e;
        } finally {
            objCon.setAutoCommit(true);
        }
    }
    
    /**
     * Remove Salaried on dataBase
     * @param codigo
     * @throws SQLException 
     */
    public static void deleteSalaried(int codigo) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(deleteSalaried);
        objSQL.setInt(1, codigo);
        objSQL.executeUpdate();
    }
    
    /**
     * Return all registers on dataBase
     * @param code
     * @return
     * @throws SQLException 
     */
    public static ResultSet searchAllSalaried(int code) throws SQLException {
        PreparedStatement objSQL = objCon.prepareStatement(allSalaried);
        objSQL.setInt(1, code);
        return objSQL.executeQuery();
    }

    /**
     * Return register = code
     * @param code
     * @return
     * @throws SQLException 
     */
    public static ResultSet searchSalaried(int code) throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(searchSalaried);
        objSQL.setInt(1, code);
        return objSQL.executeQuery();
    }
    
    public static ResultSet searchSalariedWithName(String name, int code) throws SQLException {
        PreparedStatement objSQL = objCon.prepareStatement(searchSalariedWithName);
        objSQL.setString(1, "%" + name + "%");
        objSQL.setInt(2, code);
        return objSQL.executeQuery();
    }

    /**
     * Verify Salaried with sign informed
     * @param sign
     * @return
     * @throws SQLException 
     */
    public static boolean consultEqualSignSalaried(String sign) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(searchSign);
        objSQL.setString(1, sign);
        ResultSet objResp = objSQL.executeQuery();
        return objResp.next();
    }
    
    /**
     * Return Salaried if have a register with this code
     * @param code
     * @return
     * @throws SQLException 
     */
    public static boolean cosultSalariedCode(int code) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(searchSalaried);
        objSQL.setInt(1, code);
        ResultSet objResp = objSQL.executeQuery();
        return objResp.next();
    }

    /**
     * Return object Salaried when find code
     * @param codigo
     * @return
     * @throws SQLException 
     */
    public static Salaried salariedReturnObject(int codigo) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(searchSalaried);
        objSQL.setInt(1, codigo);
        ResultSet resp = objSQL.executeQuery();

        if (resp.next()) {
            return new Salaried(resp.getInt("CODIGO"), 
                    resp.getInt("COD_ESTACIONAMENTO"), 
                    resp.getString("NOME"), 
                    resp.getString("TELEFONE"),
                    resp.getString("PLACA"), 
                    resp.getTimestamp("DATA_ENTRADA"), 
                    resp.getTimestamp("DATA_SAIDA"));
        }
        return null;
    }
    
    /**
     * Return object Salaried when find sign 
     * @param sign
     * @return
     * @throws SQLException 
     */
    public static Salaried salariedReturnObjectWithSign(String sign) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(searchSignCod);
        objSQL.setString(1, sign);
        ResultSet resp = objSQL.executeQuery();

        if (resp.next()) {
            return new Salaried(resp.getInt("CODIGO"), 
                    resp.getInt("COD_ESTACIONAMENTO"), 
                    resp.getString("NOME"), 
                    resp.getString("TELEFONE"),
                    resp.getString("PLACA"), 
                    resp.getTimestamp("DATA_ENTRADA"), 
                    resp.getTimestamp("DATA_SAIDA"));
        }
        return null;
    }
}
