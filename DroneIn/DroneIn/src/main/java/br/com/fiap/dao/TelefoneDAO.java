package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.TelefoneTO;


public class TelefoneDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public TelefoneDAO(Connection con) {
		setCon(con);
	}

	public void cadastrar(TelefoneTO tto) {
		con = Conexao.abrirConexao();
		String sql = "insert into t_din_telefone(id_usuario,id_telefone,nr_ddd,nr_telefone) values (sq_din_usuario.currval,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, tto.getIdUsuario());
			ps.setInt(2, tto.getIdTelefone());
			ps.setInt(3, tto.getNrDDD());
			ps.setInt(4, tto.getNrTelefone());
			if (ps.executeUpdate() > 0) {
				System.out.println("Inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void deletar(TelefoneTO telefone) {
		con = Conexao.abrirConexao();
		String sql = "delete from t_din_telefone where id_telefone=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdTelefone());
			if (ps.executeUpdate() > 0) {
				System.out.println("Excluido com sucesso");
			} else {
				System.out.println("Erro ao excluir");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<TelefoneTO> listar() {
		con = Conexao.abrirConexao();
		String sql = "select * from t_din_telefone ";
		ArrayList<TelefoneTO> listaTodos = new ArrayList<TelefoneTO>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					TelefoneTO tto = new TelefoneTO();
					tto.setIdUsuario(rs.getInt(1));
					tto.setIdTelefone(rs.getInt(2));
					tto.setNrDDD(rs.getInt(3));
					tto.setNrTelefone(rs.getInt(4));
					listaTodos.add(tto);

				}
				return listaTodos;

			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public TelefoneDAO() {
	}

//GET-ALL(SELECT ALL)
	public ArrayList<TelefoneTO> select() {
		ArrayList<TelefoneTO> lista = listar();
		Conexao.fecharConexao(con);
		return lista;

	}

	// GET-BY-ID
	public TelefoneTO select(int id) {
		ArrayList<TelefoneTO> listaTelefone = listar();
		for (int i = 0; i < listaTelefone.size(); i++) {
			if (listaTelefone.get(i).getIdTelefone() == id) {
				Conexao.fecharConexao(con);
				return listaTelefone.get(i);
			}
		}
		return null;
	}

	// POST (INSERT)
	public void insert(TelefoneTO tto) {
		ArrayList<TelefoneTO> lista = select();
		tto.setIdTelefone(lista.size() + 1);
		cadastrar(tto);
		Conexao.fecharConexao(con);
	}

	// DELETE
	public void delete(int id) {
		deletar(select(id));
		Conexao.fecharConexao(con);
	}
}
