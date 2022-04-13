package com.ipc1.batallas.menu_batallas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.activacion_habilidad.ActivarHabilidades;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class CompraMascotas {

    Mascotas mascotas = new Mascotas();
    Mascotas mascotasBotTienda = new Mascotas();

    public void ComprarMascotas(Mascota [] mascotasTienda, Jugador jugador, Comida [] comidaTienda){

        mostrarMascotasTienda(mascotasTienda, jugador, comidaTienda);

    }

    public Mascota [] mascotasDeLaTienda(){
        return mascotas.getMascotas();
    }

    private void mostrarMascotasTienda(Mascota[] mascotasTienda, Jugador jugador, Comida[] comidaTienda) {
        System.out.println("Usted tiene las siguientes mascotas en su mazo: ");
        Util.mostrarMascotas(jugador);
        System.out.println("\n\t************* BIENVENIDO A LA TIENDA DE MASCOTAS ***********");


        if (Util.cantidadMascotas(mascotasTienda) >= 0) {
            if (jugador.getOro() >= 3) {

                System.out.println("ESTAS SON LAS MASCOTAS DISPONIBLES\n");
                for (int i = 0; i < mascotasTienda.length; i++) {
                    if (mascotasTienda[i] != null) {
                        System.out.print(i + "-" + mascotasTienda[i].toString()+" ");
                    }
                }
                System.out.println(""+(Util.cantidadMascotas(mascotasTienda)+1)+". Cancelar compra");

                int opcionCompra = Util.solicitarNumero("Digite el numero de la mascota a comprar: ", 0, Util.cantidadMascotas(mascotasTienda)+1);

                if(opcionCompra!=(Util.cantidadMascotas(mascotasTienda)+1)) {
                    if (Util.cantidadMascotas(jugador.getMascotas()) < 4) {
                        jugador.setMascota(mascotasTienda[opcionCompra]);

                        //AQUI IRIA LAS HABILIDADES DE COMPRA
                        ActivarHabilidades.habilidadesAlComprarse(jugador.getMascotas(), comidaTienda, mascotasTienda[opcionCompra], jugador.getNombre() );

                        jugador.setOro(-3);
                        mascotasTienda[opcionCompra] = null;
                    } else {
                        System.out.println("Ya no tiene espacio para mas mascotas");
                    }
                }else{
                    System.out.println("Vuelva Pronto!!!\n");
                }
            } else {
                System.out.println("No tiene suficiente oro para seguir comprando mascotas\n");
            }
        } else {
            System.out.println("Ya no se pueden comprar más mascotas en la tienda\n");
        }
    }

    public  void llenarMascotasTienda(int ronda, int tier, Mascota [] mascotasTienda){
        int animalesDisponibles = 0;
        if(ronda <= 3){
            animalesDisponibles = 3;
        }else if(ronda <=6){
            animalesDisponibles = 4;
        }else{
            animalesDisponibles = 5;
        }

        for(int i=0; i<animalesDisponibles; i++){
            int mascotaAleatoria = Util.generarRandom(0,desbloqueoTier(tier));

            mascotasTienda[i] = new Mascota(mascotas.getMascota(mascotaAleatoria));
        }
    }

    public  void llenarMascotasBot(int ronda, int tier, Mascota [] mascotasBot){
        int animalesDisponibles = 0;
        if(ronda <= 1){
            animalesDisponibles = 3;

        }else if(ronda <=3){
            animalesDisponibles = 4;
        }else{
            animalesDisponibles = 5;
        }

        for(int i=0; i<animalesDisponibles; i++){
            int mascotaAleatoria = Util.generarRandom(0,desbloqueoTier(tier));

            mascotasBot[i] = new Mascota(mascotasBotTienda.getMascota(mascotaAleatoria));
        }
    }

    private int verTier(int ronda, int tier){

        if(ronda%2==0 && ronda <= 12){
            tier++;
        }

        return tier;
    }

    private int desbloqueoTier(int tier){
        int desbloqueo=0;

        switch (tier){
            case 1:
                desbloqueo=7;
                break;
            case 2:
                desbloqueo= 15;
                break;
            case 3:
                desbloqueo = 26;
                break;
            case 4:
                desbloqueo= 34;
                break;
            case 5:
                desbloqueo= 42;
                break;
            case 6:
                desbloqueo= 51;
                break;
            case 7:
                desbloqueo= 53;
                break;
        }


        return desbloqueo;
    }
}
