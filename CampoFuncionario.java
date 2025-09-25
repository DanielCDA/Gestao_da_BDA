import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CampoFuncionario {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minha Primeira Janela");
        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Criar o JPanel
        JPanel panel = new JPanel();

        // Adicionar componentes ao JPanel
        JLabel label = new JLabel("Olá, Daniel!");
        JButton botao = new JButton("Clique aqui");

        panel.add(label);
        panel.add(botao);

        botao.addActionListener(e -> {
            
            JOptionPane.showMessageDialog(frame, panel, "Título da Janela", JOptionPane.INFORMATION_MESSAGE);
        // Limpar campos após exibir a mensagem
       
        });

        


        // Adicionar o JPanel ao JFrame
        frame.add(panel);


        frame.setVisible(true);
    }
    }
