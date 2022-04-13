package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class HuesoDeCarne extends Comida {

    public HuesoDeCarne() {
        super("Hueso de Carne", true, 2);
    }

    public double activarEfecto(Mascota mascota, String nombreJugador){
        System.out.println("La mascota "+mascota.getNombre()+" del jugador "+nombreJugador+" aumenta  el daño en +5 "+mascota.getNombre());
        return 5;
    }
}
