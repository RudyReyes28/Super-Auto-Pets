package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadCocodrilo;

public class Cocodrilo extends Mascota {

    public Cocodrilo() {
        super("Cocodrilo", 8, 4, "reptil", "solitario", null, new HabilidadCocodrilo());
    }
}
