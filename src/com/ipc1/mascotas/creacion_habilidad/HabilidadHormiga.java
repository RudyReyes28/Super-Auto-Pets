package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadHormiga extends Habilidad {


    public HabilidadHormiga(String nombre) {
        super(nombre);
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int mascotaAleatoria = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());

        if(mascotaAleatoria!=-1){
            mascotasAliadas[mascotaAleatoria].setAtaque(nivel*2);
            mascotasAliadas[mascotaAleatoria].setVida(nivel);

            String mensajeEfecto = this.getNombre()+" otorga a " + mascotasAliadas[mascotaAleatoria].getNombre()+
                    " vida: "+nivel+" daño: "+nivel*2;

            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }
}
