package com.ipc1.archivos;

import com.ipc1.campos.caracter.Campo;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

import java.io.*;

public class ArchivoInformacionMascotas {

    private File archivoMascotas;

    public void crearArchivo(String nombreArchivo){
        archivoMascotas = new File(nombreArchivo);

        archivoMascotas.delete();

        try {
            archivoMascotas.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escribirLasMascotas(Mascota[] mascotas){

        try {
            FileWriter escribir= new FileWriter(archivoMascotas,true);

            for(int i=Util.cantidadMascotas(mascotas); i>= 0; i--) {
                escribir.write("animal,"+mascotas[i].getNombre() + "\r\n");
            }
            escribir.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void escribirLaComida(Mascota[] mascotas){

        try {
            FileWriter escribir= new FileWriter(archivoMascotas,true);

            for(int i=Util.cantidadMascotas(mascotas); i>= 0; i--) {

                if(mascotas[i].getEfectoComida()!=null) {
                    escribir.write("comida," + mascotas[i].getEfectoComida().getNombre()+","+mascotas[i].getNombre() +"\r\n");
                }
            }
            escribir.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void escribirCampo(Campo campoJugador){


        try {
            FileWriter escribir = new FileWriter(archivoMascotas, true);
            escribir.write("campo," + campoJugador.getNombreCampo()+ "\r\n");

            escribir.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leerArchivosMascotas(String [][] infoMascotas, String archivoALeer ){
        String [] fila;
        int i=0;
        String cadena;

        try {
            FileReader lector = new FileReader(archivoALeer);
            BufferedReader lectura = new BufferedReader(lector);

            cadena = lectura.readLine();

            while(cadena!=null){
                fila = cadena.split(",");
                llenarMatrizDatos(infoMascotas,fila,i);
                cadena = lectura.readLine();
                i++;
            }


        } catch (FileNotFoundException e) {
            System.out.println("No hay archivos con las mascotas guardadas");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }

    }

    public void llenarMatrizDatos(String [][] infoMacotas, String [] fila, int j){
        for(int i=0; i<fila.length; i++){
            infoMacotas[j][i]= fila[i];
        }
    }

    public File getArchivoMascotas() {
        return archivoMascotas;
    }
}
