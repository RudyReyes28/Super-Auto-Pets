package com.ipc1.batallas;

import com.ipc1.archivos.ArchivoInformacionBatalla;
import com.ipc1.archivos.Archivos;
import com.ipc1.batallas.menu_batallas.CompraComida;
import com.ipc1.batallas.menu_batallas.CompraMascotas;
import com.ipc1.batallas.menu_batallas.OrdenarVenderMascotas;
import com.ipc1.campos.Campos;
import com.ipc1.campos.caracter.Campo;
import com.ipc1.comida.caracter.Comida;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.activacion_habilidad.ActivarHabilidades;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

import java.util.Scanner;

public class ModoArena {

    private Scanner entrada = new Scanner(System.in);
    private Jugador jugador1;
    private Jugador bot = new Jugador("Toretto");
    private Mascota [] mascotasTienda = new Mascota[5];
    private Comida[] comidasTienda = new Comida[2];
    private CompraMascotas compra;
    private int ronda = 1;
    private int tier = 1;
    private Mascota [] copiaMascotaJugador = new Mascota[10];
    private Campos campos = new Campos();
    private Campo campoJugador;
    private Campo campoBot;

    private ArchivoInformacionBatalla infoBatallas;


    public ModoArena(String nombre) {
        this.jugador1 = new Jugador(nombre);
        compra = new CompraMascotas();

        infoBatallas = new ArchivoInformacionBatalla("InformacionBatallasArena.txt");
    }

    public void batalla(){
        boolean batallaCompletada = true;
        do{
            System.out.println("\n***************** RONDA "+ronda+" *****************");

            iniciarBatalla();

            if(jugador1.getVida()<=0 || jugador1.getVictorias()>=10){

                infoBatallas.escribirLasBatallas(Archivos.mostrarMensajeFinalDePartida());
                System.out.println(Archivos.mostrarMensajeFinalDePartida());
                Archivos.reiniciarMensajeFinalDePartida();

                batallaCompletada = false;
                if(jugador1.getVida()<=0){
                    System.out.println("Jugador: "+jugador1.getNombre()+"\tVida: "+jugador1.getVida()+"\t\tOro: "
                            +jugador1.getOro()+"\t\tVictorias: "+jugador1.getVictorias());
                    System.out.println(Util.rojo+"El jugador "+jugador1.getNombre()+" ha perdido"+Util.reset);

                    infoBatallas.escribirLasBatallas("\n\t\tEl jugador "+jugador1.getNombre()+" ha perdido");
                }else if(jugador1.getVictorias()>=10){
                    System.out.println("Jugador: "+jugador1.getNombre()+"\tVida: "+jugador1.getVida()+"\t\tOro: "
                            +jugador1.getOro()+"\t\tVictorias: "+jugador1.getVictorias());
                    System.out.println(Util.verde+"Felicidades, el jugador "+jugador1.getNombre()+" ha ganado"+Util.reset);

                    infoBatallas.escribirLasBatallas("\n\t\tEl jugador "+jugador1.getNombre()+" ha ganado");
                }
            }
        }while (batallaCompletada);
    }

