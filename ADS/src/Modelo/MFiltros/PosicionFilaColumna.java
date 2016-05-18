package Modelo.MFiltros;

/**
 * Created by lorena on 18/05/2016.
 */
public class PosicionFilaColumna extends MFiltro {

    private String columna;

    public PosicionFilaColumna(String contenido, String fila, String columna) {
        super(contenido, fila);
        this.columna = columna;
    }

    @Override
    public String buscar() {

        String result = " ";
        String[] filas = contenido.split("\n");
        if (Integer.valueOf(palabra)< filas.length){
            String fila = filas[Integer.valueOf(palabra)];
            if (Integer.valueOf(columna)<fila.length()) {
                if (fila.charAt(Integer.valueOf(columna))!=' '){
                    String aux = fila.substring(0, Integer.valueOf(columna));
                    int lastSpaceColumn = aux.lastIndexOf(' ');
                    result = fila.substring(lastSpaceColumn, fila.substring(Integer.valueOf(columna)).indexOf(' ')).trim();
                }
            }
        }
        return result;
    }
}
