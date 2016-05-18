package Vistas;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class VBusqueda  extends JFrame {

    private java.util.List<VPicker> vPickerList;
    private static Map<String, Integer> init = Filtros.filtros;
    private JTextField vRuta;
    private JPanel p1, p2, p3, p4;

    private JCheckBox cb1, cb2, cb3, cb4, cb5;
    public JTextField cb1tf, cb2tf, cb3tf, cb4tf, cb5tf1, cb5tf2;
    public JButton buscar;


    public VBusqueda(){
        vPickerList = new ArrayList<>();
        vRuta = new JTextField();
        buscar = new JButton("Buscar");

        p1 = new JPanel(new BorderLayout());
        p1.add(vRuta, BorderLayout.CENTER);
        p1.add(buscar, BorderLayout.EAST);
        add(p1, BorderLayout.NORTH);


        p2 = new JPanel(new GridLayout(5,1));
        cb1 = new JCheckBox("Existe");
        cb1tf = new JTextField();
        cb1tf.setEditable(false);
        cb2 = new JCheckBox("Numero de Ocurrencias");
        cb2tf = new JTextField();
        cb3 = new JCheckBox("Etiquetas");
        cb3tf = new JTextField();
        cb4 = new JCheckBox("Enlaces");
        cb4tf = new JTextField();
        cb5 = new JCheckBox("Posicion");
        JPanel p2auxPanel = new JPanel(new GridLayout(1,2));

        cb5tf1 = new JTextField();
        cb5tf2 = new JTextField();

        p2auxPanel.add(cb5tf1);
        p2auxPanel.add(cb5tf2);

        p2.add(cb1);
        p2.add(cb1tf);
        p2.add(cb2);
        p2.add(cb2tf);
        p2.add(cb3);
        p2.add(cb3tf);
        p2.add(cb4);
        p2.add(cb4tf);
        p2.add(cb5);
        p2.add(p2auxPanel);


/*

        p4 = new JPanel(new GridLayout(1,2));

        p2 = new JPanel(new GridLayout(init.size(),1) );
        for (Map.Entry<String, Integer> filtro : init.entrySet()) {
            VPicker aux = new VPicker(filtro.getKey(), filtro.getValue());
            vPickerList.add(aux);
            p2.add(aux.build());
        }
*/
        add(p2, BorderLayout.CENTER);
        System.out.println("Estoy dentro de la ventana");
    }

    public String getURL(){
        return this.vRuta.getText();
    }


}
