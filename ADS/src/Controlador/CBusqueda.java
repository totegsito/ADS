package Controlador;

import Modelo.MBusqueda;
import Vistas.VBusqueda;

import javax.swing.*;

/**
 * Created by Frank on 27/04/2016.
 */
public class CBusqueda {


    private MBusqueda modelo;
    private VBusqueda vista;

    public CBusqueda(MBusqueda modelo, VBusqueda vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    public void start(){
        System.out.println("Estoy dentro del controlador");
        vista.setTitle("Buscador");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
