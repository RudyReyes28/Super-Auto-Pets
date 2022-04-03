package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadRata extends Habilidad{


    public HabilidadRata() {
        super("Rata", "Ayuda hipocrita");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascota rata1 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "));
        Mascota rata2 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "));
        Mascota rata3 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "));

        int posicionRata = Util.cantidadMascotas(mascotasAliadas);

        if(posicionRata!=-1){
            if(nivel==1){
                mascotasAliadas[posicionRata+1] = rata1;

            }else if(nivel==2){
                mascotasAliadas[posicionRata+1] = rata1;
                mascotasAliadas[posicionRata+2] = rata2;

            }else if(nivel==3){
                mascotasAliadas[posicionRata+1] = rata1;
                mascotasAliadas[posicionRata+2] = rata2;
                mascotasAliadas[posicionRata+3] = rata3;
            }
        }

        String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nInvoca a Dirty Rats";
        Archivos.mensajeEfecto(mensajeEfecto);
    }
}
