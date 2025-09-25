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
       JFrame frame = new JFrame ("Login");
        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nome = new JLabel ("Nome:");
        nome.setBounds(50, 50, 80, 30);

        JLabel senha = new JLabel ("Senha:");
        senha.setBounds(50, 100, 80, 30);

        JTextField  textNome = new JTextField();
        textNome.setBounds(110, 50, 200, 30);

        JTextField  textSenha = new JTextField();
        textSenha.setBounds(110, 100, 200, 30);

        JButton botao = new JButton ("Entrar");
        botao.setBounds(250, 200, 80, 30);

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
        frame.add(textNome);
        frame.add(textSenha);
        frame.add(botao);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new CampoFuncionario();
    }
}
