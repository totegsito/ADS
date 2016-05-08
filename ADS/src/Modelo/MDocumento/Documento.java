package Modelo.MDocumento;

public abstract class Documento {

    protected String ruta;
    protected String contenido;
    private boolean caseSensitive = false;

    public Documento(String ruta) {
        this.ruta = ruta;
    }

    public Documento(String ruta, boolean caseSensitive){
        this(ruta);
        this.caseSensitive = caseSensitive;
    }

    public String getRuta() {
        return ruta;
    }

    public String getContenido() {
        return contenido;
    }

    public abstract void parse();

}
