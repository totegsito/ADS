package Modelo.MFiltros;

/**
 * Created by Frank on 04/04/2016.
 */
public class Ocurrencia extends MFiltro {

    public Ocurrencia(String contenido, String palabra) {
        super(contenido, palabra);
    }

    public String buscar(){
        return "La busqueda de " + palabra + " ha dado resultado " + (contenido.contains(palabra) ? "positivo" : "negativo") + "\r";
    }
}
