package br.com.jpa.jpql.testes;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.heraca.joined.PessoaJuridicaJoined;
import br.com.jpa.jpql.util.JpaUtil;

/**
 * 
 * @author Renato
 * Classe de teste respons�vel por persistir dados de Pessoa Fisica utilizando conceito de heran�a SigleTable
 */
public class TesteHerancaPessoaJuridicaJoined {

	public static void main(String[] args) {

		// Gen�rico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transa��o */
			entityManager.getTransaction().begin();

			
			PessoaJuridicaJoined pessoaJuridicaJoined = new PessoaJuridicaJoined();
			
			System.out.println("Inserindo dados de Pessoa Fisica");
			
			pessoaJuridicaJoined.setNome("Renato_Redes_Software.sa");
			pessoaJuridicaJoined.setCNPJ("00.000.000/0001-00");
			
			System.out.println("realizando insert "+ " - " 
			+ pessoaJuridicaJoined.getNome() + " - "  
			+ pessoaJuridicaJoined.getCNPJ());
			
			/* persiste os dados */
			entityManager.persist(pessoaJuridicaJoined);
			/* execulta transa��o */
			entityManager.getTransaction().commit();
			System.out.println("Dados Pessoa Juridica persistido com Sucesso!");

		} catch (Exception e) {
			// se estiver conex�o aberto, caso capturar uma Exception, fazer rollback
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
