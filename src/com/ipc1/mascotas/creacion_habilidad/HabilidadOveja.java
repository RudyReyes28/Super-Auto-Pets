package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadOveja extends Habilidad {

    public HabilidadOveja() {
        super("Oveja", "Revolucion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascota carnero1 = new Mascota("Carnero",2*nivel,2*nivel,"domestico","terrestre",null,new Habilidad("Carnero"," "));
        Mascota carnero2 = new Mascota("Carnero",2*nivel,2*nivel,"domestico","terrestre",null,new Habilidad("Carnero"," "));

        int posicionOveja= Util.cantidadMascotas(mascotasAliadas);

        try {
            if (mascotasAliadas[posicionOveja] != null) {
                mascotasAliadas[posicionOveja + 1] = carnero1;
                mascotasAliadas[posicionOveja + 2] = carnero1;

                String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nOtorga a 2 carneros";
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){

        }
    }
}
