package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadPescado extends Habilidad {

    public HabilidadPescado(String nombre) {
        super(nombre);
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
                    String mensajeEfecto = this.getNombre()+" otorga a" + mascotasAliadas[i].getNombre()+
                            " vida: "+vidadAtaque+" daño: "+vidadAtaque;
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }else{
                break;
            }
        }
    }
}
