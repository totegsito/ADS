package Controlador;

import Modelo.MBusqueda;
import Modelo.MDocumento.Documento;
import Modelo.MDocumento.DocumentoHTML;
import Modelo.MDocumento.DocumentoTexto;
import Modelo.MFiltros.MFiltro;
import Vistas.VBusqueda;
import Vistas.VPicker;
import Vistas.VResults;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
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
            boolean isFileSystem = url.matches("^(?:[\\w]\\:|\\\\)(\\\\[a-z_\\-\\s0-9\\.]+)+\\.(txt|html|xhtml|xml|json|md|php)");
            boolean isValidURL = false;
            if (isURL) {
                documento = new DocumentoHTML(url);
                if(getConnectionStatus()){
                    isValidURL = true;
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede acceder al recurso", "Fallo de conexion", JOptionPane.ERROR_MESSAGE);
                }
            } else if(isFileSystem)
                documento = new DocumentoTexto(url);
            else{
                documento = null;
                JOptionPane.showMessageDialog(null, "La ruta no es valida", "Ruta incorrecta", JOptionPane.ERROR_MESSAGE);
            }
            if(isValidURL||isFileSystem){
                find(documento);
            }
            }else{
            JOptionPane.showMessageDialog(null, "La ruta no puede estar vacía", "Dirección vacia", JOptionPane.ERROR_MESSAGE );
        }
    }


    private void find( Documento documento){
        documento.parse();
        if (!vista.getCaseSensitiveCB().isSelected()) {
            documento.lowerCase();
        }

        List<MFiltro> filtros = modelo.getMFiltros();
        List<VPicker> pickers = vista.getvPickerList();
        for (int i = 0; i < filtros.size(); i++) {
            String nuevo = "";
            boolean cent = false;
            for (JTextField textField : pickers.get(i).getTexto()) {
                if(textField.isEditable()){
                    cent = !cent;
                    nuevo += textField.getText() + ";";
                }
            }
            if(cent)
                nuevo = nuevo.substring(0, nuevo.lastIndexOf(';')-1);
            filtros.get(i).setPalabra(nuevo);
        }

        String result = modelo.startFinding(documento.getContenido());

        VResults results = new VResults(result);
        results.getSalvar().addActionListener(e->saveResults(results, result));
        results.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                results.dispose();
            }
        });
        results.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        results.pack();
        results.setResizable(false);
        results.setVisible(true);
    }

    private void saveResults(VResults results, String result){
        JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
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
        results.dispose();
    }


    private boolean getConnectionStatus () {
        boolean conStatus;
        try {
            URL u = new URL(vista.getURL());
            HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
            huc.connect();
            conStatus = true;
        } catch (Exception e) {
            conStatus = false;
        }
        return conStatus;
    }


}
