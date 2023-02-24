package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.to.PacoteTO;

import br.com.fiap.dao.PacoteDAO;

public class PacoteBO {

	private PacoteDAO pd;

	public ArrayList<PacoteTO> listar() {
		pd = new PacoteDAO();
		return pd.select();
	}

	public PacoteTO listar(int id) {
		pd = new PacoteDAO();
		return pd.select(id);
	}

	public void cadastrar(PacoteTO pto) {
		pd = new PacoteDAO();
		pd.insert(pto);
	}

	public void atualiza(PacoteTO pto) {
		pd = new PacoteDAO();
		pd.update(pto);
	}

	public void remover(int id) {
		pd = new PacoteDAO();
		pd.delete(id);
	}
}
