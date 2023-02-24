package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.fiap.to.PacoteTO;

public class PacoteDAO {

	private Connection con;

	public PacoteDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public void cadastrar(PacoteTO pto) {
		con = Conexao.abrirConexao();
		String sql = "insert into t_din_pacote(id_pacote, vl_peso, vl_altura, vl_largura, vl_comprimento, ds_conteudo, tp_conteudo)"
				+ " values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, pto.getIdPacote());
			ps.setFloat(2, pto.getVlPesoPacote());
			ps.setFloat(3, pto.getVlAltura());
			ps.setFloat(4, pto.getVlLargura());
			ps.setFloat(5, pto.getVlComprimento());
			ps.setString(6, pto.getDsConteudo());
			ps.setString(7, pto.getTpConteudo());
			if (ps.executeUpdate() > 0) {
				System.out.println("Inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void alterar(PacoteTO pto) {
		con = Conexao.abrirConexao();
		String sql = "update t_din_pacote set vl_peso=?, vl_altura=?, vl_largura=?, vl_comprimento=?, ds_conteudo=?, tp_conteudo=?";
		sql += "where id_pacote=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setFloat(1, pto.getVlPesoPacote());
			ps.setFloat(2, pto.getVlAltura());
			ps.setFloat(3, pto.getVlLargura());
			ps.setFloat(4, pto.getVlComprimento());
			ps.setString(5, pto.getDsConteudo());
			ps.setString(6, pto.getTpConteudo());
			ps.setInt(7, pto.getIdPacote());
			if (ps.executeUpdate() > 0) {
				System.out.println("Alterado com sucesso");
			} else {
				System.out.println("Erro ao alterar");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletar(PacoteTO pto) {
		con = Conexao.abrirConexao();
		String sql = "delete from t_din_pacote where id_pacote=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, pto.getIdPacote());
			if (ps.executeUpdate() > 0) {
				System.out.println("Excluido com sucesso");
			} else {
				System.out.println("Erro ao excluir");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<PacoteTO> listar() {
		con = Conexao.abrirConexao();
		String sql = "select * from t_din_pacote ";
		ArrayList<PacoteTO> listaTodos = new ArrayList<PacoteTO>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					PacoteTO pto = new PacoteTO();
					pto.setIdPacote(rs.getInt(1));
					pto.setVlPesoPacote(rs.getFloat(2));
					pto.setVlAltura(rs.getFloat(3));
					pto.setVlLargura(rs.getFloat(4));
					pto.setVlComprimento(rs.getFloat(5));
					pto.setDsConteudo(rs.getString(6));
					pto.setTpConteudo(rs.getString(7));
					listaTodos.add(pto);

				}
				return listaTodos;

			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public PacoteDAO() {
	}

	// GET-ALL(SELECT ALL)
	public ArrayList<PacoteTO> select() {
		ArrayList<PacoteTO> lista = listar();
		Conexao.fecharConexao(con);
		return lista;

	}

	// GET-BY-ID
	public PacoteTO select(int id) {
		ArrayList<PacoteTO> listaPacote = listar();
		for (int i = 0; i < listaPacote.size(); i++) {
			if (listaPacote.get(i).getIdPacote() == id) {
				Conexao.fecharConexao(con);
				return listaPacote.get(i);
			}
		}
		return null;
	}

	// POST (INSERT)
	public void insert(PacoteTO pto) {
		ArrayList<PacoteTO> lista = select();
		pto.setIdPacote(lista.size() + 1);
		cadastrar(pto);
		Conexao.fecharConexao(con);
	}

	// UPDATE
	public void update(PacoteTO pto) {
		PacoteTO p = select(pto.getIdPacote());
		p.setVlPesoPacote(pto.getVlPesoPacote());
		p.setVlAltura(pto.getVlAltura());
		p.setVlLargura(pto.getVlLargura());
		p.setVlComprimento(pto.getVlComprimento());
		p.setDsConteudo(pto.getDsConteudo());
		p.setTpConteudo(pto.getTpConteudo());
		alterar(p);
		Conexao.fecharConexao(con);
	}

	// DELETE
	public void delete(int id) {
		deletar(select(id));
		Conexao.fecharConexao(con);
	}
}