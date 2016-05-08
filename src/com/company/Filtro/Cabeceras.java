package com.company.Filtro;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Frank on 09/03/2016.
 */
public class Cabeceras extends Filtro {


    public Cabeceras(String parametro) {
        super(parametro);
    }

    @Override
    public String buscar(String contenido) {
        Document document = Jsoup.parse(contenido);
        Elements metas = document.select("meta");
        String resul = "";
        for (Element meta : metas){
            //System.out.println(meta);
            if(meta.toString().contains(getParametro().toString())){
                resul += meta.toString() + "\n";
            }
        }

        return resul;
    }
}
