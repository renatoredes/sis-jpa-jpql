package br.com.jpa.jpql.embedded;

import javax.persistence.*;

@Entity
@Table(name = "Aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private int idade;
	/**
	 * Inicializa  objeto Endereço para setar valores na classe de Teste alunos
	 */
	@Embedded
	private Endereco endereco = new Endereco();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

    //--	Get -- Set --//
	
	
}
