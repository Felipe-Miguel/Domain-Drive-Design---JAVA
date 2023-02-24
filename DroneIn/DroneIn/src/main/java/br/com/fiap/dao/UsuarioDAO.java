package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.to.UsuarioTO;


public class UsuarioDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public UsuarioDAO(Connection con) {
		setCon(con);
	}

	public void cadastrar(UsuarioTO uto) {
		con = Conexao.abrirConexao();
		String sql = "insert all into t_din_usuario(id_usuario, nr_cpf,ds_email,ds_senha,nm_usuario, dt_nascimento) values (sq_din_usuario.nextval,?,?,?,?,?) "
				+ " into t_din_telefone (id_usuario,id_telefone,nr_ddd,nr_telefone) values (sq_din_usuario.currval,sq_din_telefone.nextval,?,?) "
				+ " select * from dual ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, uto.getCpf());
			ps.setString(2, uto.getEmail());
			ps.setString(3, uto.getSenha());
			ps.setString(4, uto.getNome());
			ps.setDate(5, uto.getDtNasc());
			ps.setInt(6, uto.getNrDDD());
			ps.setLong(7, uto.getTelefone());
			
			if (ps.executeUpdate() > 0) {
				System.out.println("Inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void alterarSenha(UsuarioTO uto) {
		con = Conexao.abrirConexao();
		String sql = "update t_din_usuario set ds_senha = ? where id_usuario= ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, uto.getSenha());
			ps.setInt(2, uto.getIdUsuario());
			if (ps.executeUpdate() > 0) {
				System.out.println("Alterado com sucesso");
			} else {
				System.out.println("Erro ao alterar");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletar(UsuarioTO uto) {
		con = Conexao.abrirConexao();
		String sql =  " delete from t_din_usuario where id_usuario=? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, uto.getIdUsuario());
			if (ps.executeUpdate() > 0) {
				System.out.println("Excluido com sucesso");
			} else {
				System.out.println("Erro ao excluir");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<UsuarioTO> listar() {
		con = Conexao.abrirConexao();
		String sql = "select  u.id_usuario, u.nr_cpf, u.ds_email, u.ds_senha, u.nm_usuario, u.dt_nascimento, t.nr_ddd, t.nr_telefone from t_din_usuario u inner join t_din_telefone t on(u.id_usuario=t.id_usuario)  ";	
		
		ArrayList<UsuarioTO> listaTodos = new ArrayList<UsuarioTO>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					UsuarioTO uto = new UsuarioTO();
					uto.setIdUsuario(rs.getInt(1));
					uto.setCpf(rs.getString(2));
					uto.setEmail(rs.getString(3));
					uto.setSenha(rs.getString(4));
					uto.setNome(rs.getString(5));
					uto.setDtNasc(rs.getDate(6));
					uto.setNrDDD(rs.getInt(7));
					uto.setTelefone(rs.getLong(8));
					listaTodos.add(uto);
					
				}
				return listaTodos;

			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public UsuarioDAO() {}

	// GET-ALL(SELECT ALL)
	public ArrayList<UsuarioTO> select() {
		ArrayList<UsuarioTO> lista = listar();
		Conexao.fecharConexao(con);
		return lista;

	}

	// GET-BY-ID
	public UsuarioTO select(int id) {
		ArrayList<UsuarioTO> listaUsuario = listar();
		for (int i = 0; i < listaUsuario.size(); i++) {
			if (listaUsuario.get(i).getIdUsuario() == id) {
				Conexao.fecharConexao(con);
				return listaUsuario.get(i);
			}
		}
		return null;
	}

	// POST (INSERT)
	public void insert(UsuarioTO uto) {
		cadastrar(uto);
		Conexao.fecharConexao(con);
	}

	// UPDATE
	public void update(UsuarioTO uto) {
		UsuarioTO u = select(uto.getIdUsuario());
		u.setSenha(uto.getSenha());
		alterarSenha(u);
		Conexao.fecharConexao(con);
	}

	// DELETE
	public void delete(int id) {
		deletar(select(id));
		Conexao.fecharConexao(con);
	}
}
