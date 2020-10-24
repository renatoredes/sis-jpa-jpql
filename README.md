# JPA - JPQL
## Exemplo Persistência de dados utilizando JPA e consultas com JPQL 
### Nas implementações vamos ter alguns Exemplos Basicos e Avançados

1. clone o repositório `git clone https://github.com/renatoredes/sis-jpa-jpql`
2. Execulte as classes de testes
***
```
##### CRIAÇÃO DO BANCO: #####

CREATE DATABASE bdjpa;

##### BANCO: #####
Consultas Simples SQL

select * from conta;
select * from movimentacao;
select * from categoria;
select * from cliente;
select * from movimentacao_categoria;

```
***
  ![Consulta SQL](/screenshot/banco.png?raw=true "SQL")
### Relacionamento

```
@ManyToOne
@ManyToMany
 
```
***
### Exemplos utilizando Enum no package:

```
package br.com.jpa.jpql.enumeracao;

public enum PerfilUsuario {

	ADMINISTRADOR, GERENTE, COMUM
}

public enum StatusPedido {
	
	APROVADO, ANALISE
}
• Exemplo inserindo valor númerico no banco de dados

 @Enumerated
 private PerfilUsuario perfilUsuario;
 
• Exemplo inserindo valor texto no banco de dados

 @Enumerated(EnumType.STRING)
 private StatusPedido statusPedido;


```
***
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
  ***
  ### Exemplo Consultando dados utilizando JPQL
    
  ```
 String sql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
    
  ```
  ***
 ### Exemplo Consultando dados utilizando JPQL e INNER JOIN
  
  ```
String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria"; 
 
  ```
![Consulta JPQL](/screenshot/projeto.png?raw=true "Consulta JPQL")
***
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
***
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
***
 ### JpaUtil 
Classe JpaUtil que utiliza o recurso de  ThreadLocal<EntityManager>, que
serve para salvar uma instância de determinada classe por thread. Com isso, é possível
utilizar seguramente o mesmo EntityManager na thread iniciada, e não enviar
***
### Herança

![Herança](/screenshot/herança.png?raw=true)

***
### Estrutura de tabela utilizando estratégia de herança SINGLE_TABLE

• É possível encontrar um exemplo de Herança SINGLE_TABLE no Package <br/>
`
br.com.jpa.jpql.heraca.sigleTable
Classes: PessoaSigleTable, PessoaFisicaSigleTable, PessoaJuridicaSigleTable,
TesteHerancaPessoaFisicaSigleTable,TesteHerancaPessoaJuridicaSigleTable
`
<br/>
• Característica salvar todas as informações das Entities em uma única tabela.
<br/>
***

### Vantagens dessa abordagem: 😃 
• Dados Centralizados - os dados estão em uma única tabela, fácil de localizar
todos os dados.<br/>

• Fácil de entender — um desenvolvedor júnior poderia facilmente analisar os
dados, facilita a extração de dados via SQL. <br/>

• Boa Performance — tem uma performance boa pois a consulta é realizada
em apenas uma tabela. É possível também fazer otimizações como criação de
index no banco de dados.

***

### Desvantagem: 😡
Uma entity que herde da classe pai não pode ter campos definidos como not null.<br/>
Solução para esse problema seria deixar no banco de dados aceitando null <br/>
E validarmanualmente o campo pedigree, essa validação poderia ser feita pela anotação @NotNull
<br/>
• Exemplo na imagem:

<br/><br/>
![SINGLETABLE](/screenshot/sigletable.png?raw=true)
<br/>

***

### Estrutura de tabela utilizando estratégia de herança JOINED
• Utiliza da abordagem de uma tabela para cada entity sendo abstrata ou não.<br/>

### Vantagens: 😃 
• Tabela por Entity permitindo campos null<br/>
• Segue modelo OO—as tabelas serão reflexo do OO aplicado nas Entities.
### Desvantagem: 😡
• Insert mais custoso—um insert no banco de dados custaria “mais caro”. Para<br/>
persistir a entity PessoaFisica seria necessário realizar insert na tabela<br/>
pessoafisica e pessoa.<br/>

• Alto número de JOINS—quantomaior a hierarquia,maior o número de joins<br/>
em uma consulta para trazer a entity do banco de dados.<br/>

• É possível encontrar um exemplo de Herança JOINED no Package <br/>

`
br.com.jpa.jpql.heraca.joined
Classes: PessoaJoined, PessoaFisicaJoined,PessoaJuridicaJoined,
TesteHerancaPessoaFisicaJoined,TesteHerancaPessoaJuridicaJoined
`

• Exemplo na imagem: 
<br/><br/>
![JOINED](/screenshot/JOINED.png?raw=true)
<br/>

***

### Evitando Joins com Embedded  😃
• Imagine uma tabela onde temos os dados de Aluno e Seus respectivos endereços.<br/>
Essa funcionalidade serve para organizar melhor a orientação a objetos de aplicação.<br/>

É possível encontrar um exemplo: 
`
package br.com.jpa.jpql.embedded
package br.com.jpa.jpql.testes
`<br/>
  
Para criar 2 Endreço exemplo endereço Pessoal e Endereço do Trabalho<br/> 
No mesmo objeto poderiamos utilizar a anotação:`@AttributeOverride`<br/> 

• Nessa classe de Teste `TesteAlunoEmbedded` é possivel setar valores de endereço<br/>
Utilizando com uma classe que utiliza anotação @Embeddable<br/> D + Neh ? 😃 

***


## License
MIT © [Renato Ferreira](https://github.com/renatoredes)
