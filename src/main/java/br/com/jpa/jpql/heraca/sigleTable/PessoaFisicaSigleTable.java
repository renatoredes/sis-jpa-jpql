package br.com.jpa.jpql.heraca.sigleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author Renato
 * @DiscriminatorValue valor que indentifica classe na tabela do banco de dados.
 * Exemplo Herança utilizando estratégia SigleTable
 */
@Entity
@DiscriminatorValue("PessoaFisica")
public class PessoaFisicaSigleTable extends PessoaSigleTable{
	
	private String CPF;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	
}
