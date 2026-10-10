
# BiblioTech

Sistema de emprestimo de livros para a biblioteca do campus.

## 1. O projeto

O BiblioTech e um sistema para ajudar a biblioteca do campus a organizar os livros, os leitores, os emprestimos e as devolucoes. O cliente e a biblioteca, que precisa controlar quais livros estao disponiveis e quem esta com cada livro. O sistema busca facilitar o trabalho da bibliotecaria e ajudar os leitores a consultar o acervo.

## 2. Historias de usuario

| # | Historia de usuario |
|---|---|
| HU01 | Como leitor, quero consultar a disponibilidade de um livro, para saber se posso pega-lo emprestado sem ir ate o balcao. |
| HU02 | Como leitor, quero devolver um livro, para nao ficar com pendencia na biblioteca. |
| HU03 | Como bibliotecaria, quero registrar um emprestimo, para saber quem esta com cada exemplar. |
| HU04 | Como bibliotecaria, quero cadastrar um livro novo, para que ele possa ser encontrado no sistema. |
| HU05 | Como bibliotecaria, quero ver os emprestimos atrasados, para cobrar a devolucao. |

## 3. Requisitos

### Requisitos funcionais

| # | Requisito funcional | Veio da |
|---|---|---|
| RF01 | O sistema deve permitir que a bibliotecaria cadastre um livro no acervo. | HU04 |
| RF02 | O sistema deve permitir que a bibliotecaria cadastre um leitor. | Regra de acesso: so quem tem cadastro leva livro |
| RF03 | O sistema deve permitir que o leitor consulte a disponibilidade de um livro. | HU01 |
| RF04 | O sistema deve permitir que a bibliotecaria registre a devolucao de um livro. | HU02 |
| RF05 | O sistema deve permitir que a bibliotecaria registre o emprestimo de um livro. | HU03 |
| RF06 | O sistema deve permitir que a bibliotecaria consulte os emprestimos atrasados. | HU05 |

### Requisitos nao funcionais

| # | Requisito nao funcional |
|---|---|
| RNF01 | A consulta de disponibilidade deve responder em menos de 3 segundos. |
| RNF02 | Somente usuarios identificados como bibliotecarios podem alterar o acervo. |

## 4. Diagramas (feitos em APS)

### Casos de uso

![Diagrama de casos de uso do BiblioTech](docs/casos-de-uso.svg)

### Classes

![Diagrama de classes do BiblioTech](docs/classes.svg)

## 5. Tecnologias utilizadas

- Java
- Java Swing para a interface grafica
- Git e GitHub para controle de versao

## 6. Como executar

Abra o terminal na pasta `bibliotech`.

Para compilar os arquivos Java:

```bash
javac *.java
```

Para executar os testes dos requisitos:

```bash
java TesteRequisitos
```

Para abrir a interface grafica:

```bash
java TelaBiblioteca
```

## 7. Requisitos e verificacoes

| # | Onde esta no codigo | Como verifico |
|---|---|---|
| RF01 | `Biblioteca.cadastrarLivro()` | Ainda precisa de um teste especifico de cadastro de livro. |
| RF02 | `Biblioteca.cadastrarLeitor()` | `TesteRequisitos`: verifica se o leitor cadastrado aparece na busca. |
| RF03 | `Biblioteca.buscarLivro()` e `Livro.estaDisponivel()` | `TesteRequisitos`: verifica a disponibilidade de um livro novo e a busca de um titulo inexistente. |
| RF04 | `Biblioteca.devolver()` e `Emprestimo.registrarDevolucao()` | `TesteRequisitos`: verifica a devolucao aceita, a disponibilidade apos devolver e a recusa de uma segunda devolucao. |
| RF05 | `Biblioteca.emprestar()` e `Emprestimo.realizarEmprestimo()` | `TesteRequisitos`: verifica o emprestimo aceito, a indisponibilidade do livro emprestado e a recusa de emprestimos invalidos. |
| RF06 | Ainda nao implementado | Sem verificacao automatizada. |

## 8. O que o BiblioTech ainda nao faz

- **HU05 / RF06:** o sistema ainda nao consulta emprestimos atrasados, pois nao possui controle completo de prazo e vencimento.
- **RNF02:** ainda nao existe login para identificar a bibliotecaria antes de permitir alteracoes no acervo.
- **Cadastro pela janela:** os livros e leitores de exemplo sao cadastrados no metodo `main` de `TelaBiblioteca`; ainda nao ha formularios para cadastrar novos livros e leitores pela interface.
- **Armazenamento permanente:** os dados sao mantidos durante a execucao do programa. Ao fechar a aplicacao, os dados cadastrados em memoria se perdem.

## 9. Observacoes

- A classe `TesteRequisitos` executa verificacoes automaticas pelo terminal.
- A classe `TelaBiblioteca` abre a interface grafica.
- Os testes dependem do funcionamento das classes `Biblioteca`, `Livro`, `Leitor` e `Emprestimo`.
- A tabela de requisitos deve ser atualizada quando novas funcionalidades forem implementadas e testadas.
