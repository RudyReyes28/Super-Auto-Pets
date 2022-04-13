package com.ipc1.campos.crear_campos;

import com.ipc1.campos.caracter.Campo;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Bosque extends Campo {

    public Bosque() {
        super("Bosque", Util.verde);
    }

    @Override
    public void activarCampo(Mascota[] mascotas, String nombreJugador) {
        for (int i = 0; i <= Util.cantidadMascotas(mascotas); i++) {
            for (int j = 0; j < mascotas[i].getTipo().length; j++) {
                if (mascotas[i].getTipo(j) != null) {
                    if (mascotas[i].getTipo(j).equalsIgnoreCase("terrestre")) {

                        mascotas[i].setAtaque(2);
                        System.out.println("La mascota "+mascotas[i].getNombre()+" del jugador "+nombreJugador
                                + " tiene un buff de +2 de ataque por estar en el campo "+this.getNombreCampo());

                    }
                    if (mascotas[i].getTipo(j).equalsIgnoreCase("mamifero")) {

                        mascotas[i].setVida(2);
                        System.out.println("La mascota "+mascotas[i].getNombre()+" del jugador "+nombreJugador
                                + " tiene un buff de +2 de vida por estar en el campo "+this.getNombreCampo());
                    }

                    if(mascotas[i].getTipo(j).equalsIgnoreCase("solitario")){
                        double ataqueNerf = mascotas[i].getAtaque() * 0.2;
                        mascotas[i].setAtaque(-ataqueNerf);
                        System.out.println("La mascota "+mascotas[i].getNombre()+" del jugador "+nombreJugador
                                + " tiene un nerf de -"+ataqueNerf +" de ataque por estar en el campo "+this.getNombreCampo());
                    }
                }
            }

        }
    }
}
