
## 6. Como executar

No Codespace, dentro da pasta `bibliotech`:

```bash
javac *.java
java TesteRequisitos
java TelaBiblioteca
```

`TesteRequisitos` confere os requisitos no terminal. `TelaBiblioteca` abre a janela do sistema.

## 7. Requisitos e verificações

| # | Onde está no código | Como verifico |
|---|---|---|
| RF01 | `Biblioteca.cadastrarLivro()` | `TesteRequisitos`: 1 verificação |
| RF02 | `Biblioteca.cadastrarLeitor()` | `TesteRequisitos`: 1 verificação |
| RF03 | `Biblioteca.buscarLivro()` e `Livro.estaDisponivel()` | `TesteRequisitos`: 2 verificações |
| RF04 | `Biblioteca.devolver()` e `Emprestimo.registrarDevolucao()` | `TesteRequisitos`: 3 verificações |
| RF05 | `Biblioteca.emprestar()` e `Emprestimo.realizarEmprestimo()` | `TesteRequisitos`: 5 verificações |
| RF06 | Ainda não identificado na Entrega 1 | A confirmar |

## 8. O que o BiblioTech ainda não faz

- HU05: consultar empréstimos atrasados. O empréstimo ainda não tem prazo implementado.
- RNF02: controle de acesso. Ainda não há login de bibliotecário.
- Cadastro pela janela: os livros e leitores de exemplo são cadastrados no `main` de `TelaBiblioteca`.
- Guardar os dados: ao fechar o programa, os dados cadastrados durante a execução se perdem.

## 9. Observações

- `TesteRequisitos` verifica os requisitos pelo terminal.
- `TelaBiblioteca` abre a interface gráfica do sistema.
- Os testes dependem do funcionamento das classes `Biblioteca`, `Livro`, `Leitor` e `Emprestimo`.
