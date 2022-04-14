package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadPescado;

public class Pescado extends Mascota {


    public Pescado() {
        super("Pescado", 2, 3, "acuatico", null, null, new HabilidadPescado(),1);
    }


}
