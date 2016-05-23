package Modelo.MFiltros;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Enlaces extends MFiltro {

    public Enlaces (String contenido, String palabra) { super(contenido, palabra); }

    @Override
    public String buscar() {
        Document doc = Jsoup.parse(contenido);
        Elements media = doc.select("[src]");
        Elements links = doc.select("a[href]");
        Elements imports = doc.select("link[href]");

        String resul ="";
        for (Element src : media) {

            resul += src.attr("src") + "\n";
        }

        for (Element link : imports) {

            String enlace = link.attr("abs:href");
            if(!enlace.equals(""))
                resul += enlace + "\n";
        }

        for (Element link : links) {
            String enlace = link.attr("abs:href");
            if(!enlace.equals(""))
                resul += enlace + "\r";
        }

        return "\n\nEnlaces contenidos en la página\r" + resul + "\r\r";
    }
}
