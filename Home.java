import java.awt.*;
import javax.swing.*;

public class Home extends JFrame {
    private JPanel centralPanel; 
    private JPanel homePanel;   // painel inicial guardado

    public Home() {
        setTitle("Gestão da Boutique BDA");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel lateral (menu)
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBackground(new Color(0, 102, 153));
        menuPanel.setPreferredSize(new Dimension(200, 0));

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(0xede8df));

        ImageIcon logoIcon = new ImageIcon("logo.png");
        Image logoImg = logoIcon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImg));
        logoPanel.add(logoLabel);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridLayout(9, 1, 0, 1));
        botoesPanel.setBackground(new Color(0xede8df));

        botoesPanel.add(criarBotaoMenu("Home", "icons/home.png"));
        botoesPanel.add(criarBotaoMenu("Produto", "icons/produto.png"));
        botoesPanel.add(criarBotaoMenu("Cliente", "icons/cliente.png"));
        botoesPanel.add(criarBotaoMenu("Venda", "icons/venda.png"));
        botoesPanel.add(criarBotaoMenu("Profissional", "icons/usuario.png"));
        botoesPanel.add(criarBotaoMenu("Sair", "icons/sair.png"));

        menuPanel.add(logoPanel, BorderLayout.NORTH);
        menuPanel.add(botoesPanel, BorderLayout.CENTER);

        // Painel central dinâmico
        centralPanel = new JPanel(new BorderLayout());

        // Criar e guardar o painel inicial (home)
        homePanel = criarHomePanel();
        centralPanel.add(homePanel, BorderLayout.CENTER);

        add(menuPanel, BorderLayout.WEST);
        add(centralPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    // 🔹 Cria o painel inicial (cards + tabela)
    private JPanel criarHomePanel() {
        JPanel painel = new JPanel(new BorderLayout());

        JPanel resumoPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        resumoPanel.add(criarCard("Produto", "Total 7"));
        resumoPanel.add(criarCard("Venda", "Total 16"));
        resumoPanel.add(criarCard("Estoque", "Total 6"));

        String[] colunas = {"ID", "Nome", "Descrição", "Preço", "Categoria"};
        Object[][] dados = {
                {1, "Sapato Nike", "Tênis esportivo", 120.0, "Calçado"},
                {2, "Sandália", "Sandália feminina", 80.0, "Calçado"},
                {3, "Camisa Polo", "Camisa masculina", 60.0, "Vestuário"}
        };
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollTabela = new JScrollPane(tabela);

        painel.add(resumoPanel, BorderLayout.NORTH);
        painel.add(scrollTabela, BorderLayout.CENTER);

        return painel;
    }

    private JButton criarBotaoMenu(String texto, String caminhoIcone) {
        ImageIcon icon = new ImageIcon(caminhoIcone);
        Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JButton botao = new JButton(texto, new ImageIcon(img));
        botao.setHorizontalAlignment(SwingConstants.LEFT);
        botao.setBackground(Color.WHITE);
        botao.setFocusPainted(false);

        botao.addActionListener(e -> {
            centralPanel.removeAll();
            if (texto.equals("Produto")) {
                centralPanel.add(new ProdutoPanel(), BorderLayout.CENTER);
            } else if (texto.equals("Home")) {
                centralPanel.add(homePanel, BorderLayout.CENTER);
            }
            centralPanel.revalidate();
            centralPanel.repaint();
        });

        return botao;
    }

    private JPanel criarCard(String titulo, String valor) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createTitledBorder(titulo));
        JLabel label = new JLabel(valor, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        card.add(label, BorderLayout.CENTER);
        return card;
    }

    public static void main(String[] args) {
        new Home();
    }
}
