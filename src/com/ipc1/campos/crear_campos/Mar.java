package com.ipc1.campos.crear_campos;

import com.ipc1.campos.caracter.Campo;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Mar extends Campo {

    public Mar() {
        super("Mar", Util.azul);
    }

    @Override
    public void activarCampo(Mascota[] mascotas) {
        for (int i = 0;i<= Util.cantidadMascotas(mascotas); i++) {
            for (int j = 0; j < mascotas[i].getTipo().length; j++) {
                if (mascotas[i].getTipo(j) != null) {
                    if (mascotas[i].getTipo(j).equalsIgnoreCase("acuatico")) {

                        mascotas[i].setAtaque(1);
                        mascotas[i].setVida(1);

                    }
                }
            }

        }
    }
}