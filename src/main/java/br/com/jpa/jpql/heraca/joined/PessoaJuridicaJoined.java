package br.com.jpa.jpql.heraca.joined;

import javax.persistence.Entity;

@Entity
public class PessoaJuridicaJoined extends PessoaJoined {

	
	private String CNPJ;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

}
