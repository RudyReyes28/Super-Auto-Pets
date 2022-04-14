package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadHipopotamo;

public class Hipopotamo extends Mascota {

    public Hipopotamo() {
        super("Hipopotamo", 4, 7, "acuatico", "terrestre", null, new HabilidadHipopotamo(),4);
    }
}
