package co.edu.uniquindio.poo.service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Recorre la lista de dos en dos, segun la posicion (contando desde 1):
 * impares -> 1, 3, 5...   pares -> 2, 4, 6...
 */
public class IteradorPosicion<T extends Producto> implements Iterator<T> {

    private final List<T> lista;
    private int posicion;

    public IteradorPosicion(List<T> lista, boolean impares) {
        this.lista = lista;
        // Indice 0 es la posicion 1 (impar); indice 1 es la posicion 2 (par)
        this.posicion = impares ? 0 : 1;
    }

    @Override
    public boolean hasNext() {
        return posicion < lista.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay mas productos en este recorrido");
        }
        T actual = lista.get(posicion);
        posicion += 2;
        return actual;
    }
}
