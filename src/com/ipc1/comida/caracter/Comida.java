package com.ipc1.comida.caracter;

import com.ipc1.mascotas.caracter.Mascota;

public class Comida {

    private String nombre;
    private boolean tipoEfecto;
    private int tier;


    public Comida(String nombre, boolean tipoEfecto, int tier) {
        this.nombre = nombre;
        this.tipoEfecto = tipoEfecto;
        this.tier = tier;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isTipoEfecto() {
        return tipoEfecto;
    }

    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado){

    }
}
