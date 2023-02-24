package br.com.fiap.to;

public class TelefoneTO {
	int idUsuario, idTelefone, nrDDD, nrTelefone;
	
	public TelefoneTO() {
		// TODO Auto-generated constructor stub
	}

	public TelefoneTO(int idUsuario, int idTelefone, int nrDDD, int nrTelefone) {
		this.idUsuario=idUsuario;
		this.idTelefone = idTelefone;
		this.nrDDD = nrDDD;
		this.nrTelefone = nrTelefone;
	}

	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getNrDDD() {
		return nrDDD;
	}

	public void setNrDDD(int nrDDD) {
		this.nrDDD = nrDDD;
	}

	public int getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(int nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

}
