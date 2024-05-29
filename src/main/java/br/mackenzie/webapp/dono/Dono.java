package br.mackenzie.webapp.professor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dono")
public class Dono {
  @Id @GeneratedValue
  private long id;
  private String nome;
  private int idade;

  public Dono() {
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
  public int getIdade(){
    return idade;
  }
  public void setIdade(int idade){
    this.idade = idade;
  }
}