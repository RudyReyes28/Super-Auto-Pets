package com.ipc1.batallas;

import com.ipc1.archivos.Archivos;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

import java.util.Scanner;

public class Batallas {
    public static Mascotas mascotas = new Mascotas();
    public static Jugador jugador1 = new Jugador("Rudy");
    public static Jugador jugador2 = new Jugador("bot");
    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        llenarMascotas(jugador1);
        llenarMascotas(jugador2);
        int opcion = 0;
        /*do {
            System.out.println("\n1. Eliminar Mascota, 2.Ordenar Mascota, 3.Salir");
            opcion = Util.solicitarNumero("Digite la opcion: ",1,3);
            switch (opcion){
                case 1: eliminarMascota(jugador1);
                    break;
                case 2: ordenarMascotas(jugador1);
                    break;
                case 3:
                    break;
            }


        }while(Util.cantidadMascotas(jugador1.getMascotas())!=-1);*/

        iniciarBatalla(jugador1, jugador2);


    }

    public static void iniciarBatalla(Jugador jugador1, Jugador jugador2){
        int ronda = 1;
        int mascotaTurnoJugador1=0;
        int mascotaTurnoJugador2=0;
        double ataqueJugador1 = 0;
        double ataqueJugador2 = 0;
        boolean batallaTerminada = true;

        do{
            System.out.println();
            System.out.println("************** RONDA "+ ronda+" *****************");
            mostrarMascotasBatalla(jugador1,jugador2);

            mascotaTurnoJugador1 = Util.cantidadMascotas(jugador1.getMascotas());

            //ATAQUE JUGADOR 1
            System.out.println("Turno de: "+jugador1.getNombre());
            ataqueJugador1 = jugador1.getMascota(mascotaTurnoJugador1).getAtaque();

            String danioRealizadoMascotas=  jugador1.getMascota(mascotaTurnoJugador1).getNombre() +
                    " ha atacado a "+jugador2.getMascota(mascotaTurnoJugador2).getNombre()+" || Daño: "+ataqueJugador1+"\n";

            String danioRecibidoMascotas = jugador2.getMascota(mascotaTurnoJugador2).getNombre() + " recibió daño de: "+
                    ataqueJugador1+" tenia una vida de: "+jugador2.getMascota(mascotaTurnoJugador2).getVida();
            jugador2.getMascota(mascotaTurnoJugador2).setVida(-ataqueJugador1);
            danioRecibidoMascotas += " y ahora tiene una vida de " + jugador2.getMascota(mascotaTurnoJugador2).getVida()+"\n";

            //CONVOCANDO HABILIDADES
            System.out.println("ACTIVANDO HABILIDAD");
            jugador1.activarHabilidad(mascotaTurnoJugador1, jugador2.getMascotas());
            mostrarMascotasBatalla(jugador1,jugador2);
            System.out.println();

            //ATAQUE JUGADOR 2

            System.out.println("Turno de "+jugador2.getNombre());
            ataqueJugador2 = jugador2.getMascota(mascotaTurnoJugador2).getAtaque();

            danioRealizadoMascotas +=  jugador2.getMascota(mascotaTurnoJugador2).getNombre() +
                    " ha atacado a "+jugador1.getMascota(mascotaTurnoJugador1).getNombre()+" || Daño: "+ataqueJugador2;

            danioRecibidoMascotas += jugador1.getMascota(mascotaTurnoJugador1).getNombre() + " recibió daño de: "+
                    ataqueJugador2+" tenia una vida de: "+jugador1.getMascota(mascotaTurnoJugador1).getVida();

            jugador1.getMascota(mascotaTurnoJugador1).setVida(-ataqueJugador2);

            danioRecibidoMascotas += " y ahora tiene una vida de " + jugador1.getMascota(mascotaTurnoJugador1).getVida();



            //ACTIVANDO HABILIDADES
            System.out.println("ACTIVANDO HABILIDAD");
            jugador2.activarHabilidad(mascotaTurnoJugador2, jugador1.getMascotas());
            mostrarMascotasBatalla(jugador1,jugador2);

            Archivos.mensajeDanioRealizado(danioRealizadoMascotas);
            Archivos.mensajeDanioRecibido(danioRecibidoMascotas);

            System.out.println(Archivos.MensajeEntreBatallas());
            //COMPROBACION
            if(jugador1.getMascota(mascotaTurnoJugador1).getVida()<=0){
                mascotaDerrotada(jugador1, mascotaTurnoJugador1);
            }
            if(jugador2.getMascota(mascotaTurnoJugador2).getVida()<=0){
                mascotaDerrotada(jugador2, mascotaTurnoJugador2);
            }

            //COMPROBAMOS SI QUEDAN MASCOTAS
            if(Util.cantidadMascotas(jugador1.getMascotas())<0 || Util.cantidadMascotas(jugador2.getMascotas())<0){
                batallaTerminada = false;
                Archivos.mensajeFinalDePartida();
            }else{
                System.out.print("Digite cualquier tecla para continuar la siguiente ronda:");
                entrada.nextLine();
            }
            ronda++;

            Archivos.reiniciarMensajeEntreBatallas();

        }while(batallaTerminada);
    }

    public static void mascotaDerrotada(Jugador jugador, int posicion){
        int cantidadMascotas= Util.cantidadMascotas(jugador.getMascotas());
        if(cantidadMascotas>=0) {

            jugador.eliminarMascota(posicion);
            Mascota[] mascotas= jugador.getMascotas();

            for(int i=posicion; i<cantidadMascotas; i++){
                mascotas[i] = mascotas[i+1];
            }
            //eliminamos la ultima mascota
            jugador.eliminarMascota(cantidadMascotas);
        }
    }

    public static void llenarMascotas(Jugador jugador){
        for(int i=0; i<mascotas.getMascotas().length; i++){
            if(mascotas.getMascota(i)!= null){
                jugador.setMascota(mascotas.getMascota(i));
            }else{
                break;
            }
        }
    }

    public static void mostrarMascotas(Jugador jugador){
        System.out.println("Mascotas del jugador: "+jugador.getNombre());
        for(int i=0; i<jugador.getMascotas().length;i++){
            if(jugador.getMascota(i)!= null){
                System.out.print(i+jugador.getMascota(i).toString());
            }
        }
    }

    public static void mostrarMascotasBatalla(Jugador jugador1, Jugador jugador2){

        for(int i=0; i<jugador1.getMascotas().length;i++){
            if(jugador1.getMascota(i)!= null){
                System.out.print(jugador1.getMascota(i).toString()+"|");
            }
        }
        System.out.print("\t\t");
        for(int i=0; i<jugador2.getMascotas().length;i++){
            if(jugador2.getMascota(i)!= null){
                System.out.print(jugador2.getMascota(i).toString()+"|");
            }
        }

        System.out.println();
    }

    public static void eliminarMascota(Jugador jugador){
        mostrarMascotas(jugador);
        int cantidadMascotas= Util.cantidadMascotas(jugador.getMascotas());
        if(cantidadMascotas>=0) {
            int numero=Util.solicitarNumero("Digite la mascota a remover [0,"+cantidadMascotas+"]: ", 0, cantidadMascotas);

            jugador.eliminarMascota(numero);
            Mascota [] mascotas= jugador.getMascotas();

            for(int i=numero; i<cantidadMascotas; i++){
                mascotas[i] = mascotas[i+1];
            }
            //eliminamos la ultima mascota
            jugador.eliminarMascota(cantidadMascotas);

        }else{
            System.out.println("No hay mascotas para quitar");
        }
        mostrarMascotas(jugador);
    }

    public static void ordenarMascotas(Jugador jugador){
        mostrarMascotas(jugador);
        int cantidadMascotas= Util.cantidadMascotas(jugador.getMascotas());
        if(cantidadMascotas>0){
            int mascotaSeleccionada=Util.solicitarNumero("Digite posicion de la mascota a mover [0,"+cantidadMascotas+"]: ", 0, cantidadMascotas);
            int mascotaMovida=Util.solicitarNumero("Digite posicion a donde desea moverla [0,"+cantidadMascotas+"]: ", 0, cantidadMascotas);

            if(mascotaSeleccionada!=mascotaMovida) {
                if(mascotaSeleccionada>mascotaMovida) {
                    Mascota copiaMascota = jugador.getMascota(mascotaSeleccionada);//Aqui creamos una copia de la mascota
                    Mascota[] mascotas = jugador.getMascotas();
                    for (int i = mascotaSeleccionada - 1; i >= mascotaMovida; i--) {
                        mascotas[i + 1] = mascotas[i];
                    }
                    mascotas[mascotaMovida] = copiaMascota;
                }else{
                    Mascota copiaMascota = jugador.getMascota(mascotaSeleccionada);//Aqui creamos una copia de la mascota
                    Mascota[] mascotas = jugador.getMascotas();
                    for (int i = mascotaSeleccionada; i < mascotaMovida; i++) {
                        mascotas[i] = mascotas[i+1];
                    }
                    mascotas[mascotaMovida] = copiaMascota;
                }

                mostrarMascotas(jugador);
            }else{
                mostrarMascotas(jugador);
            }

        }else{
            System.out.println("No hay mascotas para ordenar");
        }
    }



}
