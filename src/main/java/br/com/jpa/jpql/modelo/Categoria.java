package br.com.jpa.jpql.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author Renato
 *
 */
@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Override
	public String toString() {
		return nome + " - " + id;
	}
	/*
	 � uma Regra do hibernete ter um construtor vazio como padr�o
	 ele sempre utiliza os objetos pelo construtor padr�o n�s n�o vamos utilizar esse construtor
	 essa anota��o @Deprecated indica que n�o vamos utilizar esse construtor � apenas para fim de infra-estrutuda que isso vai ser usado para o hibernete
	  
	  */
	@Deprecated  
	public Categoria() {
	}

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
