package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadBuey extends Habilidad {


    public HabilidadBuey() {
        super("Buey", "Mejor me protejo");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionBuey = Util.posicionMascota(mascotasAliadas,this.getNombre());

        if(mascotasAliadas[posicionBuey]!=null){
            //gana Melon Armor

            mascotasAliadas[posicionBuey].setAtaque(2*nivel);
            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAumenta su ataque en: " + nivel*2;
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }
}
