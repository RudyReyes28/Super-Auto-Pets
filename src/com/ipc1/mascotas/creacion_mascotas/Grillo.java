package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadGrillo;
import com.ipc1.util.Util;

public class Grillo extends Mascota {


    public Grillo() {
        super("Grillo", 1, 2, "insecto", null, null, new HabilidadGrillo());

    }

}
