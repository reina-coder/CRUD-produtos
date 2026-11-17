# CRUD de Produtos

Sistema CRUD de produtos desenvolvido em Java, executado pelo terminal. A aplicação permite cadastrar, listar, buscar, atualizar e remover produtos, salvando os dados em um arquivo JSON.

## Funcionalidades

- Cadastrar produto com nome, preço e quantidade
- Listar todos os produtos cadastrados
- Buscar um produto pelo nome
- Atualizar os dados de um produto existente
- Remover um produto pelo nome
- Carregar e salvar automaticamente os dados em `produtos.json`

## Tecnologias utilizadas

| Tecnologia | Versão | Uso no projeto |
|---|---:|---|
| Java | 21 | Linguagem principal da aplicação |
| Maven | Configuração presente | Gerenciamento do projeto e de dependências |
| Spring Boot | 4.1.1 | Framework declarado no `pom.xml` |
| Gson | 2.14.0 | Serialização e leitura dos dados em JSON |
| JSON | — | Formato de persistência dos produtos |

Apesar de o projeto declarar dependências do Spring Boot no Maven, a interface atual é totalmente baseada em console e não inicia um servidor web. O Maven também contém dependências Spring que não são utilizadas pelo código Java atual.

## Estrutura do projeto

```text
CRUD-produtos/
├── lib/
│   └── gson-2.14.0 (1).jar
├── src/br/com/reina/produtos/
│   ├── MainProduto.java
│   ├── controller/
│   │   └── ProdutoController.java
│   ├── model/
│   │   └── Produto.java
│   ├── repository/
│   │   └── ProdutoRepository.java
│   └── service/
│       └── ProdutoService.java
├── produtos.json
├── pom.xml
└── SitemaProdutosCRUD.iml
```

### Organização das classes

- **MainProduto**: inicia o programa e abre o menu.
- **ProdutoController**: controla a interação com o usuário no terminal.
- **ProdutoService**: contém as operações de cadastro, busca, listagem, atualização e remoção.
- **ProdutoRepository**: carrega e salva os produtos no arquivo JSON.
- **Produto**: representa os dados de um produto: nome, preço e quantidade.

## Persistência

Os produtos são armazenados no arquivo `produtos.json`, localizado na raiz do projeto. Ao iniciar o programa, o repositório tenta carregar esse arquivo; ao cadastrar, atualizar ou remover um produto, os dados são gravados novamente.

Exemplo:

```json
[
  {
    "nome": "Monitor gamer",
    "preco": 560.0,
    "quantidade": 3
  }
]
```

## Pré-requisitos

- Java JDK 21
- Maven

## Como executar

### Pela linha de comando

Na raiz do projeto, compile e execute com Maven:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="br.com.reina.produtos.MainProduto"
```

A classe principal também pode ser executada diretamente pela IDE após configurar o Java 21 e o JAR Gson disponível em `lib`.

## Como usar

Ao iniciar o programa, será exibido um menu:

```text
1 - Cadastrar produto
2 - Listar produtos
3 - Buscar produto
4 - Atualizar produto
5 - Remover produto
0 - Sair
```

Digite o número da operação desejada e siga as instruções exibidas no terminal.
