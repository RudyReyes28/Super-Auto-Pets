package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadArania;

public class Arania extends Mascota {

    public Arania() {
        super("Araña", 2, 2, "insecto", null, null, new HabilidadArania(),2);
    }
}
