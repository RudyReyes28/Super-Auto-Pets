package com.ipc1.batallas;

import com.ipc1.archivos.ArchivoInformacionBatalla;
import com.ipc1.archivos.ArchivoInformacionMascotas;
import com.ipc1.archivos.Archivos;
import com.ipc1.batallas.menu_batallas.CompraComida;
import com.ipc1.batallas.menu_batallas.CompraMascotas;
import com.ipc1.batallas.menu_batallas.CompraModoCreativo;
import com.ipc1.batallas.menu_batallas.OrdenarVenderMascotas;
import com.ipc1.campos.Campos;
import com.ipc1.campos.caracter.Campo;
import com.ipc1.comida.caracter.Comida;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.activacion_habilidad.ActivarHabilidades;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.CargarMascotasComida;
import com.ipc1.util.ExtraerInformacionArchivos;
import com.ipc1.util.Util;

public class ModoCreativo {

    private Mascota[] mascotasTiendaJugador1 = new Mascota[54];
    private Mascota[] mascotasTiendaJugador2 = new Mascota[54];

    private Jugador jugador1;
    private Jugador jugador2;

    private Comida[] comidasTiendaJugador1 = new Comida[2];
    private Comida[] comidasTiendaJugador2 = new Comida[2];

    private int ronda = 1;
    private int tier = 1;

    private Mascota [] copiaMascotaJugador1 = new Mascota[10];
    private Mascota [] copiaMascotaJugador2 = new Mascota[10];

    private Campos campos = new Campos();

    private Campo campoJugador1;
    private Campo campoJugador2;

    private ArchivoInformacionBatalla infoBatallas;

    private ArchivoInformacionMascotas infoMascotasJugador1;
    private ArchivoInformacionMascotas infoMascotasJugador2;

    public ModoCreativo(String nombreJugador1, String nombreJugador2) {
        jugador1 = new Jugador(nombreJugador1);
        jugador2 = new Jugador(nombreJugador2);

        llenarMascotas(mascotasTiendaJugador1);
        llenarMascotas(mascotasTiendaJugador2);

        infoBatallas = new ArchivoInformacionBatalla("InformacionBatallasCreativo.txt");
        infoMascotasJugador1 = new ArchivoInformacionMascotas();
        infoMascotasJugador2 = new ArchivoInformacionMascotas();

        //if(infoMascotasJugador1.getArchivoMascotas().exists()){
        cargarDatos(jugador1,"mascotasJugador1Creativo.csv",infoMascotasJugador1,1);
        //}

        //if(infoMascotasJugador2.getArchivoMascotas().exists()){
        cargarDatos(jugador2,"mascotasJugador2Creativo.csv",infoMascotasJugador2,2);
        //}

    }

    public void batalla(){
        boolean batallaCompletada = true;
        do{

            System.out.println("\n***************** RONDA "+ronda+" *****************");

            iniciarBatalla();

            if(jugador1.getVictorias()>=10 || jugador2.getVictorias()>=10){
                batallaCompletada = false;

                infoBatallas.escribirLasBatallas(Archivos.mostrarMensajeFinalDePartida());
                Archivos.reiniciarMensajeFinalDePartida();

                if(jugador1.getVictorias()>=10){
                    System.out.println("Jugador: "+jugador1.getNombre()+" \t\tVictorias: "+jugador1.getVictorias());
                    System.out.println(Util.rojo+"El jugador "+jugador1.getNombre()+" ha ganado"+Util.reset);

                    infoBatallas.escribirLasBatallas("\n\t\tEl jugador "+jugador1.getNombre()+" ha ganado");

                }else if(jugador2.getVictorias()>=10){
                    System.out.println("Jugador: "+jugador2.getNombre()+" \t\tVictorias: "+jugador2.getVictorias());
                    System.out.println(Util.verde+"Felicidades, el jugador "+jugador2.getNombre()+" ha ganado"+Util.reset);

                    infoBatallas.escribirLasBatallas("\n\t\tEl jugador "+jugador2.getNombre()+" ha ganado");

                }
            }
        }while (batallaCompletada);
    }


