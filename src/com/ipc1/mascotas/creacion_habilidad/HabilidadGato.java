package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadGato extends Habilidad {



    public HabilidadGato() {
        super("Gato", "Maullido");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        //POR DEFINIR
    }

    public void activarHabilidadGato(Mascota comproComida, Mascota gato, String nombreJugador){
        comproComida.setAtaque(gato.getNivel()+1);
        comproComida.setVida(gato.getNivel()+1);

        System.out.println(Util.rojo+"La mascota del jugador "+nombreJugador+" ---> "+"Gato activa la habilidad "+getNombreHabilidad()
                + "\n\t aumenta el efecto de la comida a la mascota que la comió"+Util.reset);
    }
}
