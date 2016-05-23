package Modelo.MDocumento;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class DocumentoHTML extends Documento {


    private Document documento;
    public DocumentoHTML(String ruta) {
        super(ruta);
    }

    @Override
    public void parse() {
        try{
            documento = Jsoup.connect(this.ruta).get();
            contenido = documento.html();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