    public void iniciarBatalla(){
        Archivos.llenarRonda(ronda);

        System.out.println("*********** MENU DE BATALLAS DEL JUGADOR "+ jugador1.getNombre()+" *****************");
        menuEntreBatallas(jugador1,mascotasTiendaJugador1,comidasTiendaJugador1,copiaMascotaJugador1,"mascotasJugador1Creativo.csv",infoMascotasJugador1);

        System.out.println("*********** MENU DE BATALLAS DEL JUGADOR "+ jugador2.getNombre()+" *****************");
        menuEntreBatallas(jugador2,mascotasTiendaJugador2,comidasTiendaJugador2,copiaMascotaJugador2,"mascotasJugador2Creativo.csv",infoMascotasJugador2);

        if(Util.cantidadMascotas(jugador1.getMascotas())>=0 && Util.cantidadMascotas(jugador2.getMascotas())>=0){

            System.out.println("\t"+jugador1.getNombre()+" SELECCIONE UN CAMPO PARA EMPEZAR LA BATALLA: ");
            seleccionarCampo(1);

            System.out.println("\n\t"+jugador2.getNombre()+" SELECCIONE UN CAMPO PARA EMPEZAR LA BATALLA: ");
            seleccionarCampo(2);
            System.out.println();

            boolean peleaTerminada = true;
            int pelea = 1;

            campoJugador1.activarCampo(jugador1.getMascotas(), jugador1.getNombre());
            campoJugador2.activarCampo(jugador2.getMascotas(), jugador2.getNombre());

            //COLOCAMOS LOS CAMPOS EN LOS ARCHIVOS
            infoMascotasJugador1.escribirCampo(campoJugador1);
            infoMascotasJugador2.escribirCampo(campoJugador2);


            Archivos.llenarMascotasEnBatalla(Util.textoMascotasEnBatalla(jugador1,jugador2));
            //HABILIDADES AL INICIO DE BATALLA
            //MASCOTAS DEL JUGADOR 1
            ActivarHabilidades.habilidadesAlIncioDeBatalla(jugador1.getMascotas(),jugador2.getMascotas(), jugador1.getNombre());
            //MASCOTAS DEL JUGADOR 2
            ActivarHabilidades.habilidadesAlIncioDeBatalla(jugador2.getMascotas(),jugador1.getMascotas(), jugador2.getNombre());



            do{
                System.out.println("\n************************* PELEA " + pelea + " *************************");
                System.out.println(campoJugador1.imprimirCampo(jugador1.getNombre())+"\t\t"+campoJugador2.imprimirCampo(jugador2.getNombre()));
                Util.mostrarMascotasBatalla(jugador1, jugador2);

                System.out.println(Archivos.mensajeInicioDePartida());

                System.out.println("\nPelea iniciada");
                jugador1.pelear(jugador2);
                jugador2.pelear(jugador1);

                System.out.println("Pelea finalizada\n");

                //AQUI EMPIEZAN LAS HABILIDADES EN BATALLAS
                ActivarHabilidades.habilidadesEnBatallas(jugador1.getMascotas(), jugador2.getMascotas(), jugador1.getNombre());
                ActivarHabilidades.habilidadesEnBatallas(jugador2.getMascotas(),jugador1.getMascotas(),jugador2.getNombre());
                //FIN DE LAS HABILIDADES EN BATALLAS

                //HABILIDADES AL MORIR
                ActivarHabilidades.habilidadesAlMorir(jugador1.getMascotas(), jugador2.getMascotas(), jugador1.getNombre());
                ActivarHabilidades.habilidadesAlMorir(jugador2.getMascotas(),jugador1.getMascotas(), jugador2.getNombre());


                Util.mostrarMascotasBatalla(jugador1, jugador2);
                System.out.println(Archivos.MensajeEntreBatallas(pelea));

                Archivos.reiniciarMensajeEntreBatallas();

                Util.mascotasDebilitadas(jugador1);
                Util.mascotasDebilitadas(jugador2);

                //COMPROBAMOS SI QUEDAN MASCOTAS

                if(Util.cantidadMascotas(jugador1.getMascotas())<0 || Util.cantidadMascotas(jugador2.getMascotas())<0){
                    peleaTerminada = false;
                    ronda ++;
                    aumentarTier();
                    jugador1.reiniciarOro();
                    jugador2.reiniciarOro();

                    if(Util.cantidadMascotas(jugador1.getMascotas())>=0 && Util.cantidadMascotas(jugador2.getMascotas())<0){
                        //GANO EL JUGADOR 1

                        //System.out.println("\t\tEl jugador "+ jugador1.getNombre()+ " ha ganado esta ronda\n");

                        Util.mensajeInformativoRonda(jugador1);

                        jugador1.setVictorias();
                        //jugadorPierde(jugador2);

                    }else if(Util.cantidadMascotas(jugador1.getMascotas())<0 && Util.cantidadMascotas(jugador2.getMascotas())>=0){
                        //GANO EL JUGADOR 2
                        //System.out.println("\t\tEl jugador "+ jugador2.getNombre()+ " ha ganado esta ronda\n");

                        Util.mensajeInformativoRonda(jugador2);
                        jugador2.setVictorias();
                        //jugadorPierde(jugador1);
                    }else{
                        System.out.println("\t\tEMPATE\n");
                    }

                }else{
                    Util.solicitarString("Digite cualquier letra para continuar: ");
                    pelea++;
                }

            }while (peleaTerminada);


        }else{
            System.out.println((Util.cantidadMascotas(jugador1.getMascotas())>=0)?"El jugador "+jugador2.getNombre()+" no tiene mascotas para jugar":"El jugador "+jugador1.getNombre()+" no tiene mascotas para jugar");
        }
    }


