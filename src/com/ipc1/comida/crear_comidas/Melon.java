package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Melon extends Comida {

    public Melon() {
        super("Melon", true, 5);
    }

    public double activarEfecto(double danio, Mascota mascota, String nombreJugador){
        System.out.println("La mascota "+mascota.getNombre()+" del jugador "+nombreJugador+" anula el ataque recibido");
        return -danio;
    }
}
