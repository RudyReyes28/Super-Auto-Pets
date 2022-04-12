package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadTigre extends Habilidad {


    public HabilidadTigre() {
        super("Tigre", "Repeticion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionTigre = Util.posicionMascota(mascotasAliadas,this.getNombre());

        try{
            if(posicionTigre!=-1) {
                if (mascotasAliadas[posicionTigre + 1] != null) {
                    mascotasAliadas[posicionTigre+1].activarHabilidad(mascotasAliadas,mascotasEnemigas,mascotasTienda);

                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nHace que " + mascotasAliadas[posicionTigre+1].getNombre()+
                            " active nuevamente su habilidad";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }
    }

    public void activarHabilidadTigre(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas){
        int posicionTigre = Util.cantidadMascotas(mascotasAliadas);

        try{
            if(posicionTigre!=-1) {
                if(mascotasAliadas[posicionTigre-1].getNombre().equalsIgnoreCase("Tigre")) {
                    if (mascotasAliadas[posicionTigre + 1] != null) {
                        mascotasAliadas[posicionTigre + 1].activarHabilidad(mascotasAliadas, mascotasEnemigas, null);

                        String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nHace que " + mascotasAliadas[posicionTigre + 1].getNombre() +
                                " active nuevamente su habilidad";
                        Archivos.mensajeEfecto(mensajeEfecto);
                    }
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }
    }
}
