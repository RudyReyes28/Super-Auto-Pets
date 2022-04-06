package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadRata;

public class Rata extends Mascota {

    public Rata() {
        super("Rata", 4, 5, "terrestre", "solitario", null, new HabilidadRata());
    }
}
