package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Pera extends Comida {

    public Pera() {
        super("Pera", false, 3);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        if(mascotas[animalSeleccionado]!=null){
            mascotas[animalSeleccionado].setAtaque(2);
            mascotas[animalSeleccionado].setVida(2);

            System.out.println("Se otorga +2 de vida y +2 de ataque a "+mascotas[animalSeleccionado].getNombre());
        }
    }
}
