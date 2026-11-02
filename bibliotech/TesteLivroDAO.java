public class TesteLivroDAO {
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();

      
        System.out.println("--- ETAPA 1: INSERÇÃO ---");
        boolean l1 = dao.adicionarLivro("O Alquimista", "Paulo Coelho", 1988);
        boolean l2 = dao.adicionarLivro("1984", "George Orwell", 1949);
        boolean l3 = dao.adicionarLivro("O Iluminado", "Stephen King", 1977);
        
        System.out.println("Inseriu Livro 1 (O Alquimista)? " + l1);
        System.out.println("Inseriu Livro 2 (1984)? " + l2);
        System.out.println("Inseriu Livro 3 (O Iluminado)? " + l3);

       
        System.out.println("\n--- TESTE ADICIONAL: REGISTRO INEXISTENTE ---");
        boolean atualizouInexistente = dao.atualizarLivro(999999, "Livro Inexistente", "Autor Desconhecido", 2026);
        boolean excluiuInexistente = dao.excluirLivro(999999);
        
        System.out.println("Atualização inexistente (esperado false): " + atualizouInexistente);
        System.out.println("Exclusão inexistente (esperado false): " + excluiuInexistente);

       
        System.out.println("\n--- ETAPAS 3 E 4: ATUALIZAÇÃO E EXCLUSÃO ---");
        
        
        System.out.println("Executando modificações de teste nas tabelas...");
    }
}
