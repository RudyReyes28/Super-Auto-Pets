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

    public static String MensajeEntreBatallas(){
        mensajeEntreBatallas+= cyan+"EFECTOS PRODUCIDOS:\n"+reset+mensajeEfectos+rojo+"\nDAÑO REALIZADO POR CADA MASCOTA:\n"
                +reset+mensajeDanioRealizado+azul+"\nDAÑO RECIBIDO POR CADA MASCOTA\n"+reset+mensajeDanioRecibido;

        mensajeFinalDePartida();

        return  mensajeEntreBatallas;
    }

    public static String mensajeInicioDePartida(){
        mensajeInicioDePartida+= cyan+"HABILIDADES ACTIVADAS AL INCIO DE PARTIDA: \n"+reset+mensajeEfectosInicioDePartida;

        return mensajeInicioDePartida;
    }

    public static void reiniciarMensajeEntreBatallas(){
        mensajeEntreBatallas = "";
        mensajeDanioRecibido = "";
        mensajeDanioRealizado = "";
        mensajeEfectos = "";
    }

    public static void reinicarMensajeInicioDePartida(){
        mensajeEfectosInicioDePartida="";
        mensajeInicioDePartida="";
    }

    public static void mensajeFinalDePartida(){
        mensajeFinalDePartida+="\n"+mensajeEntreBatallas;
    }

    public static String mostrarMensajeFinalDePartida(){
        return mensajeFinalDePartida;
    }
}
