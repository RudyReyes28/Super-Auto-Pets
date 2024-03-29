package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadCastor extends Habilidad {


    public HabilidadCastor() {
        super("Castor", "Represa");
    }


    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int cantidad = Util.cantidadMascotas(mascotasAliadas);

        if(cantidad == 1){
            int mascotaEscogida = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());
            mascotasAliadas[mascotaEscogida].setVida(nivel);

            String mensajeEfecto =this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nOtorga a "+mascotasAliadas[mascotaEscogida].getNombre()
                    +" una cantidad de vida de: "+nivel;
            Archivos.mensajeEfecto(mensajeEfecto);

        }else if(cantidad>1){
            int mascotaEscogida1 = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());
            int mascotaEscogida2 = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());
            mascotasAliadas[mascotaEscogida1].setVida(nivel);
            mascotasAliadas[mascotaEscogida2].setVida(nivel);

            String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nOtorga a "+mascotasAliadas[mascotaEscogida1].getNombre()+
                    " y a "+mascotasAliadas[mascotaEscogida2].getNombre()+" una cantidad de vida de: " + nivel;
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

    public void activarHabilidadCastor(Mascota [] mascotasAliadas, Mascota castor, String nombreJugador){

        try {
            int cantidad = Util.cantidadMascotas(mascotasAliadas);

            if (cantidad == 1) {
                int mascotaEscogida = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());
                mascotasAliadas[mascotaEscogida].setVida(castor.getNivel());

                String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad: " + getNombreHabilidad() + "\nOtorga a " + mascotasAliadas[mascotaEscogida].getNombre()
                        + " una cantidad de vida de: " + castor.getNivel();

                System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                //Archivos.mensajeEfecto(mensajeEfecto);

            } else if (cantidad > 1) {
                int mascotaEscogida1 = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());
                int mascotaEscogida2 = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());
                mascotasAliadas[mascotaEscogida1].setVida(castor.getNivel());
                mascotasAliadas[mascotaEscogida2].setVida(castor.getNivel());

                String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad: " + getNombreHabilidad() + "\n\tOtorga a " + mascotasAliadas[mascotaEscogida1].getNombre() +
                        " y a " + mascotasAliadas[mascotaEscogida2].getNombre() + " una cantidad de vida de: " + castor.getNivel();


                System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                //Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }
}
