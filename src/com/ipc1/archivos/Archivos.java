package com.ipc1.archivos;

public class Archivos {

    //COLORES
    private static final String negro = "\u001B[30m";
    private static final String rojo = "\u001B[31m";
    private static final String verde = "\u001B[32m";
    private static final String amarillo = "\u001B[33m";
    private static final String azul = "\u001B[34m";
    private static final String morado = "\u001B[35m";
    private static final String cyan = "\u001B[36m";
    private static final String blanco = "\u001B[37m";
    private static final String reset = "\u001B[0m";


    private static String mensajeEntreBatallas= "";
    private static String mensajeEfectos="";
    private static String mensajeDanioRealizado="";
    private static String mensajeDanioRecibido="";
    private static String mensajeFinalDePartida="";
    private static String mensajeEfectosInicioDePartida = "";
    private static String mensajeInicioDePartida = "";
    private static int ronda=1;
    private static String mascotasEnBatalla = " ";

    private static String copiaMensajeEntreBatallas= "";
    private static String copiaMensajeInicioDePartida = "";

    public static void mensajeEfecto(String efecto){
        mensajeEfectos += efecto+"\n";
    }

    public static void mensajeEfectosInicio(String efecto){
        mensajeEfectosInicioDePartida += efecto+"\n";
    }

    public static void mensajeDanioRealizado(String danio){
        mensajeDanioRealizado+= danio+"\n";
    }

    public static void mensajeDanioRecibido(String danioRecibido){
        mensajeDanioRecibido+= danioRecibido+"\n";
    }

    public static String MensajeEntreBatallas(int pelea){
        mensajeEntreBatallas+= cyan+"EFECTOS PRODUCIDOS:\n"+reset+mensajeEfectos+rojo+"\nDAÑO REALIZADO POR CADA MASCOTA:\n"
                +reset+mensajeDanioRealizado+azul+"\nDAÑO RECIBIDO POR CADA MASCOTA\n"+reset+mensajeDanioRecibido;

        copiaMensajeEntreBatallas = "EFECTOS PRODUCIDOS:\n"+mensajeEfectos+"\nDAÑO REALIZADO POR CADA MASCOTA:\n"
                +mensajeDanioRealizado+"\nDAÑO RECIBIDO POR CADA MASCOTA\n"+mensajeDanioRecibido;


        mensajeFinalDePartida += mascotasEnBatalla+"\n"+"\n************** PELEA: "+ pelea+" *******************\n"
                +copiaMensajeInicioDePartida+"\n"+copiaMensajeEntreBatallas;

        return  mensajeEntreBatallas;
    }

    public static void llenarMascotasEnBatalla(String mascotas){
        mascotasEnBatalla = mascotas;
    }

    public static String mensajeInicioDePartida(){
        mensajeInicioDePartida+= cyan+"HABILIDADES ACTIVADAS AL INCIO DE PARTIDA: \n"+reset+mensajeEfectosInicioDePartida;

        copiaMensajeInicioDePartida = "HABILIDADES ACTIVADAS AL INCIO DE PARTIDA: \n"+mensajeEfectosInicioDePartida;
        return mensajeInicioDePartida;
    }

    public static void reiniciarMensajeEntreBatallas(){
        mensajeEfectosInicioDePartida="";
        mensajeInicioDePartida="";
        mensajeEntreBatallas = "";
        mensajeDanioRecibido = "";
        mensajeDanioRealizado = "";
        mensajeEfectos = "";
        mascotasEnBatalla = " ";
        copiaMensajeInicioDePartida="";
        copiaMensajeEntreBatallas = "";
    }


    public static void llenarRonda(int ronda){
        mensajeFinalDePartida+= "\n\n****************** RONDA "+ronda+"****************\n\n";
    }


    public static String mostrarMensajeFinalDePartida(){
        return mensajeFinalDePartida;
    }

    public static void reiniciarMensajeFinalDePartida(){
        mensajeFinalDePartida= "";
    }
}
