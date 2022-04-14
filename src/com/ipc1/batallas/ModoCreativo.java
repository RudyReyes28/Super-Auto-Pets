package com.ipc1.batallas;

import com.ipc1.batallas.menu_batallas.CompraModoCreativo;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.caracter.Mascota;

public class ModoCreativo {

    private Mascota[] mascotasJugador1 = new Mascota[54];
    private Mascota[] mascotasJugador2 = new Mascota[54];
    private Jugador jugador1;
    private Jugador jugador2;


    public ModoCreativo(String nombreJugador1, String nombreJugador2) {
        jugador1 = new Jugador(nombreJugador1);
        jugador2 = new Jugador(nombreJugador2);

        llenarMascotas(mascotasJugador1);
        llenarMascotas(mascotasJugador2);
    }

    public void jugar(){
        CompraModoCreativo.comprarMascotas(mascotasJugador1,jugador1);
    }

    public void llenarMascotas(Mascota [] mascotasJugador){
        Mascotas mascotasTotales = new Mascotas();

        for(int i=0; i<mascotasJugador.length; i++){
            mascotasJugador[i] = new Mascota(mascotasTotales.getMascota(i));
        }
    }
}
