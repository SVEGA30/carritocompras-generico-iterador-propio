package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Carrito;
import co.edu.uniquindio.poo.model.ProductoDigital;
import co.edu.uniquindio.poo.model.ProductoFisico;
import co.edu.uniquindio.poo.service.Producto;

public class CarritoTest {

    private Carrito<Producto> carrito;

    @BeforeEach
    void preparar() {
        carrito = new Carrito<>();
        carrito.agregarProducto(new ProductoFisico("Mouse", 40000, 0.1));
        carrito.agregarProducto(new ProductoDigital("Ebook", 20000, 5));
        carrito.agregarProducto(new ProductoFisico("Monitor", 600000, 4));
    }

    private List<String> nombres(Iterator<Producto> it) {
        List<String> resultado = new ArrayList<>();
        while (it.hasNext()) {
            resultado.add(it.next().getNombre());
        }
        return resultado;
    }

    @Test
    void totalSumaTodosLosPrecios() {
        assertEquals(660000.0, carrito.calcularPrecioTotal(), 0.001);
    }

    @Test
    void mayorPrecioEsElMonitor() {
        assertEquals("Monitor", carrito.obtenerProductoMayorPrecio().get().getNombre());
    }

    @Test
    void carritoVacioNoTieneMayorYTotalEsCero() {
        Carrito<Producto> vacio = new Carrito<>();
        assertTrue(vacio.obtenerProductoMayorPrecio().isEmpty());
        assertEquals(0.0, vacio.calcularPrecioTotal(), 0.001);
    }

    @Test
    void iteradorPorRangoFiltraPorPrecio() {
        assertEquals(List.of("Mouse"), nombres(carrito.iteradorPorRango(30000, 100000)));
    }

    @Test
    void iteradorPorPosicionImparesYPares() {
        assertEquals(List.of("Mouse", "Monitor"), nombres(carrito.iteradorPorPosicion(true)));
        assertEquals(List.of("Ebook"), nombres(carrito.iteradorPorPosicion(false)));
    }

    @Test
    void iteradorAgotadoLanzaExcepcion() {
        Iterator<Producto> it = carrito.iteradorPorRango(1000000, 2000000);
        assertThrows(NoSuchElementException.class, it::next);
    }
}
