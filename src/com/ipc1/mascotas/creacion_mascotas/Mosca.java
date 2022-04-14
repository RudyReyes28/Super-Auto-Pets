package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadMosca;

public class Mosca extends Mascota {

    public Mosca() {
        super("Mosca", 5, 5, "volador", "insecto", null, new HabilidadMosca(),6);
    }
}
