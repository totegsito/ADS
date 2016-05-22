package Modelo.MFiltros;

public class NumeroOcurrencias extends MFiltro {

    public NumeroOcurrencias(String contenido, String palabra) {
        super(contenido, palabra);
    }

    @Override
    public String buscar() {
        String aux = contenido;
        int cont = 0;
        while(aux.contains(palabra)){
            cont++;
            aux = aux.replaceFirst(palabra, "");
        }
        return "La busqueda de " + palabra + " ha dado " + String.valueOf(cont) + " resultados\r";
    }
}
