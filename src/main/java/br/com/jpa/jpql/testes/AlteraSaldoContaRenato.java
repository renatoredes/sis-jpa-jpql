package br.com.jpa.jpql.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.jpql.modelo.Conta;

/**
 * 
 * @author Renato
 * Observal��o estamos realizando aqui um exemplo muito custoso para configurar um EntityManagerFactory
 * N�o � legal repetir este c�digo toda hora e por este motivo criamos uma classe Gen�rica JpaUtil 
 * Voc� poder� ver um exemplo de utiliza��o da Class JpaUtil na classe CriaConta.
 */
public class AlteraSaldoContaRenato {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		// find busca registro no banco
		Conta contaDoLeonardo = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();
		// Estado Managed sicroniza��o automaticamente  no banco
		contaDoLeonardo.setSaldo(20.0);
		
		em.getTransaction().commit();
		
	}
}
