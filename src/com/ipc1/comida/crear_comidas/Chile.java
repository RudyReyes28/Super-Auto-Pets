package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Chile extends Comida {

    public Chile() {
        super("Chile", true, 4);
    }

    public void activarEfecto(Mascota [] mascotasEnemigas,Mascota mascota, String nombreJugador){
        int cantMascotas = Util.cantidadMascotas(mascotasEnemigas);

        if(cantMascotas>0){
            if( mascotasEnemigas[cantMascotas-1]!=null) {
                mascotasEnemigas[cantMascotas - 1].setVida(-5);
                System.out.println("La mascota "+mascota.getNombre()+" del jugador "+nombreJugador+" activa efecto de la comida y hace 5 de daño a "+
                        mascotasEnemigas[cantMascotas-1].getNombre());
            }

        }

    }
}
