package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadCaballo;
import com.ipc1.mascotas.creacion_habilidad.HabilidadChompipe;
import com.ipc1.util.Util;

public class Miel extends Comida {


    public Miel() {
        super("Miel", true, 1);
    }

    public void efectoMascota(Mascota [] mascotasAliadas, Mascota mascota, String nombreJugador){
        Mascota abeja = new Mascota("Abeja",1,1,"volador",null,null,new Habilidad("Abeja",""));

        int cantMascotas = Util.cantidadMascotas(mascotasAliadas);

        try {
            if(mascota.getVida()<=0) {
                if (cantMascotas != -1) {
                    mascotasAliadas[cantMascotas + 1] = abeja;
                    System.out.println("La mascota "+mascota.getNombre()+" del jugador "+nombreJugador+" Se invoca una abeja al equipo");

                    activarHabilidadDeInvocados(mascotasAliadas, nombreJugador);
                }
            }
        }catch (NullPointerException ignore){

        }
    }

    public void activarHabilidadDeInvocados(Mascota [] mascotasAliadas, String nombreJugador){

        for(int i=0; i<=Util.cantidadMascotas(mascotasAliadas); i++) {
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Caballo")){
                ((HabilidadCaballo)mascotasAliadas[i].getHabilidad()).activarHabilidadCaballo(mascotasAliadas,mascotasAliadas[i], nombreJugador);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Chompipe")){
                ((HabilidadChompipe)mascotasAliadas[i].getHabilidad()).activarHabilidadChompipe(mascotasAliadas,mascotasAliadas[i], nombreJugador);

            }
        }
    }


}
