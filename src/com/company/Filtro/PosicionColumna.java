package com.company.Filtro;

/**
 * Created by Frank on 15/03/2016.
 */
public class PosicionColumna extends PosicionFila {

    private int columna;

    public PosicionColumna(Number fila, Number columna) {
        super(fila);
        this.columna = columna.intValue();
    }


}
