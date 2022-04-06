package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadMosquito;
import com.ipc1.util.Util;

public class Mosquito extends Mascota {

    public Mosquito() {
        super("Mosquito", 2, 2, "volador", null, null, new HabilidadMosquito());
    }


}
