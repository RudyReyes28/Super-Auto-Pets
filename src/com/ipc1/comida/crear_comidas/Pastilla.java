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
        mascotas[animalSeleccionado] = null;

        Util.verificarMascotas(mascotas);
    }
}
