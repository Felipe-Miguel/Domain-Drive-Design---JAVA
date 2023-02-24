package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;

public class UsuarioBO {
	private UsuarioDAO ud;

	public List<UsuarioTO> listar() {
		ud = new UsuarioDAO();
		return ud.select();
	}

	public UsuarioTO listar(int id) {
		ud = new UsuarioDAO();
		return ud.select(id);
	}

	public void cadastrar(UsuarioTO uto) {
		ud = new UsuarioDAO();
		ud.insert(uto);
	}

	public void atualiza(UsuarioTO uto) {
		ud = new UsuarioDAO();
		ud.update(uto);
	}

	public void remover(int id) {
		ud = new UsuarioDAO();
		ud.delete(id);
	}
}
