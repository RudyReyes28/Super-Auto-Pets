package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadSerpiente extends Habilidad {

    public HabilidadSerpiente() {
        super("Serpiente", "Ataque discreto");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {

        int enemigoAleatorio = Util.mascotaEnemigaAleatoria(mascotasEnemigas);

        try{
            if(enemigoAleatorio!=-1){
                mascotasEnemigas[enemigoAleatorio].setAtaque(-5*nivel);

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a " + mascotasEnemigas[enemigoAleatorio].getNombre()+
                        " quitandole una vida de: -"+(5*nivel);

                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }catch (NullPointerException ignore){

        }
    }
}