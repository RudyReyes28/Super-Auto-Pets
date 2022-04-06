package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadDodo;

public class Dodo extends Mascota {

    public Dodo() {
        super("Dodo", 2, 3, "volador", null, null, new HabilidadDodo());
    }
}
