package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadPanda;

public class Panda extends Mascota {

    public Panda() {
        super("Panda", 5, 5, "mamifero", "solitario", null, new HabilidadPanda(),6);
    }
}
