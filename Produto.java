import javax.swing.*;
import java.awt.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Produto {
    public Produto() {
         JFrame painel = new JFrame("Produtos");
         painel.setSize(1000, 600);
         painel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Layout do painel north
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


            // Layout do painel center

         JPanel painelCenter = new JPanel();
         painelCenter.setLayout(new BorderLayout());
         painelCenter.setBackground(new Color(255, 255, 255));

        String[] colunas = {"ID", "Nome", "Descrição", "Preço", "Categoria"};
        Object[][] dados = {
            {1, "Vestido Floral", "Vestido longo com estampa floral", 150.00, "Vestuário"},
            {2, "Camisa Social", "Camisa social masculina branca", 80.00, "Vestuário"},
            {3, "Calça Jeans", "Calça jeans feminina azul", 120.00, "Vestuário"},
            {4, "Bolsa de Couro", "Bolsa de couro marrom", 200.00, "Acessórios"},
            {5, "Relógio de Pulso", "Relógio analógico com pulseira de couro", 250.00, "Acessórios"},
            {6, "Tênis Esportivo", "Tênis para corrida unissex", 180.00, "Calçados"}
        };
        TableModel modeloTabela = new DefaultTableModel(dados, colunas);
        JTable tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabelaProdutos);

        painelCenter.add(scroll, BorderLayout.CENTER);
        painel.add(painelCenter, BorderLayout.CENTER);
         painel.add(painelNorth, BorderLayout.NORTH);
         painel.setVisible(true);
        
    }
   
    
 public static void main(String[] args) 
    {
        new Produto();
    }
    
}
