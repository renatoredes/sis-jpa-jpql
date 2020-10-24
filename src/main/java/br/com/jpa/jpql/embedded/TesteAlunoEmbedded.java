package br.com.jpa.jpql.embedded;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.util.JpaUtil;

public class TesteAlunoEmbedded {

	public static void main(String[] args) {
		// Gen�rico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transa��o */
			entityManager.getTransaction().begin();

			Aluno aluno = new Aluno();
			aluno.setNome("RenatoRedesSoftware");
			aluno.setIdade(32);		
			aluno.getEndereco().setEnderecoNumero(007);
			aluno.getEndereco().setEnderecoBairro("Teste");
			aluno.getEndereco().setEnderecoCasa("Teste");
			
			/* persiste os dados */
			System.out.println("realizando persistencia de dados......");
			entityManager.persist(aluno);
			/* execulta transa��o */
			entityManager.getTransaction().commit();
			System.out.println("Dados inserido com Sucesso!");

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