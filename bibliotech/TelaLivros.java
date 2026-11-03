import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaLivros extends JFrame {

    private final LivroDAO dao = new LivroDAO();

    private final DefaultTableModel modelo;
    private final JTable tabela;

    private final JTextField campoId = new JTextField(8);

    private final JLabel status = new JLabel("Pronto.");

    public TelaLivros() {

        setTitle("BiblioTech - Consulta de Livros");
        setSize(900, 450); // Aumentado um pouco para caber o novo botão
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(8, 8));

        modelo = new DefaultTableModel(
            new Object[]{"ID", "Título", "Autor", "Ano"}, 0
        ) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabela = new JTable(modelo);

        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel controles = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton atualizar = new JButton("Atualizar listagem");
        JButton buscar = new JButton("Buscar por ID");
        JButton mostrarTodos = new JButton("Mostrar todos");
        
        // DESAFIO 3: Criando o botão Limpar
        JButton limpar = new JButton("Limpar");

        controles.add(new JLabel("ID do livro:"));
        controles.add(campoId);
        controles.add(buscar);
        controles.add(limpar); // Adicionando o botão Limpar na tela
        controles.add(atualizar);
        controles.add(mostrarTodos);

        add(controles, BorderLayout.NORTH);
        add(status, BorderLayout.SOUTH);

        // Ouvintes de eventos dos botões
        atualizar.addActionListener(e -> carregarLivros());
        mostrarTodos.addActionListener(e -> carregarLivros());
        buscar.addActionListener(e -> buscarLivro());
        
        // DESAFIO 3: Configuração do botão Limpar
        limpar.addActionListener(e -> {
            campoId.setText("");
            campoId.requestFocus();
        });

        // DESAFIO 2: Configuração para buscar pressionando ENTER no campo de texto
        campoId.addActionListener(e -> {
            buscarLivro();
        });

        carregarLivros();
    }

    private void carregarLivros() {
        modelo.setRowCount(0);
        List<Livro> livros = dao.listarLivros();

        for (Livro livro : livros) {
            adicionarLinha(livro);
        }

        // DESAFIO 1: A interface já apresenta a contagem de registros aqui:
        status.setText("Livros apresentados: " + livros.size());
    }

    private void adicionarLinha(Livro livro) {
        modelo.addRow(new Object[]{
            livro.getId(),
            livro.getTitulo(),
            livro.getAutor(),
            livro.getAno()
        });
    }

    private void buscarLivro() {
        String texto = campoId.getText().trim();
        int id;

        try {
            id = Integer.parseInt(texto);
            if (id <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Informe um ID inteiro positivo.",
                "Entrada inválida",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Livro livro = dao.buscarLivroPorId(id);
        modelo.setRowCount(0);

        if (livro == null) {
            status.setText("Nenhum livro encontrado para o ID " + id);
            JOptionPane.showMessageDialog(this, "Livro não encontrado.");
        } else {
            adicionarLinha(livro);
            status.setText("Livro encontrado: " + livro.getTitulo());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLivros().setVisible(true);
        });
    }
}
