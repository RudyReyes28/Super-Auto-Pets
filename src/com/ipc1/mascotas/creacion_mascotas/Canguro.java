package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadCanguro;

public class Canguro extends Mascota {

    public Canguro() {
        super("Canguro", 1, 2, "mamifero", "terrestre", null, new HabilidadCanguro(),3);
    }
}
