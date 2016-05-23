package Modelo;

import Modelo.MDocumento.Documento;
import Modelo.MFiltros.*;

import java.util.ArrayList;
import java.util.List;


public class MBusqueda{
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
        MFiltros.add(new ValorCentral("", ""));
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
