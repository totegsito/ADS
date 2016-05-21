package Modelo.MFiltros;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by lorena on 18/05/2016.
 */
public class Etiqueta extends MFiltro {

    public Etiqueta (String contenido, String palabra) { super(contenido, palabra);}

    @Override
    public String buscar() {
        Document documento = Jsoup.parse(contenido);
        Element elemento = documento.select(palabra).first();
        return elemento.html();
    }
}