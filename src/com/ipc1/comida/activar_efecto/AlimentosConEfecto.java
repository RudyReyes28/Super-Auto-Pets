package com.ipc1.comida.activar_efecto;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.comida.crear_comidas.*;
import com.ipc1.mascotas.caracter.Mascota;

public class AlimentosConEfecto {

    public static double activarALimentosConRetornoDanio(Comida comida, Mascota[] mascotasEnemigas, Mascota mascota){
        double ataque=0;
        //ESTOS VAN EN DAÑO, EN GET DAÑO, TAL VEZ CREAR UN NUEVO METODO AUX
        if(comida instanceof Naranja){
            ataque= ((Naranja) comida).activarEfecto(mascotasEnemigas);
        }else if(comida instanceof HuesoDeCarne){
            ataque = ((HuesoDeCarne) comida).activarEfecto(mascota);
        }else if(comida instanceof Carne){
            ataque = ((Carne) comida).activarEfecto(mascota);
        }

        return ataque;
    }

    public static double activarAlimentosConRetornoVida(Comida comida, Mascota mascota, double danio){
        double vida=0;
        if(comida instanceof Ajo){
            vida = ((Ajo) comida).activarEfecto(mascota);
        }else if(comida instanceof Melon){
            vida = ((Melon) comida).activarEfecto(danio,mascota);
        }
        return vida;
    }

    public static void activarAlimentosSinRetorno(Mascota [] mascotasAliadas, Comida comida, Mascota [] mascostasEnemigas,Mascota mascota){
        //Estas irian en set vida vida
        if(comida instanceof Miel){
            ((Miel)comida).efectoMascota(mascotasAliadas);
        }else if(comida instanceof Chile){
            ((Chile)comida).activarEfecto(mascostasEnemigas, mascota);
        }else if(comida instanceof Hongo){
            ((Hongo)comida).activarHabilidad(mascota);
        }
    }

}
