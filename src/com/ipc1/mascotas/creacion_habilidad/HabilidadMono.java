package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadMono extends Habilidad {


    public HabilidadMono() {
        super("Mono", "Amistad");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionAmigo = Util.cantidadMascotas(mascotasAliadas);

        try{

            if(posicionAmigo!=-1){
                mascotasAliadas[posicionAmigo].setAtaque(2*nivel);
                mascotasAliadas[posicionAmigo].setVida(3*nivel);

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[posicionAmigo].getNombre()+
                        " dandole una vida de: +"+(3*nivel)+ " y un ataque de: +"+(2*nivel);
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }catch (NullPointerException ignore){

        }
    }
}
