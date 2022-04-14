package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadQuetzal;

public class Quetzal extends Mascota {

    public Quetzal() {
        super("Quetzal", 10, 10, "volador", "solitario", null, new HabilidadQuetzal(),7);
    }
}
