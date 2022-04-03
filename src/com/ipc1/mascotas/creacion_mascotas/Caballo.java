package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadCaballo;

public class Caballo extends Mascota {
    public Caballo() {
        super("Caballo", 2, 1, "mamifero", "domestico", null, new HabilidadCaballo());
    }


}
