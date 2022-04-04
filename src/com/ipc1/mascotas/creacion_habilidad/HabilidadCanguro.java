package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadCanguro extends Habilidad {


    public HabilidadCanguro() {
        super("Canguro", "Ya quiero pelear");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionCanguro = Util.posicionMascota(mascotasAliadas, this.getNombre());

        if(mascotasAliadas[posicionCanguro]!=null){
            mascotasAliadas[posicionCanguro].setAtaque(nivel*2);
            mascotasAliadas[posicionCanguro].setVida(nivel*2);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAumenta su" +
                    " vida en: +"+(nivel*2)+" y su ataque en: +"+(nivel*2);
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }
}
