package Controlador;

import Modelo.MBusqueda;
import Modelo.MDocumento.Documento;
import Modelo.MDocumento.DocumentoHTML;
import Modelo.MDocumento.DocumentoTexto;
import Vistas.VBusqueda;
import Vistas.VPicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Frank on 27/04/2016.
 */
public class CBusqueda {


    private MBusqueda modelo;
    private VBusqueda vista;
    private ActionListener find = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    public CBusqueda(MBusqueda modelo, VBusqueda vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void start() {
        System.out.println("Estoy dentro del controlador");
        vista.getBuscar().addActionListener(find);
        //vista.cb1.addChangeListener(cb1listener);
        //vista.changeLi
        vista.setTitle("Buscador");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        List<VPicker> listPicker = vista.getvPickerList();
        for (VPicker aux:
             listPicker) {
            aux.getjCheckBox().addChangeListener(e-> defineChangeListener(aux));
        }
    }

    private void defineChangeListener(VPicker aux){
        if(aux.getjCheckBox().isSelected()){
            for(JTextField tf : aux.getTexto()){
                tf.setEditable(true);
            }
        }else{
            for(JTextField tf : aux.getTexto()){
                tf.setEditable(false);
            }
        }
    }

    private void search(){
        String url = vista.getURL();
        if (!url.equals("")) {
            Documento documento;
            if (url.matches("(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!10(?:\\.\\d{1,3}){3})(?!127(?:\\.\\d{1,3}){3})(?!169\\.254(?:\\.\\d{1,3}){2})(?!192\\.168(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)*(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}]{2,})))(?::\\d{2,5})?(?:/[^\\s]*)?"))
                documento = new DocumentoHTML(url);
            else
                documento = new DocumentoTexto(url);
            documento.parse();


            modelo.startFinding();

        }
    }


}
