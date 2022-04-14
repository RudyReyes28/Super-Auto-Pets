package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadTortuga;

public class Tortuga extends Mascota {

    public Tortuga() {
        super("Tortuga", 1, 2, "reptil", null, null, new HabilidadTortuga(),3);
    }
}
