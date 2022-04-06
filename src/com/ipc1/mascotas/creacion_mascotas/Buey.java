package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadBuey;

public class Buey extends Mascota {

    public Buey() {
        super("Buey", 1, 4, "mamifero", null, null, new HabilidadBuey());
    }
}
