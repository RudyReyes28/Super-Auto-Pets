package com.ipc1.comida.activar_efecto;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.comida.crear_comidas.*;
import com.ipc1.mascotas.caracter.Mascota;

public class AlimentosConEfecto {

    public static double activarALimentosConRetornoDanio(Mascota[] mascotasEnemigas, Mascota mascota, String nombreJugador){
        double ataque=0;
        //ESTOS VAN EN DAÑO, EN GET DAÑO, TAL VEZ CREAR UN NUEVO METODO AUX
        if(mascota.getEfectoComida() instanceof Naranja){
            ataque= ((Naranja) mascota.getEfectoComida()).activarEfecto(mascotasEnemigas, mascota, nombreJugador);

        }else if(mascota.getEfectoComida() instanceof HuesoDeCarne){
            ataque = ((HuesoDeCarne) mascota.getEfectoComida()).activarEfecto(mascota, nombreJugador);
            mascota.setEfectoComida(null) ;

        }else if(mascota.getEfectoComida() instanceof Carne){

            ataque = ((Carne) mascota.getEfectoComida()).activarEfecto(mascota, nombreJugador);
            mascota.setEfectoComida(null) ;
        }

        return ataque;
    }

    public static double activarAlimentosConRetornoVida(Mascota mascota, double danio, String nombreJugador){
        double vida=0;
        if(mascota.getEfectoComida() instanceof Ajo){
            vida = ((Ajo) mascota.getEfectoComida()).activarEfecto(mascota, nombreJugador);
        }else if(mascota.getEfectoComida() instanceof Melon){
            vida = ((Melon) mascota.getEfectoComida()).activarEfecto(danio,mascota, nombreJugador);
            mascota.setEfectoComida(null) ;
        }
        return vida;
    }

    public static void activarAlimentosSinRetorno(Mascota [] mascotasAliadas, Mascota [] mascostasEnemigas,Mascota mascota, String nombreJugador){
        //Estas irian en set vida vida
        if(mascota.getEfectoComida() instanceof Miel){
            ((Miel)mascota.getEfectoComida()).efectoMascota(mascotasAliadas, mascota, nombreJugador);
            mascota.setEfectoComida(null) ;

        }else if(mascota.getEfectoComida() instanceof Chile){
            ((Chile)mascota.getEfectoComida()).activarEfecto(mascostasEnemigas, mascota, nombreJugador);
            mascota.setEfectoComida(null) ;

        }else if(mascota.getEfectoComida() instanceof Hongo){
            ((Hongo)mascota.getEfectoComida()).activarHabilidad(mascota, nombreJugador);
        }
    }

}
