package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadHipopotamo extends Habilidad {

    public HabilidadHipopotamo() {
        super("Hipopotamo", "Robustez");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionHipo = Util.cantidadMascotas(mascotasAliadas);

        try{
            mascotasAliadas[posicionHipo].setAtaque(2*nivel);
            mascotasAliadas[posicionHipo].setVida(2*nivel);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAumenta " +
                    "su vida: +"+(2*nivel)+" y su daño: +"+(nivel*2);
            Archivos.mensajeEfecto(mensajeEfecto);
        }catch (ArrayIndexOutOfBoundsException ignore){

        }
    }

    public void activarHabilidadHipopotamo(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota hipopotamo){

        int posicionHipo = Util.cantidadMascotas(mascotasAliadas);
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);

        if(posicionHipo!=-1 && posicionEnemigo!=-1) {

            try {
                if(mascotasAliadas[posicionHipo].getNombre().equalsIgnoreCase(hipopotamo.getNombre()) &&
                mascotasEnemigas[posicionEnemigo].getVida()<=0) {
                    mascotasAliadas[posicionHipo].setAtaque(2 * hipopotamo.getNivel());
                    mascotasAliadas[posicionHipo].setVida(2 * hipopotamo.getNivel());

                    String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nAumenta " +
                            "su vida: +" + (2 * hipopotamo.getNivel()) + " y su daño: +" + (hipopotamo.getNivel() * 2);
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            } catch (ArrayIndexOutOfBoundsException | NullPointerException ignore) {

            }
        }
    }
}
