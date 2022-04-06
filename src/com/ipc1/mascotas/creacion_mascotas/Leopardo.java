package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadLeopardo;

public class Leopardo extends Mascota {

    public Leopardo() {
        super("Leopardo", 10, 4, "mamifero", "terrestre", null, new HabilidadLeopardo());
    }
}
