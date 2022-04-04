package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadLoro extends Habilidad {


    public HabilidadLoro() {
        super("Loro", "Copia");

    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascotas mascotas = new Mascotas();
        int mascotaAleatoria = Util.generarRandom(0,mascotas.getMascotas().length-1);

        int posicionLoro = Util.posicionMascota(mascotasAliadas,this.getNombre());

        try{
            mascotasAliadas[posicionLoro].setHabilidad(mascotasAliadas[mascotaAleatoria].getHabilidad());
            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nCopia la habilidad de "+
                    mascotasAliadas[mascotaAleatoria].getNombre();
            Archivos.mensajeEfecto(mensajeEfecto);
        }catch (ArrayIndexOutOfBoundsException ignore){

        }
    }
}
