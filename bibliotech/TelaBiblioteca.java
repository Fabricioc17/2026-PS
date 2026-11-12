import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaBiblioteca extends JFrame {
    private Biblioteca biblioteca;
    private JTextField campoTitulo;
    private JTextField campoMatricula;
    private JTextArea areaAcervo;

    private final Color COR_FUNDO = new Color(240, 247, 244);
    private final Color COR_PRIMARIA = new Color(27, 94, 32);
    private final Color COR_SECUNDARIA = new Color(56, 142, 60);
    private final Color COR_TEXTO = new Color(33, 37, 41);

    public TelaBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("BiblioTech | Sistema de Biblioteca");
        setSize(820, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout(12, 12));
        painelPrincipal.setBackground(COR_FUNDO);
        painelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(painelPrincipal);

        JPanel topo = new JPanel(new BorderLayout(10, 10));
        topo.setBackground(COR_FUNDO);

        JLabel tituloTela = new JLabel("BiblioTech | Controle de Empréstimos");
        tituloTela.setFont(new Font("SansSerif", Font.BOLD, 20));
        tituloTela.setForeground(COR_PRIMARIA);
        topo.add(tituloTela, BorderLayout.NORTH);

        JPanel campos = new JPanel(new GridLayout(2, 2, 10, 8));
        campos.setBackground(COR_FUNDO);

        campoTitulo = new JTextField();
        campoMatricula = new JTextField();
        estilizarCampo(campoTitulo);
        estilizarCampo(campoMatricula);

        campos.add(criarLabel("Título do livro:"));
        campos.add(campoTitulo);
        campos.add(criarLabel("Matrícula do leitor:"));
        campos.add(campoMatricula);
        topo.add(campos, BorderLayout.CENTER);

        painelPrincipal.add(topo, BorderLayout.NORTH);

        areaAcervo = new JTextArea();
        areaAcervo.setEditable(false);
        areaAcervo.setLineWrap(true);
        areaAcervo.setWrapStyleWord(true);
        areaAcervo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        areaAcervo.setForeground(COR_TEXTO);
        areaAcervo.setBackground(Color.WHITE);
        areaAcervo.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(areaAcervo);
        scroll.setBorder(BorderFactory.createLineBorder(COR_SECUNDARIA, 1));
        painelPrincipal.add(scroll, BorderLayout.CENTER);
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        botoes.setBackground(COR_FUNDO);

        JButton botaoEmprestar = criarBotao("Emprestar", COR_PRIMARIA, Color.WHITE);
        JButton botaoDevolver = criarBotao("Devolver", new Color(46, 125, 50), Color.WHITE);
        JButton botaoAtualizar = criarBotao("Atualizar acervo", new Color(220, 225, 222), COR_TEXTO);
        JButton botaoConsultar = criarBotao("Consultar livros (MariaDB)", COR_SECUNDARIA, Color.WHITE);
        JButton botaoPerfil = criarBotao("Meu Perfil", new Color(27, 94, 32), Color.WHITE);
        botaoPerfil.addActionListener(e -> new TelaPerfil("Ana Silva", "2026011", 2).setVisible(true));

        botaoEmprestar.addActionListener(e -> emprestar());
        botaoDevolver.addActionListener(e -> devolver());
        botaoAtualizar.addActionListener(e -> atualizarAcervo());
        botaoConsultar.addActionListener(e -> new TelaLivros().setVisible(true));

        botoes.add(botaoEmprestar);
        botoes.add(botaoDevolver);
        botoes.add(botaoAtualizar);
        botoes.add(botaoConsultar);
        botoes.add(botaoPerfil);
        painelPrincipal.add(botoes, BorderLayout.SOUTH);

        atualizarAcervo();
    }

    private JButton criarBotao(String texto, Color fundo, Color textoCor) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(fundo);
        btn.setForeground(textoCor);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(8, 15, 8, 15));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JLabel criarLabel(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 13));
        lbl.setForeground(COR_TEXTO);
        return lbl;
    }

    private void estilizarCampo(JTextField campo) {
        campo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COR_SECUNDARIA, 1),
            new EmptyBorder(5, 8, 5, 8)
        ));
    }

    private void atualizarAcervo() {
        areaAcervo.setText(biblioteca.obterAcervoComoTexto());
        areaAcervo.setCaretPosition(0);
    }

    private void emprestar() {
        String titulo = campoTitulo.getText().trim();
        String matricula = campoMatricula.getText().trim();

        if (titulo.isEmpty() || matricula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o título e a matrícula.");
            return;
        }

        boolean resultado = biblioteca.emprestar(titulo, matricula);
        atualizarAcervo();

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Empréstimo realizado.");
        } else {
            JOptionPane.showMessageDialog(this,
                "Empréstimo recusado. Confira o título, a matrícula, a disponibilidade e o limite do leitor.");
        }
    }

    private void devolver() {
        String titulo = campoTitulo.getText().trim();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o título do livro.");
            return;
        }

        boolean resultado = biblioteca.devolver(titulo);
        atualizarAcervo();

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Devolução registrada.");
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum empréstimo ativo encontrado para esse título.");
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        biblioteca.cadastrarLivro(new Livro("Capitães da Areia", "Jorge Amado", 1937));
        biblioteca.cadastrarLeitor(new Leitor("Pedro Alves", "2026010", 1));
        biblioteca.cadastrarLeitor(new Leitor("Ana Lima", "2026011", 2));

        SwingUtilities.invokeLater(() -> {
            TelaBiblioteca tela = new TelaBiblioteca(biblioteca);
            tela.setVisible(true);
        });
    }
}
