package com.company.Documento;

/**
 * Created by Frank on 02/03/2016.
 */
public abstract class Documento {


    // Igual esto se podría simplificar, al fin y al cabo el nombre será parte de la ruta
    protected String nombre;
    protected String ruta;
    protected String contenido;

    public Documento(String ruta){
        this.ruta = ruta;
    }

    public Documento(String ruta, String nombre){
        this(ruta);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getContenido() {
        return contenido;
    }

    public abstract void parse();
}
