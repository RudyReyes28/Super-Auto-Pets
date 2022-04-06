package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadVenado;

public class Venado extends Mascota {

    public Venado() {
        super("Venado", 1, 1, "mamifero", null, null, new HabilidadVenado());
    }
}
