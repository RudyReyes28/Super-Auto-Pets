package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadCastor;
import com.ipc1.util.Util;

public class Castor extends Mascota {

    public Castor() {
        super("Castor", 2, 2, "terrestre", "acuatico", null, new HabilidadCastor(),1);
    }

}
