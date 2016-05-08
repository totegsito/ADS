package Modelo.MFiltros;

/**
 * Created by Frank on 04/04/2016.
 */
public class Ocurrencia extends Filtro{

    public Ocurrencia(String contenido, String palabra) {
        super(contenido, palabra);
    }

    public String buscar(){
        return contenido.contains(palabra) ? "Existe" : "No existe";
    }
}
