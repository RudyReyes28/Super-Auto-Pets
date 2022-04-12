package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadRinoceronte extends Habilidad {


    public HabilidadRinoceronte() {
        super("Rinoceronte", "Estampida");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);

        try{

            if(posicionEnemigo!=-1){
                mascotasEnemigas[posicionEnemigo].setVida(-4*nivel);

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a " + mascotasEnemigas[posicionEnemigo].getNombre()+
                        " quitandole una vida de: -"+(4*nivel);
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }

    public void activarHabilidadRinoceronte(Mascota[] mascotasEnemigas, Mascota rinoceronte){
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);

        try{

            if(posicionEnemigo!=-1){
                mascotasEnemigas[posicionEnemigo].setVida(-4* rinoceronte.getNivel());

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a " + mascotasEnemigas[posicionEnemigo].getNombre()+
                        " quitandole una vida de: -"+(4* rinoceronte.getNivel());
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }
}
