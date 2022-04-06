package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadEscarabajo;

public class Escarabajo extends Mascota {


    public Escarabajo() {
        super("Escarabajo", 2, 3, "insecto", null, null, new HabilidadEscarabajo());
    }
}
