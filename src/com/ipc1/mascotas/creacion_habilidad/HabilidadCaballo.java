package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadCaballo extends Habilidad {


    public HabilidadCaballo() {
        super("Caballo", "Rugido Aliado");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        for(int i=0; i<mascotasAliadas.length; i++){
            if(mascotasAliadas[i]!= null){
                if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Grillo Zombi") ||
                        mascotasAliadas[i].getNombre().equalsIgnoreCase("Dirty Rat") ||
                        mascotasAliadas[i].getNombre().equalsIgnoreCase("Carnero") ||
                        mascotasAliadas[i].getNombre().equalsIgnoreCase("Abeja")){

                    mascotasAliadas[i].setAtaque(nivel);
                    String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[i].getNombre()+
                            " un daño de: "+nivel;
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }
    }

    public void activarHabilidadCaballo(Mascota[] mascotasAliadas,Mascota caballo, String nombreJugador){
        for(int i=0; i<mascotasAliadas.length; i++){
            if(mascotasAliadas[i]!= null){
                if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Grillo Zombi") ||
                        mascotasAliadas[i].getNombre().equalsIgnoreCase("Dirty Rat") ||
                        mascotasAliadas[i].getNombre().equalsIgnoreCase("Carnero") ||
                        mascotasAliadas[i].getNombre().equalsIgnoreCase("Abeja")||
                        mascotasAliadas[i].getNombre().equalsIgnoreCase("Zombie Fly")){

                    mascotasAliadas[i].setAtaque(caballo.getNivel());
                    String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre()+" activa la habilidad: "+getNombreHabilidad()
                            +"\n\tOtorga a " + mascotasAliadas[i].getNombre()+
                            " un daño de: "+caballo.getNivel();
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }
    }
}
