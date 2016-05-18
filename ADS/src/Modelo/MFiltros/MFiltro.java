package Modelo.MFiltros;

/**
 * Created by Frank on 04/04/2016.
 */
public abstract class MFiltro {
    protected String contenido;
    protected String palabra;
    private boolean caseSensitive;

    public MFiltro(String contenido, String palabra) {
        this.contenido = contenido;
        this.palabra = palabra;
    }

    public String getPalabra(){
        return palabra;
    }

    public String getContenido(){
        return contenido;
    }

    public abstract String buscar();

}