package Modelo.MFiltros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValorCentral extends MFiltro {

    public ValorCentral(String contenido, String palabra) {
        super(contenido, palabra);
    }

    @Override
    public String buscar() {
        String[] palabras = palabra.split(";");
        String resul = "";
        Pattern p = Pattern.compile(palabras[0] + "\\s*(\\w|[.,-/\"])+\\s*" + palabras[1]);
        Matcher m = p.matcher(contenido);
        if(m.find()){
            resul += m.group();
        }else{
            resul += "No se han encontrado coincidencias para " + palabras[0] + " y " + palabras[1];
        }
        return resul;
    }
}
