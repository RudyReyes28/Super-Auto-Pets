package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadZorro;

public class Zorro extends Mascota {

    public Zorro() {
        super("Zorro", 5, 2, "solitario", "terrestre", null, new HabilidadZorro());
    }
}
