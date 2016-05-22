package Modelo.MFiltros;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PerfilFormulario extends MFiltro {
    public PerfilFormulario(String contenido, String palabra) {
        super(contenido, palabra);
    }
    @Override
    public String buscar() {
        Document doc = Jsoup.parse(contenido);
        Elements forms = doc.select("form");
        String cabecera = "Perfil de formularios:\n" + "\n";
        String resul = "";
        for(Element form : forms){
            Elements inputs = form.getElementsByTag("input");
            resul+= form.attr("method") + "\t" + form.attr("action")+"?";
            for(Element input : inputs){
                resul+= input.attr("name")+ "&";
            }
            resul = resul.substring(0, resul.lastIndexOf('&')) + "\n";
        }
        return cabecera + (resul.equals("")? "No existen formularios" : resul);
    }
}
