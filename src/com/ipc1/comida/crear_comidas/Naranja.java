package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Naranja extends Comida {

    public Naranja() {
        super("Naranja", true, 1);
    }

    public double activarEfecto(Mascota[] mascotasEnemigas){
        double danio=0;
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);

        if(posicionEnemigo!=-1){
            danio = mascotasEnemigas[posicionEnemigo].getAtaque()*0.1;
        }

        System.out.println("Se regresa "+danio+"al enemigo");

        return danio;
    }
}
