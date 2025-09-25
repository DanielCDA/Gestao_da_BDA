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
        
        JPanel CampoFuncionario = new JPanel();
        CampoFuncionario.setSize(new Dimension(400, 300));
        CampoFuncionario.setLayout(new GridLayout(5, 2, 10, 10));
        
       


        // String nome = JOptionPane.showInputDialog(null, "Nome do Produto:");
        // if (nome == null || nome.trim().isEmpty()) return;

        // String descricao = JOptionPane.showInputDialog(null, "Descrição:");
        // if (descricao == null || descricao.trim().isEmpty()) return;

        // String precoStr = JOptionPane.showInputDialog(null, "Preço:");
        // if (precoStr == null || precoStr.trim().isEmpty()) return;
        // double preco = Double.parseDouble(precoStr);

        // String categoria = JOptionPane.showInputDialog(null, "Categoria:");
        // if (categoria == null || categoria.trim().isEmpty()) return;

        // int novoId = modeloTabela.getRowCount() + 1;
        // modeloTabela.addRow(new Object[]{novoId, nome, descricao, preco, categoria});
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
