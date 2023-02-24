package br.com.fiap.to;

public class EnderecoTO {

	private int idEstado, idEndereco, cep, numero, idCidade;
	private String logradouro, complemento, referencia, cidade, estado;

	public EnderecoTO() {

	}

	public EnderecoTO(int idEstado, int idEndereco, int cep, int numero, int idCidade, String logradouro, String complemento,
			String referencia,String cidade, String estado) {
		this.idEstado=idEstado;
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.numero = numero;
		this.idCidade = idCidade;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.referencia = referencia;
		this.cidade=cidade;
		this.estado=estado;

	}

	

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
