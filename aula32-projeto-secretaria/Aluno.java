/*
Disciplina: 2026-peso
Estudante: Fabricio Candido Ferreira
Data: 2026/08/11
Projeto: aula332-projeto-secretaria
Arquivo: Aluno.Java

*/

/*
A classe é o molde da ficha
Ele não guarda os dados de ninguem: descreve o que toda ficha de aluno
tem (nome,matricula, cuso) e o que ela sabe fazer. Cada "new Aluno(...)"
no main carimba uma ficha nova a partir deste molde
Regra de java o arquivo tem que ter o mesmo nome que a classe 

*/

public class Aluno {
/*
Atributos os campos impressos na ficha
// Private: so o codigo desta classe mexe neles. de fora ninguem escreve direto; tem que passar pelos metodos publicos la embaixo
*/
    private String nome;
    private String matricula;
    private String curso;
    private String time;
    

// CONSTRUTOR: roda no momento do "new" e preenche a ficha.
// E o __init__ de voces, em Java. Tem o mesmo nome da classe e nao
// declara tipo de retorno. Os valores chegam de fora, entre parenteses.

public Aluno(String nome, String matricula, String curso , String time) {
    // "this" = ESTA ficha aqui (o self do Java).
    // this.nome e o atributo da ficha; nome, sozinho, e o parametro
    // que acabou de chegar. Sem o this, os dois seriam o parametro.
    this.nome = nome;
    this.matricula = matricula;
    this.curso = curso;
    this.time = time;
}

// GETTERS: as janelas de leitura da ficha.
// Devolvem o valor guardado sem deixar ninguem de fora alterar.
// Padrao do nome: get + Atributo, com a primeira letra maiuscula.
public String getNome() {
    return nome;
}

public String getMatricula() {
    return matricula;
}

public String getCurso() {
    return curso;
}

public String getTime(){
    return time;
}

// SETTERS: a unica porta de entrada para mudar um dado da ficha.
// Hoje eles so trocam o valor, mas e aqui que um dia entra a regra
// ("nome vazio nao vale", "curso tem que existir").
// Repare que nao existe setMatricula: matricula nao muda, por decisao
// do projeto. Sem setter, ninguem altera - nem por engano.
public void setNome(String nome) {
    this.nome = nome;
}

public void setCurso(String curso) {
    this.curso = curso;
}

public void setTime(String time){
    this.time = time;
}
//toString: Como a ficha vai aparecer quando alguem manda emprimila
// Sem ele:, System.out.println(aluno) mostra Aluno@7ad041f3
// o @Override avisa o compilador: estou trocando um metodo que toda classe ja tem por uma versão minha 
public String toString(){
    return matricula + "|" + nome + "|"+ curso +"|" + time;
}
}