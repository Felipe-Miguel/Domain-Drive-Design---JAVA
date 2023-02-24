package br.com.fiap.to;

import java.sql.Date;



public class UsuarioTO {
	private int idUsuario, nrDDD;
	private long telefone;
	private String nome, email, senha, cpf;
	private Date dtNasc;

	public UsuarioTO() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioTO( int nrDDD, long telefone, int idUsuario, String nome, String email, String senha, String cpf, Date dtNasc) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.telefone=telefone;
		this.nrDDD=nrDDD;
	}

	
	public int getNrDDD() {
		return nrDDD;
	}

	public void setNrDDD(int nrDDD) {
		this.nrDDD = nrDDD;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	

}
