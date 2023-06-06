package com.example.deliveryapp;

public class Producto {
    private String nombre;
    private String precio;
    private String id;

    public Producto() {
        // Constructor vacío requerido para Firebase
    }

    public Producto(String nombre, String precio, String id) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Puedes agregar setters si necesitas actualizar las propiedades

}
