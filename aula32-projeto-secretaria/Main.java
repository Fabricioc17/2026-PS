/*
Disciplina: 2026-peso
Estudante: Fabricio Candido Ferreira
Data: 2026/08/11
Projeto: aula332-projeto-secretaria
Arquivo: Main.Java

*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado =new Scanner(System.in);

    //O Gaveteiro Tipado: o <Aluno> diz que so enyta na ficha de aluno aqui
        ArrayList<Aluno> lista = new ArrayList<Aluno>();

    // while (true) = repete para sempre. A unica saida e o break da opcao 0.
    
    while(true){
        System.out.println("============================================");
    System.out.println("        SECRETARIA DO SEU NOME");
    System.out.println("============================================");
    System.out.println("[1] Cadastrar aluno");
    System.out.println("[2] Listar alunos");
    System.out.println("[0] Sair");
    System.out.print("Sua escolha: ");
    String opcao = teclado.nextLine().trim();    // trim: tira espaços das pontas

// Texto se compara com .equals, nunca com == (isso vale ouro em Java).
    if(opcao.equals("0")){
        System.out.println("Secretaria fechada. Até a proxima!!!");
        break;
    }else if (opcao.equals("1")){
        cadastrar(lista, teclado);
    }else if (opcao.equals("2")){
        listar(lista);
    }else{
        System.out.println("Opcao Invalida!!! Vale 0, 1 ou 2.");
    }
    }
    }
    // Le os dados no balcao, carimba a ficha e guarda no gaveteiro.
    static void cadastrar(ArrayList<Aluno> lista, Scanner teclado) {
    System.out.print("Nome: ");
    String nome = teclado.nextLine().trim();

    System.out.println("Matricula:");
    String matricula = teclado.nextLine().trim();

    System.out.println("Curso: ");
    String curso = teclado.nextLine().trim();

    Aluno novo = new Aluno(nome, matricula, curso);
    lista.add(novo);

    System.out.println("Ficha de " + novo.getNome() + "arquivas!!");
}



    // LACUNA GUIADA: leia matricula e curso do mesmo jeito,
    // crie a ficha com new Aluno(...), guarde com lista.add(...),
    // e avise: "Ficha de " + novo.getNome() + " arquivada!"


// Percorre o gaveteiro e imprime ficha por ficha (padrao da Aula 29).
    static void listar(ArrayList<Aluno> lista) {
    if(lista.size() == 0){
        System.out.println("Nenhuma ficha no gaveteiro..");
    }else{
        System.out.println("===== Fichas no gavetreito:" + lista.size()+"===");
        for (Aluno aluno : lista){
            System.out.println( 
                aluno.getMatricula() + " | " +
                aluno.getNome() + " | " +
                aluno.getCurso()
            );
        }
    }
    // LACUNA AUTONOMA: se lista.size() == 0, avise "Nenhuma ficha..."
    // senao, imprima "--- FICHAS NO GAVETEIRO: N ---" com lista.size()
    // e percorra com for,
    // imprimindo matricula + " | " + nome + " | " + curso pelos getters


    }
}



   
    