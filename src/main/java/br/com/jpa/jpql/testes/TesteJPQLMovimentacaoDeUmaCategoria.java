package br.com.jpa.jpql.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.jpa.jpql.modelo.Categoria;
import br.com.jpa.jpql.modelo.Movimentacao;

/**
 * 
 * @author Renato
 * Observal��o estamos realizando aqui um exemplo muito custoso para configurar um EntityManagerFactory
 * N�o � legal repetir este c�digo toda hora e por este motivo criamos uma classe Gen�rica JpaUtil 
 * Voc� poder� ver um exemplo de utiliza��o da Class JpaUtil na classe CriaConta.
 */
public class TesteJPQLMovimentacaoDeUmaCategoria {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

		Categoria categoria = new Categoria();
		categoria.setId(1L);
		
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> movimentacoes = query.getResultList();
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Categorias: " + movimentacao.getCategorias());
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}
}
