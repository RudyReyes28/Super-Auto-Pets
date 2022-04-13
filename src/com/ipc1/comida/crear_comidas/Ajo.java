package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Ajo extends Comida {

    public Ajo() {
        super("Ajo", true, 3);
    }

    public double activarEfecto(Mascota mascota, String nombreJugador){
        System.out.println("La mascota "+mascota.getNombre()+" del jugador "+nombreJugador+" recibe 2 de daño menos");
        return 2;
    }

}
