package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Mascota;

public class GrilloZombi extends Mascota {

    public GrilloZombi() {
        super("Grillo", 1, 1, "insecto", null, null, 1, 0);

    }

    @Override
    public void habilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas) {

    }
}
