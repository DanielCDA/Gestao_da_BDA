import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProdutoPanel extends JPanel {
    private DefaultTableModel modeloTabela;
    private JTable tabelaProdutos;

    public ProdutoPanel() {
        setLayout(new BorderLayout());

        // Painel superior (botões)
        JPanel painelNorth = new JPanel();
        painelNorth.setPreferredSize(new Dimension(1000, 40));

        JButton botaoAdicionar = new JButton("Adicionar Produto");
        botaoAdicionar.setBackground(new Color(0, 153, 76));
        botaoAdicionar.setForeground(Color.WHITE);
        botaoAdicionar.setFocusPainted(false);

        JButton botaoEditar = new JButton("Editar Produto");
        botaoEditar.setBackground(new Color(255, 153, 0));
        botaoEditar.setForeground(Color.WHITE);
        botaoEditar.setFocusPainted(false);

        JButton botaoExcluir = new JButton("Excluir Produto");
        botaoExcluir.setBackground(new Color(204, 0, 0));
        botaoExcluir.setForeground(Color.WHITE);
        botaoExcluir.setFocusPainted(false);

        painelNorth.add(botaoAdicionar);
        painelNorth.add(botaoEditar);
        painelNorth.add(botaoExcluir);

        // Painel central (tabela)
        JPanel painelCenter = new JPanel();
        painelCenter.setLayout(new BorderLayout());
        painelCenter.setBackground(Color.WHITE);

        String[] colunas = {"ID", "Nome", "Descrição", "Preço", "Categoria"};
        Object[][] dados = {};
        modeloTabela = new DefaultTableModel(dados, colunas);
        tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabelaProdutos);

        // 🔹 Ações dos botões
        botaoAdicionar.addActionListener(e -> adicionarProduto());
        botaoEditar.addActionListener(e -> editarProduto());
        botaoExcluir.addActionListener(e -> excluirProduto());

        painelCenter.add(scroll, BorderLayout.CENTER);

        // Adiciona os painéis no ProdutoPanel
        add(painelNorth, BorderLayout.NORTH);
        add(painelCenter, BorderLayout.CENTER);
    }

    // Método para adicionar produto na tabela
    private void adicionarProduto() {
        JFrame frame = new JFrame ("Adicionar Produto");
        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Criar os rótulos
        JLabel nome = new JLabel ("Nome:");
        nome.setBounds(50, 100, 80, 30);

        JLabel descricao = new JLabel ("Descrição:");
        descricao.setBounds(50, 150, 80, 30);

        JLabel preco = new JLabel ("Preço:");
        preco.setBounds(50, 200, 80, 30);

        JLabel categoria = new JLabel ("Categoria:");
        categoria.setBounds(350, 50, 80, 30);

        // Criar os campos de texto
        JTextField  textNome = new JTextField();
        textNome.setBounds(110, 100, 200, 30);

        JTextField textPreco = new JTextField();
        textPreco.setBounds(110, 200, 200, 30);

        JTextField  textDescricao = new JTextField();
        textDescricao.setBounds(110, 150, 200, 30);

        JTextField textCategoria = new JTextField();
        textCategoria.setBounds(420, 50, 200, 30);

        JButton botao = new JButton ("Entrar");
        botao.setBounds(310, 210, 80, 30);
        botao.addActionListener(e -> {
           int novoId = modeloTabela.getRowCount() + 1;
         modeloTabela.addRow(new Object[]{novoId, textNome.getText(), textDescricao.getText(), textPreco.getText(), textCategoria.getText()});
        });        
        // String nome = JOptionPane.showInputDialog(null, "Nome do Produto:");
        // if (nome == null || nome.trim().isEmpty()) return;

        // String descricao = JOptionPane.showInputDialog(null, "Descrição:");
        // if (descricao == null || descricao.trim().isEmpty()) return;

        // String precoStr = JOptionPane.showInputDialog(null, "Preço:");
        // if (precoStr == null || precoStr.trim().isEmpty()) return;
        // double preco = Double.parseDouble(precoStr);

        // String categoria = JOptionPane.showInputDialog(null, "Categoria:");
        // if (categoria == null || categoria.trim().isEmpty()) return;

         
         frame.add(nome);
        frame.add(descricao);
        frame.add(preco);
        frame.add(categoria);
        frame.add(textNome);
        frame.add(textDescricao);
        frame.add(textPreco);
        frame.add(textCategoria);
        frame.add(botao);
        frame.setVisible(true);
    }

    private void editarProduto() {
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para editar!");
            return;
        }

        String nome = JOptionPane.showInputDialog(null, "Nome do Produto:", modeloTabela.getValueAt(linhaSelecionada, 1));
        if (nome != null) modeloTabela.setValueAt(nome, linhaSelecionada, 1);

        String descricao = JOptionPane.showInputDialog(null, "Descrição:", modeloTabela.getValueAt(linhaSelecionada, 2));
        if (descricao != null) modeloTabela.setValueAt(descricao, linhaSelecionada, 2);

        String precoStr = JOptionPane.showInputDialog(null, "Preço:", modeloTabela.getValueAt(linhaSelecionada, 3));
        if (precoStr != null) {
            double preco = Double.parseDouble(precoStr);
            modeloTabela.setValueAt(preco, linhaSelecionada, 3);
        }

        String categoria = JOptionPane.showInputDialog(null, "Categoria:", modeloTabela.getValueAt(linhaSelecionada, 4));
        if (categoria != null) modeloTabela.setValueAt(categoria, linhaSelecionada, 4);
    }

    private void excluirProduto() {
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir!");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(null,
                "Tem certeza que deseja excluir este produto?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            modeloTabela.removeRow(linhaSelecionada);
        }
    }
}
