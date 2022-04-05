package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadGorila extends Habilidad {


    public HabilidadGorila() {
        super("Gorila", "Escudo");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        //ESCUDO DE COCO
    }
}
