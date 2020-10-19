package br.com.jpa.jpql.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.jpql.modelo.Conta;

/**
 * 
 * @author Renato
 * Observalção estamos realizando aqui um exemplo muito custoso para configurar um EntityManagerFactory
 * Não é legal repetir este código toda hora e por este motivo criamos uma classe Genérica JpaUtil 
 * Você poderá ver um exemplo de utilização da Class JpaUtil na classe CriaConta.
 */
public class AlteraSaldoContaRenato {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		// find busca registro no banco
		Conta contaDoLeonardo = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();
		// Estado Managed sicronização automaticamente  no banco
		contaDoLeonardo.setSaldo(20.0);
		
		em.getTransaction().commit();
		
	}
}
