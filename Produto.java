import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Produto {
    private DefaultTableModel modeloTabela;
    private JTable tabelaProdutos;

    public Produto() {
         JFrame painel = new JFrame("Produtos");
         painel.setSize(1000, 600);
         painel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Layout do painel north
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


            // Layout do painel center

         JPanel painelCenter = new JPanel();
         painelCenter.setLayout(new BorderLayout());
         painelCenter.setBackground(new Color(255, 255, 255));

        String[] colunas = {"ID", "Nome", "Descrição", "Preço", "Categoria"};
        Object[][] dados = {
            {1, "Vestido Floral", "Vestido longo com estampa floral", 150.00, "Vestuário"},
            {2, "Camisa Social", "Camisa social masculina branca", 80.00, "Vestuário"},
            {3, "Calça Jeans", "Calça jeans feminina azul", 120.00, "Vestuário"},
            {4, "Bolsa de Couro", "Bolsa de couro marrom", 200.00, "Acessórios"},
            {5, "Relógio de Pulso", "Relógio analógico com pulseira de couro", 250.00, "Acessórios"},
            {6, "Tênis Esportivo", "Tênis para corrida unissex", 180.00, "Calçados"}
        };
        modeloTabela = new DefaultTableModel(dados, colunas);
        tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabelaProdutos);

         // 🔹 Ações dos botões
        botaoAdicionar.addActionListener(e -> adicionarProduto());
        botaoEditar.addActionListener(e -> editarProduto());
        botaoExcluir.addActionListener(e -> excluirProduto());

        painelCenter.add(scroll, BorderLayout.CENTER);
        painel.add(painelCenter, BorderLayout.CENTER);
         painel.add(painelNorth, BorderLayout.NORTH);
         painel.setVisible(true);
        
    }

    // Método para adicionar produto na tabela
    private void adicionarProduto() {
        String nome = JOptionPane.showInputDialog(null, "Nome do Produto:");
        if (nome == null || nome.trim().isEmpty()) return;

        String descricao = JOptionPane.showInputDialog(null, "Descrição:");
        if (descricao == null || descricao.trim().isEmpty()) return;

        String precoStr = JOptionPane.showInputDialog(null, "Preço:");
        if (precoStr == null || precoStr.trim().isEmpty()) return;
        double preco = Double.parseDouble(precoStr);

        String categoria = JOptionPane.showInputDialog(null, "Categoria:");
        if (categoria == null || categoria.trim().isEmpty()) return;

        int novoId = modeloTabela.getRowCount() + 1;
        modeloTabela.addRow(new Object[]{novoId, nome, descricao, preco, categoria});
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
   
    
 public static void main(String[] args) 
    {
        new Produto();
    }
    
}
