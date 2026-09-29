/*
Disciplina: 2026-PS
Projeto: bibliotech
Arquivo: Livro.java
Autor: Fabricio Candido
Descrição: A caixa "Livro" do diagrama de classes, em java (aula37)

*/

public class Livro{
// Atributos: a faixa do meio da caixa, por uma linha, todos private
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponivel; // não esta na caixa o codigo pediu

// Contrutor preenche a ficha do livro no momento do new
public Livro(String titulo, String autor, int ano){
    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
    this.disponivel = true;
}
// GETTERS: as janelas de leitura.
public String getTitulo(){
    return titulo;
}
public String getAutor(){
    return autor;
}
public int getAno(){
    return ano;
}

// Opperação da caixa: estaDisponivel(), a faixa de baixo do diagrama
public boolean estaDisponivel(){
    return disponivel;
}

// Os doi metodos que o emprestimo vai uar na auka 38.
public void emprestar(){
    this.disponivel = false;
}
public void devolver(){
    this.disponivel = true;
}

//toString: como a ficha se apresenta aula34
public String toString(){
    String situacao = disponivel? "disponivel" : "emprestado";
    return titulo + " (" + autor + "," + ano +") - " + situacao;
}
}