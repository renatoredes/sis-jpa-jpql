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

	public String getEnderecoCasa() {
		return enderecoCasa;
	}

	public void setEnderecoCasa(String enderecoCasa) {
		this.enderecoCasa = enderecoCasa;
	}

	public int getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(int enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	// --Get e Set --//
	
}
