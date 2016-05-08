package com.company.Filtro;

/**
 * Created by Frank on 02/03/2016.
 */
public class Ocurrencia extends Filtro {

    public Ocurrencia(String parametro) {
        super(parametro);
    }

    @Override
    public Integer buscar(String contenido) {
        int cont = 0;
        String ocurrencia = super.getParametro().toString();
        while(contenido.contains(ocurrencia)){
            contenido = contenido.substring(contenido.indexOf(
                    ocurrencia)+ocurrencia.length(),contenido.length());
            cont++;
        }
        return cont;
    }
}
