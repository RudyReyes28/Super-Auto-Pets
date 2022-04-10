package com.ipc1.campos.crear_campos;

import com.ipc1.campos.caracter.Campo;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Granja extends Campo {

    public Granja() {
        super("Granja", Util.amarillo);
    }

    @Override
    public void activarCampo(Mascota[] mascotas) {
        for (int i = 0; i<= Util.cantidadMascotas(mascotas); i++) {
            for (int j = 0; j < mascotas[i].getTipo().length; j++) {
                if (mascotas[i].getTipo(j) != null) {
                    if (mascotas[i].getTipo(j).equalsIgnoreCase("domestico")) {

                        mascotas[i].setAtaque(1);
                        mascotas[i].setVida(1);

                    }
                    if (mascotas[i].getTipo(j).equalsIgnoreCase("mamifero")) {

                        mascotas[i].setAtaque(1);
                        mascotas[i].setVida(1);

                    }

                    if(mascotas[i].getTipo(j).equalsIgnoreCase("solitario")){
                        double ataqueNerf = mascotas[i].getAtaque() * 0.2;
                        mascotas[i].setAtaque(-ataqueNerf);

                    }
                }
            }

        }
    }
}
