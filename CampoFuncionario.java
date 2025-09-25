import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

        panel.add(label);
        panel.add(botao);

        botao.addActionListener(e -> {

            frame= new JFrame("Minha Primeira Janela");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
       
        });
        
        


        // Adicionar o JPanel ao JFrame
        frame.add(panel);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CampoFuncionario();
    }
}
