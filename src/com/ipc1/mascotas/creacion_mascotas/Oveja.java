package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadOveja;

public class Oveja extends Mascota {

    public Oveja() {
        super("Oveja", 2, 2, "domestico", "terrestre", null, new HabilidadOveja(),3);
    }
}
