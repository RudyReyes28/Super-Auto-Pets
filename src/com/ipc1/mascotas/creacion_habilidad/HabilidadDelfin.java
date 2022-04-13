package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadDelfin extends Habilidad {


    public HabilidadDelfin() {
        super("Delfin", "Salpicon");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionMascotaEnemiga=0;
        double vidaMascotaEnemigo= 20;
        for(int i=0; i<mascotasEnemigas.length;i++){
            if(mascotasEnemigas[i]!=null){
                if(vidaMascotaEnemigo>mascotasEnemigas[i].getVida()){
                    vidaMascotaEnemigo = mascotasEnemigas[i].getVida();
                    posicionMascotaEnemiga=i;
                }
            }
        }

        if(mascotasEnemigas[posicionMascotaEnemiga]!=null){
            mascotasEnemigas[posicionMascotaEnemiga].setVida(-5*nivel);
            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nHace daño a " + mascotasEnemigas[posicionMascotaEnemiga].getNombre()+
                    " le quita una vida de: -"+(nivel*5);
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

    public void activarHabilidadDelfin(Mascota[] mascotasEnemigas,Mascota delfin, String nombreJugador){
        int posicionMascotaEnemiga=0;
        double vidaMascotaEnemigo= 20;
        for(int i=0; i<mascotasEnemigas.length;i++){
            if(mascotasEnemigas[i]!=null){
                if(vidaMascotaEnemigo>mascotasEnemigas[i].getVida()){
                    vidaMascotaEnemigo = mascotasEnemigas[i].getVida();
                    posicionMascotaEnemiga=i;
                }
            }
        }

        if(mascotasEnemigas[posicionMascotaEnemiga]!=null){
            mascotasEnemigas[posicionMascotaEnemiga].setVida(-5*delfin.getNivel());
            String mensajeEfecto ="La mascota del jugador "+nombreJugador+" ---> "+ this.getNombre()+" activa la habilidad "+getNombreHabilidad()
                    +"\n\tHace daño a " + mascotasEnemigas[posicionMascotaEnemiga].getNombre()+
                    " le quita una vida de: -"+(delfin.getNivel()*5);
            Archivos.mensajeEfectosInicio(mensajeEfecto);
        }
    }
}
