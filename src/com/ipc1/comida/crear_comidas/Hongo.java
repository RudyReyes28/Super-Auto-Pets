package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Hongo extends Comida {

    public Hongo() {
        super("Hongo", true, 5);
    }

    public void activarHabilidad(Mascota mascota){

        if(mascota.getVida()<=0) {
            mascota.reiniciarVida(1);
            mascota.reiniciarAtaque(1);

            System.out.println("La mascota " + mascota.getNombre() + " resucita con (1/1)");
        }
    }
}
