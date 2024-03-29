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
    
    public void activarHabilidadCocodrilo(Mascota [] mascotasEnemigas, Mascota cocodrilo, String nombreJugador){
        try{
            if(mascotasEnemigas[0]!= null){
                mascotasEnemigas[0].setVida(-8*cocodrilo.getNivel());

                String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre()+" activa la habilidad "+getNombreHabilidad()
                        +"\n\tAtaca a " + mascotasEnemigas[0].getNombre()+
                        " quitandole una vida de: -"+(8*cocodrilo.getNivel());
                Archivos.mensajeEfectosInicio(mensajeEfecto);
            }
        }catch (NullPointerException ignore){

        }
    }
}
