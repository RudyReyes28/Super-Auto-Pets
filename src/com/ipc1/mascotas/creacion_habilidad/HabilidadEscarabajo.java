package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadEscarabajo extends Habilidad {
    public HabilidadEscarabajo() {
        super("Escarabajo", "Apetito");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        for(int i = 0; i<mascotasTienda.length; i++){
            if(mascotasTienda[i]!= null){
                mascotasTienda[i].setVida(nivel);

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasTienda[i].getNombre()+
                        " vida: "+nivel;
                Archivos.mensajeEfecto(mensajeEfecto);
            }else{
                break;
            }
        }
    }
}
