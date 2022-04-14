package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadFoca;

public class Foca extends Mascota {

    public Foca() {
        super("Foca", 3, 8, "acuatico", "mamifero", null, new HabilidadFoca(),5);
    }
}
