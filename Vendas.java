import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// Classe que representa um item da venda
class ItemVenda {
    String produto;
    int quantidade;
    double preco;
    double subtotal;

    public ItemVenda(String produto, int quantidade, double preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.subtotal = quantidade * preco;
    }

    @Override
    public String toString() {
        return produto + " | Qtd: " + quantidade + " | Preço: " + preco + " | Subtotal: " + subtotal;
    }
}
public class Vendas extends JFrame {
     private static int contadorVendas = 1; // 🔹 gera IDs automáticos
    private JTextField campoIdVenda, campoCliente, campoTotal;
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;
    private JButton botaoAdicionar, botaoRegistrar;

    public Vendas() {
        setTitle("Registrar Venda - Boutique BDA");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(new Color(70, 130, 180)); // azul

        // 🔹 Painel superior com dados da venda
        JPanel painelSuperior = new JPanel(new GridLayout(2, 2, 10, 10));
        painelSuperior.setBackground(new Color(70, 130, 180));

        JLabel lblId = new JLabel("ID da Venda:");
        lblId.setForeground(Color.WHITE);
        painelSuperior.add(lblId);
        campoIdVenda = new JTextField(String.valueOf(contadorVendas)); // ID inicial
        campoIdVenda.setEditable(false);
        painelSuperior.add(campoIdVenda);

        JLabel lblCliente = new JLabel("Nome do Cliente:");
        lblCliente.setForeground(Color.WHITE);
        painelSuperior.add(lblCliente);
        campoCliente = new JTextField();
        painelSuperior.add(campoCliente);

        painel.add(painelSuperior, BorderLayout.NORTH);

        // 🔹 Tabela de Produtos
        String[] colunas = {"Produto", "Quantidade", "Preço Unitário", "Subtotal"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabelaProdutos);

        painel.add(scroll, BorderLayout.CENTER);

        // 🔹 Painel inferior com total e botões
        JPanel painelInferior = new JPanel(new GridLayout(2, 2, 10, 10));
        painelInferior.setBackground(new Color(70, 130, 180));

        JLabel lblTotal = new JLabel("Total Geral:");
        lblTotal.setForeground(Color.WHITE);
        painelInferior.add(lblTotal);
        campoTotal = new JTextField();
        campoTotal.setEditable(false);
        painelInferior.add(campoTotal);

        botaoAdicionar = new JButton("Adicionar Produto");
        painelInferior.add(botaoAdicionar);

        botaoRegistrar = new JButton("Registrar Venda");
        painelInferior.add(botaoRegistrar);

        painel.add(painelInferior, BorderLayout.SOUTH);

        add(painel);

        // 🔹 Ações dos botões
        botaoAdicionar.addActionListener(e -> adicionarProduto());
        botaoRegistrar.addActionListener(e -> registrarVenda());
    
}
 // Método para adicionar produto na tabela
    private void adicionarProduto() {
        String produto = JOptionPane.showInputDialog(this, "Nome do Produto:");
        if (produto == null || produto.trim().isEmpty()) return;

        String qtdStr = JOptionPane.showInputDialog(this, "Quantidade:");
        if (qtdStr == null || qtdStr.trim().isEmpty()) return ;
        int quantidade = Integer.parseInt(qtdStr);

        String precoStr = JOptionPane.showInputDialog(this, "Preço Unitário:");
        if (precoStr == null || precoStr.trim().isEmpty()) return;
        double preco = Double.parseDouble(precoStr);

        double subtotal = quantidade * preco;

        // Adiciona na tabela
        modeloTabela.addRow(new Object[]{produto, quantidade, preco, subtotal});

        // Atualiza total geral
        atualizarTotal();
    }

    // Método para somar os subtotais e atualizar campo Total
    private void atualizarTotal() {
        double total = 0.0;
        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            total += (double) modeloTabela.getValueAt(i, 3);
        }
        campoTotal.setText(String.valueOf(total));
    }

    // Método para registrar a venda (simulado)
    private void registrarVenda() {
        String cliente = campoCliente.getText();
        if (cliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do cliente!");
            return;
        }

        List<ItemVenda> itens = new ArrayList<>();
        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            String produto = (String) modeloTabela.getValueAt(i, 0);
            int quantidade = (int) modeloTabela.getValueAt(i, 1);
            double preco = (double) modeloTabela.getValueAt(i, 2);
            itens.add(new ItemVenda(produto, quantidade, preco));
        }

        double total = Double.parseDouble(campoTotal.getText());

        // 🔹 Simulando o salvamento (aqui seria no banco via DAO)
        System.out.println("Venda registrada:");
        System.out.println("ID: " + campoIdVenda.getText());
        System.out.println("Cliente: " + cliente);
        for (ItemVenda item : itens) {
            System.out.println(item);
        }
        System.out.println("Total: " + total);
        System.out.println("----------------------------------");

        JOptionPane.showMessageDialog(this, "Venda registrada com sucesso!");

        // 🔹 Prepara nova venda
        contadorVendas++;
        campoIdVenda.setText(String.valueOf(contadorVendas));
        campoCliente.setText("");
        campoTotal.setText("");
        modeloTabela.setRowCount(0); // limpa tabela
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Vendas().setVisible(true);
        });
    }
}
