import java.util.Scanner;

public class TesteBuscarLivro {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LivroDAO dao = new LivroDAO();

        System.out.println("=== BUSCAR LIVRO ===");

        while (true) {
            System.out.print("\nInforme o ID do livro (ou 0 para sair): ");
            int id = entrada.nextInt();

            if (id == 0) {
                System.out.println("Saindo do programa de busca...");
                break;
            }

            String livro = dao.buscarLivroPorId(id);

            if (livro != null) {
                System.out.println("Livro encontrado:");
                System.out.println(livro);
            } else {
                System.out.println("Livro não encontrado.");
            }
        }

        entrada.close();
    }
}