    public void menuEntreBatallas(Jugador jugador, Mascota[] mascotasTienda, Comida[] comidasTienda, Mascota[] copiaMascotas,String nombreArchivo,ArchivoInformacionMascotas inforMascotas){
        int opcion = 0;


        CompraComida.llenarComida(comidasTienda,tier);

        jugador.reiniciarMascotas(copiaMascotas);

        do{
            System.out.println("\nJugador: "+jugador.getNombre()+"\t\tOro: "
                    +jugador.getOro()+"\t\tVictorias: "+jugador.getVictorias());

            System.out.println("************* MENÚ ENTRE BATALLAS ***************");
            System.out.println("\t1. Comprar Mascota\n\t2. Comprar Comida\n\t3. Ordenar Mascotas");
            System.out.println("\t4. Fusionar Mascotas\n\t5. Vender Mascotas\n\t6. Empezar Batalla");
            opcion = Util.solicitarNumero("Digite una opcion: ",1,6);

            switch (opcion) {
                case 1:
                    CompraModoCreativo.comprarMascotas(mascotasTienda,jugador, comidasTienda);
                    copiarMascotas(jugador,copiaMascotas);
                    break;
                case 2:
                    CompraComida.mostrarComidaTienda(comidasTienda,jugador,mascotasTienda,mascotasTienda);
                    break;
                case 3:
                    OrdenarVenderMascotas.ordenarMascotas(jugador);
                    copiarMascotas(jugador,copiaMascotas);
                    break;
                case 4:
                    OrdenarVenderMascotas.fusionarMascota(jugador,mascotasTienda);
                    copiarMascotas(jugador,copiaMascotas);
                    break;
                case 5:
                    OrdenarVenderMascotas.venderMascotas(jugador);
                    copiarMascotas(jugador,copiaMascotas);
                    break;

                default:
                    copiarMascotas(jugador,copiaMascotas);
                    System.out.println("SUERTE !!!\n");
                    if(Util.cantidadMascotas(jugador.getMascotas())>=0){
                        inforMascotas.crearArchivo(nombreArchivo);
                        inforMascotas.escribirLasMascotas(jugador.getMascotas());
                        inforMascotas.escribirLaComida(jugador.getMascotas());
                    }
            }
        }while(opcion!=6);
    }

    public void llenarMascotas(Mascota [] mascotasJugador){
        Mascotas mascotasTotales = new Mascotas();

        for(int i=0; i<mascotasJugador.length; i++){
            mascotasJugador[i] = new Mascota(mascotasTotales.getMascota(i));
        }
    }

    public void copiarMascotas(Jugador jugador, Mascota [] copiaMascotaJugador) {

        for (int i = 0; i < jugador.getMascotas().length; i++) {
            if (jugador.getMascota(i) != null) {
                copiaMascotaJugador[i] = new Mascota(jugador.getMascota(i));
            }
        }
    }

    public void seleccionarCampo(int jugador){
        for(int i=0; i<campos.getCampos().length;i++){
            System.out.print(i+"-"+campos.getCampo(i).getNombreCampo()+" ");
        }

        int seleccion = Util.solicitarNumero("Seleccione un campo: ",0,campos.getCampos().length-1);

        if(jugador==1){
            campoJugador1 = campos.getCampo(seleccion);
        }else{
            campoJugador2 = campos.getCampo(seleccion);
        }


    }

    public void aumentarTier(){

        if(ronda%2==0 && ronda <= 12){
            tier++;
        }
    }

    public void cargarDatos(Jugador jugador, String nombreArchivo, ArchivoInformacionMascotas archivoMascotas, int campoSeleccion){
        System.out.println("\n"+jugador.getNombre()+" desea cargar los datos de la partida anterior?: \n\t1. Si\n\t2. No");
        int opcion = Util.solicitarNumero("Seleccione la opcion: ",1,2);

        if(opcion==1) {
            String[][] infoMascotas = new String[12][3];
            archivoMascotas.leerArchivosMascotas(infoMascotas,nombreArchivo);

            String [] mascotasACargar = new String[5];
            String [] campoACargar = new String[2];
            String [][] comidaACargar = new String[5][2];

            ExtraerInformacionArchivos.extraerMascotas(infoMascotas,mascotasACargar);
            ExtraerInformacionArchivos.extraerComida(infoMascotas,comidaACargar);
            ExtraerInformacionArchivos.extraerCampo(infoMascotas,campoACargar);

            CargarMascotasComida.cargarMascotas(jugador,mascotasACargar);
            CargarMascotasComida.cargarComida(jugador,comidaACargar);

            if(campoSeleccion==1){
                campoJugador1 = CargarMascotasComida.cargarCampo(campoACargar);
            }else{
                campoJugador2 = CargarMascotasComida.cargarCampo(campoACargar);
            }
        }

    }
}
