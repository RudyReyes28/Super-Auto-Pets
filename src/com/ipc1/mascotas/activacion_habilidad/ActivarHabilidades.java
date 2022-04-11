package com.ipc1.mascotas.activacion_habilidad;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.*;;
import com.ipc1.util.Util;

public class ActivarHabilidades {

    public static void habilidadesEnBatallas(Mascota[] mascotasAliadas, Mascota [] mascotasEnemigas){

        for(int i=0; i<= Util.cantidadMascotas(mascotasAliadas);i++){
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Hormiga")){
                ((HabilidadHormiga)mascotasAliadas[i].getHabilidad()).activarHabilidadHormiga(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Grillo")){
                ((HabilidadGrillo)mascotasAliadas[i].getHabilidad()).activarHabilidadGrillo(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Elefante")){
                ((HabilidadElefante)mascotasAliadas[i].getHabilidad()).activarHabilidadElefante(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Puerco Espin")){
                ((HabilidadPuercoEspin)mascotasAliadas[i].getHabilidad()).activarHabilidadPuercoEspin(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Pavoreal")){
                ((HabilidadPavoReal)mascotasAliadas[i].getHabilidad()).activarHabilidadPavoreal(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Rata")){
                ((HabilidadRata)mascotasAliadas[i].getHabilidad()).activarHabilidadRata(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Zorro")) {
                ((HabilidadZorro)mascotasAliadas[i].getHabilidad()).activarHabilidadZorro(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Araña")){
                ((HabilidadArania)mascotasAliadas[i].getHabilidad()).activarHabilidadArania(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Mapache")){
                ((HabilidadMapache)mascotasAliadas[i].getHabilidad()).activarHabilidadMapache(mascotasAliadas,mascotasAliadas[i],i);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Tortuga")){
                ((HabilidadTortuga)mascotasAliadas[i].getHabilidad()).activarHabilidadTortuga(mascotasAliadas,mascotasAliadas[i],i);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Oveja")){
                ((HabilidadOveja)mascotasAliadas[i].getHabilidad()).activarHabilidadOveja(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Lobo")){
                ((HabilidadLobo)mascotasAliadas[i].getHabilidad()).activarHabilidadLobo(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Buey")){
                ((HabilidadBuey)mascotasAliadas[i].getHabilidad()).activarHabilidadBuey(mascotasAliadas,mascotasAliadas[i],i);

            }

        }
    }

    public static void habilidadesAlComprarse(Mascota [] mascotasAliadas){
        for(int i=0; i<= Util.cantidadMascotas(mascotasAliadas);i++){
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Nutria")){
                ((HabilidadNutria)mascotasAliadas[i].getHabilidad()).activarHabilidadNutria(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Jirafa")) {
                ((HabilidadJirafa)mascotasAliadas[i].getHabilidad()).activarHabilidadJirafa(mascotasAliadas,mascotasAliadas[i]);
            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Caracol")) {
                ((HabilidadCaracol)mascotasAliadas[i].getHabilidad()).activarHabilidadCaracol(mascotasAliadas,mascotasAliadas[i]);
            }
        }
    }

    public static void habilidadesAlComer(Mascota [] mascotasTienda, Mascota mascota, Mascota[] mascotasAliadas){
        if(mascota.getNombre().equalsIgnoreCase("Escarabajo")){
            ((HabilidadEscarabajo) mascota.getHabilidad()).activarHabilidadEscarabajo(mascotasTienda,mascota);
        }

        for(int i=0; i<=Util.cantidadMascotas(mascotasAliadas); i++){
            if(mascota.getNombre().equalsIgnoreCase("Conejo")){
                ((HabilidadConejo)mascotasAliadas[i].getHabilidad()).activarHabilidadConejo(mascota,mascotasAliadas[i]);
            }
        }
    }

    public static void habilidadesAlVenderse(Mascota [] mascotasAliadas, Mascota mascotaVendida){
        if(mascotaVendida.getNombre().equalsIgnoreCase("Castor")){
            ((HabilidadCastor) mascotaVendida.getHabilidad()).activarHabilidadCastor(mascotasAliadas,mascotaVendida);
        }
    }

    public static void habilidadesAlIncioDeBatalla(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas){
        for(int i=0; i<= Util.cantidadMascotas(mascotasAliadas);i++){
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Mosquito")){
                ((HabilidadMosquito)mascotasAliadas[i].getHabilidad()).activarHabilidadMosquito(mascotasEnemigas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Sapo")){
                ((HabilidadSapo)mascotasAliadas[i].getHabilidad()).activarHabilidadSapo(mascotasAliadas);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Dodo")){
                ((HabilidadDodo)mascotasAliadas[i].getHabilidad()).activarHabilidadDodo(mascotasAliadas,i,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Camello")){
                ((HabilidadCamello)mascotasAliadas[i].getHabilidad()).activarHabilidadCamello(mascotasAliadas,mascotasAliadas[i]);

            }
        }
    }

    public static void habilidadesAlSubirNivel(Mascota [] mascotasAliadas, Mascota mascota){
        if(mascota.getNombre().equalsIgnoreCase("Pescado")){
            ((HabilidadPescado)mascota.getHabilidad()).activarHabilidadPescado(mascotasAliadas,mascota);
        }
    }
}
