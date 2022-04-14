package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadCamaleon;

public class Camaleon extends Mascota {

    public Camaleon() {
        super("Camaleon", 8, 8, "reptil", "solitario", null, new HabilidadCamaleon(),7);
    }
}
