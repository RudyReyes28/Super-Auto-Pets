package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadPavoReal extends Habilidad {


    public HabilidadPavoReal() {
        super("Pavo Real", "Potenciacion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionPavo = Util.posicionMascota(mascotasAliadas, this.getNombre());
        if(mascotasAliadas[posicionPavo]!=null){
            double ataque = mascotasAliadas[posicionPavo].getAtaque()*0.5*nivel;
            mascotasAliadas[posicionPavo].setAtaque(ataque);
            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nE incrementa su ataque en: " +ataque;
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }
}
