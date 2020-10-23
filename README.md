# JPA - JPQL
## Exemplo Persistência de dados utilizando JPA e consultas com JPQL 
### Nas implementações vamos ter alguns Exemplos Basicos e Avançados

1. clone o repositório `git clone https://github.com/renatoredes/sis-jpa-jpql`

```
##### CRIAÇÃO DO BANCO: #####

CREATE DATABASE bdjpa;

##### BANCO: #####
Consultas Tabelas utilizando SQL

select * from conta;
select * from movimentacao;
select * from categoria;
select * from cliente;
select * from movimentacao_categoria;

```
  ![Consulta SQL](/screenshot/banco.png?raw=true "SQL")
### Relacionamento

```
@ManyToOne
@ManyToMany
 
```
### Exemplo utilizando Enum
```
public enum TipoMovimentacao {
	ENTRADA, SAIDA;
}
```
### Exemplos de Persistência de dados

```
EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);

		em.getTransaction().commit();
		em.close();
  
  ```  
  ### Exemplo Consultando dados utilizando JPQL
    
  ```
 String sql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
    
  ```
 ### Exemplo Consultando dados utilizando JPQL e INNER JOIN
  
  ```
String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria"; 
 
  ```
![Consulta JPQL](/screenshot/projeto.png?raw=true "Consulta JPQL")

### Retorna essa consulta
```
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Categorias: [Viagem - 1, Negocio - 2]
Descricao: Viagem E.U.A
Valor: 300.00
Tipo: SAIDA
Categorias: [Viagem - 1, Negocio - 2]
Descricao: Viagem Canadá
Valor: 400.00
Tipo: SAIDA
```  
 ### JpaUtil 
Implementei a classe JpaUtil que utiliza o recurso de  ThreadLocal<EntityManager>, que
serve para salvar uma instância de determinada classe por thread. Com isso, é possível
utilizar seguramente o mesmo EntityManager na thread iniciada, e não enviar
o EntityManager para o usuário errado.<br/>
 
É Possivel visualizar um exemplo de uso deste recurso na clase CriaConta
```
// Genérico
EntityManager entityManager = JpaUtil.getEntityManager();
```
  
 ### JpaUtil 
Classe JpaUtil que utiliza o recurso de  ThreadLocal<EntityManager>, que
serve para salvar uma instância de determinada classe por thread. Com isso, é possível
utilizar seguramente o mesmo EntityManager na thread iniciada, e não enviar

### Herança

![Herança](/screenshot/herança.png?raw=true)


### Estrutura de tabela utilizando estratégia de herança SINGLE_TABLE

• É possível encontrar um exemplo de Herança SINGLE_TABLE no Package <br/>
`
br.com.jpa.jpql.heraca.sigleTable
Classes: PessoaSigleTable, PessoaFisicaSigleTable, PessoaJuridicaSigleTable
`
• Característica salvar todas as informações das Entities em uma única tabela.
• Exemplo na imagem 
### Vantagens dessa abordagem:
• Dados Centralizados - os dados estão em uma única tabela, fácil de localizar
todos os dados.<br/>

• Fácil de entender — um desenvolvedor júnior poderia facilmente analisar os
dados, facilita a extração de dados via SQL. <br/>

• Boa Performance — tem uma performance boa pois a consulta é realizada
em apenas uma tabela. É possível também fazer otimizações como criação de
index no banco de dados.


<br/><br/>
![SINGLETABLE](/screenshot/sigletable.png?raw=true)


