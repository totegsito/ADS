package Modelo;

import Modelo.MDocumento.Documento;
import Modelo.MFiltros.MFiltro;

import java.util.HashMap;
import java.util.Map;


public class MBusqueda{
    private Documento doc;
    private Map<String, MFiltro> MFiltros;

    public MBusqueda(){
        this.MFiltros = new HashMap<>();
    }

    public void addFiltro(String key, MFiltro value){
        this.MFiltros.put(key, value);
    }

    public Map<String, MFiltro> getMFiltros(){
        return this.MFiltros;
    }

    public void startFinding(){
        String resul = "";
        for(Map.Entry<String, MFiltro> filtro : MFiltros.entrySet()){
            resul += filtro.getValue().buscar();
        }
    }



}
