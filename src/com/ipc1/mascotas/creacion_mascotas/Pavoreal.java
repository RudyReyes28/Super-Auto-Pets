package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadPavoReal;

public class Pavoreal extends Mascota {

    public Pavoreal() {
        super("Pavoreal", 2, 5, "domestico", "volador", null, new HabilidadPavoReal(),2);
    }
}
