import java.awt.*;
import javax.swing.*;

public class Home extends JFrame {
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

        // Painel superior do menu com logo
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(0xede8df));

        // Carregar logo (substituir pelo caminho correto da sua imagem)
        ImageIcon logoIcon = new ImageIcon("logo.png");
        Image logoImg = logoIcon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImg));

        

        logoPanel.add(logoLabel);
     

        // Painel de botões do menu
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridLayout(10, 1, 0, 5));
        botoesPanel.setBackground(new Color(0xede8df));

        // Criar botões com ícones
        botoesPanel.add(criarBotaoMenu("Home", "icons/home.png"));
        botoesPanel.add(criarBotaoMenu("Produto", "icons/produto.png"));
        botoesPanel.add(criarBotaoMenu("Estoque", "icons/estoque.png"));
        botoesPanel.add(criarBotaoMenu("Cliente", "icons/cliente.png"));
        botoesPanel.add(criarBotaoMenu("Venda", "icons/venda.png"));
        botoesPanel.add(criarBotaoMenu("Usuário", "icons/usuario.png"));
        botoesPanel.add(criarBotaoMenu("Sair", "icons/sair.png"));

        // Adiciona logo e botões no painel do menu
        menuPanel.add(logoPanel, BorderLayout.NORTH);
        menuPanel.add(botoesPanel, BorderLayout.CENTER);

        // Painel central (onde vai o conteúdo)
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BorderLayout());

        // Exemplo de cards de resumo
        JPanel resumoPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        resumoPanel.add(criarCard("Produto", "Total 7"));
        resumoPanel.add(criarCard("Venda", "Total 16"));
        resumoPanel.add(criarCard("Estoque", "Total 6"));

        // Exemplo de tabela
        String[] colunas = {"ID", "Nome", "Descrição", "Preço", "Categoria"};
        Object[][] dados = {
                {1, "Sapato Nike", "Tênis esportivo", 120.0, "Calçado"},
                {2, "Sandália", "Sandália feminina", 80.0, "Calçado"},
                {3, "Camisa Polo", "Camisa masculina", 60.0, "Vestuário"}
        };
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollTabela = new JScrollPane(tabela);

        centralPanel.add(resumoPanel, BorderLayout.NORTH);
        centralPanel.add(scrollTabela, BorderLayout.CENTER);
       
        // Adiciona no frame
        add(menuPanel, BorderLayout.WEST);
        add(centralPanel, BorderLayout.CENTER);
        setVisible(true);

        
    }

    private JButton criarBotaoMenu(String texto, String caminhoIcone) {
        ImageIcon icon = new ImageIcon(caminhoIcone);
        Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JButton botao = new JButton(texto, new ImageIcon(img));
        botao.setHorizontalAlignment(SwingConstants.LEFT);
        botao.setBackground(Color.WHITE);
        botao.setFocusPainted(false);
        return botao;
    }

    private JPanel criarCard(String titulo, String valor) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
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
