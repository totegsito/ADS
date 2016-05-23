package Vistas;

import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class VBusqueda  extends JFrame {

    private JTextField vRuta;
    private JPanel p1, p2, p3;
    private List<VPicker> vPickerList;
    private JCheckBox caseSensitiveCB;

    private Map<String, Integer> init = VFiltros.filtros;

    private JButton buscar;

    public JButton getBuscar() {
        return buscar;
    }

    public JCheckBox getCaseSensitiveCB() {
        return caseSensitiveCB;
    }

    public List<VPicker> getvPickerList() {
        return vPickerList;
    }

    public VBusqueda(){
        super("Document Scrapper");
        vPickerList = new ArrayList<>();
        vRuta = new JTextField();
        buscar = new JButton("Buscar");

        Border border = BorderFactory.createEmptyBorder(10,10,10,10);

        p1 = new JPanel(new BorderLayout());
        p1.add(vRuta, BorderLayout.CENTER);
        p1.add(buscar, BorderLayout.EAST);
        add(p1, BorderLayout.NORTH);

        p3 = new JPanel(new GridLayout(1,2));
        p3.setBorder(border);
        caseSensitiveCB = new JCheckBox("No distinguir mayusculas");
        p3.add(caseSensitiveCB);
        add(p3, BorderLayout.CENTER);

        p2 = new JPanel(new GridLayout(init.size(),1) );
        p2.setBorder(border);
        for (Map.Entry<String, Integer> filtro : init.entrySet()) {
            VPicker aux = new VPicker(filtro.getKey(), filtro.getValue());
            vPickerList.add(aux);
            p2.add(aux.build());
        }

        add(p2, BorderLayout.SOUTH);

    }

    public String getURL(){
        return this.vRuta.getText();
    }


}
