package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadLobo extends Habilidad {


    public HabilidadLobo() {
        super("Lobo", "Aullido");

    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionLobo = Util.cantidadMascotas(mascotasAliadas);

        if(posicionLobo==0 && mascotasAliadas[posicionLobo]!=null){
            if(nivel == 1 || nivel== 2){
                mascotasAliadas[posicionLobo].setAtaque(nivel+1);
                mascotasAliadas[posicionLobo].setVida(nivel+1);

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAdquiere "
                        + " un ataque de: +"+(nivel+1)+" y una vida de: +"+(nivel+1);
                Archivos.mensajeEfecto(mensajeEfecto);
            }else if(nivel == 3){
                mascotasAliadas[posicionLobo].setAtaque(5);
                mascotasAliadas[posicionLobo].setVida(5);
                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAdquiere "
                        + " un ataque de: +5 y una vida de: +5";
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }
    }
}
