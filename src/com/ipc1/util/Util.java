package com.ipc1.util;

import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.caracter.Mascota;

import java.security.SecureRandom;
import java.util.Scanner;

public class Util {

    public static Scanner entrada = new Scanner(System.in);

    public static int cantidadMascotas(Mascota[] mascotas){
        ordenarMascotas(mascotas);

        int cantidadDeMascotas = -1;
        for(int i=0; i<mascotas.length; i++){
            if(mascotas[i]!= null){
                cantidadDeMascotas++;
            }else{
                break;
            }
        }
        return cantidadDeMascotas;
    }

    public static int solicitarNumero(String mensaje, int limiteInferior, int limiteSuperior) {
        int numeroIngresado = 0;
        boolean hayError = false;
        do {
            try {

                System.out.print("\n" + mensaje);
                numeroIngresado = entrada.nextInt();
                if ((numeroIngresado >= limiteInferior) && (numeroIngresado <= limiteSuperior)) {
                    hayError = false;
                } else {
                    hayError = true;
                    System.out.println(
                            "Debe ingresar un número entre [" + limiteInferior + " . . " + limiteSuperior + "]");
                    System.out.println("Ingrese de nuevo.");
                }
            } catch (Exception e) {
                hayError = true;
                System.out.println(
                        "Debe ingresar un número entre [" + limiteInferior + " . . " + limiteSuperior + "]");
                System.out.println("Ingrese un numero entero.");

            }
            entrada.nextLine();
        } while (hayError);
        return numeroIngresado;
    }

    public static int generarRandom(int valorI, int valorF){
        SecureRandom aleatorio = new SecureRandom();
        return aleatorio.nextInt((valorF - valorI) + 1) + valorI;
    }

    public static int mascotaAleatoria(Mascota [] mascotas, String nombreMascota){
        SecureRandom aleatorio = new SecureRandom();
        int cantidadDeMascotas = cantidadMascotas(mascotas);
        int mascotaEscogida;

        if(cantidadDeMascotas<=0){
            mascotaEscogida = -1;
        }else{
            boolean correcto = true;
            mascotaEscogida = aleatorio.nextInt(cantidadDeMascotas+1);
            do {
                if (nombreMascota.equals(mascotas[mascotaEscogida].getNombre())) {
                    mascotaEscogida = aleatorio.nextInt(cantidadDeMascotas+1);
                }else{
                    correcto = false;
                }
            }while(correcto);
        }
        return mascotaEscogida;
    }

    public static int mascotaEnemigaAleatoria(Mascota [] mascotas){
        SecureRandom aleatorio = new SecureRandom();
        int cantidadDeMascotas = cantidadMascotas(mascotas);
        int mascotaEscogida;

        if(cantidadDeMascotas<0){
            mascotaEscogida = -1;
        }else{
            mascotaEscogida = aleatorio.nextInt(cantidadDeMascotas+1);
        }
        return mascotaEscogida;
    }

    public static int posicionMascota(Mascota[] mascotas, String nombreMascota){
        int posicion=0;
        for(int i=0; i<mascotas.length; i++){
            if(mascotas[i]!=null){
                if(mascotas[i].getNombre().equals(nombreMascota)){
                    posicion=i;
                    break;
                }
            }else{
                break;
            }
        }
        return posicion;
    }

    public static void ordenarMascotas(Mascota [] mascotas){
        Mascota aux;

        for(int i=0; i<(mascotas.length-1);i++){
            for(int j=0; j<(mascotas.length-1);j++){

                if(mascotas[j]==null){
                    aux = mascotas[j];
                    mascotas[j] = mascotas[j+1];
                    mascotas[j+1] = aux;
                }
            }
        }
    }

    public static void mostrarMascotasBatalla(Jugador jugador1, Jugador jugador2){
        ordenarMascotas(jugador1.getMascotas());

        for(int i=0; i<jugador1.getMascotas().length;i++){
            if(jugador1.getMascota(i)!= null){
                System.out.print(jugador1.getMascota(i).toString()+"|");
            }
        }

        ordenarMascotas(jugador2.getMascotas());
        System.out.print("\t\t");
        for(int i=(jugador2.getMascotas().length-1); i>=0 ;i--){
            if(jugador2.getMascota(i)!= null){
                System.out.print(jugador2.getMascota(i).toString()+"|");
            }
        }

        System.out.println();
    }

    public static void mascotasDebilitadas(Jugador jugador){
        int cant = cantidadMascotas(jugador.getMascotas());
        for(int i=0; i<= cant; i++){
            if(jugador.getMascota(i).getVida()<=0){
                jugador.eliminarMascota(i);
            }
        }

        ordenarMascotas(jugador.getMascotas());
    }

    public static String solicitarString(String mensaje){
        String respuesta = "";
        boolean hayErrorStringIngresado = false;

        do {
            System.out.print("\n"+mensaje);
            respuesta = entrada.nextLine();
            //scanner.nextLine();//probar
            respuesta = respuesta.trim();
            if (respuesta.length() >0){
                hayErrorStringIngresado=false;
            }
            else{
                hayErrorStringIngresado = true;
                System.out.println("Ingresa un caracter como minimo.");
            }

        } while (hayErrorStringIngresado);

        return respuesta;
    }
}
