package br.com.jpa.jpql.embedded;

import javax.persistence.*;

@Entity
@Table(name = "Aluno")
public class Aluno {

	@Id
	private int id;
	
	private String nome;
	
	private int idade;
	
	@Embedded
	private Endereco endereco;

    //--	Get -- Set --//
	
}
