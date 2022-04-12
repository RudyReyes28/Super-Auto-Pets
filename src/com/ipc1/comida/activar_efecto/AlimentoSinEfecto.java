package com.ipc1.comida.activar_efecto;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.comida.crear_comidas.*;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.caracter.Mascota;

public class AlimentoSinEfecto {

    public static void activarAlimentoSinEfecto(Comida comida, Mascota [] mascotasJugador, int posicion, Mascota[] mascotasTienda, Jugador jugador){

        if(comida instanceof Manzana){
            comida.activarEfecto(mascotasJugador,posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Pastelito){
            comida.activarEfecto(mascotasJugador,posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Pastilla){
            comida.activarEfecto(mascotasJugador,posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Ensalada){
            comida.activarEfecto(mascotasJugador,posicion);
            jugador.setOro(-3);

        }else if(comida instanceof ComidaEnlatada){
            comida.activarEfecto(mascotasTienda, posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Pera){
            comida.activarEfecto(mascotasTienda, posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Chocolate){
            comida.activarEfecto(mascotasTienda, posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Sushi){
            comida.activarEfecto(mascotasTienda, posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Pizza){
            comida.activarEfecto(mascotasTienda, posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Gelatina){
            comida.activarEfecto(mascotasTienda, posicion);
            jugador.setOro(-3);

        }else if(comida instanceof Leche){
            comida.activarEfecto(mascotasTienda, posicion);
        }


    }
}
