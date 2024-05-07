package org.example.Ejercicios;

import java.util.Date;

public class Venta {

    private String nombreProducto;
    private String nombreCliente;
    private double precio;
    private Date fecha;

    public Venta(String nombreProducto, String nombreCliente, double precio, Date fecha) {
        this.nombreProducto = nombreProducto;
        this.nombreCliente = nombreCliente;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getPrecio() {
        return precio;
    }

    public Date getFecha() {
        return fecha;
    }
}
