package com.ipc1.archivos;

public class Archivos {

    private static String mensajeEntreBatallas= "";
    private static String mensajeEfectos="";
    private static String mensajeDanioRealizado="";
    private static String mensajeDanioRecibido="";
    private static String mensajeFinalDePartida="";

    public static void mensajeEfecto(String efecto){
        mensajeEfectos += efecto+"\n";
    }

    public static void mensajeDanioRealizado(String danio){
        mensajeDanioRealizado+= danio+"\n";
    }

    public static void mensajeDanioRecibido(String danioRecibido){
        mensajeDanioRecibido+= danioRecibido+"\n";
    }

    public static String MensajeEntreBatallas(){
        mensajeEntreBatallas+= "EFECTOS PRODUCIDOS:\n"+mensajeEfectos+"DAÑO REALIZADO POR CADA MASCOTA:\n"
                +mensajeDanioRealizado+"DAÑO RECIBIDO POR CADA MASCOTA\n"+mensajeDanioRecibido;

        mensajeFinalDePartida();

        return  mensajeEntreBatallas;
    }

    public static void reiniciarMensajeEntreBatallas(){
        mensajeEntreBatallas = "";
        mensajeDanioRecibido = "";
        mensajeDanioRealizado = "";
        mensajeEfectos = "";
    }

    public static void mensajeFinalDePartida(){
        mensajeFinalDePartida+="\n"+mensajeEntreBatallas;
    }
}
