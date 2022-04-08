package com.ipc1.batallas;

import com.ipc1.archivos.Archivos;
import com.ipc1.batallas.menu_batallas.CompraMascotas;
import com.ipc1.batallas.menu_batallas.OrdenarVenderMascotas;
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
    private CompraMascotas compra;
    private int ronda = 1;
    private int tier = 1;
    private Mascota [] copiaMascotaJugador = new Mascota[10];

    public ModoArena(String nombre) {
        this.jugador1 = new Jugador(nombre);
        compra = new CompraMascotas();
    }

    public void batalla(){
        boolean batallaCompletada = true;
        do{
            System.out.println("\n***************** RONDA "+ronda+" *****************");
            iniciarBatalla();

            if(jugador1.getVida()<=0 || jugador1.getVictorias()>=10){
                batallaCompletada = false;
                if(jugador1.getVida()<=0){
                    System.out.println("Jugador: "+jugador1.getNombre()+"\tVida: "+jugador1.getVida()+"\t\tOro: "
                            +jugador1.getOro()+"\t\tVictorias: "+jugador1.getVictorias());
                    System.out.println(Util.rojo+"El jugador "+jugador1.getNombre()+" ha perdido"+Util.reset);
                }else if(jugador1.getVictorias()>=10){
                    System.out.println("Jugador: "+jugador1.getNombre()+"\tVida: "+jugador1.getVida()+"\t\tOro: "
                            +jugador1.getOro()+"\t\tVictorias: "+jugador1.getVictorias());
                    System.out.println(Util.verde+"Felicidades, el jugador "+jugador1.getNombre()+" ha ganado"+Util.reset);
                }
            }
        }while (batallaCompletada);
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
                    jugador1.reiniciarOro();

                    if(Util.cantidadMascotas(jugador1.getMascotas())>=0 && Util.cantidadMascotas(bot.getMascotas())<0){
                        System.out.println("\t\tEl jugador "+ jugador1.getNombre()+ " ha ganado esta ronda\n");
                        jugador1.setVictorias();
                    }else if(Util.cantidadMascotas(jugador1.getMascotas())<0 && Util.cantidadMascotas(bot.getMascotas())>=0){
                        //GANO EL BOT
                        System.out.println("\t\tEl jugador "+ bot.getNombre()+ " ha ganado esta ronda\n");
                        jugadorPierde();
                    }else{
                        System.out.println("\t\tEMPATE\n");
                    }

                    //System.out.println(Archivos.mostrarMensajeFinalDePartida());
                }else{
                    Util.solicitarString("Digite cualquier letra para continuar: ");
                    pelea++;
                }

            } while (peleaTerminada);
        }else{
            System.out.println("No tiene ninguna mascota para pelear");
        }
    }

    public void menuEntreBatallas(){

        int opcion = 0;
        compra.llenarMascotasTienda(ronda,tier,mascotasTienda);
        compra.llenarMascotasBot(ronda,tier, bot.getMascotas());
        //VOLVEMOS A REINICIAR LAS MASCOTAS DEL JUGADOR
        jugador1.reiniciarMascotas(copiaMascotaJugador);

        do{
            System.out.println("Jugador: "+jugador1.getNombre()+"\tVida: "+jugador1.getVida()+"\t\tOro: "
                    +jugador1.getOro()+"\t\tVictorias: "+jugador1.getVictorias());

            System.out.println("************* MENÚ ENTRE BATALLAS ***************");
            System.out.println("\t1. Comprar Mascota\n\t2. Comprar Comida\n\t3. Ordenar Mascotas");
            System.out.println("\t4. Fusionar Mascotas\n\t5. Vender Mascotas\n\t6. Empezar Batalla");
            opcion = Util.solicitarNumero("Digite una opcion: ",1,6);

            switch (opcion){
                case 1:
                    System.out.println("Usted tiene las siguientes mascotas en su mazo: ");
                    Util.mostrarMascotas(jugador1);
                    compra.ComprarMascotas(ronda,tier,mascotasTienda,jugador1);
                    copiarMascotas();
                    break;
                case 2: //Comprar Comida
                    break;
                case 3:
                    OrdenarVenderMascotas.ordenarMascotas(jugador1);
                    copiarMascotas();
                    break;
                case 4:
                    OrdenarVenderMascotas.fusionarMascota(jugador1,mascotasTienda);
                    copiarMascotas();
                    break;
                case 5:
                    OrdenarVenderMascotas.venderMascotas(jugador1);
                    copiarMascotas();
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

    public CompraMascotas getCompra() {
        return compra;
    }

    public void copiarMascotas() {

        for (int i = 0; i < jugador1.getMascotas().length; i++) {
            if (jugador1.getMascota(i) != null) {
                copiaMascotaJugador[i] = new Mascota(jugador1.getMascota(i));
            }
        }
    }

}
