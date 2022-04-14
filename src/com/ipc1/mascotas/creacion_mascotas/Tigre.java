package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadTigre;

public class Tigre extends Mascota {

    public Tigre() {
        super("Tigre", 4, 3, "terrestre", "mamifero", null, new HabilidadTigre(),6);
    }
}
