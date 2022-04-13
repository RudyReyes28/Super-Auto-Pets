package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadElefante extends Habilidad {


    public HabilidadElefante() {
        super("Elefante", "Daño colateral");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionElefante = Util.posicionMascota(mascotasAliadas,this.getNombre());

        for(int i=posicionElefante-1; i>=posicionElefante-nivel;i--){
            if(i>=0) {
                if (mascotasAliadas[i] != null) {
                    mascotasAliadas[i].setVida(-1);
                    String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nLe quita a " + mascotasAliadas[i].getNombre() +
                            " una vida de : -1";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }
    }

    public void activarHabilidadElefante(Mascota [] mascotasAliadas, Mascota elefante, String nombreJugador){
        int posicionElefante = Util.cantidadMascotas(mascotasAliadas);
        if(posicionElefante!=-1) {

            if(mascotasAliadas[posicionElefante].getNombre().equals(elefante.getNombre())) {

                for (int i = posicionElefante - 1; i >= posicionElefante - elefante.getNivel(); i--) {
                    if (i >= 0) {
                        if (mascotasAliadas[i] != null) {
                            mascotasAliadas[i].setVida(-1);
                            String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad " + getNombreHabilidad()
                                    + "\n\tLe quita a " + mascotasAliadas[i].getNombre() +
                                    " una vida de : -1";
                            Archivos.mensajeEfecto(mensajeEfecto);
                        }
                    }
                }
            }
        }
    }
}
