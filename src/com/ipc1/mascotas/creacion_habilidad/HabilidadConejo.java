package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadConejo extends Habilidad {




    public HabilidadConejo() {
        super("Conejo", "Cariño");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {

       /* if(mascotasAliadas[posicionAmigo]!=null){
            mascotasAliadas[posicionAmigo].setVida(nivel);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[posicionAmigo].getNombre()+
                    " una vida de: "+nivel;
            Archivos.mensajeEfecto(mensajeEfecto);
        }*/

    }

    public void activarHabilidadConejo(Mascota mascotaComida, Mascota conejo, String nombreJugador){
        if(mascotaComida!=null){
            mascotaComida.setVida(conejo.getNivel());

            String mensajeEfecto ="La mascota del jugador "+nombreJugador+" ---> "+ this.getNombre()+" activa la habilidad "+getNombreHabilidad()
                    +"\n\tOtorga a " + mascotaComida.getNombre()+ " una vida de: "+conejo.getNivel();

            System.out.println(Util.rojo+mensajeEfecto+Util.reset);
            //Archivos.mensajeEfecto(mensajeEfecto);
        }
    }
}
