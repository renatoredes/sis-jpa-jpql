package br.com.jpa.jpql.enumeracao;

import javax.persistence.EntityManager;

import br.com.jpa.jpql.util.JpaUtil;

public class TesteEnum {

	public static void main(String[] args) {
		// Gen�rico
		EntityManager entityManager = JpaUtil.getEntityManager();

		try {
			/* Abrir transa��o */
			entityManager.getTransaction().begin();

			Pedido pedido = new Pedido();

			System.out.println("####### Populando banco > tabela pedido_enum #######");
			
			pedido.setNomeProduto("Notebook");
			pedido.setStatusPedido(StatusPedido.ANALISE);  // valor do enum ser� texto isso foi definido no enum
			pedido.setPerfilUsuario(PerfilUsuario.ADMINISTRADOR);  // no banco o valor � 0

//			pedido.setNomeProduto("Desktop");
//			pedido.setPerfilUsuario(PerfilUsuario.GERENTE); // no banco o valor � 1
//
//			pedido.setNomeProduto("Smart TV ");
//			pedido.setPerfilUsuario(PerfilUsuario.COMUM); // no banco o valor � 2

			System.out.println("Nome: " + pedido.getNomeProduto());
			System.out.println("---------------------------------------");

			System.out.println(
					"Perfil do Usuario: " + pedido.getPerfilUsuario() + " > No banco o tipo ser� Enum numeral ");
			System.out.println("---------------------------------------");

			/* persiste os dados */
			System.out.println("realizando persistencia de dados......");
			System.out.println("---------------------------");
			entityManager.persist(pedido);

			/* execulta transa��o */
			entityManager.getTransaction().commit();
			System.out.println("####### Dados persistidos com Sucesso! ###########");
			System.out.println("Nome: " + pedido.getNomeProduto());
			System.out.println(
					"Perfil do Usuario: " + pedido.getPerfilUsuario() + " > No banco o tipo ser� valor numerico de acordo com a ordem do Enum");
			System.out.println("####### Dados persistidos com Sucesso! ###########");

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