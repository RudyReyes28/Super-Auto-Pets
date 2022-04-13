package com.ipc1.campos.crear_campos;

import com.ipc1.campos.caracter.Campo;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class SinCampo extends Campo {

    public SinCampo() {
        super("Sin campo", Util.blanco);
    }

    @Override
    public void activarCampo(Mascota[] mascotas, String nombreJugador) {
        int cant = cantidadSolitarios(mascotas);
        if(cant==1){
            for(int i=0; i<= Util.cantidadMascotas(mascotas);i++){
                for(int j=0;j<mascotas[i].getTipo().length;j++){
                    if(mascotas[i].getTipo(j)!=null) {
                        if (mascotas[i].getTipo(j).equalsIgnoreCase("solitario")) {

                            mascotas[i].setAtaque(3);
                            mascotas[i].setVida(3);

                            System.out.println("La mascota "+mascotas[i].getNombre()+" del jugador "+nombreJugador
                                    + " tiene un buff de +3 de ataque y de vida por estar en el campo "+this.getNombreCampo());

                        }
                    }
                }
            }
        }
    }

    private int cantidadSolitarios(Mascota[] mascotas){
        int cant=0;

        for (int i = 0; i <= Util.cantidadMascotas(mascotas); i++) {
            for (int j = 0; j < mascotas[i].getTipo().length; j++) {
                if (mascotas[i].getTipo(j) != null) {
                    if (mascotas[i].getTipo(j).equalsIgnoreCase("solitario")) {

                        cant++;

                    }
                }
            }

        }

        return cant;
    }
}
