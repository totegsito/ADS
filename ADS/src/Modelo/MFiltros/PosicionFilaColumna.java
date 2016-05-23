package Modelo.MFiltros;

public class PosicionFilaColumna extends MFiltro {


    public PosicionFilaColumna(String contenido, String palabra) {
        super(contenido, palabra);
    }

    @Override
    public String buscar() {

        String[] palabras= palabra.split(";");

        String result = "";
        String[] filas = contenido.split("\n");

        if (Integer.valueOf(palabras[0])< filas.length){
            String fila = filas[Integer.valueOf(palabras[0])].trim();
            if (Integer.valueOf(palabras[1])<fila.length()) {
                if (fila.charAt(Integer.valueOf(palabras[1]))!=' '){
                    CharSequence blank = "\\s";
                    if(fila.matches("^\\s*$")){
                        if(fila.substring(0, Integer.valueOf(palabras[1])).contains(blank)){
                            result = fila.substring(fila.indexOf('\b'));
                            System.out.println("Estoy aqui" + result);
                            if(result.contains(blank)){
                                result = result.substring(0, result.indexOf("\b"));
                            }
                        }
                    }else{
                        result = fila;
                    }
                }
                else result = "Espacio en blanco";
            }
            else
                result = "Posición indicada fuera de rango en la fila";
        } else
            result = "Numero de fila excede el número de filas total";
        System.out.println(result);
        return result;
    }
}
