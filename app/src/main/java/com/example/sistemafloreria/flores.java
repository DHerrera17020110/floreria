package com.example.sistemafloreria;

public class flores {
    int id_flores;
    String color, tipo;
    double precio, cantidad;

    public flores(int id_flores, String color, String tipo, double precio, double cantidad) {
        this.id_flores = id_flores;
        this.color = color;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public flores() {

    }

    public int getId_flores() {
        return id_flores;
    }

    public void setId_flores(int id_flores) {
        this.id_flores = id_flores;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
