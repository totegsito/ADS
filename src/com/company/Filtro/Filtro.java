package com.company.Filtro;

/**
 * Created by Frank on 02/03/2016.
 */
public abstract class Filtro  <T, K>{

    protected K parametro;

    public Filtro(K parametro){
        this.parametro = parametro;
    }

    protected K getParametro(){ return parametro; }

    public abstract T buscar(String contenido);
}
