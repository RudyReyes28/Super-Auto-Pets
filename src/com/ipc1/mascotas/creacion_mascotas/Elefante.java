package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadElefante;

public class Elefante extends Mascota {

    public Elefante() {
        super("Elefante", 3, 5, "mamifero", "terrestre", null, new HabilidadElefante());
    }
}
