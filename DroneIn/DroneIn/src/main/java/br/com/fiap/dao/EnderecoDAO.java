package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.EnderecoTO;

public class EnderecoDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public EnderecoDAO(Connection con) {
		setCon(con);
	}

	public void cadastrar(EnderecoTO eto) {
		con = Conexao.abrirConexao();
		String sql = "insert all into t_din_cidade(id_cidade,id_estado, nm_cidade) values (sq_din_cidade.nextval,?,?) "
				+ " into t_din_endereco(id_endereco, id_cidade, nr_cep, nm_logradouro, nr_logradouro, ds_complemento, ds_referencia) "
				+ " values (sq_din_endereco.nextval,sq_din_cidade.currval,?,?,?,?,?) "
				+ " select * from dual";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, eto.getIdEstado());
			ps.setString(2, eto.getCidade());
			ps.setInt(3, eto.getCep());
			ps.setString(4, eto.getLogradouro());
			ps.setInt(5, eto.getNumero());
			ps.setString(6, eto.getComplemento());
			ps.setString(7, eto.getReferencia());
			if (ps.executeUpdate() > 0) {
				System.out.println("Inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void alterar(EnderecoTO eto) {
		con = Conexao.abrirConexao();
		String sql = "update t_din_endereco set id_cidade=?, nr_cep=?, nm_logradouro=?, nr_logradouro=?, ds_complemento=?, ds_referencia=?";
		sql += "where id_endereco=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, eto.getIdCidade());
			ps.setInt(2, eto.getCep());
			ps.setString(3, eto.getLogradouro());
			ps.setInt(4, eto.getNumero());
			ps.setString(5, eto.getComplemento());
			ps.setString(6, eto.getReferencia());
			ps.setInt(7, eto.getIdEndereco());
			if (ps.executeUpdate() > 0) {
				System.out.println("Alterado com sucesso");
			} else {
				System.out.println("Erro ao alterar");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletar(EnderecoTO eto) {
		con = Conexao.abrirConexao();
		String sql = "delete from t_din_endereco where id_endereco=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, eto.getIdEndereco());
			if (ps.executeUpdate() > 0) {
				System.out.println("Excluido com sucesso");
			} else {
				System.out.println("Erro ao excluir");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<EnderecoTO> listar() {
		con = Conexao.abrirConexao();
		String sql = "SELECT en.id_endereco,en.id_cidade, en.nr_cep,en.nm_logradouro,en.nr_logradouro,en.ds_complemento,en.ds_referencia,c.nm_cidade, e.sg_estado from t_din_endereco en inner join t_din_cidade c on(c.id_cidade=en.id_cidade) inner join t_din_estado e on(e.id_estado=c.id_estado) order by id_endereco";
		ArrayList<EnderecoTO> listaTodos = new ArrayList<EnderecoTO>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EnderecoTO eto = new EnderecoTO();
					eto.setIdEndereco(rs.getInt(1));
					eto.setIdCidade(rs.getInt(2));
					eto.setCep(rs.getInt(3));
					eto.setLogradouro(rs.getString(4));
					eto.setNumero(rs.getInt(5));
					eto.setComplemento(rs.getString(6));
					eto.setReferencia(rs.getString(7));
					eto.setCidade(rs.getString(8));
					eto.setEstado(rs.getString(9));
					listaTodos.add(eto);

				}
				return listaTodos;

			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public EnderecoDAO() {
	}

//GET-ALL(SELECT ALL)
	public ArrayList<EnderecoTO> select() {
		ArrayList<EnderecoTO> lista = listar();
		Conexao.fecharConexao(con);
		return lista;

	}

	// GET-BY-ID
	public EnderecoTO select(int id) {
		ArrayList<EnderecoTO> listaEndereco = listar();
		for (int i = 0; i < listaEndereco.size(); i++) {
			if (listaEndereco.get(i).getIdEndereco() == id) {
				Conexao.fecharConexao(con);
				return listaEndereco.get(i);
			}
		}
		return null;
	}

	// POST (INSERT)
	public void insert(EnderecoTO eto) {
		cadastrar(eto);
		Conexao.fecharConexao(con);
	}

	// UPDATE
	public void update(EnderecoTO eto) {
		EnderecoTO e = select(eto.getIdEndereco());
		e.setCep(eto.getCep());
		e.setLogradouro(eto.getLogradouro());
		e.setNumero(eto.getNumero());
		e.setComplemento(eto.getComplemento());
		e.setReferencia(eto.getReferencia());
		alterar(e);
		Conexao.fecharConexao(con);
	}

	// DELETE
	public void delete(int id) {
		deletar(select(id));
		Conexao.fecharConexao(con);
	}
}
