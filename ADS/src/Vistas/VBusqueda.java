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
    private JTextField[] ta;
    public JButton buscar;


    public VBusqueda(){
        vPickerList = new ArrayList<>();
        vRuta = new JTextField();
        buscar = new JButton("Buscar");
        ta = new JTextField[5];

        p1 = new JPanel(new BorderLayout());
        p1.add(vRuta, BorderLayout.CENTER);
        p1.add(buscar, BorderLayout.EAST);
        add(p1, BorderLayout.NORTH);
/*

        p4 = new JPanel(new GridLayout(1,2));
*/
        p2 = new JPanel(new GridLayout(init.size(),1) );
        for (Map.Entry<String, Integer> filtro : init.entrySet()) {
            VPicker aux = new VPicker(filtro.getKey(), filtro.getValue());
            vPickerList.add(aux);
            p2.add(aux.build());
        }

        add(p2, BorderLayout.CENTER);
        System.out.println("Estoy dentro de la ventana");
    }

    public String getURL(){
        return this.vRuta.getText();
    }


}
