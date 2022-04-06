package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadSerpiente;

public class Serpiente extends Mascota {

    public Serpiente() {
        super("Serpiente", 6, 6, "reptil", "terrestre", "desertico", new HabilidadSerpiente());
    }
}
