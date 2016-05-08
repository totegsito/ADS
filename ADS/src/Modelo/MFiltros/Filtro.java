package Modelo.MFiltros;

/**
 * Created by Frank on 04/04/2016.
 */
public abstract class Filtro {
    protected String contenido;
    protected String palabra;
    private boolean caseSensitive;

    public Filtro(String contenido, String palabra) {
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
