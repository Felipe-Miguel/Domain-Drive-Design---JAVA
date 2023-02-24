package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.fiap.to.EntregaEnderecoTO;


public class EntregaEnderecoDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public EntregaEnderecoDAO(Connection con) {
		setCon(con);
	}

	public void cadastrar(EntregaEnderecoTO entregaEndereco) {
		con = Conexao.abrirConexao();
		String sql = "insert into t_din_entrega_endereco(id_entrega_endereco,id_entrega,id_endereco,nm_responsavel,nr_tel_responsavel,tp_endereco) values (sq_din_entrega_endereco.nextval,sq_din_entrega.currval,sq_din_endereco.currval,?,?,?) ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, entregaEndereco.getNmResponsavel());
			ps.setLong(2, entregaEndereco.getnrTelefoneResponsavel());
			ps.setString(3, entregaEndereco.getTpEndereco());
			if (ps.executeUpdate() > 0) {
				System.out.println("Inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void alterar(EntregaEnderecoTO eto) {
		con = Conexao.abrirConexao();
		String sql = "update t_din_entrega_endereco set nm_responsavel=?, nr_tel_responsavel=?, tp_endereco=?";
		sql += "where id_entrega_endereco=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, eto.getNmResponsavel());
			ps.setLong(2, eto.getnrTelefoneResponsavel());
			ps.setString(3, eto.getTpEndereco());
			ps.setInt(4, eto.getIdEntregaEnd());
			if (ps.executeUpdate() > 0) {
				System.out.println("Alterado com sucesso");
			} else {
				System.out.println("Erro ao alterar");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletar(EntregaEnderecoTO eto) {
		con = Conexao.abrirConexao();
		String sql = "delete from t_din_entrega_endereco where id_entrega_endereco=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, eto.getIdEntregaEnd());
			if (ps.executeUpdate() > 0) {
				System.out.println("Excluido com sucesso");
			} else {
				System.out.println("Erro ao excluir");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<EntregaEnderecoTO> listar() {
		con = Conexao.abrirConexao();
		String sql = "select * from t_din_entrega_endereco ";
		ArrayList<EntregaEnderecoTO> listaTodos = new ArrayList<EntregaEnderecoTO>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EntregaEnderecoTO eto = new EntregaEnderecoTO();
					eto.setIdEntregaEnd(rs.getInt(1));
					eto.setIdEntrega(rs.getInt(2));
					eto.setIdEndereco(rs.getInt(3));
					eto.setNmResponsavel(rs.getString(4));
					eto.setnrTelefoneResponsavel(rs.getLong(5));
					eto.setTpEndereco(rs.getString(6));
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

	public EntregaEnderecoDAO() {
	}

	// GET-ALL(SELECT ALL)
	public ArrayList<EntregaEnderecoTO> select() {
		ArrayList<EntregaEnderecoTO> lista = listar();
		Conexao.fecharConexao(con);
		return lista;

	}

	// GET-BY-ID
	public EntregaEnderecoTO select(int id) {
		ArrayList<EntregaEnderecoTO> listaEntENd = listar();
		for (int i = 0; i < listaEntENd.size(); i++) {
			if (listaEntENd.get(i).getIdEntregaEnd() == id) {
				Conexao.fecharConexao(con);
				return listaEntENd.get(i);
			}
		}
		return null;
	}

	// POST (INSERT)
	public void insert(EntregaEnderecoTO eto) {
		ArrayList<EntregaEnderecoTO> lista = select();
		eto.setIdEntregaEnd(lista.size() + 1);
		cadastrar(eto);
		Conexao.fecharConexao(con);
	}

	public void update(EntregaEnderecoTO eto) {
		EntregaEnderecoTO e = select(eto.getIdEntregaEnd());
		e.setNmResponsavel(eto.getNmResponsavel());
		e.setnrTelefoneResponsavel(eto.getnrTelefoneResponsavel());
		e.setTpEndereco(eto.getTpEndereco());
		alterar(e);
		Conexao.fecharConexao(con);
	}

	// DELETE
	public void delete(int id) {
		deletar(select(id));
		Conexao.fecharConexao(con);
	}
}
