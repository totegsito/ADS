package Modelo.MFiltros;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Cabeceras extends MFiltro {

    public Cabeceras(String contenido, String palabra) { super(contenido, palabra);}

    @Override
    public String buscar() {

        String cab = "Busqueda en las metas de la palabra " + palabra + "\n";
        Document document = Jsoup.parse(contenido);
        Elements metas = document.select("meta");
        String resul = "";
        for (Element meta : metas){
            if(meta.toString().contains(palabra)){
                resul += meta.toString() + "\n";
            }
        }

        return resul.equals("") ? "No se han encontrado coincidencias" : cab + resul +"\n";
    }
}
