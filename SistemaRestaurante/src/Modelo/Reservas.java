package Modelo;

import java.sql.Date;


public class Reservas {
    
    private int id_Reserva;
    private String Nombre_cliente;
    private int DNI;
    private String email;
    private int telefono;
    private Date fecha_hora;
    private int  numero_mesa; 

    public Reservas() {
    }

    public Reservas(int id_Reserva, String Nombre_cliente, int DNI, String email, int telefono, Date fecha_hora, int numero_mesa) {
        this.id_Reserva = id_Reserva;
        this.Nombre_cliente = Nombre_cliente;
        this.DNI = DNI;
        this.email = email;
        this.telefono = telefono;
        this.fecha_hora = fecha_hora;
        this.numero_mesa = numero_mesa;
    }

    
    public int getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(int id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public String getNombre_cliente() {
        return Nombre_cliente;
    }

    public void setNombre_cliente(String Nombre_cliente) {
        this.Nombre_cliente = Nombre_cliente;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getNumero_mesa() {
        return numero_mesa;
    }

    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }
    
    
    
    
    
}
