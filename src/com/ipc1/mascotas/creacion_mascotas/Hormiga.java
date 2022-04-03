package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadHormiga;
import com.ipc1.util.Util;

public class Hormiga extends Mascota{


    public Hormiga() {
        super("Hormiga", 2, 1, "insecto", "terrestre", null, new HabilidadHormiga());
    }



}
