package Vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class VPicker {
    private JCheckBox jCheckBox;
    private List<JTextField> texto;


    public VPicker(String name, int params){
        texto = new ArrayList<>(params);
        this.jCheckBox = new JCheckBox(name);
        for(int i = 0; i<params;i++){
            texto.add(new JTextField(20/params));
            System.out.println(20/params);
        }
    }

    public JPanel build(){
        JPanel result = new JPanel(new GridLayout(1,2));
        result.add(jCheckBox);
        JPanel aux = new JPanel(new FlowLayout());
        for (JTextField jtextfield : texto) {
            aux.add(jtextfield);
        }
        result.add(aux);
        return result;
    }


}
