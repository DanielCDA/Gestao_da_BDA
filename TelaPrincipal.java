import javax.swing.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        setTitle("Gestão da Boutique BDA");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criar barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Criar menus
        JMenu menuProdutos = new JMenu("Produtos");
        JMenu menuClientes = new JMenu("Clientes");
        JMenu menuVendas = new JMenu("Vendas");

        // Itens de Produtos
        JMenuItem itemCadastrarProduto = new JMenuItem("Cadastrar Produto");
        JMenuItem itemListarProduto = new JMenuItem("Listar Produtos");
        menuProdutos.add(itemCadastrarProduto);
        menuProdutos.add(itemListarProduto);

        // Itens de Clientes
        JMenuItem itemCadastrarCliente = new JMenuItem("Cadastrar Cliente");
        JMenuItem itemListarCliente = new JMenuItem("Listar Clientes");
        menuClientes.add(itemCadastrarCliente);
        menuClientes.add(itemListarCliente);

        // Itens de Vendas
        JMenuItem itemNovaVenda = new JMenuItem("Nova Venda");
        JMenuItem itemListarVendas = new JMenuItem("Histórico de Vendas");
        menuVendas.add(itemNovaVenda);
        menuVendas.add(itemListarVendas);

        // Adicionar menus na barra
        menuBar.add(menuProdutos);
        menuBar.add(menuClientes);
        menuBar.add(menuVendas);

        // Colocar no frame
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
