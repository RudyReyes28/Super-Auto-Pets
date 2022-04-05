package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadGato extends Habilidad {

    //private Comida [] comida;

    public HabilidadGato() {
        super("Gato", "Maullido");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        //POR DEFINIR
    }
}
