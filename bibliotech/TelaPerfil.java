import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class TelaPerfil extends JFrame {

    private final Color COR_FUNDO = new Color(240, 247, 244);
    private final Color COR_PRIMARIA = new Color(27, 94, 32);
    private final Color COR_SECUNDARIA = new Color(56, 142, 60);
    private final Color COR_CARD = Color.WHITE;
    private final Color COR_TEXTO = new Color(33, 37, 41);

    private final JLabel labelFoto = new JLabel("👤", SwingConstants.CENTER);
    private final JLabel labelNome = new JLabel();

    public TelaPerfil(String nome, String matricula, int livrosEmprestados) {
        setTitle("BiblioTech | Meu Perfil");
        setSize(450, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout(15, 15));
        painelPrincipal.setBackground(COR_FUNDO);
        painelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(painelPrincipal);

        JLabel titulo = new JLabel("Meu Perfil", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        titulo.setForeground(COR_PRIMARIA);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel cardPerfil = new JPanel(new BorderLayout(10, 15));
        cardPerfil.setBackground(COR_CARD);
        cardPerfil.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COR_SECUNDARIA, 1),
            new EmptyBorder(25, 20, 25, 20)
        ));

        JPanel painelFoto = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelFoto.setBackground(COR_CARD);
        labelFoto.setPreferredSize(new Dimension(140, 140));
        labelFoto.setFont(new Font("SansSerif", Font.PLAIN, 60));
        labelFoto.setOpaque(true);
        labelFoto.setBackground(new Color(232, 245, 233));
        labelFoto.setForeground(COR_PRIMARIA);
        labelFoto.setBorder(BorderFactory.createLineBorder(COR_PRIMARIA, 2));
        painelFoto.add(labelFoto);
        cardPerfil.add(painelFoto, BorderLayout.NORTH);

        JPanel painelInfo = new JPanel(new GridLayout(3, 1, 5, 5));
        painelInfo.setBackground(COR_CARD);

        labelNome.setText(nome);
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);
        labelNome.setFont(new Font("SansSerif", Font.BOLD, 20));
        labelNome.setForeground(COR_TEXTO);

        JLabel labelTipo = new JLabel("Leitor(a) cadastrado(a) • Matrícula: " + matricula, SwingConstants.CENTER);
        labelTipo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        labelTipo.setForeground(Color.GRAY);

        JLabel labelEmprestimos = new JLabel("Livros emprestados: " + livrosEmprestados, SwingConstants.CENTER);
        labelEmprestimos.setFont(new Font("SansSerif", Font.BOLD, 15));
        labelEmprestimos.setForeground(COR_SECUNDARIA);

        painelInfo.add(labelNome);
        painelInfo.add(labelTipo);
        painelInfo.add(labelEmprestimos);
        cardPerfil.add(painelInfo, BorderLayout.CENTER);

        painelPrincipal.add(cardPerfil, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 0));
        painelBotoes.setBackground(COR_FUNDO);

        JButton botaoEditarNome = criarBotao("Editar nome", COR_SECUNDARIA, Color.WHITE);
        JButton botaoFoto = criarBotao("Alterar fotografia", COR_PRIMARIA, Color.WHITE);

        botaoEditarNome.addActionListener(e -> editarNome());
        botaoFoto.addActionListener(e -> alterarFotografia());

        painelBotoes.add(botaoEditarNome);
        painelBotoes.add(botaoFoto);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
    }

    private JButton criarBotao(String texto, Color fundo, Color textoCor) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(fundo);
        btn.setForeground(textoCor);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(10, 14, 10, 14));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void editarNome() {
        String novoNome = JOptionPane.showInputDialog(this, "Digite o seu nome:", labelNome.getText());
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            labelNome.setText(novoNome.trim());
            JOptionPane.showMessageDialog(this, "Nome atualizado com sucesso!");
        }
    }

    private void alterarFotografia() {
        JFileChooser seletor = new JFileChooser();
        seletor.setDialogTitle("Selecione uma fotografia de perfil");
        seletor.setFileFilter(new FileNameExtensionFilter("Imagens JPG e PNG", "jpg", "jpeg", "png"));

        if (seletor.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        try {
            File origem = seletor.getSelectedFile();
            BufferedImage img = ImageIO.read(origem);

            if (img == null) {
                JOptionPane.showMessageDialog(this, "Arquivo de imagem inválido.");
                return;
            }

            Path pasta = Path.of("imagens", "usuarios");
            Files.createDirectories(pasta);

            String nomeArquivo = "perfil-" + UUID.randomUUID() + ".png";
            Path destino = pasta.resolve(nomeArquivo);
            ImageIO.write(img, "png", destino.toFile());

            Image reduzida = img.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
            labelFoto.setIcon(new ImageIcon(reduzida));
            labelFoto.setText("");

            JOptionPane.showMessageDialog(this, "Fotografia atualizada com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar foto: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPerfil("Ana Silva", "2026011", 2).setVisible(true);
        });
    }
}
