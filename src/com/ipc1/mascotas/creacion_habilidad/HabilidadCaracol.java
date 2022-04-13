package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadCaracol extends Habilidad {

    public HabilidadCaracol() {
        super("Caracol", "Resurgir");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        for (int i = 0; i < mascotasAliadas.length; i++) {
            if (mascotasAliadas[i] != null) {
                if (!this.getNombre().equals(mascotasAliadas[i].getNombre())) {
                    mascotasAliadas[i].setAtaque(nivel);
                    mascotasAliadas[i].setVida(nivel);

                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[i].getNombre()+
                            " vida: "+nivel+" daño: "+nivel;
                    Archivos.mensajeEfecto(mensajeEfecto);
                }

            } else {
                break;
            }
        }
    }

    public void activarHabilidadCaracol(Mascota[] mascotasAliadas, Mascota caracol, String nombreJugador){
        for (int i = 0; i < mascotasAliadas.length; i++) {
            if (mascotasAliadas[i] != null) {
                if (!this.getNombre().equals(mascotasAliadas[i].getNombre())) {
                    mascotasAliadas[i].setAtaque(caracol.getNivel());
                    mascotasAliadas[i].setVida(caracol.getNivel());

                    String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre()+" activa la habilidad "+getNombreHabilidad()
                            +"\n\tOtorga a " + mascotasAliadas[i].getNombre()+
                            " vida: "+caracol.getNivel()+" daño: "+caracol.getNivel();

                    System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                    //Archivos.mensajeEfecto(mensajeEfecto);
                }

            }
        }
    }
}
