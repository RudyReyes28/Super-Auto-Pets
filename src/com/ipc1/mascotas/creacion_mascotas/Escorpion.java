package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadEscorpion;

public class Escorpion extends Mascota {

    public Escorpion() {
        super("Escorpion", 1, 1, "desertico", "solitario", null, new HabilidadEscorpion());
    }
}
