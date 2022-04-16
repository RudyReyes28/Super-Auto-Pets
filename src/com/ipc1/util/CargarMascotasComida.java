package com.ipc1.util;

import com.ipc1.campos.Campos;
import com.ipc1.campos.caracter.Campo;
import com.ipc1.comida.Comidas;
import com.ipc1.comida.caracter.Comida;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.caracter.Mascota;

public class CargarMascotasComida {

    public static void cargarMascotas(Jugador jugador, String [] mascotas){
        Mascotas aniadirMascotas = new Mascotas();

        for(int i= (mascotas.length-1); i>= 0; i--){
            if(mascotas[i]!=null){
                int posicionMascota = Util.posicionMascota(aniadirMascotas.getMascotas(), mascotas[i]);

                jugador.setMascota(aniadirMascotas.getMascota(posicionMascota));

            }
        }
    }

    public static void cargarComida(Jugador jugador, String [][] comidas){


        for(int i=0; i< comidas.length; i++){
            if(comidas[i][0]!=null && comidas[i][1]!=null){
                Comidas aniadirComidas = new Comidas();
                int encontrarComida = buscarComida(aniadirComidas.getComidas(),comidas[i][0]);
                int encontrarMascota = encontrarMascota(jugador.getMascotas(), comidas[i][1]);

                if(encontrarComida!=-1 && encontrarMascota!=-1){
                    jugador.getMascota(encontrarMascota).setEfectoComida(aniadirComidas.getComida(encontrarComida));
                }
            }
        }
    }

    public static Campo cargarCampo(String [] campos){
        Campos aniadirCampos = new Campos();
        int encontrarCampo = 0;

        for(int i=0; i<campos.length; i++){
            if(campos[i]!=null){
                encontrarCampo = buscarCampo(aniadirCampos.getCampos(), campos[i]);

            }
        }

        return aniadirCampos.getCampo(encontrarCampo);
    }

    public static int buscarCampo(Campo [] camposJugador,String campo){
        int campoEncontrado =0;


        for(int i=0; i<camposJugador.length; i++){
            if(camposJugador[i].getNombreCampo().equalsIgnoreCase(campo)){
                campoEncontrado=i;
            }
        }

        return campoEncontrado;
    }

    public static int buscarComida(Comida[] comidasBuscar,String comida){
        int comidaEncontrada=-1;

        for(int i=0; i<comidasBuscar.length; i++){
            if(comidasBuscar[i]!=null){
                if(comidasBuscar[i].getNombre().equalsIgnoreCase(comida)){
                    comidaEncontrada=i;
                }
            }
        }

        return comidaEncontrada;
    }

    public static int encontrarMascota(Mascota[] mascotas, String nombreMascota){
        int posicion=-1;
        for(int i=Util.cantidadMascotas(mascotas); i>=0; i--){
            if(mascotas[i]!=null){
                if(mascotas[i].getNombre().equalsIgnoreCase(nombreMascota)){
                    posicion=i;
                    break;
                }
            }else{
                break;
            }
        }
        return posicion;
    }

}
