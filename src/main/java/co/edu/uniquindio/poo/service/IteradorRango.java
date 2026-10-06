package co.edu.uniquindio.poo.service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Recorre la lista y entrega solo los productos cuyo precio
 * esta entre minimo y maximo (ambos incluidos).
 */
public class IteradorRango<T extends Producto> implements Iterator<T> {

    private final List<T> lista;
    private final double minimo;
    private final double maximo;
    private int posicion = 0;

    public IteradorRango(List<T> lista, double minimo, double maximo) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("El minimo no puede ser mayor que el maximo");
        }
        this.lista = lista;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    private boolean estaEnRango(T producto) {
        double precio = producto.getPrecio();
        return precio >= minimo && precio <= maximo;
    }

    // Avanza hasta el proximo producto valido; se puede llamar varias veces sin perder elementos
    @Override
    public boolean hasNext() {
        while (posicion < lista.size() && !estaEnRango(lista.get(posicion))) {
            posicion++;
        }
        return posicion < lista.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay mas productos en el rango");
        }
        return lista.get(posicion++);
    }
}
