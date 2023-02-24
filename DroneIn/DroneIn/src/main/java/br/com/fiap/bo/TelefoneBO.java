package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.TelefoneDAO;
import br.com.fiap.to.TelefoneTO;

public class TelefoneBO {
	private TelefoneDAO td;

	public List<TelefoneTO> listar() {
		td = new TelefoneDAO();
		return td.select();
	}

	public TelefoneTO listar(int id) {
		td = new TelefoneDAO();
		return td.select(id);
	}

	public void cadastrar(TelefoneTO uto) {
		td = new TelefoneDAO();
	}

	public void remover(int id) {
		td = new TelefoneDAO();
		td.delete(id);
	}
}
