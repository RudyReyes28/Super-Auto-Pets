package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadJirafa extends Habilidad {

    public HabilidadJirafa() {
        super("Jirafa", "Fortaleza aliada");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionJirafa = Util.posicionMascota(mascotasAliadas, this.getNombre());

        for(int i=posicionJirafa+1; i<=posicionJirafa+nivel;i++){
            mascotasAliadas[i].setAtaque(1);
            mascotasAliadas[i].setVida(1);

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[i].getNombre()+
                    " vida: 1 daño: 1";
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

    public void activarHabilidadJirafa(Mascota[] mascotasAliadas, Mascota jirafa, String nombreJugador){
        try {
            int posicionJirafa = Util.posicionMascota(mascotasAliadas, this.getNombre());

            for (int i = posicionJirafa + 1; i <= (posicionJirafa + jirafa.getNivel()); i++) {
                if (mascotasAliadas[i] != null) {
                    mascotasAliadas[i].setAtaque(1);
                    mascotasAliadas[i].setVida(1);

                    String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad " + getNombreHabilidad()
                            + "\n\tOtorga a " + mascotasAliadas[i].getNombre() +
                            " vida: 1 daño: 1";

                    System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                    //Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }
    }
}
