package br.com.fiap.to;

import java.sql.Date;
import java.util.Random;

public class EntregaTO {

	private int idEntrega, idUsuario, idPacote;
	private float vlPreco, vlDistancia;
	private String dsConfirmacao;
	private Date dtConclusao,dtPedido;

	public EntregaTO() {
		// TODO Auto-generated constructor stub
	}

	public EntregaTO(int idUsuario, int idPacote,int idEntrega, float vlPreco, float vlDistancia, String dsConfirmacao,
			 Date dtConclusao ,Date dtPedido) {
		this.idUsuario=idUsuario;
		this.idPacote=idPacote;
		this.idEntrega = idEntrega;
		this.vlPreco = vlPreco;
		this.vlDistancia = vlDistancia;
		this.dsConfirmacao = dsConfirmacao;
		this.dtConclusao = dtConclusao;
		this.dtPedido = dtPedido;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}
	public int getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}

	public float getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(float vlPreco) {
		this.vlPreco = vlPreco;
	}

	public float getVlDistancia() {
		return vlDistancia;
	}

	public void setVlDistancia(float vlDistancia) {
		this.vlDistancia = vlDistancia;
	}

	public String getDsConfirmacao() {
		return dsConfirmacao;
	}

	public void setDsConfirmacao(String dsConfirmacao) {
		this.dsConfirmacao = dsConfirmacao;
	}

	public Date getDtPedido() {
		return dtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}

	
	public Date getDtConclusao() {
		return dtConclusao;
	}

	public void setDtConclusao(Date dtConclusao) {
		this.dtConclusao = dtConclusao;
	}

	/**
	 * @param Recebe um valor distancia float e um objeto pacote Método que calcula
	 *               o preço da entrega com base na distancia e peso, conforme o
	 *               peso do pacote aumenta o preço por KM aumenta também
	 * @return retorna um valor float com o preco da viagem
	 **/
	public Float calculaPreco(float vlDistancia, PacoteTO pacote) {
		if (pacote.getVlPesoPacote() < 1000) {
			Float vlPreco = vlDistancia * 7;
			return vlPreco;
		} else if (pacote.getVlPesoPacote() < 2000) {
			Float vlPreco = vlDistancia * 9;
			return vlPreco;
		} else if (pacote.getVlPesoPacote() >= 2000) {
			Float vlPreco = vlDistancia * 11;
			return vlPreco;
		}
		return vlPreco;

	}

	/**
	 * Método que gera uma distancia(em KM) aleatoria de 0 a 10 * @return retorna um
	 * valor float com a distância da viagem
	 **/
	public Float geraDistancia() {
		Random gerador = new Random();
		Float distancia = gerador.nextFloat() * 10;
		return distancia;
	}

	/**
	 * @param Recebe um objeto Entrega Método que calcula o tempo média de entrega
	 *               do produto em minutos, utilizando uma velocidade média de
	 *               40km/h e acrescentando 2 minutos de margem de erro
	 * @return retorna um valor float com o tempo médio em minutos de entrega do
	 *         produto
	 **/
	public Float calculaTempo(EntregaTO entrega) {
		float tempoMin = (entrega.getVlDistancia() / 40) * 60 + 2;
		return tempoMin;
	}

}
