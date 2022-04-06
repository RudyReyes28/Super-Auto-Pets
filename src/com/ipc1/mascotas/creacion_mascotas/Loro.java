package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadLoro;

public class Loro extends Mascota {

    public Loro() {
        super("Loro", 5, 3, "volador", null, null, new HabilidadLoro());
    }
}
