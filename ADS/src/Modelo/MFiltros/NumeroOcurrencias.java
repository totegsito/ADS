package Modelo.MFiltros;

public class NumeroOcurrencias extends Filtro {

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
        return String.valueOf(cont);
    }
}
