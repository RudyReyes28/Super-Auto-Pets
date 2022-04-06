package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadCamello;

public class Camello extends Mascota {

    public Camello() {
        super("Camello", 2, 5, "mamifero", "desertico", null, new HabilidadCamello());
    }
}
