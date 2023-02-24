package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.to.EnderecoTO;

import br.com.fiap.dao.EnderecoDAO;

public class EnderecoBO {

	private EnderecoDAO ed;

	public ArrayList<EnderecoTO> listar() {
		ed = new EnderecoDAO();
		return ed.select();
	}

	public EnderecoTO listar(int id) {
		ed = new EnderecoDAO();
		return ed.select(id);
	}

	public void cadastrar(EnderecoTO eto) {
		ed = new EnderecoDAO();
		ed.insert(eto);
	}

	public void atualiza(EnderecoTO eto) {
		ed = new EnderecoDAO();
		ed.update(eto);
	}

	public void remover(int id) {
		ed = new EnderecoDAO();
		ed.delete(id);
	}
}
