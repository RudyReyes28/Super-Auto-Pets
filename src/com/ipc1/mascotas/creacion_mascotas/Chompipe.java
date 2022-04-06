package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadChompipe;

public class Chompipe extends Mascota {

    public Chompipe() {
        super("Chompipe", 3, 4, "terrestre", "volador", null, new HabilidadChompipe());
    }
}
