package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Ensalada extends Comida {

    public Ensalada() {
        super("Ensalada", false, 3);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        int mascota1 = Util.mascotaEnemigaAleatoria(mascotas);
        int mascota2 = Util.mascotaAleatoria(mascotas,mascotas[mascota1].getNombre());

        if(mascota1 != -1){
            if(mascotas[mascota1]!=null){
                mascotas[mascota1].setAtaque(1);
                mascotas[mascota1].setVida(1);
                System.out.println("Se otorga +1 de vida y +1 de ataque a "+mascotas[mascota1].getNombre());
            }
        }

        if(mascota2 !=-1){
            if(mascotas[mascota2]!=null){
                mascotas[mascota2].setAtaque(1);
                mascotas[mascota2].setVida(1);
                System.out.println("Se otorga +1 de vida y +1 de ataque a "+mascotas[mascota2].getNombre());
            }
        }


    }
}
