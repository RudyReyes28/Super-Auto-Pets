package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadArdilla extends Habilidad {


    public HabilidadArdilla() {
        super("Ardilla", "Rebajas");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        //ARREGLO DE COMPRAS
    }
}
