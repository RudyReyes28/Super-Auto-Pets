package com.ipc1.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoInformacionBatalla {
    private File archivoBatalla;


    public ArchivoInformacionBatalla(String nombreArchivo) {

        archivoBatalla = new File(nombreArchivo);

        archivoBatalla.delete();

        try {
            archivoBatalla.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escribirLasBatallas(String informacionBatallas){

        try {
            FileWriter escribir= new FileWriter(archivoBatalla,true);

            escribir.write(informacionBatallas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
