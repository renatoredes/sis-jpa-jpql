package br.com.jpa.jpql.testes;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.jpa.jpql.modelo.Conta;
import br.com.jpa.jpql.modelo.Movimentacao;

/**
 * 
 * @author Renato 
 *         Observal��o estamos realizando aqui um exemplo muito custoso
 *         para configurar um EntityManagerFactory N�o � legal repetir este
 *         c�digo toda hora e por este motivo criamos uma classe Gen�rica
 *         JpaUtil Voc� poder� ver um exemplo de utiliza��o da Class JpaUtil na
 *         classe CriaConta.
 *
 *
 * 
 *         select responsavel por buscar movimenta��o associada a conta de um
 *         determinado id m -> indica que eu estou apilidando/chamando minha
 *         Class Movimentacao de m m.conta -> indica que conta estar dentro da
 *         minha classe Movimentacao o parametro -> :pConta seria no caso o id
 *         da conta no banco de dados relaciona SQL
 **/

public class TesteJPQL {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		String sql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

		Conta conta = new Conta();
		conta.setId(1L);
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pConta", conta);

		// essa query retorna uma lista de movimenta��o
		List<Movimentacao> movimentacoes = query.getResultList();
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}
}
