package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Pastilla extends Comida {

    public Pastilla() {
        super("Pastilla para dormir", false, 2);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        System.out.println("La mascota "+mascotas[animalSeleccionado]+" se ha puesto a dormir");
        mascotas[animalSeleccionado] = null;
        System.out.println("");

        Util.verificarMascotas(mascotas);
    }
}
