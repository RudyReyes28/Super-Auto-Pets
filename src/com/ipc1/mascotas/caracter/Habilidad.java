package com.ipc1.mascotas.caracter;


public class Habilidad {

    private String nombre;
    private String nombreHabilidad;

    public Habilidad(String nombre, String nombreHabilidad) {
        this.nombre = nombre;
        this.nombreHabilidad = nombreHabilidad;
    }


    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota [] mascotasEnemigas, Mascota [] mascotasTienda, int nivel){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }
}
