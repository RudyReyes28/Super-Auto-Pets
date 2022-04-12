package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadBallena extends Habilidad {


    public HabilidadBallena() {
        super("Ballena", "Succion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {

        int posicionBallena = Util.posicionMascota(mascotasAliadas, this.getNombre());

        try{
            if(posicionBallena!=-1) {
                if (mascotasAliadas[posicionBallena + 1] != null) {
                    Mascota tmp = mascotasAliadas[posicionBallena + 1];
                    tmp.setNivel(nivel);
                    mascotasAliadas[posicionBallena+1]=mascotasAliadas[posicionBallena];
                    mascotasAliadas[posicionBallena] = tmp;

                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad();
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }

        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }
    
    public void activarHabilidadBallena(Mascota[] mascotasAliadas, Mascota ballena, int posicionBallena){
        try{
            if(posicionBallena!=-1) {
                if (mascotasAliadas[posicionBallena + 1] != null) {
                    Mascota tmp = mascotasAliadas[posicionBallena + 1];
                    tmp.setNivel(ballena.getNivel());
                    mascotasAliadas[posicionBallena+1]=mascotasAliadas[posicionBallena];
                    mascotasAliadas[posicionBallena] = tmp;

                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad();
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }

        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }
}
