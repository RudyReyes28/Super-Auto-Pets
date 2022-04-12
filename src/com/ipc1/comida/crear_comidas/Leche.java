package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class Leche extends Comida {

    private int nivel=1;
    public Leche(int nivel) {
        super("Leche", false, 0);
        this.nivel = nivel;
    }


    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        if(mascotas[animalSeleccionado]!=null){
            mascotas[animalSeleccionado].setAtaque(nivel);
            mascotas[animalSeleccionado].setVida(2*nivel);

            System.out.println("Se otorga +1 de vida y +1 de ataque a "+mascotas[animalSeleccionado].getNombre());
        }
    }
}
