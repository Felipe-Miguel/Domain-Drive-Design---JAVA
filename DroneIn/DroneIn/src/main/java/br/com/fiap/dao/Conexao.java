package br.com.fiap.dao;

import java.sql.*;

public class Conexao {
	/**
	 * @return retorna um objeto conexão ou uma String dizendo se o método deu certo
	 * @throws caso de algum erro para achar a Classe, erro SQL ou algum erro a
	 *              parte
	 **/
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "RM93642";
			final String PASS = "180904";
			con = DriverManager.getConnection(url, USER, PASS);
			System.out.println("ConexÃ£o aberta.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	/**
	 * @param passa um objeto conexão como parâmetro
	 * @return retorna um objeto String dizendo se a conexão foi fechada
	 * @throws caso de algum erro para achar a Classe, erro SQL ou algum erro a
	 *              parte
	 **/
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexão fechada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}