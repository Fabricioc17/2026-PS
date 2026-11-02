public class TesteLivroDAO {
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();

        // 1. Cadastrar O Pequeno Príncipe
        boolean cad1 = dao.adicionarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
        System.out.println("Cadastrou livro 1? " + cad1);

        // 2. Cadastrar outro livro de sua escolha
        boolean cad2 = dao.adicionarLivro("O Hobbit", "J.R.R. Tolkien", 1937);
        System.out.println("Cadastrou livro 2? " + cad2);
        
        // --- PAUSA AQUI ---
        // 3. Abra o terminal do MariaDB e rode: SELECT * FROM livros;
        // Descubra os IDs que o MariaDB gerou para os dois livros acima.
        // Exemplo: Digamos que O Pequeno Príncipe virou ID 2 e O Hobbit virou ID 3.
        
        // 4. Atualizar o título de UM dos livros (Ex: mudando o ID 2)
        boolean att = dao.atualizarLivro(2, "O Pequeno Príncipe - Edição Revisada", "Antoine de Saint-Exupéry", 1943);
        System.out.println("Atualizou livro? " + att);

        // 5. Excluir o OUTRO livro (Ex: excluindo o ID 3)
        boolean exc = dao.excluirLivro(3);
        System.out.println("Excluiu livro? " + exc);
        
        // --- FIM DO JAVA ---
        // 6. Volte no terminal do MariaDB e rode SELECT * FROM livros; de novo.
        // Você deverá ver apenas O Pequeno Príncipe com o título atualizado.
    }
}
