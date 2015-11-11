package database;

import static database.ConnectionFactory.returnObjectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Parking;

public class ParkingSQL {

    private static final Connection objCon = returnObjectSQL();
    private static PreparedStatement objCons;
    private static ResultSet result;

    /* ============== PARK INSERT ======================== */
    private static final String insert = "INSERT INTO CAD_ESTACIONAMENTO (NOME, CNPJ, ENDERECO, CIDADE, UF, NUM_VAGAS, TARIFA_POR_HORA, "
            + "TARIFA_POR_MES, DATA_REGISTRO)  VALUES  (?,?,?,?,?,?,?,?,?)";
    /* ============== PARK SEARCH ======================== */
    private static final String search = "SELECT *FROM CAD_ESTACIONAMENTO WHERE COD_ESTACIONAMENTO = ?";
    /* ============== PARK SEARCH ======================== */
    private static final String allParkings = "SELECT *FROM CAD_ESTACIONAMENTO";
    /* ============== PARK CONSULT ======================== */
    private static final String consultCnpj = "SELECT * FROM CAD_ESTACIONAMENTO WHERE CNPJ= ?";
    /* ============== PARK EDIT ======================== */
    private static final String editPark = "UPDATE CAD_ESTACIONAMENTO SET NOME = ?, CNPJ = ?, ENDERECO = ?, CIDADE = ?, UF = ?, NUM_VAGAS = ?, TARIFA_POR_HORA = ?, TARIFA_POR_MES = ? WHERE COD_ESTACIONAMENTO = ?";
    /* ============== PARK DELETE ======================== */
    private static final String deletePark = "DELETE FROM CAD_ESTACIONAMENTO WHERE COD_ESTACIONAMENTO = ?";

    /**
     * Insere um novo estacionamento no banco
     * @param objPark
     * @throws SQLException 
     */
    public static void insertPark(Parking objPark) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(insert);
            objCons.setString(1, objPark.getNome());
            objCons.setString(2, objPark.getCnpj());
            objCons.setString(3, objPark.getEndereco());
            objCons.setString(4, objPark.getCidade());
            objCons.setString(5, objPark.getUf());
            objCons.setInt(6, objPark.getNum_vagas());
            objCons.setDouble(7, objPark.getTarifa_por_hora());
            objCons.setDouble(8, objPark.getTarifa_por_mes());
            objCons.setDate(9, objPark.getData_registro());
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
     * Edita um estacionamento no banco
     * @param objPark
     * @throws SQLException 
     */
    public static void updatePark(Parking objPark) throws SQLException {
        objCon.setAutoCommit(false);
        try {
            objCons = objCon.prepareStatement(editPark);
            objCons.setString(1, objPark.getNome());
            objCons.setString(2, objPark.getCnpj());
            objCons.setString(3, objPark.getEndereco());
            objCons.setString(4, objPark.getCidade());
            objCons.setString(5, objPark.getUf());
            objCons.setInt(6, objPark.getNum_vagas());
            objCons.setDouble(7, objPark.getTarifa_por_hora());
            objCons.setDouble(8, objPark.getTarifa_por_mes());
            objCons.setInt(9, objPark.getCod());
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
     * Remove um estacionamento do banco
     * @param codigo
     * @throws SQLException 
     */
    public static void deletePark(int codigo) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(deletePark);
        objSQL.setInt(1, codigo);
        objSQL.executeUpdate();
    }

    /**
     * Pesquisa um estacionamento no banco com o condigo informado
     * @param code
     * @return ResultSet result
     * @throws SQLException 
     */
    public static ResultSet searchWithCodePark(int code) throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(search);
        objSQL.setInt(1, code);
        return objSQL.executeQuery();
    }

    /**
     * Consulta no banco de dados um estacionamento com o cnpj informado
     * @param cnpj
     * @return ResultSet result
     * @throws SQLException 
     */
    public static boolean searchWithCnpjPark(String cnpj) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(consultCnpj);
        objSQL.setString(1, cnpj);
        ResultSet objResp = objSQL.executeQuery();
        return objResp.next();
    }

    /**
     * Pesquisa todos os estacionamentos no banco de dados
     * @return ResultSet result
     * @throws SQLException 
     */
    public static ResultSet returnAllParkings() throws SQLException {
        PreparedStatement objSQL
                = objCon.prepareStatement(allParkings);
        return objSQL.executeQuery();
    }
    
    /**
     * Retorna um objeto de estacionamento com o codigo informado
     * @param codigo
     * @return Parking obj
     * @throws SQLException 
     */
    public static Parking parkReturnWithCodeObject(int codigo) throws SQLException {

        PreparedStatement objSQL = objCon.prepareStatement(search);
        objSQL.setInt(1, codigo);
        ResultSet resp = objSQL.executeQuery();

        if (resp.next()) {
            return new Parking(resp.getInt("COD_ESTACIONAMENTO"), 
                    resp.getString("NOME"), 
                    resp.getString("CNPJ"),
                    resp.getString("ENDERECO"), 
                    resp.getString("CIDADE"), 
                    resp.getString("UF"), 
                    resp.getInt("NUM_VAGAS"), 
                    resp.getFloat("TARIFA_POR_HORA"),
                    resp.getFloat("TARIFA_POR_MES"), 
                    resp.getDate("DATA_REGISTRO"));
        }
        return null;
    }
}
