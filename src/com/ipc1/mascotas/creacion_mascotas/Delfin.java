package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadDelfin;

public class Delfin extends Mascota {

    public Delfin() {
        super("Delfin", 4, 6, "acuatico", null, null, new HabilidadDelfin());
    }
}
