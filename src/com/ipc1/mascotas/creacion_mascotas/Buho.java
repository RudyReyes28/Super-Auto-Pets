package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadBuho;

public class Buho extends Mascota {

    public Buho() {
        super("Buho", 5, 3, "volador", "solitario", null, new HabilidadBuho());
    }
}
