package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_mascotas.GrilloZombi;
import com.ipc1.util.Util;

public class HabilidadGrillo extends Habilidad {


    public HabilidadGrillo() {
        super("Grillo", "Zombificacion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        GrilloZombi grilloZombi = new GrilloZombi();
        grilloZombi.setAtaque(nivel);
        grilloZombi.setVida(nivel);

        int posicion = Util.cantidadMascotas(mascotasAliadas);
        mascotasAliadas[posicion+1]=grilloZombi;

        String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nInvoca a un grillo zombi con vida de: "+ nivel+
                " y ataque de: "+ nivel;
        Archivos.mensajeEfecto(mensajeEfecto);
    }

    public void activarHabilidadGrillo(Mascota[] mascotasAliadas, Mascota grillo, String nombreJugador){
        try {
            GrilloZombi grilloZombi = new GrilloZombi();
            grilloZombi.setAtaque(grillo.getNivel());
            grilloZombi.setVida(grillo.getNivel());

            int posicion = Util.cantidadMascotas(mascotasAliadas);
            if(posicion!=-1) {
                if(grillo.getVida()<=0) {
                    mascotasAliadas[posicion + 1] = grilloZombi;

                    activarHabilidadDeInvocados(mascotasAliadas, nombreJugador);

                    String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad: " + getNombreHabilidad() +
                            "\n\tInvoca a un grillo zombi con vida de: " + grillo.getNivel() +
                            " y ataque de: " + grillo.getNivel();
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }
    }


    public void activarHabilidadDeInvocados(Mascota [] mascotasAliadas, String nombreJugador){

        for(int i=0; i<=Util.cantidadMascotas(mascotasAliadas); i++) {
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Caballo")){
                ((HabilidadCaballo)mascotasAliadas[i].getHabilidad()).activarHabilidadCaballo(mascotasAliadas,mascotasAliadas[i], nombreJugador);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Chompipe")){
                ((HabilidadChompipe)mascotasAliadas[i].getHabilidad()).activarHabilidadChompipe(mascotasAliadas,mascotasAliadas[i], nombreJugador);

            }
        }
    }
}
