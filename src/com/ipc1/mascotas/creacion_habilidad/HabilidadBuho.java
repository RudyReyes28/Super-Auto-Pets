package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadBuho extends Habilidad {


    public HabilidadBuho() {
        super("Buho", "Suerte amigos");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int mascotaAleatoria = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());

        if(mascotasAliadas[mascotaAleatoria]!=null){
            mascotasAliadas[mascotaAleatoria].setAtaque(nivel*2);
            mascotasAliadas[mascotaAleatoria].setVida(nivel*2);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[mascotaAleatoria].getNombre()+
                    " vida: +"+(nivel*2)+" ataque: +"+(nivel*2);
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

    public void activarHabilidadBuho(Mascota [] mascotasAliadas, Mascota buho, String nombreJugador){

        int mascotaAleatoria = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());

        try {
            if (mascotaAleatoria != -1) {
                mascotasAliadas[mascotaAleatoria].setAtaque(buho.getNivel() * 2);
                mascotasAliadas[mascotaAleatoria].setVida(buho.getNivel() * 2);

                String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad " + getNombreHabilidad()
                        + "\n\tOtorga a " + mascotasAliadas[mascotaAleatoria].getNombre() +
                        " vida: +" + (buho.getNivel() * 2) + " ataque: +" + (buho.getNivel() * 2);

                System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                //Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (NullPointerException ignore){

        }
    }
}
