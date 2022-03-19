package com.example.sistemafloreria;

public class clientes {
    int id_cli;
    String nombrecliente,telefono,edad,sexo;

    public clientes(int id_cli, String nombrecliente, String telefono, String edad, String sexo) {
        this.id_cli = id_cli;
        this.nombrecliente = nombrecliente;
        this.telefono = telefono;
        this.edad = edad;
        this.sexo = sexo;
    }

    public clientes() {

    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
