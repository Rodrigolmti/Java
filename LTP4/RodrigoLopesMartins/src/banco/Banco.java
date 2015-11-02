package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.firebirdsql.jdbc.FBDriver;

import dados.Pessoa;
import erro.PessoaException;

public class Banco {
	
	public static Connection objConexao;

	public static void abrirConexao() throws SQLException{
		DriverManager.registerDriver(new FBDriver());
		objConexao = DriverManager.getConnection(
				"jdbc:firebirdsql:server1b/3050:D:/PROGRAM FILES/FIREBIRD/LTP4/BDPESSOAS.GDB",
				"SYSDBA", "masterkey");
	}
	
	public static void fecharConexao() throws SQLException{
		objConexao.close();
	}
	
	/*
	 * 
	 * METODOS PARA FAZER A BUSCA E RETORNAR SE EXISTE OU N�O USUARIO CADASTRADO PARA O CODIGO INFORMADO
	 * 
	 */
	
	//Metodo de busca que retorna de existe ou nao a pessoa cadastrada
	public static void consultaPessoaCodigo(int codPessoa) throws SQLException,PessoaException{
		
		PreparedStatement objSQL = objConexao.prepareStatement(
				"SELECT * FROM AGENDA WHERE CODIGO= ?");
		objSQL.setInt(1, codPessoa);
		ResultSet objResp = objSQL.executeQuery();
		if (!objResp.next()){
			throw new PessoaException("N�o Existe pessoa para o C�digo." );
		}
	}
	
	//Metodo de busca que retorna de existe ou nao a pessoa cadastrada
		public static void consultaPessoaNome(String nome) throws SQLException,PessoaException{
			
			PreparedStatement objSQL = objConexao.prepareStatement(
					"SELECT * FROM AGENDA WHERE NOME= ?");
			objSQL.setString(1, nome);
			ResultSet objResp = objSQL.executeQuery();
			if (objResp.next()){
				throw new PessoaException("Ja existe uma pessoa cadastrada com este nome!." );
			}
		}

	/*
	* 
	* METODOS PARA FAZER A BUSCA E RETORNAR O OBJETO COM AS INFORMA��ES ENCONTRADAS 
	* 
	*/	
		
		
	//Metodo que busca por codigo e retorna o objeto pessoa
	public static Pessoa buscarPessoaCodigo(int codigo) throws SQLException, PessoaException {
		
		PreparedStatement objSQL = objConexao.prepareStatement("SELECT * FROM AGENDA WHERE CODIGO = ?");
		objSQL.setInt(1, codigo);
		ResultSet resp = objSQL.executeQuery();
		
		if(resp.next()) {
			return new Pessoa(resp.getInt("CODIGO"), resp.getString("NOME"), resp.getString("TELEFONE"), 
					resp.getDate("NASCIMENTO"), resp.getString("EMAIL"));
		} else throw new PessoaException("\nN�o foi possivel encontrar uma pessoa com este codigo!");
	}
	
	//Metodo que busca pessoa por nome
	public static ArrayList<Pessoa> buscarPessoaNome(String nome) throws SQLException, PessoaException {
		
                ArrayList<Pessoa> listaPessoas = new ArrayList<>();
		PreparedStatement objSQL = objConexao.prepareStatement("SELECT * FROM AGENDA WHERE NOME LIKE ?");
		objSQL.setString(1, "%" + nome + "%");
		ResultSet resp = objSQL.executeQuery();
		
		while(resp.next()) {
			listaPessoas.add(new Pessoa(resp.getInt("CODIGO"), resp.getString("NOME"), resp.getString("TELEFONE"), 
					resp.getDate("NASCIMENTO"), resp.getString("EMAIL")));
		} 
		
		if(listaPessoas.isEmpty()) {
			throw new PessoaException("N�o foi encontrada nenhuma pessoa com o codigo informado");
		} else return listaPessoas;
	}
	
	//Metodo que busca pessoa pelo mes de nascimento
	//Terminar
	public static ArrayList<Pessoa> buscarPessoaMes(int mes) throws SQLException, PessoaException {
		
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
                
		PreparedStatement objSQL = objConexao.prepareStatement("SELECT * FROM AGENDA WHERE EXTRACT(MONTH FROM NASCIMENTO) = ? Order By NOME");
		objSQL.setInt(1, mes);
		ResultSet resp = objSQL.executeQuery();
		
		while(resp.next()) {
			listaPessoas.add(new Pessoa(resp.getInt("CODIGO"), resp.getString("NOME"), resp.getString("TELEFONE"), 
					resp.getDate("NASCIMENTO"), resp.getString("EMAIL")));
		} 
		
		if(listaPessoas.isEmpty()) {
			throw new PessoaException("N�o foi encontrada nenhuma pessoa com o mes informado");
		} else return listaPessoas;
	}
	
	/*
	 * 
	 * METODOS PARA INCLUS�O, EXCLUS�O E ALTERA��O DE PESSOAS NO BANCO
	 * 
	 */
	
	//Metodo para incluir pessoa no banco
	public static void incluirPessoa(Pessoa objPessoa) throws SQLException {

        try {
    		objConexao.setAutoCommit(false); // Controlar Transa��o pelo Aplicativo
            // Venda
            String atualizaSQL ="Insert INTO AGENDA (NOME, TELEFONE, NASCIMENTO, EMAIL) VALUES (? ,?, ?, ?)" ;
            PreparedStatement objSqlUpdate = objConexao.prepareStatement(atualizaSQL);
            objSqlUpdate.setString(1,objPessoa.getNome());
            objSqlUpdate.setString(2,objPessoa.getTelefone());
            objSqlUpdate.setDate(3,objPessoa.getNascimento());
            objSqlUpdate.setString(4,objPessoa.getEmail());
            objSqlUpdate.executeUpdate();
           
            objConexao.commit(); // Concluir Transa��o

        } catch (SQLException objSQLException) {
        	objConexao.rollback(); // Desfaz Transa��o
            throw objSQLException;
        } finally {
        	objConexao.setAutoCommit(true); // Habilitar controle automatico de Transa��o pelo SGDB
        }
		
	}
	
	//Metodo para alterar pessoa do banco
	public static void alterarPessoa(Pessoa objPessoa) throws SQLException {
	
            PreparedStatement objSQL = objConexao.prepareStatement(
		"UPDATE AGENDA SET NOME = ?, TELEFONE = ?, NASCIMENTO = ?, EMAIL = ? WHERE CODIGO = ?");
            objSQL.setString(1,objPessoa.getNome());
            objSQL.setString(2,objPessoa.getTelefone());
            objSQL.setDate(3,objPessoa.getNascimento());
            objSQL.setString(4,objPessoa.getEmail());
            objSQL.setInt(5, objPessoa.getCodigo());
            
            objSQL.executeUpdate();
	}
	
	//Metodo para excluir pessoa do banco
	public static void excluirPessoa(int codigo) throws SQLException {
		
		PreparedStatement objSQL = objConexao.prepareStatement("DELETE FROM AGENDA WHERE CODIGO =?");
		objSQL.setInt(1, codigo);
		objSQL.executeUpdate();
	}
}