package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Pizza extends Comida {

    public Pizza() {
        super("Pizza", false, 6);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        int mascota1 = Util.mascotaEnemigaAleatoria(mascotas);
        int mascota2 = Util.mascotaAleatoria(mascotas,mascotas[mascota1].getNombre());

        if(mascota1 != -1){
            if(mascotas[mascota1]!=null){
                mascotas[mascota1].setAtaque(2);
                mascotas[mascota1].setVida(2);
                System.out.println("Se otorga +2 de vida y +2 de ataque a "+mascotas[mascota1].getNombre());
            }
        }

        if(mascota2 !=-1){
            if(mascotas[mascota2]!=null){
                mascotas[mascota2].setAtaque(2);
                mascotas[mascota2].setVida(2);
                System.out.println("Se otorga +2 de vida y +2 de ataque a "+mascotas[mascota2].getNombre());
            }
        }
    }
}
