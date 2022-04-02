package com.ipc1.util;

import com.ipc1.mascotas.caracter.Mascota;

import java.security.SecureRandom;
import java.util.Scanner;

public class Util {

    public static Scanner entrada = new Scanner(System.in);

    public static int cantidadMascotas(Mascota[] mascotas){
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
}
