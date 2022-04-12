package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadEscorpion extends Habilidad {


    public HabilidadEscorpion() {
        super("Escorpion", "Aguja");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);

        try{
            if(posicionEnemigo!=-1){
                double ataque = mascotasEnemigas[posicionEnemigo].getVida();

                mascotasEnemigas[posicionEnemigo].setVida(-ataque);

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a " + mascotasEnemigas[posicionEnemigo].getNombre()+
                        " quitandole una vida de: -"+ataque;
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }

    }

    public void activarHabilidadEscorpion(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas){
         int cantMasacotasAliadas = Util.cantidadMascotas(mascotasAliadas);
         int mascotaEnemiga = Util.cantidadMascotas(mascotasEnemigas);

         try {
             if (cantMasacotasAliadas != -1 && mascotaEnemiga != -1) {
                 if (mascotasAliadas[cantMasacotasAliadas].getNombre().equalsIgnoreCase(this.getNombre())) {
                     double ataque = mascotasEnemigas[mascotaEnemiga].getVida();

                     mascotasEnemigas[mascotaEnemiga].setVida(-ataque);

                     String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nAtaca a " + mascotasEnemigas[mascotaEnemiga].getNombre() +
                             " quitandole una vida de: -" + ataque;
                     Archivos.mensajeEfecto(mensajeEfecto);
                 }
             }
         }catch (NullPointerException ignore){

         }
    }
}
