package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadGorila;

public class Gorila extends Mascota {

    public Gorila() {
        super("Gorila", 6, 9, "mamifero", "terrestre", null, new HabilidadGorila(),6);
    }
}
