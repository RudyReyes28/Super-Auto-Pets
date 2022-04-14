package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadJirafa;

public class Jirafa extends Mascota {

    public Jirafa() {
        super("Jirafa", 2, 5, "mamifero", "terrestre", null, new HabilidadJirafa(),3);
    }
}
