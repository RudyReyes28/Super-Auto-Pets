package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadGato extends Habilidad {



    public HabilidadGato() {
        super("Gato", "Maullido");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        //POR DEFINIR
    }

    public void activarHabilidadGato(Mascota comproComida, Mascota gato){
        comproComida.setAtaque(gato.getNivel()+1);
        comproComida.setVida(gato.getNivel()+1);

        System.out.println("Gato activa la habilidad "+getNombreHabilidad()+ " y aumenta el efecto de la comido "+
                " a la mascota que la comió");
    }
}
