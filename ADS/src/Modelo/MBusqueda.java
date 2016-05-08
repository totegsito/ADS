package Modelo;

import Modelo.MDocumento.Documento;
import Modelo.MFiltros.Filtro;

import java.util.ArrayList;

/**
 * Created by Frank on 27/04/2016.
 */
public class MBusqueda{
    private Documento doc;
    private ArrayList<Filtro> filtros;

    public MBusqueda(){
        this.filtros = new ArrayList<Filtro>();
    }

    public void addFiltro(Filtro filtro){
        this.filtros.add(filtro);
    }

    public ArrayList<Filtro> getFiltros(){
        return this.filtros;
    }



}
