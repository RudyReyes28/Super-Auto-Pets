package com.ipc1;

import com.ipc1.batallas.ModoArena;
import com.ipc1.batallas.ModoCreativo;
import com.ipc1.batallas.ModoVersus;
import com.ipc1.util.Util;

public class Jugar {

    public static void main(String[] args) {
        int opcion = 0;

        do{
            System.out.println("************ BIENVENIDO A SUPER AUTO PETS *****************");
            System.out.println("\t\t PUEDE JUGAR LOS SIGUIENTES MODOS DE JUEGO: ");
            System.out.println("1. Modo Arena\t2. Modo Versus\t3. Modo Creativo\t4. Salir del juego");
            opcion = Util.solicitarNumero("Dijite una opcion: ",1,4);

            if(opcion==1){
                String nombreJugador = Util.solicitarString("Escriba el nombre del jugador: ");
                ModoArena batallaArena = new ModoArena(nombreJugador);
                batallaArena.batalla();

            }else if(opcion==2){
                String nombreJugador1 = Util.solicitarString("Escriba el nombre del jugador 1: ");
                String nombreJugador2 = Util.solicitarString("Escriba el nombre del jugador 2: ");
                ModoVersus batallaVersus = new ModoVersus(nombreJugador1,nombreJugador2);
                batallaVersus.batalla();

            }else if(opcion == 3){
                String nombreJugadorCreativo1 = Util.solicitarString("Escriba el nombre del jugador 1: ");
                String nombreJugadorCreativo2 = Util.solicitarString("Escriba el nombre del jugador 2: ");
                ModoCreativo batallaCreativo = new ModoCreativo(nombreJugadorCreativo1,nombreJugadorCreativo2);
                batallaCreativo.batalla();
            }else{
                System.out.println("VUELVA PRONTO");
            }


        }while(opcion!=4);

    }
}
