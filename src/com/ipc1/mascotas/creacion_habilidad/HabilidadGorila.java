package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadGorila extends Habilidad {

    private int turno=0;

    public HabilidadGorila() {
        super("Gorila", "Escudo");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        //ESCUDO DE COCO
    }

    public void activarHabilidadGorilla(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota gorila, String nombreJugador){

        int posicionGorilla = Util.cantidadMascotas(mascotasAliadas);
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);

        if(posicionGorilla!=-1 && posicionEnemigo!=-1){
            if(mascotasAliadas[posicionGorilla].getNombre().equalsIgnoreCase(gorila.getNombre())){
                if(turno%3==0) {
                    double vida = mascotasEnemigas[posicionEnemigo].getAtaque();

                    mascotasAliadas[posicionGorilla].setVida(vida);

                    String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad " + getNombreHabilidad();
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
                turno++;
            }
        }
    }
}
