package Controlador;

import Modelo.MBusqueda;
import Modelo.MDocumento.Documento;
import Modelo.MDocumento.DocumentoHTML;
import Modelo.MDocumento.DocumentoTexto;
import Modelo.MFiltros.MFiltro;
import Vistas.VBusqueda;
import Vistas.VPicker;
import Vistas.VResults;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CBusqueda {


    private MBusqueda modelo;
    private VBusqueda vista;

    public CBusqueda(MBusqueda modelo, VBusqueda vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void start() {
        System.out.println("Estoy dentro del controlador");
        vista.setTitle("Buscador");
        vista.pack();
        vista.setResizable(false);
        vista.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        List<VPicker> listPicker = vista.getvPickerList();
        for (VPicker aux :
                listPicker) {
            aux.getjCheckBox().addChangeListener(e -> defineChangeListener(aux, listPicker.indexOf(aux)));
        }
        vista.getBuscar().addActionListener(e -> search());
    }

    private void defineChangeListener(VPicker aux, int pos) {
        if (aux.getjCheckBox().isSelected()) {
            for (JTextField tf : aux.getTexto()) {
                tf.setEditable(true);
            }
        } else {
            for (JTextField tf : aux.getTexto()) {
                tf.setEditable(false);
            }
        }
        modelo.setState(pos);
    }

    private void search() {
        String url = vista.getURL();
        if (!url.equals("")) {
            Documento documento;
            boolean isURL = url.matches("(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!10(?:\\.\\d{1,3}){3})(?!127(?:\\.\\d{1,3}){3})(?!169\\.254(?:\\.\\d{1,3}){2})(?!192\\.168(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)*(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}]{2,})))(?::\\d{2,5})?(?:/[^\\s]*)?");
            if (isURL) {
                documento = new DocumentoHTML(url);
            } else
                documento = new DocumentoTexto(url);
            documento.parse();
            if (!vista.getCaseSensitiveCB().isSelected()) {
                documento.lowerCase();
            }
            List<MFiltro> filtros = modelo.getMFiltros();
            List<VPicker> pickers = vista.getvPickerList();
            for (int i = 0; i < filtros.size(); i++) {
                String nuevo = "";
                for (JTextField textField : pickers.get(i).getTexto()) {
                    nuevo += textField.getText();
                }
                filtros.get(i).setPalabra(nuevo);
            }

            String result = modelo.startFinding(documento.getContenido());
            System.out.println(result);

            VResults results = new VResults(result);
            results.getSalvar().addActionListener(e->saveResults(results, result));
            results.addWindowFocusListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    results.dispose();
                }
            });
            results.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        }
    }


    private void saveResults(VResults results, String result){
        JFileChooser fc=new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        fc.setFileFilter(filtro);
        int seleccion = fc.showSaveDialog(results.getP1() );

        if(seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = fc.getSelectedFile();
            try( FileWriter fw = new FileWriter(fichero) ){

                fw.write(result);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


}
