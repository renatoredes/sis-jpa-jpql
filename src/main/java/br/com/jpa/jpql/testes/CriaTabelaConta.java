package br.com.jpa.jpql.testes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Renato
 * Observal��o estamos realizando aqui um exemplo muito custoso para configurar um EntityManagerFactory
 * N�o � legal repetir este c�digo toda hora e por este motivo criamos uma classe Gen�rica JpaUtil 
 * Voc� poder� ver um exemplo de utiliza��o da Class JpaUtil na classe CriaConta.
 */
public class CriaTabelaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		emf.close();
	}
}
