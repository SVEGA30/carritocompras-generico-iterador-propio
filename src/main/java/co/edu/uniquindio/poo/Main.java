package co.edu.uniquindio.poo;

import java.util.Iterator;
import java.util.Locale;

import co.edu.uniquindio.poo.model.Carrito;
import co.edu.uniquindio.poo.model.ProductoDigital;
import co.edu.uniquindio.poo.model.ProductoFisico;
import co.edu.uniquindio.poo.service.Producto;

public class Main {

    private static void imprimir(String titulo, Iterator<Producto> it) {
        System.out.println("\n" + titulo);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        Carrito<Producto> carrito = new Carrito<>();

        carrito.agregarProducto(new ProductoFisico("Audifonos", 180000, 0.3));
        carrito.agregarProducto(new ProductoDigital("Licencia Antivirus", 60000, 150.0));
        carrito.agregarProducto(new ProductoFisico("Cargador", 35000, 0.2));
        carrito.agregarProducto(new ProductoDigital("Curso de Java", 220000, 2048.0));
        carrito.agregarProducto(new ProductoFisico("Teclado", 95000, 0.9));
        carrito.agregarProducto(new ProductoDigital("Ebook de Estructuras", 15000, 12.5));
        carrito.agregarProducto(new ProductoFisico("Monitor", 650000, 4.5));

        System.out.println("Todos los productos");
        for (Producto p : carrito) {
            System.out.println(p);
        }

        imprimir("Productos con precio entre $50000 y $200000", carrito.iteradorPorRango(50000, 200000));
        imprimir("Productos en posiciones impares (1, 3, 5, 7)", carrito.iteradorPorPosicion(true));
        imprimir("Productos en posiciones pares (2, 4, 6)", carrito.iteradorPorPosicion(false));

        System.out.println("\nProducto de mayor precio:");
        carrito.obtenerProductoMayorPrecio().ifPresent(System.out::println);

        System.out.println(String.format(Locale.US, "%nPrecio total (%d productos): $%.2f",
                carrito.cantidadProductos(), carrito.calcularPrecioTotal()));
    }
}
