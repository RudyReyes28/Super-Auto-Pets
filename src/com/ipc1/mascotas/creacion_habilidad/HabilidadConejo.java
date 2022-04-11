package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

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

    public void activarHabilidadConejo(Mascota mascotaComida, Mascota conejo){
        if(mascotaComida!=null){
            mascotaComida.setVida(conejo.getNivel());

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotaComida.getNombre()+
                    " una vida de: "+conejo.getNivel();
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }
}
