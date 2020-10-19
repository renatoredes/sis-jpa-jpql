package br.com.jpa.jpql.testes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Renato
 * Observalção estamos realizando aqui um exemplo muito custoso para configurar um EntityManagerFactory
 * Não é legal repetir este código toda hora e por este motivo criamos uma classe Genérica JpaUtil 
 * Você poderá ver um exemplo de utilização da Class JpaUtil na classe CriaConta.
 */
public class CriaTabelaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		emf.close();
	}
}
