package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Sushi extends Comida {

    public Sushi() {
        super("Sushi", false, 4);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        int animal1 = 0;
        int animal2 = 1;
        int animal3 = Util.generarRandom(2,4);

        if(mascotas[animal1]!=null){
            mascotas[animal1].setAtaque(1);
            mascotas[animal1].setVida(1);

            System.out.println("Se otorga +1 de vida y +1 de ataque a "+mascotas[animal1].getNombre());
        }
        if(mascotas[animal2]!=null){
            mascotas[animal2].setAtaque(1);
            mascotas[animal2].setVida(1);

            System.out.println("Se otorga +1 de vida y +1 de ataque a "+mascotas[animal2].getNombre());
        }
        if(mascotas[animal3]!=null){
            mascotas[animal3].setAtaque(1);
            mascotas[animal3].setVida(1);

            System.out.println("Se otorga +1 de vida y +1 de ataque a "+mascotas[animal3].getNombre());
        }

    }
}
