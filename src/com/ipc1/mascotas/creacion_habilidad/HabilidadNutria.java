package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadNutria extends Habilidad {


    public HabilidadNutria() {
        super("Nutria", "Ventaja economica");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posMascota = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());

        if(posMascota!=-1){

            mascotasAliadas[posMascota].setAtaque(nivel);
            mascotasAliadas[posMascota].setVida(nivel);
            String mensaje = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\n\tOtorga a "+mascotasAliadas[posMascota].getNombre()+
                    " Vida: "+nivel+" Ataque: "+nivel;

            System.out.println(Util.rojo+mensaje+Util.reset);
            //Archivos.mensajeEfecto(mensaje);
        }
    }

    public void activarHabilidadNutria(Mascota[] mascotasAliadas, Mascota nutria, String nombreJugador){

        int posMascota = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());

        if(posMascota!=-1){

            mascotasAliadas[posMascota].setAtaque(nutria.getNivel());
            mascotasAliadas[posMascota].setVida(nutria.getNivel());
            String mensaje = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre()+" activa la habilidad: "
                    +getNombreHabilidad()+"\n\tOtorga a "+mascotasAliadas[posMascota].getNombre()+
                    " Vida: "+nutria.getNivel()+" Ataque: "+nutria.getNivel();

            System.out.println(Util.rojo+mensaje+Util.reset);
            //Archivos.mensajeEfecto(mensaje);
        }
    }
}
