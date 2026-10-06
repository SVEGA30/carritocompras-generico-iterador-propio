package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import co.edu.uniquindio.poo.service.IteradorPosicion;
import co.edu.uniquindio.poo.service.IteradorRango;
import co.edu.uniquindio.poo.service.Producto;

public class Carrito<T extends Producto> implements Iterable<T> {

    private final List<T> productos = new ArrayList<>();

    // 1. Agregar productos
    public void agregarProducto(T producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        productos.add(producto);
    }

    // 2. Producto de mayor precio (vacio si el carrito no tiene productos)
    public Optional<T> obtenerProductoMayorPrecio() {
        T mayor = null;
        for (T producto : productos) {
            if (mayor == null || producto.getPrecio() > mayor.getPrecio()) {
                mayor = producto;
            }
        }
        return Optional.ofNullable(mayor);
    }

    // 3. Precio total
    public double calcularPrecioTotal() {
        double total = 0;
        for (T producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public int cantidadProductos() {
        return productos.size();
    }

    public void mostrarProductos() {
        for (T producto : productos) {
            System.out.println(producto);
        }
    }

    // ===== Iteradores propios =====

    // Recorrido completo (rango sin limites)
    @Override
    public Iterator<T> iterator() {
        return new IteradorRango<>(productos, 0, Double.MAX_VALUE);
    }

    // Recorrido por precio
    public Iterator<T> iteradorPorRango(double minimo, double maximo) {
        return new IteradorRango<>(productos, minimo, maximo);
    }

    // Recorrido por posicion: true = posiciones impares, false = pares
    public Iterator<T> iteradorPorPosicion(boolean impares) {
        return new IteradorPosicion<>(productos, impares);
    }
}
