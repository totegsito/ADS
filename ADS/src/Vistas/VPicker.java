package Vistas;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

    public void setjCheckBox(JCheckBox jCheckBox) {
        this.jCheckBox = jCheckBox;
    }

    public void setTexto(List<JTextField> texto) {
        this.texto = texto;
    }

    public List<JTextField> getTexto() {
        return texto;
    }

    public VPicker(String name, int params){
        texto = new ArrayList<>(params);
        this.jCheckBox = new JCheckBox(name);
        /*this.jCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(jCheckBox.isSelected()){
                    for (JTextField text:
                            texto) {
                        text.setEditable(true);

                    }
                }else{
                    for(JTextField text: texto){
                        text.setEditable(false);
                    }
                }
            }
        });*/
        for(int i = 0; i<params;i++){
            texto.add(new JTextField());
        }

        for(JTextField text : texto){
            text.setEditable(false);
            text.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (text.getText().length() >= (20/params) ) // limit textfield to 3 characters
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
