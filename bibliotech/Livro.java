/*
Disciplina: 2026-PS
Projeto: bibliotech
Arquivo: Livro.java
Autor: Fabricio Candido
Descrição: A caixa "Livro" do diagrama de classes, em java (aula37 + atualizacao aula43)
*/

public class Livro {
    // Atributos originais
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponivel;
    
    // FASE 2: Novo atributo para armazenar o ID do MariaDB
    private int id;

    // Construtor original (sem ID) - Usado nas aulas passadas
    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }

    // FASE 3: Novo Construtor para o MariaDB (com ID)
    public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true; // Por padrão, o livro inicia disponível
    }

    // FASE 2: Métodos de acesso para o ID do banco
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // GETTERS originais: as janelas de leitura
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    // Operação da caixa: estaDisponivel()
    public boolean estaDisponivel() {
        return disponivel;
    }

    // Métodos de empréstimo e devolução originais
    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    // toString original
    public String toString() {
        String situacao = disponivel ? "disponivel" : "emprestado";
        return titulo + " (" + autor + "," + ano + ") - " + situacao;
    }
}
