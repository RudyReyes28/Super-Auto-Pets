package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadCaracol;

public class Caracol extends Mascota {

    public Caracol() {
        super("Caracol", 2, 2, "insecto", "solitario", null, new HabilidadCaracol());
    }
}
