package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Naranja extends Comida {

    public Naranja() {
        super("Naranja", true, 1);
    }

    public double activarEfecto(Mascota[] mascotasEnemigas, Mascota mascota, String nombreJugador){
        double danio=0;
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);

        if(posicionEnemigo!=-1){
            danio = mascotasEnemigas[posicionEnemigo].getAtaque()*0.1;
        }

        System.out.println("La mascota "+mascota.getNombre()+" del jugador "+nombreJugador+ " activa el efecto de la "+this.getNombre() );
        System.out.printf("\tSe regresa %.2f de daño al enemigo",danio);
        System.out.println();

        return danio;
    }
}
