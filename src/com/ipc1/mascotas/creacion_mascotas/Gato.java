package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadGato;

public class Gato extends Mascota {

    public Gato() {
        super("Gato", 4, 5, "mamifero", "domestico", null, new HabilidadGato(),6);
    }
}
