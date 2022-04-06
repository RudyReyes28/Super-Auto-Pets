package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadVaca;

public class Vaca extends Mascota {

    public Vaca() {
        super("Vaca", 4, 6, "mamifero", "terrestre", null, new HabilidadVaca());
    }
}
