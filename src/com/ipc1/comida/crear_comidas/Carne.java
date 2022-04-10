package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Carne extends Comida {

    public Carne() {
        super("Carne", true, 6);
    }

    public double activarEfecto(Mascota mascota){
        System.out.println("Aumenta  el daño en +20 "+mascota.getNombre());
        return 20;
    }
}
