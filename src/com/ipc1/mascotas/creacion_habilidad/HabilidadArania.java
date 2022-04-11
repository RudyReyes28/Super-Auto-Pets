package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadArania extends Habilidad {

    public HabilidadArania() {
        super("Araña", "Liberacion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascotas mascotasInvocadas = new Mascotas();
        int mascotaAleatoria = Util.generarRandom(0,mascotasInvocadas.getMascotas().length-1);
        int totalMascotas = Util.cantidadMascotas(mascotasAliadas);

        if(mascotasInvocadas.getMascota(mascotaAleatoria)!=null){
            mascotasInvocadas.getMascota(mascotaAleatoria).setNivel(nivel);
            mascotasAliadas[totalMascotas+1]=mascotasInvocadas.getMascota(mascotaAleatoria);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nInvoca " + mascotasInvocadas.getMascota(mascotaAleatoria).getNombre();

            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

    public void activarHabilidadArania(Mascota[] mascotasAliadas, Mascota arania){
        Mascotas mascotasInvocadas = new Mascotas();
        int mascotaAleatoria = Util.generarRandom(0,mascotasInvocadas.getMascotas().length-1);
        int totalMascotas = Util.cantidadMascotas(mascotasAliadas);

        try {
            if (totalMascotas != -1) {
                if (arania.getVida() <= 0) {
                    mascotasInvocadas.getMascota(mascotaAleatoria).setNivel(arania.getNivel());
                    mascotasAliadas[totalMascotas + 1] = mascotasInvocadas.getMascota(mascotaAleatoria);

                    String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nInvoca " + mascotasInvocadas.getMascota(mascotaAleatoria).getNombre();

                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }
    }
}
