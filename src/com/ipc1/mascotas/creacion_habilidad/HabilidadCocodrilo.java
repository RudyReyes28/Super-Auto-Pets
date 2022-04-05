package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadCocodrilo extends Habilidad {


    public HabilidadCocodrilo() {
        super("Cocodrilo", "Mordida");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        try{
            if(mascotasEnemigas[0]!= null){
                mascotasEnemigas[0].setVida(-8*nivel);

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a " + mascotasEnemigas[0].getNombre()+
                        " quitandole una vida de: -"+(8*nivel);
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (NullPointerException ignore){

        }
    }
}
