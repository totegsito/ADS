package com.company.Documento;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Frank on 02/03/2016.
 */
public class DocumentoHTML extends Documento {


    private Document documento;

    public DocumentoHTML(String ruta) {
        super(ruta);
    }

    public DocumentoHTML(String ruta, String nombre) {
        super(ruta, nombre);
    }


    @Override
    public void parse() {
        try{
            documento = Jsoup.connect(this.ruta).get();
            this.contenido = documento.html();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public String getText(){
        return documento.text();
    }

    public String getHtml() { return documento.html(); }
}
