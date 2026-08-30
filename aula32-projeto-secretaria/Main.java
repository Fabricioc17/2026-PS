/* 
  Disciplina: 2026-PS
  Estudante: Fabricio Candido Ferreira 
  Data: 2026/08/11 
  Projeto: aula32-projeto-secretaria 
  Arquivo: Main.java 
*/ 

import java.util.ArrayList; 
import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) { 
        Scanner teclado = new Scanner(System.in); 
        ArrayList<Aluno> lista = new ArrayList<Aluno>(); 
        
        while(true){ 
            System.out.println("============================================"); 
            System.out.println("            SECRETARIA do Fabricio          "); 
            System.out.println("============================================"); 
            System.out.println("[1] Cadastrar aluno"); 
            System.out.println("[2] Listar alunos"); 
            System.out.println("[3] Buscar Matricula"); 
            System.out.println("[4] Atualizar Curso"); 
            System.out.println("[5] Excluir Aluno"); 
            System.out.println("[6] Relatório por Curso"); 
            System.out.println("[0] Sair"); 
            System.out.print("Sua escolha: "); 
            
            String opcao = teclado.nextLine().trim(); 
            
            if(opcao.equals("0")){ 
                System.out.println("Secretaria fechada. Até a próxima!!!"); 
                break; 
            } else if (opcao.equals("1")){ 
                cadastrar(lista, teclado); 
            } else if (opcao.equals("2")){ 
                listar(lista); 
            } else if(opcao.equals("3")){ 
                buscar(lista, teclado); 
            } else if (opcao.equals("4")){ 
                atualizar(lista, teclado);
            } else if(opcao.equals("5")){
                remover(lista, teclado);
            } else if(opcao.equals("6")){
                relatorio(lista, teclado);
            } else { 
                System.out.println("Opção Inválida!!! Vale 0, 1, 2, 3, 4, 5 ou 6."); 
            } 
        } 
        teclado.close();
    } 

    static void cadastrar(ArrayList<Aluno> lista, Scanner teclado) { 
        System.out.print("Nome: "); 
        String nome = teclado.nextLine().trim(); 
        System.out.print("Matrícula: "); 
        String matricula = teclado.nextLine().trim(); 
        
        // MATRICULA UNICA: busca ANTES de inserir. Se ja existe, desiste.
        Aluno existente = buscarPorMatricula(lista, matricula);
        if (existente != null) {
            System.out.println("Ja existe ficha com a matricula " + matricula + "!");
            return; 
        }

        System.out.print("Curso: "); 
        String curso = teclado.nextLine().trim(); 
        System.out.print("Time do coração: ");
        String time = teclado.nextLine().trim();
        
        Aluno novo = new Aluno(nome, matricula, curso, time); 
        lista.add(novo); 
        System.out.println("Ficha de " + novo.getNome() + " arquivada!"); 
    } 

    static void listar(ArrayList<Aluno> lista) { 
        if(lista.size() == 0){ 
            System.out.println("Nenhuma ficha no gaveteiro.."); 
        } else { 
            System.out.println("--- FICHAS NO GAVETEIRO: " + lista.size() + " ---"); 
            for (Aluno aluno : lista){ 
                // a impressao chama o toString sozinha.
                System.out.println(aluno); 
            } 
        } 
    }

    static Aluno buscarPorMatricula(ArrayList<Aluno> lista, String matricula){ 
        for (int i = 0; i < lista.size(); i++){ 
            Aluno a = lista.get(i); 
            if (a.getMatricula().equals(matricula)) {
                return a; 
            }
        } 
        return null; 
    } 

    static void buscar(ArrayList<Aluno> lista, Scanner teclado){ 
        System.out.print("Matrícula procurada: "); 
        String matricula = teclado.nextLine().trim(); 
        
        Aluno a = buscarPorMatricula(lista, matricula); 
        
        if (a == null){ 
            System.out.println("Nenhuma ficha com a matrícula " + matricula + "."); 
            return;
        }
        System.out.println("Achei: " + a);
    }

    static void atualizar(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Matricula da ficha a atualizar: ");
        String matricula = teclado.nextLine().trim();
        
        Aluno a = buscarPorMatricula(lista, matricula);
        
        if (a == null) {
            System.out.println("Nenhuma ficha com a matricula " + matricula + ".");
            return;
        }
        
        System.out.print("Novo curso de " + a.getNome() + ": ");
        String novoCurso = teclado.nextLine().trim();
        
        a.setCurso(novoCurso);
        System.out.println("Ficha atualizada: " + a);
    }

    static void remover(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Matricula da ficha a remover: ");
        String matricula = teclado.nextLine().trim();
        
        Aluno a = buscarPorMatricula(lista, matricula);
        if (a == null) {
            System.out.println("Nenhuma ficha com a matricula " + matricula + ".");
            return;
        }
        
        System.out.print("Tem certeza que remove " + a.getNome() + "? (s/n): ");
        String resposta = teclado.nextLine().trim();
        if (resposta.equalsIgnoreCase("s")) {
            lista.remove(a); 
            System.out.println("Ficha removida.");
        } else {
            System.out.println("Remocao cancelada.");
        }
    }

    // RELATORIO: o padrao preparar -> percorrer -> usar, da Aula 29.
    static void relatorio(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.println("--- RELATORIO DA SECRETARIA ---");
        System.out.println("Total de fichas: " + lista.size());
        System.out.print("Contar alunos de qual curso? ");
        String curso = teclado.nextLine().trim();

        int contador = 0;                           // preparar (ANTES do for)
        for (int i = 0; i < lista.size(); i++) {    // percorrer
            Aluno a = lista.get(i);
            if (a.getCurso().equals(curso)) {
                contador = contador + 1;
            }
        }
        System.out.println("Alunos de " + curso + ": " + contador); // usar
    }
}
