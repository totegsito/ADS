package com.company;

import com.company.Documento.DocumentoHTML;
import com.company.Documento.DocumentoTexto;
import com.company.Filtro.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        DocumentoHTML documento = new DocumentoHTML("http://upm.es/");
        DocumentoTexto documentoTexto = new DocumentoTexto("D:\\Universidad\\proyectoParaPruebas\\src\\com\\company\\test.txt");
        documentoTexto.parse();

        System.out.println(documentoTexto.getContenido());
        //System.out.println(documento.getHtml());

        /*Filtro hello = new Existe("hello");
        Filtro me = new Existe("me");
        Filtro caca = new Existe("caca");
        Filtro cuantosHello = new Ocurrencia("Hello");
        Filtro enlaces = new Enlaces("");
        Filtro cabeceras = new Cabeceras("property");*/
        /*Filtro enlaces = new Enlaces("");
        Filtro numero = new Ocurrencia("UPM");
        Filtro etiqueta = new Etiqueta("a");


        ArrayList<Filtro> filtros = new ArrayList<Filtro>();*/
        /*filtros.add(hello);
        filtros.add(me);
        filtros.add(cuantosHello);
        filtros.add(enlaces);
        filtros.add(cabeceras);*/
       /* filtros.add(enlaces);
        filtros.add(numero);
        filtros.add(etiqueta);



        for(Filtro filtro : filtros){
            System.out.println(filtro.buscar(documento.getHtml()));
        }*/


        //System.out.println(hello.buscar(documento.getText()));
/*

        ArrayList<String> filtros = new ArrayList<String>();
        filtros.add("hello");
        filtros.add("me");
        filtros.add("caca");

        for(String filtro : filtros){
            Filtro filter = new Existe(filtro);
            System.out.println(filter.buscar(documento.getText()));
        }
*/




    }
}
