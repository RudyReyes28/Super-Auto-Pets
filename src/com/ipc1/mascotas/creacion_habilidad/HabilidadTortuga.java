package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.comida.crear_comidas.Melon;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadTortuga extends Habilidad {

    public HabilidadTortuga() {
        super("Tortuga", "Proteccion Aliada");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        //MELON ARMOR
    }

    public void activarHabilidadTortuga(Mascota [] mascotasAliadas,Mascota tortuga, int posicion){

        if(tortuga.getVida()<=0) {
            for(int i=posicion-1;i>= posicion-tortuga.getNivel();i--){
                if(i>=0){
                    if(mascotasAliadas[i]!=null){
                        mascotasAliadas[i].setEfectoComida(new Melon());
                        String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nLe da a " + mascotasAliadas[i].getNombre() +
                                " Melon Armor";
                        Archivos.mensajeEfecto(mensajeEfecto);
                    }
                }
            }
        }

    }
}
