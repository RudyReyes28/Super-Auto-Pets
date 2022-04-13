package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadVenado extends Habilidad {

    public HabilidadVenado() {
        super("Venado", "Venganza");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascota camion = new Mascota("Camion",5*nivel,5*nivel,null,null,null,new Habilidad("Camion"," "));

        int cantidadMascotas = Util.cantidadMascotas(mascotasAliadas);

        try{
            mascotasAliadas[cantidadMascotas+1]=camion;
            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nInvoca a un camion con vida: "+
                    (nivel*5)+ "y ataque: "+(nivel*5);
            Archivos.mensajeEfecto(mensajeEfecto);
        }catch(ArrayIndexOutOfBoundsException ignore){

        }

    }

    public void activarHabilidadVenado(Mascota[] mascotasAliadas, Mascota venado, String nombreJugador){
        Mascota camion = new Mascota("Camion",5*venado.getNivel(),5*venado.getNivel(),null,null,null,new Habilidad("Camion"," "));

        int cantidadMascotas = Util.cantidadMascotas(mascotasAliadas);

        try{
            if(venado.getVida()<=0) {
                mascotasAliadas[cantidadMascotas + 1] = camion;
                String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad " + getNombreHabilidad()
                        + "\n\tInvoca a un camion con vida: " +
                        (venado.getNivel() * 5) + "y ataque: " + (venado.getNivel() * 5);
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch(ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }
}
