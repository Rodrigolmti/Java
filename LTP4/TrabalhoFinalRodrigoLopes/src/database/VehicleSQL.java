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
import model.Vehicle;

/**
 *
 * @author rodrigo.martins
 */
public class VehicleSQL {

    private static final Connection objCon = returnObjectSQL();
    private static PreparedStatement objCons;
    private static ResultSet result;

    /* ============== SALARIED VEHICLE ======================= */
    private static final String insertVehicle = "INSERT INTO REG_ES_VEICULO (COD_ESTACIONAMENTO, CODIGO, PLACA, ENTRADA, TARIFA_POR_HORA) VALUES (?,?,?,CURRENT_TIMESTAMP,?)";
    /* ============== VEHICLE SEARCH ========================= */
    private static final String allVehicles = "SELECT *FROM REG_ES_VEICULO";
    /* ============== VEHICLE SEARCH SIGN ===================== */
    private static final String searchVehicleSign = "SELECT *FROM REG_ES_VEICULO WHERE PLACA = ?";
    /* ============== VEHICLE SEARCH SIGN ===================== */
    private static final String searchVehicleExit = "SELECT *FROM REG_ES_VEICULO WHERE PLACA =? AND SAIDA IS NULL";
    /* ============== VEHICLE SEARCH SIGN ===================== */
    private static final String vehicleExit = "SELECT *FROM REG_ES_VEICULO WHERE PLACA =? AND SAIDA IS NOT NULL";
    /* ============== VEHICLE SEARCH SALARIED ================= */
    private static final String searchSignNotSalaried = "SELECT *FROM REG_ES_VEICULO WHERE CODIGO = 0";
    /* ============== VEHICLE SEARCH SALARIED NOT NULL ======== */
    private static final String searchSignSalaried = "SELECT *FROM REG_ES_VEICULO WHERE CODIGO <> 0";
    /* ============== VEHICLE SEARCH ========================= */
    private static final String searchVehicle = "SELECT *FROM REG_ES_VEICULO WHERE NOTICKET = ?";
    /* ============== VEHICLE SEARCH ========================= */
    private static final String searchVehicleCode = "SELECT *FROM REG_ES_VEICULO WHERE COD_ESTACIONAMENTO = ? ORDER BY PLACA";
    /* ============== VEHICLE SUM =========================== */
    private static final String sumValueTotal = "SELECT SUM(VALOR_PAGO) TOT FROM REG_ES_VEICULO WHERE ENTRADA >= ? AND SAIDA <= ?";
    /* ============== VEHICLE SUM =========================== */
    private static final String sumValueTotalNotSalaried = "SELECT SUM(VALOR_PAGO) TOT FROM REG_ES_VEICULO WHERE ENTRADA >= ? AND SAIDA <= ? AND CODIGO = 0";
    /* ============== VEHICLE SUM =========================== */
    private static final String sumValueTotalSalaried = "SELECT SUM(VALOR_PAGO) TOT FROM REG_ES_VEICULO WHERE ENTRADA >= ? AND SAIDA <= ? AND CODIGO <> 0";
    /* ============== VEHICLE EXIT =========================== */
    private static final String updateVihicleExit = "UPDATE REG_ES_VEICULO SET SAIDA = CURRENT_TIMESTAMP, PERMANENCIA_EM_HORAS = (CURRENT_TIMESTAMP - ENTRADA) * 24.0, VALOR_PAGO = (CURRENT_TIMESTAMP - ENTRADA) * 24.0 *  TARIFA_POR_HORA WHERE NOTICKET = ? AND CODIGO = 0";
    /* ============== VEHICLE COUNT ========================== */
    private static final String count = "SELECT *FROM REG_ES_VEICULO";
    /* ============== VEHICLE COUNT ========================== */
    private static final String salariedExit = "UPDATE REG_ES_VEICULO SET SAIDA =?, VALOR_PAGO = ? WHERE NOTICKET =?";
    /* ============== INSERT VEHICLE ======================== */
    /**
     * Insere um veiculo no banco de dados
     *
     * @param obj
     * @throws SQLException
     */
    public static void insertVehicle(Vehicle obj) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(insertVehicle);
            objCons.setInt(1, obj.getCod_estacionamento());
            objCons.setInt(2, obj.getCodigo());
            objCons.setString(3, obj.getPlaca());
            objCons.setDouble(4, obj.getTarifa_por_hora());
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
     * Edita um veiculo no banco de dados
     *
     * @param car
     * @throws SQLException
     */
    public static void updateVehicleExit(Vehicle car) throws SQLException {

        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(updateVihicleExit);
            objCons.setInt(1, car.getNoTicket());
            objCons.execute();
            objCon.commit();
        } catch (SQLException e) {
            objCon.rollback();
            throw e;
        } finally {
            objCon.setAutoCommit(true);
        }
    }
    
    public static void updateSalariedExit(int code, Timestamp date, double price) throws SQLException {

        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(salariedExit);
            objCons.setTimestamp(1, date);
            objCons.setDouble(2, price);
            objCons.setInt(3, code);
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
     * Retorna todos os veiculos cadastrados no banco de dados
     *
     * @return ResultSet result
     * @throws SQLException
     */
    public static ResultSet searchAllVehicles() throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(allVehicles);
        return objSQL.executeQuery();
    }

    /**
     * Retorna o veiculo com o codigo informado
     *
     * @param code
     * @return ResultSet result
     * @throws SQLException
     */
    public static ResultSet searchVehiclesCode(int code) throws SQLException {
        PreparedStatement objSQL = objCon.prepareStatement(searchVehicleCode);
        objSQL.setInt(1, code);
        return objSQL.executeQuery();
    }

    /**
     * Consulta um veiculo com a placa informada
     *
     * @param sign
     * @return boolean
     * @throws SQLException
     */
    public static boolean cosultVehicleSign(String sign) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(searchVehicleExit);
        objSQL.setString(1, sign);
        ResultSet objResp = objSQL.executeQuery();
        return objResp.next();
    }

    /**
     * Consulta um veiculo com a aplca informada
     *
     * @param sign
     * @return boolean
     * @throws SQLException
     */
    public static boolean consultSign(String sign) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(searchVehicleSign);
        objSQL.setString(1, sign);
        ResultSet objResp = objSQL.executeQuery();
        return objResp.next();
    }
    
    /**
     * Verifica se a saida do veiculo esta vazia
     * @param sign
     * @return ResultSet result
     * @throws SQLException 
     */
    public static boolean vehicleExit(String sign) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(vehicleExit);
        objSQL.setString(1, sign);
        ResultSet objResp = objSQL.executeQuery();
        return objResp.next();
    }

    /**
     * Conta quantos veiculos tem no banco
     *
     * @return int count
     * @throws SQLException
     */
    public static int countVehicle() throws SQLException {
        int countRegister = 0;

        PreparedStatement objSQL = objCon.prepareStatement(count);
        ResultSet resp = objSQL.executeQuery();
        while (resp.next()) {
            countRegister++;
        }

        return countRegister;
    }

    /**
     * Conta quantos veiculos que não são mensalistas
     *
     * @return int count
     * @throws SQLException
     */
    public static int countVehicleIsNotSalaried() throws SQLException {
        int countRegister = 0;

        PreparedStatement objSQL = objCon.prepareStatement(searchSignNotSalaried);
        ResultSet resp = objSQL.executeQuery();
        while (resp.next()) {
            countRegister++;
        }

        return countRegister;
    }

    /**
     * Conta quantos veiculos são mensalistas
     *
     * @return int count
     * @throws SQLException
     */
    public static int countVehicleIsSalaried() throws SQLException {
        int countRegister = 0;

        PreparedStatement objSQL = objCon.prepareStatement(searchSignSalaried);
        ResultSet resp = objSQL.executeQuery();

        while (resp.next()) {
            countRegister++;
        }

        return countRegister;
    }

    /**
     * Faz a soma dos valores pagos e retorna o valor total
     *
     * @param one
     * @param two
     * @return float sumValue
     * @throws SQLException
     */
    public static Float sum(Timestamp one, Timestamp two) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(sumValueTotal);
        objSQL.setTimestamp(1, one);
        objSQL.setTimestamp(2, two);
        ResultSet resp = objSQL.executeQuery();

        resp.next();
        float sumValue = (float) resp.getDouble("TOT");

        return sumValue;
    }

    /**
     * Faz a soma dos valores pagos por mensalista e retorna o total
     *
     * @param one
     * @param two
     * @return float sumValue
     * @throws SQLException
     */
    public static Float sumSalaried(Timestamp one, Timestamp two) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(sumValueTotalSalaried);
        objSQL.setTimestamp(1, one);
        objSQL.setTimestamp(2, two);
        ResultSet resp = objSQL.executeQuery();

        resp.next();
        float sumValue = (float) resp.getDouble("TOT");

        return sumValue;
    }

    /**
     * Faz a soma dos valores pagos por horistas e retorna o total
     *
     * @param one
     * @param two
     * @return float sumValue
     * @throws SQLException
     */
    public static Float sumNotSalaried(Timestamp one, Timestamp two) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(sumValueTotalNotSalaried);
        objSQL.setTimestamp(1, one);
        objSQL.setTimestamp(2, two);
        ResultSet resp = objSQL.executeQuery();

        resp.next();
        float sumValue = (float) resp.getDouble("TOT");

        return sumValue;
    }

    /**
     * Retorna um objeto veiculo com o codigo informado
     *
     * @param code
     * @return Vehicle obj
     * @throws SQLException
     */
    public static Vehicle vehicleReturnObject(int code) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(searchVehicle);
        objSQL.setInt(1, code);
        ResultSet resp = objSQL.executeQuery();

        if (resp.next()) {
            return new Vehicle(resp.getInt("NOTICKET"),
                    resp.getInt("COD_ESTACIONAMENTO"),
                    resp.getInt("CODIGO"),
                    resp.getString("PLACA"),
                    resp.getTimestamp("ENTRADA"),
                    resp.getTimestamp("SAIDA"),
                    resp.getFloat("PERMANENCIA_EM_HORAS"),
                    resp.getFloat("TARIFA_POR_HORA"),
                    resp.getFloat("VALOR_PAGO"));
        }
        return null;
    }
}
