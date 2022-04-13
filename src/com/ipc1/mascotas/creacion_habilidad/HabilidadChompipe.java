package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadChompipe extends Habilidad {


    public HabilidadChompipe() {
        super("Chompipe", "Solidaridad");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {

        try {
            for (int i = 0; i < mascotasAliadas.length; i++) {
                if (mascotasAliadas[i] != null) {
                    if (mascotasAliadas[i].getNombre().equalsIgnoreCase("Grillo Zombi") ||
                            mascotasAliadas[i].getNombre().equalsIgnoreCase("Dirty Rat") ||
                            mascotasAliadas[i].getNombre().equalsIgnoreCase("Carnero") ||
                    mascotasAliadas[i].getNombre().equalsIgnoreCase("Abeja")){

                        mascotasAliadas[i].setAtaque(3*nivel);
                        mascotasAliadas[i].setVida(3*nivel);

                        String mensajeEfecto = this.getNombre() + " activa la habilidad: " + getNombreHabilidad() + "\nOtorga a " + mascotasAliadas[i].getNombre() +
                                " un daño de: +" + (3*nivel)+" y una vida de: +"+(3*nivel);
                        Archivos.mensajeEfecto(mensajeEfecto);
                    }
                }
            }
        }catch (NullPointerException ignore){

        }
    }
    
    public void activarHabilidadChompipe(Mascota [] mascotasAliadas, Mascota chompipe, String nombreJugador){
        try {
            for (int i = 0; i < mascotasAliadas.length; i++) {
                if (mascotasAliadas[i] != null) {
                    if (mascotasAliadas[i].getNombre().equalsIgnoreCase("Grillo Zombi") ||
                            mascotasAliadas[i].getNombre().equalsIgnoreCase("Dirty Rat") ||
                            mascotasAliadas[i].getNombre().equalsIgnoreCase("Carnero") ||
                            mascotasAliadas[i].getNombre().equalsIgnoreCase("Abeja")||
                            mascotasAliadas[i].getNombre().equalsIgnoreCase("Zombie Fly")){
                        mascotasAliadas[i].setAtaque(3*chompipe.getNivel());
                        mascotasAliadas[i].setVida(3*chompipe.getNivel());

                        String mensajeEfecto ="La mascota del jugador "+nombreJugador+" ---> "+ this.getNombre() + " activa la habilidad: " + getNombreHabilidad()
                                + "\n\tOtorga a " + mascotasAliadas[i].getNombre() +
                                " un daño de: +" + (3*chompipe.getNivel())+" y una vida de: +"+(3*chompipe.getNivel());
                        Archivos.mensajeEfecto(mensajeEfecto);
                    }
                }
            }
        }catch (NullPointerException ignore){

        }
    }
}
