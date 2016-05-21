package Modelo.MDocumento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class DocumentoTexto extends Documento{

    public DocumentoTexto(String ruta) {
        super(ruta);
    }

    @Override
    public void parse() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try{
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while((linea=br.readLine())!=null)
                contenido+=linea+"\n";
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
