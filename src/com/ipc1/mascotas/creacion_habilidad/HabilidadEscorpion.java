package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadEscorpion extends Habilidad {


    public HabilidadEscorpion() {
        super("Escorpion", "Aguja");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);

        try{
            if(posicionEnemigo!=-1){
                double ataque = mascotasEnemigas[posicionEnemigo].getVida();

                mascotasEnemigas[posicionEnemigo].setVida(-ataque);

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a " + mascotasEnemigas[posicionEnemigo].getNombre()+
                        " quitandole una vida de: -"+ataque;
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }catch (NullPointerException ignore){

        }
    }
}
