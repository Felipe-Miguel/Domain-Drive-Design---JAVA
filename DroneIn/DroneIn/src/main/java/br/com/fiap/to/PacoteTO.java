package br.com.fiap.to;

public class PacoteTO {
	private int idPacote;
	private float vlPesoPacote, vlAltura, vlLargura, vlComprimento;
	private String dsConteudo;
	private String tpConteudo;

	public PacoteTO() {
		// TODO Auto-generated constructor stub
	}

	public PacoteTO(int idPacote, float vlPesoPacote, float vlAltura, float vlLargura, float vlComprimento,
			String dsConteudo, String tpConteudo) {
		this.idPacote = idPacote;
		this.vlPesoPacote = vlPesoPacote;
		this.vlAltura = vlAltura;
		this.vlLargura = vlLargura;
		this.vlComprimento = vlComprimento;
		this.dsConteudo = dsConteudo;
		this.tpConteudo = tpConteudo;
	}

	public String getTpConteudo() {
		return tpConteudo;
	}

	public void setTpConteudo(String tpConteudo) {
		this.tpConteudo = tpConteudo;
	}

	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}

	public float getVlPesoPacote() {
		return vlPesoPacote;
	}

	/**
	 * @param vlPesoPacote = variável int com o peso do pacote ele verifica se o
	 *                     peso do pacote é superior a 2,5Kg
	 **/
	public void setVlPesoPacote(float vlPesoPacote) {
		if (vlPesoPacote <= 2.5) {
			this.vlPesoPacote = vlPesoPacote;
		} else {
			System.out.println("Peso fora do permitido");
		}

	}

	public float getVlAltura() {
		return vlAltura;
	}

	/**
	 * @param vlAltura = variável int com a altura do pacote ele verifica se o
	 *                 tamanho da altura é superior a 30cm
	 **/
	public void setVlAltura(float vlAltura) {
		if (vlAltura <= 30) {
			this.vlAltura = vlAltura;
		} else {
			System.out.println("Altura fora do permitido");
		}
	}

	public float getVlLargura() {
		return vlLargura;
	}

	/**
	 * @param vlLargura = variável int com o peso do pacote ele verifica se o
	 *                  tamanho do pacote é superior a 30cm
	 **/
	public void setVlLargura(float vlLargura) {
		if (vlLargura <= 30) {
			this.vlLargura = vlLargura;
		} else {
			System.out.println("Largura fora do permitido");
		}
	}

	public float getVlComprimento() {
		return vlComprimento;
	}

	/**
	 * @param passa um int vlAltura como parametro ele verifica se o tamanho do
	 *              pacote é superior a 30cm
	 **/
	public void setVlComprimento(float vlComprimento) {
		if (vlComprimento <= 30) {
			this.vlComprimento = vlComprimento;
		} else {
			System.out.println("Comprimento fora do permitido");
		}
	}

	public String getDsConteudo() {
		return dsConteudo;
	}

	public void setDsConteudo(String dsConteudo) {
		this.dsConteudo = dsConteudo;
	}

}
