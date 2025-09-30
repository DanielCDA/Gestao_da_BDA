import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;




public class CampoFuncionario extends JPanel {
     private DefaultTableModel modeloTabela;
    private JTable tabelaProdutos;

    public CampoFuncionario() {
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

        String[] colunas = {"ID", "Nome", "Número de Telefone", "Endereço", "Categoria"};
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

    // public CampoFuncionario() {
    //     frame = new JFrame("Minha Primeira Janela");
    //     frame.setSize(800, 600);

    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     // Criar o JPanel
    //     JPanel panel = new JPanel();

    //     // Adicionar componentes ao JPanel
    //     JLabel label = new JLabel("Olá, Daniel!");
    //     JButton botao = new JButton("Clique aqui");

    //     botao.addActionListener(e -> 
    //     { adicionarFuncionario();   
    //     });
        

    //     // Adicionar o JPanel ao JFrame
    //     panel.add(label);
    //     panel.add(botao);
    //     frame.add(panel);


    //     frame.setVisible(true);
    // }

    private void adicionarFuncionario() {
        JFrame frame = new JFrame ("Addicionar Funcionario");
        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Criar os rótulos
        JLabel nome = new JLabel ("Nome:");
        nome.setBounds(50, 100, 80, 30);

        JLabel senha = new JLabel ("Senha:");
        senha.setBounds(50, 150, 80, 30);

        JLabel id = new JLabel ("ID:");
        id.setBounds(50, 50, 80, 30);

        JLabel telefone = new JLabel ("Telefone:");
        telefone.setBounds(350, 50, 80, 30);
        
        JPanel genero = criarCardGenero();
        genero.setBounds(350, 100, 280, 50); 
        

        // Criar os campos de texto
        JTextField  textNome = new JTextField();
        textNome.setBounds(110, 100, 200, 30);

        JTextField  textId  = new JTextField();
        textId.setBounds(110, 50, 200, 30);

        JTextField  textSenha = new JTextField();
        textSenha.setBounds(110, 150, 200, 30);

        JTextField numTelefone = new JTextField();
        numTelefone.setBounds(420, 50, 200, 30);

        JButton botao = new JButton ("Entrar");
        botao.setBounds(310, 210, 80, 30);
        botao.addActionListener(e -> {
            String nomeDigitado = textNome.getText();
            String senhaDigitada = textSenha.getText();
            String idDigitado = textId.getText();
            String telefoneDigitado = numTelefone.getText();
            // Aqui você pode adicionar a lógica para processar os dados do funcionário
            JOptionPane.showMessageDialog(frame, "Funcionário adicionado:\nNome: " + nomeDigitado + "\nSenha: " + senhaDigitada + "\nID: " + idDigitado + "\nTelefone: " + telefoneDigitado, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        });        
        frame.add(nome);
        frame.add(senha);
        frame.add(id);
        frame.add(telefone);
        frame.add(genero);
        frame.add(textNome);
        frame.add(textSenha);
        frame.add(textId);
        frame.add(numTelefone);
        frame.add(botao);
        frame.setVisible(true);


    }

    private JPanel criarCardGenero() 
    {
        JPanel card = new JPanel();
        card.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        card.setBorder(BorderFactory.createTitledBorder("Gênero"));

        // Opções de gênero
        JRadioButton masculino = new JRadioButton("Masculino");
        JRadioButton feminino = new JRadioButton("Feminino");
        
        // Grupo (para garantir que só 1 pode ser selecionado)
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(masculino);
        grupoGenero.add(feminino);

        // Adiciona ao painel
        card.add(masculino);
        card.add(feminino);

        return card;
    }

    public static void main(String[] args) {
        new CampoFuncionario();
    }
}
