package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.service.Producto;

public class ProductoFisico implements Producto {
    private final String nombre;
    private final double precio;
    private final double pesoKg;

    public ProductoFisico(String nombre, double precio, double pesoKg) {
        this.nombre = nombre;
        this.precio = precio;
        this.pesoKg = pesoKg;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    @Override
    public String toString() {
        return "Fisico: " + nombre + " ($" + precio + ", " + pesoKg + " kg)";
    }
}
