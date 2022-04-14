package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadBallena;

public class Ballena extends Mascota {

    public Ballena() {
        super("Ballena", 3, 8, "acuatico", null, null, new HabilidadBallena(),4);
    }
}
