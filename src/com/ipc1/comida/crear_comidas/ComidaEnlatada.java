package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;

public class ComidaEnlatada extends Comida {

    public ComidaEnlatada() {
        super("Comida enlatada", false, 3);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        for(int i=0; i<mascotas.length; i++){
            if(mascotas[i]!=null){
                mascotas[i].setAtaque(2);
                mascotas[i].setVida(1);
            }
        }

        System.out.println("Se le han dado +1 de vida y +2 de daño a todos los animales de la tienda");
    }
}
