package br.com.jpa.jpql.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.jpql.modelo.Cliente;
import br.com.jpa.jpql.modelo.Conta;

/**
 * 
 * @author Renato
 * Observalção estamos realizando aqui um exemplo muito custoso para configurar um EntityManagerFactory
 * Não é legal repetir este código toda hora e por este motivo criamos uma classe Genérica JpaUtil 
 * Você poderá ver um exemplo de utilização da Class JpaUtil na classe CriaConta.
 */

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager(); 
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Renato");
		cliente.setEndereco("Rua da Tecnologia, 50");
		cliente.setProfissao("Software Develop");
		cliente.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
