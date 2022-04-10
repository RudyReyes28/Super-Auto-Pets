package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Pastelito extends Comida {

    public Pastelito() {
        super("Pastelito", false, 2);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        if(mascotas[animalSeleccionado]!=null){
            mascotas[animalSeleccionado].setAtaque(3);
            mascotas[animalSeleccionado].setVida(3);

            System.out.println("Se otorga +3 de vida y +3 de ataque a "+mascotas[animalSeleccionado].getNombre());
        }
    }
}
