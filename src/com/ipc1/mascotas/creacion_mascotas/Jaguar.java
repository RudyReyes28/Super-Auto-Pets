package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadJaguar;

public class Jaguar extends Mascota {

    public Jaguar() {
        super("Jaguar", 7, 4, "mamifero", "terrestre", null, new HabilidadJaguar());
    }
}
