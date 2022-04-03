package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadMapache extends Habilidad {


    public HabilidadMapache() {
        super("Mapache","Rapartir poder");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionMapache = Util.posicionMascota(mascotasAliadas,this.getNombre());
        if(mascotasAliadas[posicionMapache-1]!=null){
            double ataque = mascotasAliadas[posicionMapache-1].getAtaque();
            mascotasAliadas[posicionMapache-1].setAtaque(ataque*nivel);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[posicionMapache-1].getNombre()+
                    " un incremento del daño en: "+ataque*nivel;
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }
}
