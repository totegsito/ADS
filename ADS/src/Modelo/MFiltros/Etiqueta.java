package Modelo.MFiltros;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Etiqueta extends MFiltro {

    public Etiqueta (String contenido, String palabra) { super(contenido, palabra);}

    @Override
    public String buscar() {
        Document documento = Jsoup.parse(contenido);
        Element elemento = documento.select(palabra).first();
        return "Este es el contenido de la primera etiqueta " + palabra + elemento.html()+"\r";
    }
}
