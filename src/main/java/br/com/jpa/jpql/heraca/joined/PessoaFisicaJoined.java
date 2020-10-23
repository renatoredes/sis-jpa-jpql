package br.com.jpa.jpql.heraca.joined;

import javax.persistence.*;

@Entity
public class PessoaFisicaJoined extends PessoaJoined {

	private String CPF;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

}
