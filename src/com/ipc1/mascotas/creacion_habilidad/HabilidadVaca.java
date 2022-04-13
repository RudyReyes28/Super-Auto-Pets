package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.comida.crear_comidas.Leche;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadVaca extends Habilidad {


    public HabilidadVaca() {
        super("Vaca", "Leche potenciadora");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        //POR DEFINIR
    }

    public void activarHabilidadVaca(Comida []  comidaTienda, Mascota vaca, String nombre){
        for(int i=0; i<comidaTienda.length; i++){
            comidaTienda[i] = new Leche(vaca.getNivel());
        }
        System.out.println(Util.rojo+"La mascota del jugador "+nombre+" ---> Vaca activa su habilidad "+getNombreHabilidad()+" \n\tY reemplaza la tienda con leche gratis"+Util.reset);
    }
}
