package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.service.Producto;

public class ProductoDigital implements Producto {
    private final String nombre;
    private final double precio;
    private final double tamanoMb;

    public ProductoDigital(String nombre, double precio, double tamanoMb) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamanoMb = tamanoMb;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public double getTamanoMb() {
        return tamanoMb;
    }

    @Override
    public String toString() {
        return "Digital: " + nombre + " ($" + precio + ", " + tamanoMb + " MB)";
    }
}
