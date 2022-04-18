package com.ipc1.batallas.menu_batallas;

import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.activacion_habilidad.ActivarHabilidades;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class OrdenarVenderMascotas {

    //METODO PARA ORDENAR MASCOTAS

    public static void ordenarMascotas(Jugador jugador) {
        System.out.println("*********** ORDENAR MASCOTAS ****************");
        Util.verMascotas(jugador);
        int cantidadMascotas = Util.cantidadMascotas(jugador.getMascotas());
        if (cantidadMascotas > 0) {
            int mascotaSeleccionada = Util.solicitarNumero("Digite posicion de la mascota a mover [0," + cantidadMascotas + "]: ", 0, cantidadMascotas);
            int mascotaMovida = Util.solicitarNumero("Digite posicion a donde desea moverla [0," + cantidadMascotas + "]: ", 0, cantidadMascotas);

            if (mascotaSeleccionada != mascotaMovida) {
                if (mascotaSeleccionada > mascotaMovida) {
                    Mascota copiaMascota = jugador.getMascota(mascotaSeleccionada);//Aqui creamos una copia de la mascota
                    Mascota[] mascotas = jugador.getMascotas();
                    for (int i = mascotaSeleccionada - 1; i >= mascotaMovida; i--) {
                        mascotas[i + 1] = mascotas[i];
                    }
                    mascotas[mascotaMovida] = copiaMascota;
                } else {
                    Mascota copiaMascota = jugador.getMascota(mascotaSeleccionada);//Aqui creamos una copia de la mascota
                    Mascota[] mascotas = jugador.getMascotas();
                    for (int i = mascotaSeleccionada; i < mascotaMovida; i++) {
                        mascotas[i] = mascotas[i + 1];
                    }
                    mascotas[mascotaMovida] = copiaMascota;
                }

                Util.verMascotas(jugador);
            } else {
                Util.verMascotas(jugador);
            }

        } else {
            System.out.println("No hay mascotas para ordenar");
        }

    }

    public static void fusionarMascota(Jugador jugador, Mascota [] mascotasTienda){
        System.out.println("*********** FUSIONAR MASCOTAS ****************");
        System.out.println("1. Fusionar desde el propio mazo\t\t 2. Fusionar desde la tienda");
        int opcion = Util.solicitarNumero("Digite la opcion: ",1,2);
        if(opcion==1) {
            Util.verMascotas(jugador);
            int cantidadMascotas = Util.cantidadMascotas(jugador.getMascotas());

            if (cantidadMascotas > 0) {
                int mascota1 = Util.solicitarNumero("Digite la primera mascota a fusionar: ", 0, cantidadMascotas);
                int mascota2 = Util.solicitarNumero("Digite la segunda mascota a fusionar: ", 0, cantidadMascotas);

                if (mascota1 != mascota2) {
                    if (jugador.getMascota(mascota1).getNombre().equalsIgnoreCase(jugador.getMascota(mascota2).getNombre())) {
                        realizarFusion(jugador, mascota1, mascota2);
                    } else {
                        System.out.println("Las mascotas no son del mismo tipo");
                    }
                } else {
                    System.out.println("No se puede fusionar");
                }
            } else {
                System.out.println("No hay mascotas para fusionar");
            }
        }else if(opcion == 2){
            fusionTienda(jugador,mascotasTienda);
        }
    }

    private static void fusionTienda(Jugador jugador, Mascota[] mascotasTienda){
        Util.verMascotas(jugador);
        System.out.println();
        Util.verMascotasTienda(mascotasTienda);

        int cantMascotasJu = Util.cantidadMascotas(jugador.getMascotas());
        int cantMascotasTi = Util.cantidadMascotas(mascotasTienda);

        if (cantMascotasJu>= 0 && cantMascotasTi >=0) {
            if (jugador.getOro() >= 3){
                int mascota1 = Util.solicitarNumero("Digite la mascota de su mazo a fusionar: ", 0, cantMascotasJu);
                int mascota2 = Util.solicitarNumero("Digite la mascota de la tienda a fusionar: ", 0, cantMascotasTi);

                if (jugador.getMascota(mascota1).getNombre().equalsIgnoreCase(mascotasTienda[mascota2].getNombre())) {
                    mascotasTienda[mascota2]=null;
                    jugador.setOro(-3);
                    jugador.getMascota(mascota1).setVida(1);
                    jugador.getMascota(mascota1).setAtaque(1);

                    int nivelAntes =  jugador.getMascota(mascota1).getNivel();
                    jugador.getMascota(mascota1).setExp(1);

                    System.out.println("La fusion se ha completado");
                    System.out.println("Nivel actual de la mascota: "+jugador.getMascota(mascota1).getNivel());

                    int nivelDespues = jugador.getMascota(mascota1).getNivel();

                    if(nivelDespues>nivelAntes){
                        ActivarHabilidades.habilidadesAlSubirNivel(jugador.getMascotas(), jugador.getMascota(mascota1), jugador.getNombre());
                    }

                    Util.verificarMascotas(mascotasTienda);
                    Util.verificarMascotas(jugador.getMascotas());
                } else {
                    System.out.println("Las mascotas no son del mismo tipo");
                }

            }else {
                System.out.println("No tiene sufiente oro");
            }
        }else{
            System.out.println("No hay mascotas para fusionar");
        }
    }

    private static void realizarFusion(Jugador jugador, int mascota1, int mascota2){
        if(jugador.getMascota(mascota1).getVida() == jugador.getMascota(mascota2).getVida()){
            jugador.eliminarMascota(mascota1);
            jugador.getMascota(mascota2).setVida(1);
            jugador.getMascota(mascota2).setAtaque(1);

            int nivelAntes =  jugador.getMascota(mascota2).getNivel();
            jugador.getMascota(mascota2).setExp(1);

            System.out.println("La fusion se ha completado");
            System.out.println("Nivel actual de la mascota: "+jugador.getMascota(mascota2).getNivel());

            int nivelDespues = jugador.getMascota(mascota2).getNivel();

            if(nivelDespues>nivelAntes){
                ActivarHabilidades.habilidadesAlSubirNivel(jugador.getMascotas(), jugador.getMascota(mascota2), jugador.getNombre());
            }

        }else if(jugador.getMascota(mascota1).getVida() < jugador.getMascota(mascota2).getVida()){
            jugador.eliminarMascota(mascota1);
            jugador.getMascota(mascota2).setVida(1);
            jugador.getMascota(mascota2).setAtaque(1);

            int nivelAntes =  jugador.getMascota(mascota2).getNivel();

            jugador.getMascota(mascota2).setExp(1);

            System.out.println("La fusion se ha completado");
            System.out.println("Nivel actual de la mascota: "+jugador.getMascota(mascota2).getNivel());

            int nivelDespues = jugador.getMascota(mascota2).getNivel();

            if(nivelDespues>nivelAntes){
                ActivarHabilidades.habilidadesAlSubirNivel(jugador.getMascotas(), jugador.getMascota(mascota2), jugador.getNombre());
            }
        }else{
            jugador.eliminarMascota(mascota2);
            jugador.getMascota(mascota1).setVida(1);
            jugador.getMascota(mascota1).setAtaque(1);
            jugador.getMascota(mascota1).setExp(1);

            int nivelAntes =  jugador.getMascota(mascota1).getNivel();

            System.out.println("La fusion se ha completado");
            System.out.println("Nivel actual de la mascota: "+jugador.getMascota(mascota1).getNivel());

            int nivelDespues = jugador.getMascota(mascota1).getNivel();

            if(nivelDespues>nivelAntes){
                ActivarHabilidades.habilidadesAlSubirNivel(jugador.getMascotas(), jugador.getMascota(mascota1), jugador.getNombre());
            }
        }



        jugador.setContadorMascotas(-1);

        System.out.println("");
        Util.verificarMascotas(jugador.getMascotas());
    }

    public static void venderMascotas(Jugador jugador){
        System.out.println("*********** VENDER MASCOTAS ****************");
        Util.verMascotas(jugador);
        int cantidadMascotas = Util.cantidadMascotas(jugador.getMascotas());
        System.out.println(" "+(cantidadMascotas+1)+". Cancelar venta");
        if(cantidadMascotas>=0){
            int mascota1 = Util.solicitarNumero("Digite la mascota a vender: ",0,cantidadMascotas+1);

            if(mascota1 != (cantidadMascotas+1)) {
                int coste = jugador.getMascota(mascota1).getNivel();

                System.out.println("Esta mascota ha sido vendida por " + coste + " de oro");
                jugador.setOro(coste);
                //AQUI IRÁ LA HABILIDADES DE MASCOTAS QUE SE VENDEN

                ActivarHabilidades.habilidadesAlVenderse(jugador.getMascotas(), jugador.getMascota(mascota1), jugador.getNombre());

                jugador.eliminarMascota(mascota1);
                jugador.setContadorMascotas(-1);
                Util.verificarMascotas(jugador.getMascotas());
            }else{
                System.out.println("Vuelva pronto \n");
            }

        }else{
            System.out.println("No hay mascotas para vender\n");
        }
    }
}
