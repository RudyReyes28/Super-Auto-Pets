package com.ipc1.campos.crear_campos;

import com.ipc1.campos.caracter.Campo;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Pantano extends Campo {

    public Pantano() {
        super("Pantano", Util.verde);
    }

    @Override
    public void activarCampo(Mascota[] mascotas, String nombreJugador) {
        for(int i=0; i<= Util.cantidadMascotas(mascotas);i++){
            for(int j=0;j<mascotas[i].getTipo().length;j++){
                if(mascotas[i].getTipo(j)!=null) {
                    if (mascotas[i].getTipo(j).equalsIgnoreCase("reptil")) {

                        mascotas[i].setAtaque(1);
                        mascotas[i].setVida(1);

                        System.out.println("La mascota "+mascotas[i].getNombre()+" del jugador "+nombreJugador
                                + " tiene un buff de +1 de ataque y de vida por estar en el campo "+this.getNombreCampo());

                    }
                }
            }
        }
    }
}
