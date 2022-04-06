package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadConejo;

public class Conejo extends Mascota {

    public Conejo() {
        super("Conejo", 3, 2, "mamifero", null, null, new HabilidadConejo());
    }
}
