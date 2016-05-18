package Vistas;

import java.util.HashMap;
import java.util.Map;

public class Filtros {

    public static final Map<String, Integer> filtros = new HashMap<String, Integer>();
    static {
        filtros.put("Existe", 1);
        filtros.put("Numero de Ocurrencias", 1);
        filtros.put("Enlaces", 0);
        filtros.put("Etiqueta", 1);
        filtros.put("Posicion", 2);
    }
}
