package com.company.Documento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Frank on 02/03/2016.
 */
public class DocumentoTexto extends Documento {

    public DocumentoTexto(String ruta) {
        super(ruta);
    }

    public DocumentoTexto(String ruta, String nombre) {
        super(ruta, nombre);
    }

    @Override
    public void parse() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                contenido+=linea+"\n";
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
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
