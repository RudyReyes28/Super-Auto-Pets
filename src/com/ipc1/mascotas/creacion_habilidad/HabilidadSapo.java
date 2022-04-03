package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadSapo extends Habilidad {

    public HabilidadSapo() {
        super("Sapo", "Metamorfosis");

    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionSapo=0;
        int posicionMascota=0;
        double vidaMayor = 0;
        int cantidad = Util.cantidadMascotas(mascotasAliadas);
        if(cantidad>0){
            for(int i=0; i<mascotasAliadas.length; i++){
                if(mascotasAliadas[i]!= null) {
                    if (!mascotasAliadas[i].getNombre().equals(this.getNombre())) {
                        if (vidaMayor < mascotasAliadas[i].getVida()) {
                            vidaMayor = mascotasAliadas[i].getVida();
                            posicionMascota=i;
                        }
                    }else{
                        posicionSapo=i;
                    }
                }else{
                    break;
                }
            }
        }
        if(mascotasAliadas[posicionSapo]!=null){
            mascotasAliadas[posicionSapo].setVida(vidaMayor);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nCopia de " + mascotasAliadas[posicionMascota].getNombre()+
                    " una vida: "+vidaMayor;
            Archivos.mensajeEfecto(mensajeEfecto);
        }

    }
}
