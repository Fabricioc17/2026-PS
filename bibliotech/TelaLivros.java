import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TelaLivros extends JFrame {

    private final LivroDAO dao = new LivroDAO();
    private final DefaultTableModel modelo;
    private final JTable tabela;

    private final Color COR_FUNDO = new Color(240, 247, 244);
    private final Color COR_PRIMARIA = new Color(27, 94, 32);
    private final Color COR_SECUNDARIA = new Color(56, 142, 60);
    private final Color COR_LINHA_PAR = Color.WHITE;
    private final Color COR_LINHA_IMPAR = new Color(232, 245, 233);
    private final Color COR_SELECAO = new Color(165, 214, 167);
    private final Color COR_TEXTO = new Color(33, 37, 41);

    private final JTextField campoId = new JTextField(8);
    private final JTextField campoTitulo = new JTextField(18);

    private final JLabel status = new JLabel("Pronto.");

    public TelaLivros() {
        setTitle("BiblioTech | Gerenciamento de Livros");
        setSize(950, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout(12, 12));
        painelPrincipal.setBackground(COR_FUNDO);
        painelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(painelPrincipal);

        modelo = new DefaultTableModel(
            new Object[]{"ID", "Capa", "Título", "Autor", "Ano"}, 0
        ) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabela = new JTable(modelo);
        estilizarTabela();

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createLineBorder(COR_SECUNDARIA, 1));
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);

        JPanel topo = new JPanel(new BorderLayout(8, 8));
        topo.setBackground(COR_FUNDO);

        JLabel tituloTela = new JLabel("Acervo BiblioTech");
        tituloTela.setFont(new Font("SansSerif", Font.BOLD, 20));
        tituloTela.setForeground(COR_PRIMARIA);
        topo.add(tituloTela, BorderLayout.NORTH);

        JPanel containerControles = new JPanel(new GridLayout(2, 1, 6, 6));
        containerControles.setBackground(COR_FUNDO);

        JPanel linhaId = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        linhaId.setBackground(COR_FUNDO);
        JButton botaoBuscarId = criarBotao("Buscar por ID", COR_PRIMARIA, Color.WHITE);
        JButton botaoLimparId = criarBotao("Limpar", new Color(220, 225, 222), COR_TEXTO);
        JButton botaoMostrarTodos = criarBotao("Mostrar todos", COR_SECUNDARIA, Color.WHITE);
        JButton botaoCapa = criarBotao("Selecionar capa", new Color(46, 125, 50), Color.WHITE);

        linhaId.add(criarLabel("ID do livro:"));
        estilizarCampo(campoId);
        linhaId.add(campoId);
        linhaId.add(botaoBuscarId);
        linhaId.add(botaoLimparId);
        linhaId.add(botaoMostrarTodos);
        linhaId.add(botaoCapa);

        JPanel linhaTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        linhaTitulo.setBackground(COR_FUNDO);
        JButton botaoBuscarTitulo = criarBotao("Buscar por título", COR_PRIMARIA, Color.WHITE);
        JButton botaoLimparTitulo = criarBotao("Limpar", new Color(220, 225, 222), COR_TEXTO);
        JButton botaoAtualizar = criarBotao("Atualizar listagem", COR_SECUNDARIA, Color.WHITE);

        linhaTitulo.add(criarLabel("Título:"));
        estilizarCampo(campoTitulo);
        linhaTitulo.add(campoTitulo);
        linhaTitulo.add(botaoBuscarTitulo);
        linhaTitulo.add(botaoLimparTitulo);
        linhaTitulo.add(botaoAtualizar);

        containerControles.add(linhaId);
        containerControles.add(linhaTitulo);
        topo.add(containerControles, BorderLayout.CENTER);
        painelPrincipal.add(topo, BorderLayout.NORTH);

        status.setFont(new Font("SansSerif", Font.BOLD, 13));
        status.setForeground(COR_PRIMARIA);
        painelPrincipal.add(status, BorderLayout.SOUTH);

        botaoBuscarId.addActionListener(e -> buscarLivro());
        botaoMostrarTodos.addActionListener(e -> carregarLivros());
        botaoAtualizar.addActionListener(e -> carregarLivros());
        botaoBuscarTitulo.addActionListener(e -> buscarPorTitulo());
        botaoCapa.addActionListener(e -> selecionarCapa());

        botaoLimparId.addActionListener(e -> campoId.setText(""));
        botaoLimparTitulo.addActionListener(e -> campoTitulo.setText(""));

        campoId.addActionListener(e -> buscarLivro());
        campoTitulo.addActionListener(e -> buscarPorTitulo());

        carregarLivros();
    }
    private void selecionarCapa() {
        int linha = tabela.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um livro na tabela.");
            return;
        }

        int linhaModelo = tabela.convertRowIndexToModel(linha);
        int id = (int) modelo.getValueAt(linhaModelo, 0);

        JFileChooser seletor = new JFileChooser();
        seletor.setDialogTitle("Selecione a capa do livro");
        seletor.setFileFilter(new FileNameExtensionFilter("Imagens JPG e PNG", "jpg", "jpeg", "png"));

        if (seletor.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        Path destino = null;

        try {
            destino = Path.of(ImagemLivro.salvar(seletor.getSelectedFile().toPath(), id));
            boolean atualizado = dao.atualizarCapa(id, destino.toString().replace('\\', '/'));

            if (!atualizado) {
                Files.deleteIfExists(destino);
                JOptionPane.showMessageDialog(this, "Não foi possível atualizar o livro.");
                return;
            }

            carregarLivros();
            JOptionPane.showMessageDialog(this, "Capa salva com sucesso!");

        } catch (Exception ex) {
            if (destino != null) {
                try {
                    Files.deleteIfExists(destino);
                } catch (Exception ignorado) {
                }
            }
            JOptionPane.showMessageDialog(this, "Erro ao salvar capa: " + ex.getMessage());
        }
    }

    private ImageIcon criarMiniatura(String caminho) {
        if (caminho == null || caminho.isBlank()) {
            return null;
        }
        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            return null;
        }
        ImageIcon original = new ImageIcon(caminho);
        Image redimensionada = original.getImage().getScaledInstance(55, 75, Image.SCALE_SMOOTH);
        return new ImageIcon(redimensionada);
    }

    private void estilizarTabela() {
        tabela.setRowHeight(85);
        tabela.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabela.setForeground(COR_TEXTO);
        tabela.setSelectionBackground(COR_SELECAO);
        tabela.setSelectionForeground(COR_TEXTO);
        tabela.setShowVerticalLines(false);
        tabela.setGridColor(new Color(210, 230, 215));

        tabela.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        tabela.getTableHeader().setBackground(COR_PRIMARIA);
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setPreferredSize(new Dimension(0, 38));

        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(340);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(240);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(80);

        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, column == 1 ? "" : value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? COR_LINHA_PAR : COR_LINHA_IMPAR);
                }

                if (column == 0 || column == 4) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setIcon(null);
                    setForeground(COR_TEXTO);
                } else if (column == 1) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                    if (value instanceof ImageIcon) {
                        setIcon((ImageIcon) value);
                        setText("");
                    } else {
                        setIcon(null);
                        setText("Sem capa");
                        setForeground(Color.GRAY);
                        setFont(new Font("SansSerif", Font.ITALIC, 12));
                    }
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setIcon(null);
                    setForeground(COR_TEXTO);
                }

                return c;
            }
        };

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(renderizador);
        }
    }

    private JButton criarBotao(String texto, Color fundo, Color textoCor) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(fundo);
        btn.setForeground(textoCor);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(7, 14, 7, 14));
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

    private void carregarLivros() {
        modelo.setRowCount(0);
        List<Livro> livros = dao.listarLivros();
        for (Livro livro : livros) {
            adicionarLinha(livro);
        }
        status.setText("Livros apresentados: " + livros.size());
    }

    private void adicionarLinha(Livro livro) {
        modelo.addRow(new Object[]{
            livro.getId(),
            criarMiniatura(livro.getCapa()),
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
            if (id <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID inteiro positivo.", "Entrada inválida", JOptionPane.WARNING_MESSAGE);
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

    private void buscarPorTitulo() {
        String titulo = campoTitulo.getText().trim();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o título do livro.", "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Livro> livros = dao.buscarLivrosPorTitulo(titulo);
        modelo.setRowCount(0);

        for (Livro livro : livros) {
            adicionarLinha(livro);
        }

        status.setText("Livros encontrados: " + livros.size());

        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum livro encontrado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLivros().setVisible(true);
        });
    }
}

