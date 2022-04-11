package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadHormiga extends Habilidad {


    public HabilidadHormiga() {
        super("Hormiga", "Compañerismo");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int mascotaAleatoria = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());

        if(mascotaAleatoria!=-1){
            mascotasAliadas[mascotaAleatoria].setAtaque(nivel*2);
            mascotasAliadas[mascotaAleatoria].setVida(nivel);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[mascotaAleatoria].getNombre()+
                    " vida: +"+nivel+" daño: +"+nivel*2;
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

    public void activarHabilidadHormiga(Mascota[] mascotasAliadas, Mascota hormiga){
        if(hormiga.getVida()<=0){
            int mascotaAleatoria = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());

            if(mascotaAleatoria!=-1){
                mascotasAliadas[mascotaAleatoria].setAtaque(hormiga.getNivel()*2);
                mascotasAliadas[mascotaAleatoria].setVida(hormiga.getNivel());

                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[mascotaAleatoria].getNombre()+
                        " vida: +"+hormiga.getNivel()+" daño: +"+hormiga.getNivel()*2;
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }
    }
}
