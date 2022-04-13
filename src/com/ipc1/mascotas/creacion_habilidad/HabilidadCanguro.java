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

    public void activarHabilidadCanguro(Mascota[] mascotasAliadas, Mascota canguro, String nombreJugador){

        int mascotaAtacante = Util.cantidadMascotas(mascotasAliadas);
        try {
            if (mascotaAtacante - 1 >= 0) {
                if (mascotasAliadas[mascotaAtacante - 1].getNombre().equals(canguro.getNombre())) {
                    mascotasAliadas[mascotaAtacante - 1].setAtaque(canguro.getNivel() * 2);
                    mascotasAliadas[mascotaAtacante - 1].setVida(canguro.getNivel() * 2);

                    String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad " + getNombreHabilidad()
                            + "\n\tAumenta su vida en: +" + (canguro.getNivel() * 2) + " y su ataque en: +" + (canguro.getNivel() * 2);
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (NullPointerException ignore){

        }

    }
}
