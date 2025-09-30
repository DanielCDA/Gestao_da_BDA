import java.awt.*;
import javax.swing.*;




public class CampoFuncionario extends JPanel {
    private JFrame frame;

    public CampoFuncionario() {
        frame = new JFrame("Minha Primeira Janela");
        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Criar o JPanel
        JPanel panel = new JPanel();

        // Adicionar componentes ao JPanel
        JLabel label = new JLabel("Olá, Daniel!");
        JButton botao = new JButton("Clique aqui");

        botao.addActionListener(e -> 
        { adicionarFuncionario();   
        });
        

        // Adicionar o JPanel ao JFrame
        panel.add(label);
        panel.add(botao);
        frame.add(panel);


        frame.setVisible(true);
    }

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
        textNome.setBounds(110, 50, 200, 30);

        JTextField  textSenha = new JTextField();
        textSenha.setBounds(110, 100, 200, 30);

        JTextField  textId = new JTextField();
        textId.setBounds(110, 150, 200, 30);

        JTextField numTelefone = new JTextField();
        numTelefone.setBounds(420, 50, 200, 30);

        JButton botao = new JButton ("Entrar");
        botao.setBounds(310, 210, 80, 30);



        botao.addActionListener(e -> {
            String nomeDigitado = textNome.getText();
            String senhaDigitada = textSenha.getText();
            if (nomeDigitado.equals("Daniel") && senhaDigitada.equals("123"))
            {
                JOptionPane.showMessageDialog(frame, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Nome ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
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

    private Component criarCard(String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarCard'");
    }

    public static void main(String[] args) {
        new CampoFuncionario();
    }
}
