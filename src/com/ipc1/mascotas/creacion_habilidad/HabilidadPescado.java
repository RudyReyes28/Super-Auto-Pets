package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadPescado extends Habilidad {

    public HabilidadPescado() {
        super("Pescado", "Power-up");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int vidadAtaque = 0;
        if(nivel==1){
            vidadAtaque=1;
        }else{
            vidadAtaque=2;
        }
        for(int i=0; i<mascotasAliadas.length; i++){
            if(mascotasAliadas[i]!= null){
                if(!this.getNombre().equals(mascotasAliadas[i].getNombre())){
                    mascotasAliadas[i].setAtaque(vidadAtaque);
                    mascotasAliadas[i].setVida(vidadAtaque);
                    String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[i].getNombre()+
                            " vida: "+vidadAtaque+" daño: "+vidadAtaque;
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }else{
                break;
            }
        }
    }

    public void activarHabilidadPescado(Mascota [] mascotasAliadas, Mascota mascota, String nombreJugador){
        int vidadAtaque = 0;
        if(mascota.getNivel()==1){
            vidadAtaque=1;
        }else{
            vidadAtaque=2;
        }
        for(int i=0; i<mascotasAliadas.length; i++){
            if(mascotasAliadas[i]!= null){
                if(!this.getNombre().equals(mascotasAliadas[i].getNombre())){
                    mascotasAliadas[i].setAtaque(vidadAtaque);
                    mascotasAliadas[i].setVida(vidadAtaque);
                    String mensajeEfecto ="La mascota del jugador "+nombreJugador+" ---> "+ this.getNombre()+" activa la habilidad: "+getNombreHabilidad()
                            +"\n\tOtorga a " + mascotasAliadas[i].getNombre()+ " vida: "+vidadAtaque+" daño: "+vidadAtaque;

                    System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                    //Archivos.mensajeEfecto(mensajeEfecto);
                }
            }else{
                break;
            }
        }
    }
}
