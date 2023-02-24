package br.com.fiap.bo;

import java.util.ArrayList;


import br.com.fiap.dao.EntregaDAO;
import br.com.fiap.to.EntregaTO;

public class EntregaBO {
	private EntregaDAO ed;

	public ArrayList<EntregaTO> listar() {
		ed = new EntregaDAO();
		return ed.select();
	}

	public EntregaTO listar(int id) {
		ed = new EntregaDAO();
		return ed.select(id);
	}

	public void cadastrar(EntregaTO uto) {
		ed = new EntregaDAO();
		ed.insert(uto);
	}

	public void atualiza(EntregaTO uto) {
		ed = new EntregaDAO();
		ed.update(uto);
	}
	
	public void remover(int id) {
		ed=new EntregaDAO();	
		ed.delete(id);
	}
}