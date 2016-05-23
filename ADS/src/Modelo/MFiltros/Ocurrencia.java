package Modelo.MFiltros;


public class Ocurrencia extends MFiltro {

    public Ocurrencia(String contenido, String palabra) {
        super(contenido, palabra);
    }

    public String buscar(){
        return "La busqueda de " + palabra + " ha dado resultado " + (contenido.contains(palabra) ? "positivo" : "negativo") + "\r";
    }
}
