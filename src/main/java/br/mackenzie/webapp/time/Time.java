package br.mackenzie.webapp.professor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="times")
public class Time {
	@Id @GeneratedValue
	private long id;
	private String nome;
	private String conferencia;
	private int titulos;

	public Time() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getConferencia(){
		return conferencia;
	}
	public void setConferencia(String conferencia){
		this.conferencia = conferencia;
	}
	public int getTitulos(){
		return titulos;
	}
	public void setTitulos(int titulos){
		this.titulos = titulos;
	}
}