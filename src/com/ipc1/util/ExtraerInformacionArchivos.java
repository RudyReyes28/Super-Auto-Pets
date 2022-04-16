package com.ipc1.util;

public class ExtraerInformacionArchivos {

    public static void extraerMascotas(String [][] infoMascotas, String [] mascotasExtraidas){
        int nombreMascotas = 0;

        for(int i=0; i<infoMascotas.length; i++){

            for(int j=0; j<infoMascotas[0].length; j++){

                if(infoMascotas[i][j]!=null){

                    if(infoMascotas[i][j].equalsIgnoreCase("animal")){
                        mascotasExtraidas[nombreMascotas] = infoMascotas[i][j+1];
                        nombreMascotas++;
                    }
                }
            }
        }
    }

    public static void extraerComida(String [][] infoMascotas, String [][] comidasExtraidas){
        int nombreComidas = 0;

        for(int i=0; i<infoMascotas.length; i++){

            for(int j=0; j<infoMascotas[0].length; j++){

                if(infoMascotas[i][j]!=null){

                    if(infoMascotas[i][j].equalsIgnoreCase("comida")){
                        comidasExtraidas[nombreComidas][0] = infoMascotas[i][j+1];
                        comidasExtraidas[nombreComidas][1] = infoMascotas[i][j+2];
                        nombreComidas++;
                    }
                }
            }
        }
    }
    
    public static void extraerCampo(String [][] infoMascotas, String [] camposExtraidos){
        int nombreCampo = 0;

        for(int i=0; i<infoMascotas.length; i++){

            for(int j=0; j<infoMascotas[0].length; j++){

                if(infoMascotas[i][j]!=null){

                    if(infoMascotas[i][j].equalsIgnoreCase("campo")){
                        camposExtraidos[nombreCampo] = infoMascotas[i][j+1];
                        nombreCampo++;
                    }
                }
            }
        }
    }
}

