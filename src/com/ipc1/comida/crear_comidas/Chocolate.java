package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Chocolate extends Comida {

    public Chocolate() {
        super("Chocolate", false, 4);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        if(mascotas[animalSeleccionado]!=null){
            mascotas[animalSeleccionado].setExp(1);
            System.out.println("Se le ha dado +1 de exp a "+mascotas[animalSeleccionado].getNombre());
        }
    }
}
