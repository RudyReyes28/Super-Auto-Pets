package com.ipc1.comida.activar_efecto;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.comida.crear_comidas.*;
import com.ipc1.mascotas.caracter.Mascota;

public class AlimentosConEfecto {

    public static double activarALimentosConRetornoDanio(Mascota[] mascotasEnemigas, Mascota mascota){
        double ataque=0;
        //ESTOS VAN EN DAÑO, EN GET DAÑO, TAL VEZ CREAR UN NUEVO METODO AUX
        if(mascota.getEfectoComida() instanceof Naranja){
            ataque= ((Naranja) mascota.getEfectoComida()).activarEfecto(mascotasEnemigas);

        }else if(mascota.getEfectoComida() instanceof HuesoDeCarne){
            ataque = ((HuesoDeCarne) mascota.getEfectoComida()).activarEfecto(mascota);
            mascota.setEfectoComida(null) ;

        }else if(mascota.getEfectoComida() instanceof Carne){

            ataque = ((Carne) mascota.getEfectoComida()).activarEfecto(mascota);
            mascota.setEfectoComida(null) ;
        }

        return ataque;
    }

    public static double activarAlimentosConRetornoVida(Mascota mascota, double danio){
        double vida=0;
        if(mascota.getEfectoComida() instanceof Ajo){
            vida = ((Ajo) mascota.getEfectoComida()).activarEfecto(mascota);
        }else if(mascota.getEfectoComida() instanceof Melon){
            vida = ((Melon) mascota.getEfectoComida()).activarEfecto(danio,mascota);
            mascota.setEfectoComida(null) ;
        }
        return vida;
    }

    public static void activarAlimentosSinRetorno(Mascota [] mascotasAliadas, Mascota [] mascostasEnemigas,Mascota mascota){
        //Estas irian en set vida vida
        if(mascota.getEfectoComida() instanceof Miel){
            ((Miel)mascota.getEfectoComida()).efectoMascota(mascotasAliadas, mascota);
            mascota.setEfectoComida(null) ;

        }else if(mascota.getEfectoComida() instanceof Chile){
            ((Chile)mascota.getEfectoComida()).activarEfecto(mascostasEnemigas, mascota);
            mascota.setEfectoComida(null) ;

        }else if(mascota.getEfectoComida() instanceof Hongo){
            ((Hongo)mascota.getEfectoComida()).activarHabilidad(mascota);
        }
    }

}
