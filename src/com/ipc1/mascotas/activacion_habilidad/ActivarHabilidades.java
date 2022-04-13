package com.ipc1.mascotas.activacion_habilidad;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.*;;
import com.ipc1.util.Util;

public class ActivarHabilidades {

    public static void habilidadesEnBatallas(Mascota[] mascotasAliadas, Mascota [] mascotasEnemigas, String nombreJ){

        for(int i=0; i<= Util.cantidadMascotas(mascotasAliadas);i++){
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Elefante")){
                ((HabilidadElefante)mascotasAliadas[i].getHabilidad()).activarHabilidadElefante(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Pavoreal")){
                ((HabilidadPavoReal)mascotasAliadas[i].getHabilidad()).activarHabilidadPavoreal(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Zorro")) {
                ((HabilidadZorro)mascotasAliadas[i].getHabilidad()).activarHabilidadZorro(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Lobo")){
                ((HabilidadLobo)mascotasAliadas[i].getHabilidad()).activarHabilidadLobo(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Buey")){
                ((HabilidadBuey)mascotasAliadas[i].getHabilidad()).activarHabilidadBuey(mascotasAliadas,mascotasAliadas[i],i, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Canguro")){
                ((HabilidadCanguro)mascotasAliadas[i].getHabilidad()).activarHabilidadCanguro(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Loro")){
                ((HabilidadLoro)mascotasAliadas[i].getHabilidad()).activarHabilidadLoro(mascotasAliadas,i,mascotasEnemigas, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Hipopotamo")){
                ((HabilidadHipopotamo)mascotasAliadas[i].getHabilidad()).activarHabilidadHipopotamo(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Puma")) {
                ((HabilidadPuma)mascotasAliadas[i].getHabilidad()).activarHabilidadPuma(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Jaguar")) {
                ((HabilidadJaguar)mascotasAliadas[i].getHabilidad()).activarHabilidadJaguar(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Escorpion")){
                ((HabilidadEscorpion)mascotasAliadas[i].getHabilidad()).activarHabilidadEscorpion(mascotasAliadas,mascotasEnemigas, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Panda")){
                ((HabilidadPanda)mascotasAliadas[i].getHabilidad()).activarHabilidadPanda(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Tigre")) {
                ((HabilidadTigre)mascotasAliadas[i].getHabilidad()).activarHabilidadTigre(mascotasAliadas,mascotasEnemigas, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Serpiente")) {
                ((HabilidadSerpiente)mascotasAliadas[i].getHabilidad()).acrivarHabilidadSerpiente(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Mamut")) {
                ((HabilidadMamut)mascotasAliadas[i].getHabilidad()).activarHabilidadMamut(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Gorila")) {
                ((HabilidadGorila)mascotasAliadas[i].getHabilidad()).activarHabilidadGorilla(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Mosca")) {
                ((HabilidadMosca)mascotasAliadas[i].getHabilidad()).activarHabilidadMosca(mascotasAliadas,mascotasAliadas[i], nombreJ);
            }

        }

    }
    public static void habilidadesAlMorir(Mascota[] mascotasAliadas, Mascota [] mascotasEnemigas, String nombreJ){
        for(int i=0; i<= Util.cantidadMascotas(mascotasAliadas);i++) {
            if (mascotasAliadas[i].getNombre().equalsIgnoreCase("Hormiga")) {
                ((HabilidadHormiga) mascotasAliadas[i].getHabilidad()).activarHabilidadHormiga(mascotasAliadas, mascotasAliadas[i],nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Grillo")){
                ((HabilidadGrillo)mascotasAliadas[i].getHabilidad()).activarHabilidadGrillo(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Puerco Espin")){
                ((HabilidadPuercoEspin)mascotasAliadas[i].getHabilidad()).activarHabilidadPuercoEspin(mascotasAliadas,mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Rata")){
                ((HabilidadRata)mascotasAliadas[i].getHabilidad()).activarHabilidadRata(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Araña")){
                ((HabilidadArania)mascotasAliadas[i].getHabilidad()).activarHabilidadArania(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Mapache")){
                ((HabilidadMapache)mascotasAliadas[i].getHabilidad()).activarHabilidadMapache(mascotasAliadas,mascotasAliadas[i],i, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Tortuga")){
                ((HabilidadTortuga)mascotasAliadas[i].getHabilidad()).activarHabilidadTortuga(mascotasAliadas,mascotasAliadas[i],i, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Oveja")){
                ((HabilidadOveja)mascotasAliadas[i].getHabilidad()).activarHabilidadOveja(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Venado")){
                ((HabilidadVenado)mascotasAliadas[i].getHabilidad()).activarHabilidadVenado(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }
        }
    }

    public static void habilidadesAlComprarse(Mascota [] mascotasAliadas, Comida[] comidaTienda, Mascota mascotaComprada, String nombreJ){
        for(int i=0; i<= Util.cantidadMascotas(mascotasAliadas);i++){
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Nutria")) {
                if (mascotaComprada.getNombre().equalsIgnoreCase(mascotasAliadas[i].getNombre())) {
                    ((HabilidadNutria) mascotasAliadas[i].getHabilidad()).activarHabilidadNutria(mascotasAliadas, mascotasAliadas[i],nombreJ);

                }
            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Vaca")) {
                if (mascotaComprada.getNombre().equalsIgnoreCase(mascotasAliadas[i].getNombre())) {
                    ((HabilidadVaca)mascotasAliadas[i].getHabilidad()).activarHabilidadVaca(comidaTienda,mascotasAliadas[i], nombreJ);

                }
            }
        }


        for(int i=0; i<= Util.cantidadMascotas(mascotasAliadas);i++){
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Jirafa")) {
                ((HabilidadJirafa)mascotasAliadas[i].getHabilidad()).activarHabilidadJirafa(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Caracol")) {
                ((HabilidadCaracol)mascotasAliadas[i].getHabilidad()).activarHabilidadCaracol(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Llama")) {
                ((HabilidadLlama)mascotasAliadas[i].getHabilidad()).activarHabilidadLlama(mascotasAliadas,mascotasAliadas[i],i,nombreJ);
            }
        }
    }

    public static void habilidadesAlComer(Mascota [] mascotasTienda, Mascota mascotaComer, Mascota[] mascotasAliadas, Jugador jugador){
        if(mascotaComer.getNombre().equalsIgnoreCase("Escarabajo")){
            ((HabilidadEscarabajo) mascotaComer.getHabilidad()).activarHabilidadEscarabajo(mascotasTienda,mascotaComer, jugador.getNombre());

        }else if(mascotaComer.getNombre().equalsIgnoreCase("Foca")){
            ((HabilidadFoca)mascotaComer.getHabilidad()).activarHabilidadFoca(mascotasAliadas,mascotaComer, jugador.getNombre());

        }

        for(int i=0; i<=Util.cantidadMascotas(mascotasAliadas); i++){
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Conejo")){
                ((HabilidadConejo)mascotasAliadas[i].getHabilidad()).activarHabilidadConejo(mascotaComer,mascotasAliadas[i], jugador.getNombre());

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Ardilla")){
                ((HabilidadArdilla)mascotasAliadas[i].getHabilidad()).activarHabilidadArdilla(mascotasAliadas[i],jugador);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Gato")){
                ((HabilidadGato)mascotasAliadas[i].getHabilidad()).activarHabilidadGato(mascotaComer,mascotasAliadas[i], jugador.getNombre());

            }
        }
    }

    public static void habilidadesAlVenderse(Mascota [] mascotasAliadas, Mascota mascotaVendida,String nombreJ){
        if(mascotaVendida.getNombre().equalsIgnoreCase("Castor")){
            ((HabilidadCastor) mascotaVendida.getHabilidad()).activarHabilidadCastor(mascotasAliadas,mascotaVendida, nombreJ);
        }else if(mascotaVendida.getNombre().equalsIgnoreCase("Buho")){
            ((HabilidadBuho)mascotaVendida.getHabilidad()).activarHabilidadBuho(mascotasAliadas,mascotaVendida, nombreJ);

        }
    }

    public static void habilidadesAlIncioDeBatalla(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, String nombreJ){
        for(int i=0; i<= Util.cantidadMascotas(mascotasAliadas);i++){
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Mosquito")){
                ((HabilidadMosquito)mascotasAliadas[i].getHabilidad()).activarHabilidadMosquito(mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Sapo")){
                ((HabilidadSapo)mascotasAliadas[i].getHabilidad()).activarHabilidadSapo(mascotasAliadas, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Dodo")){
                ((HabilidadDodo)mascotasAliadas[i].getHabilidad()).activarHabilidadDodo(mascotasAliadas,i,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Camello")){
                ((HabilidadCamello)mascotasAliadas[i].getHabilidad()).activarHabilidadCamello(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Delfin")){
                ((HabilidadDelfin)mascotasAliadas[i].getHabilidad()).activarHabilidadDelfin(mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Ballena")){
                ((HabilidadBallena)mascotasAliadas[i].getHabilidad()).activarHabilidadBallena(mascotasAliadas,mascotasAliadas[i],i, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Rinoceronte")){
                ((HabilidadRinoceronte)mascotasAliadas[i].getHabilidad()).activarHabilidadRinoceronte(mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Mono")){
                ((HabilidadMono)mascotasAliadas[i].getHabilidad()).activarHabilidadMono(mascotasAliadas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Cocodrilo")){
                ((HabilidadCocodrilo)mascotasAliadas[i].getHabilidad()).activarHabilidadCocodrilo(mascotasEnemigas,mascotasAliadas[i], nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Leopardo")) {
                ((HabilidadLeopardo)mascotasAliadas[i].getHabilidad()).activarHabilidadLeopardo(mascotasEnemigas,mascotasAliadas[i].getNivel(), nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Pulpo")) {
                ((HabilidadPulpo)mascotasAliadas[i].getHabilidad()).activarHabilidadNivel3Pulpo(mascotasEnemigas,mascotasAliadas[i].getNivel(), nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Quetzal")) {
                ((HabilidadQuetzal)mascotasAliadas[i].getHabilidad()).activarHabilidadQuetzal(mascotasAliadas,mascotasAliadas[i],i, nombreJ);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Camaleon")) {
                ((HabilidadCamaleon)mascotasAliadas[i].getHabilidad()).activarHabilidadCamaleon(mascotasEnemigas,mascotasAliadas[i].getNivel(),mascotasAliadas,i, nombreJ);

            }
        }
    }

    public static void habilidadesAlSubirNivel(Mascota [] mascotasAliadas, Mascota mascota, String nombreJugador){
        if(mascota.getNombre().equalsIgnoreCase("Pescado")){
            ((HabilidadPescado)mascota.getHabilidad()).activarHabilidadPescado(mascotasAliadas,mascota,nombreJugador);

        }else if(mascota.getNombre().equalsIgnoreCase("Pulpo")){
            ((HabilidadPulpo)mascota.getHabilidad()).activarHabilidadPulo(mascotasAliadas, mascota.getNivel(),nombreJugador);
        }
    }
}
