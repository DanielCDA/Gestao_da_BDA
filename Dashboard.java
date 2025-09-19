import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Gestão da Boutique BDA");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel lateral (menu)
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(9, 1)); // menu vertical
        menuPanel.setBackground(new Color(0, 102, 153)); // azul
        menuPanel.setPreferredSize(new Dimension(200, 0));

        // Botões do menu
        String[] opcoes = {"Produto", "Estoque", "Cliente", "Venda", "Usuário", "Configuração", "Relatório", "Fala Conosco", "Sair"};
        for (String opcao : opcoes) {
            JButton btn = new JButton(opcao);
            btn.setFocusPainted(false);
            btn.setBackground(Color.WHITE);
            menuPanel.add(btn);
        }

        // Painel central
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BorderLayout());

        // Painel de cards de resumo
        JPanel resumoPanel = new JPanel();
        resumoPanel.setLayout(new GridLayout(1, 3, 10, 10));
        resumoPanel.add(criarCard("Produto", "Total 7"));
        resumoPanel.add(criarCard("Venda", "Total 16"));
        resumoPanel.add(criarCard("Estoque", "Total 6"));

        // Painel de tabela
        String[] colunas = {"ID", "Nome", "Descrição", "Preço", "Categoria"};
        Object[][] dados = {
                {1, "Os segredos da mente", "Aprenda a enriquecer", 43.00, "Livro"},
                {2, "Notebook Dell Inspiron", "Notebook", 6143.00, "Informática"},
                {3, "Kimono de Judô Adulto", "Tamanho G", 399.00, "Esporte"}
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
        new Dashboard();
    }
}
