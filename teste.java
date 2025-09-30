
import javax.swing.JFrame;
import javax.swing.JList;

public class teste {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minha Primeira Janela");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JList<String> lista = new JList<>(new String[]{"Item 1", "Item 2", "Item 3"});
        frame.add(lista);
        frame.setVisible(true);
    }    
}
