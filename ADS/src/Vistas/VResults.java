package Vistas;

import javax.swing.*;
import java.awt.*;

public class VResults extends JFrame{


    private JPanel p1;
    private JScrollPane scrollPane;
    private JTextArea textArea;


    private JButton salvar;

    public JPanel getP1() {
        return p1;
    }

    public JButton getSalvar() {
        return salvar;
    }

    public VResults(String result){
        super("Resultados busqueda");


        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));

        p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        salvar = new JButton("Guardar Resultados");
        p1.add(salvar);
        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500,400));
        textArea.setText(result);
        add(p1, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }
}
