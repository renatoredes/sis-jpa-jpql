package br.com.jpa.jpql.heraca.joined;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.util.JpaUtil;

/**
 * 
 * @author Renato
 * Classe de teste responsável por persistir dados de Pessoa Fisica utilizando conceito de herança SigleTable
 */
public class TesteHerancaPessoaFisicaJoined {

	public static void main(String[] args) {

		// Genérico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transação */
			entityManager.getTransaction().begin();

			
			PessoaFisicaJoined pessoaFisicaJoined = new PessoaFisicaJoined();
			
			System.out.println("Inserindo dados de Pessoa Fisica");
			
			pessoaFisicaJoined.setNome("Renato");
			pessoaFisicaJoined.setCPF("000.000.000-00");
			
			System.out.println("realizando insert "+ " - " 
			+ pessoaFisicaJoined.getNome() + " - "  
			+ pessoaFisicaJoined.getCPF());
			
			/* persiste os dados */
			System.out.println("realizando persistencia de dados......");
			entityManager.persist(pessoaFisicaJoined);
			/* execulta transação */
			entityManager.getTransaction().commit();
			System.out.println("Dados Pessoa Fisica persistido com Sucesso!");

		} catch (Exception e) {
			// se estiver conexão aberto, caso capturar uma Exception, fazer rollback
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();

			}
		}
	}
}
