package com.ipc1.batallas;

import com.ipc1.archivos.Archivos;
import com.ipc1.batallas.menu_batallas.CompraMascotas;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

import java.util.Scanner;

public class ModoArena {

    private Scanner entrada = new Scanner(System.in);
    private Jugador jugador1;
    private Jugador bot = new Jugador("Toretto");
    private Mascotas mascotas = new Mascotas();
    private Mascota [] mascotasTienda = new Mascota[5];
    CompraMascotas compra;
    private int ronda = 1;
    private int tier = 1;

    public ModoArena(String nombre) {
        this.jugador1 = new Jugador(nombre);
        compra = new CompraMascotas();
    }

    public void iniciarBatalla(){
        menuEntreBatallas();

        if(Util.cantidadMascotas(jugador1.getMascotas())>=0) {
            boolean peleaTerminada = true;
            int pelea = 1;

            do {
                System.out.println("************************* PELEA " + pelea + " *************************");
                Util.mostrarMascotasBatalla(jugador1, bot);
                System.out.println("\nPelea iniciada");
                jugador1.pelear(bot);
                bot.pelear(jugador1);

                System.out.println("Pelea finalizada\n");
                Util.mostrarMascotasBatalla(jugador1, bot);
                System.out.println(Archivos.MensajeEntreBatallas());

                Archivos.reiniciarMensajeEntreBatallas();

                Util.mascotasDebilitadas(jugador1);
                Util.mascotasDebilitadas(bot);

                //COMPROBAMOS SI QUEDAN MASCOTAS

                if(Util.cantidadMascotas(jugador1.getMascotas())<0 || Util.cantidadMascotas(bot.getMascotas())<0){
                    peleaTerminada = false;
                    ronda ++;
                    aumentarTier();

                    if(Util.cantidadMascotas(jugador1.getMascotas())>=0 && Util.cantidadMascotas(bot.getMascotas())<0){
                        System.out.println("El jugador "+ jugador1.getNombre()+ " ha ganado esta ronda\n");
                        jugador1.setVictorias();
                    }else if(Util.cantidadMascotas(jugador1.getMascotas())<0 && Util.cantidadMascotas(bot.getMascotas())>=0){
                        //GANO EL BOT
                        System.out.println("El jugador "+ bot.getNombre()+ " ha ganado esta ronda\n");
                        jugadorPierde();
                    }else{
                        System.out.println("Empate\n");
                    }

                    System.out.println(Archivos.mostrarMensajeFinalDePartida());
                }else{
                    Util.solicitarString("Digite cualquier letra para continuar: ");
                    pelea++;
                }

            } while (peleaTerminada);
        }else{
            System.out.println("No tiene niguna mascota para pelear");
        }
    }

    public void menuEntreBatallas(){
        //Comprar Mascota
        //Comprar Comida
        //Ordenar Mascotas
        //Fusionar Mascotas
        //Vender Mascotas
        //Empezar Batalla
        //Retirarse

        int opcion = 0;
        compra.llenarMascotasTienda(ronda,tier,mascotasTienda);
        compra.llenarMascotasBot(ronda,tier, bot.getMascotas());

        do{
            System.out.println("************* MENÚ ENTRE BATALLAS ***************");
            System.out.println("\t1. Comprar Mascota\n\t2. Comprar Comida\n\t3.Ordenar Mascotas");
            System.out.println("\t4. Fusionar Mascotas\n\t5. Vender Mascotas\n\t6. Empezar Batalla");
            opcion = Util.solicitarNumero("Digite una opcion: ",1,6);

            switch (opcion){
                case 1: compra.ComprarMascotas(ronda,tier,mascotasTienda,jugador1);
                    break;
                case 2: //Comprar Comida
                    break;
                case 3: //Ordenar Mascotas
                    break;
                case 4: //Fusionar Mascotas
                    break;
                case 5: //Vender mascotas
                    break;

                default:
                    System.out.println("SUERTE !!!\n");
            }
        }while(opcion!=6);

    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getBot() {
        return bot;
    }

    public void jugadorPierde(){
        if(ronda<= 3){
            jugador1.setVida(-1);
        }else if(ronda<=6){
            jugador1.setVida(-2);
        }else{
            jugador1.setVida(-3);
        }
    }

    public void aumentarTier(){

        if(ronda%2==0 && ronda <= 12){
            tier++;
        }
    }

    /*public void ComprarMascotas(){

    }

    public void llenarMascotasTienda(){
        int animalesDisponibles = 0;
        if(ronda <= 3){
            animalesDisponibles = 3;
        }else if(ronda <=6){
            animalesDisponibles = 4;
        }else{
            animalesDisponibles = 5;
        }

        for(int i=0; i<animalesDisponibles; i++){
            int mascotaAleatoria = Util.generarRandom(0,desbloqueoTier());

            mascotasTienda[i] = new Mascota(mascotas.getMascota(mascotaAleatoria));
        }
    }

    public int verTier(){

        if(ronda%2==0 && ronda <= 12){
            tier++;
        }

        return tier;
    }

    public int desbloqueoTier(){
        int desbloqueo=0;

        switch (verTier()){
            case 1:
                desbloqueo=7;
                break;
            case 2:
                desbloqueo= 15;
                break;
            case 3:
                desbloqueo = 26;
                break;
            case 4:
                desbloqueo= 34;
                break;
            case 5:
                desbloqueo= 42;
                break;
            case 6:
                desbloqueo= 51;
                break;
            case 7:
                desbloqueo= 53;
                break;
        }


        return desbloqueo;
    }

     */

}
