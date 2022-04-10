package com.ipc1.campos.caracter;

import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Campo {

    private String nombreCampo;
    private String color;
    private final String reset = Util.reset;

    public Campo(String nombreCampo, String color) {
        this.nombreCampo = nombreCampo;
        this.color = color;
    }

    public void activarCampo(Mascota[] mascotas){

    }

    @Override
    public String toString() {
       return color+"***************** Jugando en el campo: "+this.nombreCampo+"  ********************"+reset;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }
}
