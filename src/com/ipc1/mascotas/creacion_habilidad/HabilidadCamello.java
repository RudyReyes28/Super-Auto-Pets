package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadCamello extends Habilidad {


    public HabilidadCamello() {
        super("Camello", "Joroba");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionCamello = Util.posicionMascota(mascotasAliadas,this.getNombre());

        if(mascotasAliadas[posicionCamello-1]!=null){
            mascotasAliadas[posicionCamello-1].setAtaque(nivel);
            mascotasAliadas[posicionCamello-1].setVida(2*nivel);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[posicionCamello-1].getNombre()+
                    " vida: "+2*nivel+" daño: "+nivel;
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

    public void activarHabilidadCamello(Mascota [] mascotasAliadas, Mascota camello) {
        int posicionCamello = Util.posicionMascota(mascotasAliadas, this.getNombre());

        if (posicionCamello > 0){
            if (mascotasAliadas[posicionCamello - 1] != null) {
                mascotasAliadas[posicionCamello - 1].setAtaque(camello.getNivel());
                mascotasAliadas[posicionCamello - 1].setVida(2 * camello.getNivel());

                String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nOtorga a " + mascotasAliadas[posicionCamello - 1].getNombre() +
                        " vida: " + (2 * camello.getNivel()) + " daño: " + camello.getNivel();
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }
    }
}
