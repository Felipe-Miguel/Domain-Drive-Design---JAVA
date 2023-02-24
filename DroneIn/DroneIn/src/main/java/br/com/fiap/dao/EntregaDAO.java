package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.EntregaTO;

public class EntregaDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public EntregaDAO(Connection con) {
		setCon(con);
	}

	/**
	 * @param Recebe um objeto Entrega, Usuario e Pacote Método que registra uma
	 *               entrega
	 * @return retorna uma String informando se o registro deu certo ou não
	 *         * @throws caso de algum erro SQL
	 **/
	public void cadastrar(EntregaTO entrega) {
		con = Conexao.abrirConexao();

		String sql = "insert into t_din_entrega(id_entrega, id_usuario, id_pacote, dt_pedido,dt_conclusao,vl_preco,vl_distancia,st_entrega) values (sq_din_entrega.nextval,sq_din_usuario.currval,sq_din_pacote.currval,?,?,?,?,?)";
	
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setDate(1, entrega.getDtPedido());
			ps.setDate(2, entrega.getDtConclusao());
			ps.setFloat(3, entrega.getVlPreco());
			ps.setFloat(4, entrega.getVlDistancia());
			ps.setString(5, entrega.getDsConfirmacao());
			if (ps.executeUpdate() > 0) {
				System.out.println("Inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param Recebe um objeto Entrega Método que executa um update na coluna
	 *               st_entrega na tabela de entrega, método feito para
	 *               confirmar a aetorizacao de entrega
	 * @return retorna uma String informando se o update deu certo ou não * @throws
	 *         caso de algum erro SQL
	 **/
	public void confirmarEntrega(EntregaTO entrega) {
		con = Conexao.abrirConexao();
		String sql = "update t_din_entrega set st_entrega = ? where id_entrega=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, entrega.getDsConfirmacao());
			ps.setInt(2,entrega.getIdEntrega());
			if (ps.executeUpdate() > 0) {
				System.out.println("Alterado com sucesso");
			} else {
				System.out.println("Erro ao alterar");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletar(EntregaTO eto) {
		con = Conexao.abrirConexao();
		String sql = "delete from t_din_entrega where id_entrega=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, eto.getIdEntrega());
			if (ps.executeUpdate() > 0) {
				System.out.println("Excluido com sucesso");
			} else {
				System.out.println("Erro ao excluir");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<EntregaTO> listar() {
		con = Conexao.abrirConexao();
		String sql = "SELECT * from t_din_entrega";
		ArrayList<EntregaTO> listaTodos = new ArrayList<EntregaTO>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EntregaTO eto = new EntregaTO();
					eto.setIdEntrega(rs.getInt(1));
					eto.setIdUsuario(rs.getInt(2));
					eto.setIdPacote(rs.getInt(3));
					eto.setDtPedido(rs.getDate(4));
					eto.setDtConclusao(rs.getDate(5));
					eto.setVlPreco(rs.getFloat(6));
					eto.setVlDistancia(rs.getFloat(7));
					eto.setDsConfirmacao(rs.getString(8));
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

	public EntregaDAO() {
	}

	// GET-ALL(SELECT ALL)
	public ArrayList<EntregaTO> select() {
		ArrayList<EntregaTO> lista = listar();
		Conexao.fecharConexao(con);
		return lista;

	}

	// GET-BY-ID
	public EntregaTO select(int id) {
		ArrayList<EntregaTO> listaEntrega = listar();
		for (int i = 0; i < listaEntrega.size(); i++) {
			if (listaEntrega.get(i).getIdEntrega() == id) {
				Conexao.fecharConexao(con);
				return listaEntrega.get(i);
			}
		}
		return null;
	}

	// POST (INSERT)
	public void insert(EntregaTO eto) {
		ArrayList<EntregaTO> lista = select();
		eto.setIdEntrega(lista.size() + 1);
		cadastrar(eto);
		Conexao.fecharConexao(con);
	}

	// UPDATE
	public void update(EntregaTO eto) {
		EntregaTO e = select(eto.getIdEntrega());
		e.setDsConfirmacao(eto.getDsConfirmacao());
		confirmarEntrega(e);
		Conexao.fecharConexao(con);
	}

	// DELETE
	public void delete(int id) {
		deletar(select(id));
		Conexao.fecharConexao(con);
	}
}
