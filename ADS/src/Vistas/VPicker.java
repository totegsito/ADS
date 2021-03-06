package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class VPicker {
    private JCheckBox jCheckBox;
    private List<JTextField> texto;


    public JCheckBox getjCheckBox() {
        return jCheckBox;
    }

    public List<JTextField> getTexto() {
        return texto;
    }

    public VPicker(String name, int params){
        texto = new ArrayList<>(params);
        this.jCheckBox = new JCheckBox(name);

        for(int i = 0; i<params;i++){
            texto.add(new JTextField());
        }

        for(JTextField text : texto){
            text.setEditable(false);
            text.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (text.getText().length() >= (20/params) )
                        e.consume();
                }
            });
        }
    }

    public JPanel build(){
        JPanel result = new JPanel(new GridLayout(1,2));
        result.add(jCheckBox);
        JPanel aux = new JPanel(new GridLayout(1,texto.size()));
        for (JTextField jtextfield : texto) {
            aux.add(jtextfield);
        }
        result.add(aux);
        return result;
    }


}
