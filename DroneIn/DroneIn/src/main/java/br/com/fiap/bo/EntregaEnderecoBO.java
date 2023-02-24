package br.com.fiap.bo;

import java.util.ArrayList;


import br.com.fiap.dao.EntregaEnderecoDAO;
import br.com.fiap.to.EntregaEnderecoTO;

public class EntregaEnderecoBO {
	private EntregaEnderecoDAO ed;

	public ArrayList<EntregaEnderecoTO> listar() {
		ed = new EntregaEnderecoDAO();
		return ed.select();
	}

	public EntregaEnderecoTO listar(int id) {
		ed = new EntregaEnderecoDAO();
		return ed.select(id);
	}

	public void cadastrar(EntregaEnderecoTO eto) {
		ed = new EntregaEnderecoDAO();
		ed.insert(eto);
	}

	public void atualiza(EntregaEnderecoTO eto) {
		ed = new EntregaEnderecoDAO();
		ed.update(eto);
	}
	
	public void remover(int id) {
		ed=new EntregaEnderecoDAO();	
		ed.delete(id);
	}
}