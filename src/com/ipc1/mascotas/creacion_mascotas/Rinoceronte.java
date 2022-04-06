package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadRinoceronte;

public class Rinoceronte extends Mascota {

    public Rinoceronte() {
        super("Rinoceronte", 5, 8, "desertico", "terrestre", null, new HabilidadRinoceronte());
    }
}
