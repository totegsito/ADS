package Vistas;

import javax.swing.*;
import java.awt.*;

public class VBusqueda  extends JFrame {
    private JTextField vRuta;
    private JPanel p1, p2, p3, p4;

    private JCheckBox cb1, cb2, cb3, cb4, cb5;
    private JTextField[] ta;
    private JButton buscar;


    public VBusqueda(){
        vRuta = new JTextField();
        buscar = new JButton("Buscar");
        ta = new JTextField[5];

        p1 = new JPanel(new BorderLayout());
        p1.add(vRuta, BorderLayout.CENTER);
        p1.add(buscar, BorderLayout.EAST);
        add(p1, BorderLayout.NORTH);

        p4 = new JPanel(new GridLayout(1,2));


        cb1 = new JCheckBox("Existe");
        cb2 = new JCheckBox("Numero de ocurrencias");
        cb3 = new JCheckBox("Enlaces");
        cb4 = new JCheckBox("Etiqueta");
        cb5 = new JCheckBox("Posicion");

        p2 = new JPanel(new GridLayout(5,1) );
        p2.add(cb1);
        p2.add(cb2);
        p2.add(cb3);
        p2.add(cb4);
        p2.add(cb5);
        p4.add(p2);


        p3 = new JPanel(new GridLayout(5,1));
        for (JTextField jTextField : ta){
            jTextField = new JTextField(20);
            p3.add(jTextField);
        }

        p4.add(p3);

        add(p4);
        System.out.println("Estoy dentro de la ventana");
    }

    public String getURL(){
        return this.vRuta.getText();
    }


}
