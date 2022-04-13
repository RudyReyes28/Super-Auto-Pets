package com.ipc1.campos.crear_campos;

import com.ipc1.campos.caracter.Campo;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Sabana extends Campo {

    private int posicion=0;
    public Sabana() {
        super("Sabana", Util.morado);
    }

    @Override
    public void activarCampo(Mascota[] mascotas, String nombreJugador) {
        if(mascotas[posicion]!=null){
            for(int i=0; i<mascotas[posicion].getTipo().length; i++){
                if(mascotas[posicion].getTipo(i)!=null){
                    if(mascotas[posicion].getTipo(i).equalsIgnoreCase("desertico")){
                        mascotas[posicion].setVida(1);

                        System.out.println("La mascota "+mascotas[i].getNombre()+" del jugador "+nombreJugador
                                + " tiene un buff de +1 de vida por estar en el campo "+this.getNombreCampo());
                    }
                }
            }
        }
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
