package br.com.jpa.jpql.heraca.sigleTable;

import javax.persistence.*;

/**
 * 
 * @author Renato
 * @DiscriminatorValue valor que indentifica classe na tabela do banco de dados.
 * Exemplo Herança utilizando estratégia SigleTable
 */

@Entity
@DiscriminatorValue("PessoaJuridica")
public class PessoaJuridicaSigleTable extends PessoaSigleTable {

	private String CNPJ;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
}
