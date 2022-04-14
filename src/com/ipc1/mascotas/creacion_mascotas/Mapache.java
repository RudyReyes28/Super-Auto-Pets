package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadMapache;

public class Mapache extends Mascota {

    public Mapache() {
        super("Mapache", 5, 4, "solitario", null, null, new HabilidadMapache(),3);
    }
}
