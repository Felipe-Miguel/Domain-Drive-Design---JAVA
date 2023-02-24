package br.com.fiap.to;

public class EntregaEnderecoTO {
	private String nmResponsavel, tpEndereco;
	private int idEntregaEnd,idEntrega,IdEndereco;
	private long nrTelefoneResponsavel;

	public EntregaEnderecoTO() {
		// TODO Auto-generated constructor stub
	}

	public EntregaEnderecoTO(int idEntregaEnd,int idEntrega, int IdEndereco, String nmResponsavel, long nrTelefoneResponsavel, String tpEndereco) {
		this.idEntregaEnd = idEntregaEnd;
		this.idEntrega=idEntrega;
		this.IdEndereco=IdEndereco;
		this.nmResponsavel = nmResponsavel;
		this.nrTelefoneResponsavel = nrTelefoneResponsavel;
		this.tpEndereco = tpEndereco;
	}

	public int getIdEntregaEnd() {
		return idEntregaEnd;
	}

	public void setIdEntregaEnd(int idEntregaEnd) {
		this.idEntregaEnd = idEntregaEnd;
	}

	
	public int getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}

	public int getIdEndereco() {
		return IdEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		IdEndereco = idEndereco;
	}

	public String getNmResponsavel() {
		return nmResponsavel;
	}

	public void setNmResponsavel(String nmResponsavel) {
		this.nmResponsavel = nmResponsavel;
	}

	public long getnrTelefoneResponsavel() {
		return nrTelefoneResponsavel;
	}

	public void setnrTelefoneResponsavel(long nrTelefoneResponsavel) {
		this.nrTelefoneResponsavel = nrTelefoneResponsavel;
	}

	public String getTpEndereco() {
		return tpEndereco;
	}

	public void setTpEndereco(String tpEndereco) {
		this.tpEndereco = tpEndereco;
	}
}
