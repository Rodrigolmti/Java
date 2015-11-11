/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.firebirdsql.jdbc.FBDriver;

/**
 *
 * @author rodrigo.martins
 */
public class ConnectionFactory {

    private static Connection objCon;
    /**
     * Abrir conexão com o banco de dados
     * @throws SQLException
     */
    public static void createConnection() throws SQLException {
        DriverManager.registerDriver(new FBDriver());

//        objCon = DriverManager.getConnection(
//                "jdbc:firebirdsql:server1b/3050:D:/PROGRAM FILES/FIREBIRD/LTP4/BDESTACIONAMENTO.GDB",
//                "SYSDBA", "masterkey");

        objCon = DriverManager.getConnection(
                "jdbc:firebirdsql:localhost/3050:D:/BDESTACIONAMENTO.GDB",
                "SYSDBA", "masterkey");
        
//        objCon = DriverManager.getConnection(
//                "jdbc:firebirdsql:localhost/3050:E:/BDESTACIONAMENTO.GDB",
//                "SYSDBA", "masterkey");
        
    }

    /**
     * Fecha conexão com o banco de dados
     * @throws SQLException
     */
    public static void closeConecction() throws SQLException {
        objCon.close();
    }

    /**
     * Retorna o objeto Connection para as outras classes que necessitam do mesmo
     * @return Connection objCon
     */
    public static Connection returnObjectSQL() {
        return objCon;
    }
}
