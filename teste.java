
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class teste {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minha Primeira Janela");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showInputDialog(null, "Categoria:");
        frame.setVisible(true);
    }    
}
