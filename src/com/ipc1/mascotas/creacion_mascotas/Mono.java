package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadMono;

public class Mono extends Mascota {

    public Mono() {
        super("Mono", 1, 2, "mamifero", null, null, new HabilidadMono(),5);
    }
}
