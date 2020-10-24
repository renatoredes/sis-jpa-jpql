package br.com.jpa.jpql.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author Renato
 * Essa classe não é uma entity a anotação abaixo
 * @Embeddable indica à JPA que essa classe pode ser ‘anexada’ a uma entity.
 */
@Embeddable
public class Endereco {

	@Column(name = "endereco_casa")
	private String enderecoCasa;

	@Column(name = "endereco_numero")
	private int enderecoNumero;

	@Column(name = "endereco_bairro")
	private String enderecoBairro;

	// --Get e Set --//
}
