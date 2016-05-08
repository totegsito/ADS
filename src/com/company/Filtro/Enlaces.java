package com.company.Filtro;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Frank on 07/03/2016.
 */
public class Enlaces extends Filtro{


    public Enlaces(String parametro) {
        super(parametro);
    }


    @Override
    public String buscar(String contenido) {
        Document doc = Jsoup.parse(contenido);
        Elements media = doc.select("[src]");
        Elements links = doc.select("a[href]");
        Elements imports = doc.select("link[href]");

        String resul ="";

        for (Element src : media) {

            resul += src.attr("src") + "\n";
        }

        for (Element link : imports) {

            //resul += link.attr("abs:href" + "\n");
            String enlace = link.attr("abs:href");
            if(!enlace.equals(""))
            resul += enlace + "\n";
        }

        for (Element link : links) {

            //resul += link.attr("abs:href" + "\n");
            String enlace = link.attr("abs:href");
            if(!enlace.equals(""))
            resul += enlace + "\n";
        }

        return resul;
    }
}