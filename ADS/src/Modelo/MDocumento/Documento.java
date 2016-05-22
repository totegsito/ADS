package Modelo.MDocumento;

public abstract class Documento {

    protected String ruta;
    protected String contenido;

    public Documento(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public String getContenido() {
        return contenido;
    }

    public void lowerCase(){
        this.contenido.toLowerCase();
    }

    public abstract void parse();

}
