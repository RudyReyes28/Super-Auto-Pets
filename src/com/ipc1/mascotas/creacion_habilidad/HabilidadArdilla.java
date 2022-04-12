package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.jugador.Jugador;
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

    public void activarHabilidadArdilla(Mascota ardilla, Jugador jugador){
        jugador.setOro(ardilla.getNivel());
        System.out.println("Ardilla activa la habilidad "+getNombreHabilidad()+" y el jugador "+jugador.getNombre()+
                " recibe una rebaja de "+ardilla.getNivel());
    }
}
