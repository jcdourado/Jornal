package model;

import java.util.Date;

public class Noticia {
	private String tipo;
	private String jornalista;
	private String titulo;
	private String descricao;
	private Date dataCriacao;
	private String aprovador_id;
	private Date aprovador_data;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getJornalista() {
		return jornalista;
	}
	public void setJornalista(String jornalista) {
		this.jornalista = jornalista;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getAprovador_id() {
		return aprovador_id;
	}
	public void setAprovador_id(String aprovador_id) {
		this.aprovador_id = aprovador_id;
	}
	public Date getAprovador_data() {
		return aprovador_data;
	}
	public void setAprovador_data(Date aprovador_data) {
		this.aprovador_data = aprovador_data;
	}
}
