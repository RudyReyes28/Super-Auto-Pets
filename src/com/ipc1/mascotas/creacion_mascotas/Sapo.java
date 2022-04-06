package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadSapo;

public class Sapo extends Mascota {

    public Sapo() {
        super("Sapo", 3, 3, "terrestre", "acuatico", null, new HabilidadSapo());
    }
}
