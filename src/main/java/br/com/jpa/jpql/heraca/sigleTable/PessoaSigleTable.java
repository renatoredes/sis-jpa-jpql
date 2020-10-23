package br.com.jpa.jpql.heraca.sigleTable;

import javax.persistence.*;

/**
 * 
 * @author Renato
 * SINGLE_TABLE Tipo de Herança
 * @DiscriminatorColumn coluna responsável por armazenar a entity
 * Exemplo Herança utilizando estratégia SigleTable
 */
@Entity
@Table(name = "Pessoa_SigleTable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pertence_a_classe")
public class PessoaSigleTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;

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
	
	
}
