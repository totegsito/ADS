package Vistas;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class VFiltros {
    public static final Map<String, Integer> filtros = new LinkedHashMap<>();
    static {
        filtros.put("Enlaces", 0);
        filtros.put("Perfil de formularios", 0);
        filtros.put("Existe", 1);
        filtros.put("Numero de Ocurrencias", 1);
        filtros.put("Etiqueta", 1);
        filtros.put("Cabeceras", 1);
        filtros.put("Valor entre dos palabras", 2);
    }
}