    public void iniciarBatalla(){
        Archivos.llenarRonda(ronda);
        menuEntreBatallas();




        if(Util.cantidadMascotas(jugador1.getMascotas())>=0) {
            boolean peleaTerminada = true;
            int pelea = 1;

            seleccionarCampo();
            campoJugador.activarCampo(jugador1.getMascotas(), jugador1.getNombre());
            campoBot.activarCampo(bot.getMascotas(), bot.getNombre());

            Archivos.llenarMascotasEnBatalla(Util.textoMascotasEnBatalla(jugador1,bot));
            //MASCOTAS DEL JUGADOR 1
            ActivarHabilidades.habilidadesAlIncioDeBatalla(jugador1.getMascotas(),bot.getMascotas(), jugador1.getNombre());
            //MASCOTAS DEL BOT
            ActivarHabilidades.habilidadesAlIncioDeBatalla(bot.getMascotas(),jugador1.getMascotas(), bot.getNombre());




            do {
                System.out.println("\n************************* PELEA " + pelea + " *************************");
                System.out.println(campoJugador.imprimirCampo(jugador1.getNombre())+"\t\t"+campoBot.imprimirCampo(bot.getNombre()));
                Util.mostrarMascotasBatalla(jugador1, bot);

                System.out.println(Archivos.mensajeInicioDePartida());
                System.out.println("\nPelea iniciada");
                jugador1.pelear(bot);
                bot.pelear(jugador1);

                System.out.println("Pelea finalizada\n");

                //AQUI EMPIEZAN LAS HABILIDADES EN BATALLAS
                ActivarHabilidades.habilidadesEnBatallas(jugador1.getMascotas(), bot.getMascotas(), jugador1.getNombre());
                ActivarHabilidades.habilidadesEnBatallas(bot.getMascotas(),jugador1.getMascotas(),bot.getNombre());
                //FIN DE LAS HABILIDADES EN BATALLAS

                //HABILIDADES AL MORIR
                ActivarHabilidades.habilidadesAlMorir(jugador1.getMascotas(), bot.getMascotas(), jugador1.getNombre());
                ActivarHabilidades.habilidadesAlMorir(bot.getMascotas(),jugador1.getMascotas(), bot.getNombre());


                Util.mostrarMascotasBatalla(jugador1, bot);

                System.out.println(Archivos.MensajeEntreBatallas(pelea));

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
                        //System.out.println("\t\tEl jugador "+ jugador1.getNombre()+ " ha ganado esta ronda\n");
                        Util.mensajeInformativoRonda(jugador1);
                        jugador1.setVictorias();
                    }else if(Util.cantidadMascotas(jugador1.getMascotas())<0 && Util.cantidadMascotas(bot.getMascotas())>=0){
                        //GANO EL BOT
                        //System.out.println("\t\tEl jugador "+ bot.getNombre()+ " ha ganado esta ronda\n");
                        Util.mensajeInformativoRonda(bot);
                        jugadorPierde();
                    }else{
                        System.out.println("\t\tEMPATE\n");
                    }


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
        CompraComida.llenarComida(comidasTienda,tier);


        //VOLVEMOS A REINICIAR LAS MASCOTAS DEL JUGADOR
        jugador1.reiniciarMascotas(copiaMascotaJugador);

        do{
            System.out.println("\nJugador: "+jugador1.getNombre()+"\tVida: "+jugador1.getVida()+"\t\tOro: "
                    +jugador1.getOro()+"\t\tVictorias: "+jugador1.getVictorias());

            System.out.println("************* MENÚ ENTRE BATALLAS ***************");
            System.out.println("\t1. Comprar Mascota\n\t2. Comprar Comida\n\t3. Ordenar Mascotas");
            System.out.println("\t4. Fusionar Mascotas\n\t5. Vender Mascotas\n\t6. Empezar Batalla");
            opcion = Util.solicitarNumero("Digite una opcion: ",1,6);

            switch (opcion){
                case 1:
                    compra.ComprarMascotas(mascotasTienda,jugador1, comidasTienda);
                    copiarMascotas();
                    break;
                case 2:
                    CompraComida.mostrarComidaTienda(comidasTienda,jugador1,compra.mascotasDeLaTienda(),mascotasTienda);
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

    public void copiarMascotas() {

        for (int i = 0; i < jugador1.getMascotas().length; i++) {
            if (jugador1.getMascota(i) != null) {
                copiaMascotaJugador[i] = new Mascota(jugador1.getMascota(i));
            }
        }
    }

    public void seleccionarCampo(){
        for(int i=0; i<campos.getCampos().length;i++){
            System.out.print(i+"-"+campos.getCampo(i).getNombreCampo()+" ");
        }

        int seleccion = Util.solicitarNumero("Seleccione un campo: ",0,campos.getCampos().length-1);
        campoJugador = campos.getCampo(seleccion);

        campoBot = campos.getCampo(Util.generarRandom(0,5));
    }

}
