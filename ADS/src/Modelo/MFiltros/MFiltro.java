package Modelo.MFiltros;


public abstract class MFiltro {
    protected String contenido;
    protected String palabra;
    private boolean caseSensitive;

    public MFiltro(String contenido, String palabra) {
        this.contenido = contenido;
        this.palabra = palabra;
    }

    public MFiltro(String contenido) {
        this.contenido = contenido;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra(){
        return palabra;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido(){
        return contenido;
    }

    public abstract String buscar();

}
