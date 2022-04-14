package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadArdilla;

public class Ardilla extends Mascota {

    public Ardilla() {
        super("Ardilla", 2, 5, "domestico", null, null, new HabilidadArdilla(),4);
    }
}
