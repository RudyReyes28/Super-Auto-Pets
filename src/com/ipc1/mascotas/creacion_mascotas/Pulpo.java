package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadPulpo;

public class Pulpo extends Mascota {

    public Pulpo() {
        super("Pulpo", 8, 8, "acuatico", "solitario", null, new HabilidadPulpo());
    }
}
