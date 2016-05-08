import java.util.HashMap;

public class Filtros {

    private static final HashMap<String, Integer> filtros;
    static {
        filtros = new HashMap<String, Integer>();
        filtros.put("Existe", 1);
        filtros.put("Numero de Ocurrencias", 1);
        filtros.put("Enlaces", 1);
        filtros.put("Etiqueta", 1);
        filtros.put("Posicion", 2);
    }
}
