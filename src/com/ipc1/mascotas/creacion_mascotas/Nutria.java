package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadNutria;

public class Nutria extends Mascota {


    public Nutria() {
        super("Nutria", 1, 2, "mamifero", null, null, new HabilidadNutria());
    }
}
