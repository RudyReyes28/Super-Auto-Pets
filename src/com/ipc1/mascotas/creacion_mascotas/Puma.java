package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadPuma;

public class Puma extends Mascota {

    public Puma() {
        super("Puma", 3, 7, "mamifero", "terrestre", null, new HabilidadPuma());
    }
}
