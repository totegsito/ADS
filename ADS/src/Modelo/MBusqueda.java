package Modelo;

import Modelo.MDocumento.Documento;
import Modelo.MFiltros.MFiltro;

import java.util.ArrayList;

/**
 * Created by Frank on 27/04/2016.
 */
public class MBusqueda{
    private Documento doc;
    private ArrayList<MFiltro> MFiltros;

    public MBusqueda(){
        this.MFiltros = new ArrayList<MFiltro>();
    }

    public void addFiltro(MFiltro MFiltro){
        this.MFiltros.add(MFiltro);
    }

    public ArrayList<MFiltro> getMFiltros(){
        return this.MFiltros;
    }



}
