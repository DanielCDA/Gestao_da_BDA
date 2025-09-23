import javax.swing.*;
import java.awt.*;

public class Produto {
    public static void main(String[] args) 
    {
         JFrame painel = new JFrame("Produtos");
         painel.setSize(1000, 600);
         painel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Layout do painel north
         JPanel painelNorth = new JPanel();
         painelNorth.setBackground(new Color(0, 102, 153));
         painelNorth.setPreferredSize(new Dimension(1000, 100));
         
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






         

         painel.add(painelNorth, BorderLayout.NORTH);
         painel.setVisible(true);
    }
   
    
}
