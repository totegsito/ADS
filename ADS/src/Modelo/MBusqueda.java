package Modelo;

import Modelo.MDocumento.Documento;
import Modelo.MFiltros.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MBusqueda{
    private Documento doc;
    private List<MFiltro> MFiltros = new ArrayList<>();
    private boolean[] activos;


    public MBusqueda(){
        this.MFiltros = new ArrayList<>();
        MFiltros.add(new Enlaces("", ""));
        MFiltros.add(new PerfilFormulario("", ""));
        MFiltros.add(new Ocurrencia("", ""));
        MFiltros.add(new NumeroOcurrencias("", ""));
        MFiltros.add(new Etiqueta("", ""));
        MFiltros.add(new Cabeceras("", ""));
        activos = new boolean[MFiltros.size()];
    }

    public void setState(int pos){
        activos[pos] = !activos[pos];
    }

    public List<MFiltro> getMFiltros(){
        return this.MFiltros;
    }

    public String startFinding(String content){
        String resul = "";
        for(int i = 0; i<MFiltros.size(); i++){
            MFiltros.get(i).setContenido(content);
            if(activos[i])
                resul += MFiltros.get(i).buscar();
        }
        return resul;
    }



}
