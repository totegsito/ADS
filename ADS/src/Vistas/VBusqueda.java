package Vistas;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VBusqueda  extends JFrame {

    private JTextField vRuta;
    private JPanel p1, p2, p3, p4;
    private List<VPicker> vPickerList;

    private Map<String, Integer> init = VFiltros.filtros;

    /*public JCheckBox cb1, cb2, cb3, cb4, cb5;
    public JTextField cb1tf, cb2tf, cb3tf, cb4tf, cb5tf1, cb5tf2;*/
    private JButton buscar;


    public JButton getBuscar() {
        return buscar;
    }

    public void setBuscar(JButton buscar) {
        this.buscar = buscar;
    }

    public List<VPicker> getvPickerList() {
        return vPickerList;
    }

    public void setvPickerList(List<VPicker> vPickerList) {
        this.vPickerList = vPickerList;
    }

    public VBusqueda(){
        vPickerList = new ArrayList<>();
        vRuta = new JTextField();
        buscar = new JButton("Buscar");

        p1 = new JPanel(new BorderLayout());
        p1.add(vRuta, BorderLayout.CENTER);
        p1.add(buscar, BorderLayout.EAST);
        add(p1, BorderLayout.NORTH);


        p4 = new JPanel(new GridLayout(1,2));

        p2 = new JPanel(new GridLayout(init.size(),1) );
        for (Map.Entry<String, Integer> filtro : init.entrySet()) {
            VPicker aux = new VPicker(filtro.getKey(), filtro.getValue());
            vPickerList.add(aux);
            p2.add(aux.build());
        }

        add(p2, BorderLayout.CENTER);
        System.out.println("Estoy dentro de la ventana");


        //p3 = new JPanel(new GridLayout())

    }



    public String getURL(){
        return this.vRuta.getText();
    }


}
