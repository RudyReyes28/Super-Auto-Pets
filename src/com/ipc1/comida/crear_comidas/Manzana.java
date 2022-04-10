package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Manzana extends Comida {

    public Manzana() {
        super("Manzana", false, 1);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        if(mascotas[animalSeleccionado]!=null){
            mascotas[animalSeleccionado].setAtaque(1);
            mascotas[animalSeleccionado].setVida(1);

            System.out.println("Se otorga +1 de vida y +1 de ataque a "+mascotas[animalSeleccionado].getNombre());
        }
    }
}
