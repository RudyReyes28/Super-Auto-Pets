package com.ipc1.batallas.menu_batallas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.activacion_habilidad.ActivarHabilidades;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class CompraModoCreativo {


    public static void comprarMascotas(Mascota[] mascotas, Jugador jugador, Comida[] comidasTienda) {
        int opcion = 0;

        do {
            System.out.println("************** BIENVENIDO AQUI PUEDE ARMAR EL MAZO LEGENDARIO QUE DESEE");
            System.out.println("Antes de empezar, por mayor facilidad elija ordenar las mascotas de la siguiente manera: ");
            System.out.println("\t1. Ordenar por tier\t\t2. Ordenar por vida\t\t3. Ordenar por daño\t\t4. Salir");
            opcion = Util.solicitarNumero("Digite la opcion: ", 0, 4);

            switch (opcion) {
                case 1:
                    comprarPorTier(mascotas, jugador, comidasTienda);
                    break;
                case 2:
                    comprarPorVida(mascotas, jugador, comidasTienda);
                    break;
                case 3:
                    comprarPorDanio(mascotas, jugador, comidasTienda);
                    break;
                default:
                    System.out.println("VUELVA PRONTO");
            }
        }while (opcion!=4);
    }

    public static void comprarPorDanio(Mascota[] mascotas, Jugador jugador, Comida [] comidaTienda) {
        ordenarMascotasPorDanio(mascotas);

        int salir = 0;
        do {
            Util.verMascotas(jugador);
            System.out.println();

            System.out.println("******** ORDENANDO LAS MASCOTAS POR DAÑO ************");
            System.out.println("Seleccione la manera de ordenar las mascotas: ");
            System.out.println("1. De menor a mayor daño\t\t2. De mayor a menor daño");
            int opcion = Util.solicitarNumero("Ingrese la opcion: ", 1, 2);


            if (opcion == 1) {
                imprimirMascotasCrecienteDecreciente(mascotas, 1);
            } else {
                imprimirMascotasCrecienteDecreciente(mascotas, 2);
            }

            int indice = Util.solicitarNumero("Ingrese el indice de la mascota a adquirir: ", 0, mascotas.length - 1);


            if (Util.cantidadMascotas(jugador.getMascotas()) < 4) {
                jugador.setMascota(mascotas[indice]);

                //AQUI IRIA LAS HABILIDADES DE COMPRA
                ActivarHabilidades.habilidadesAlComprarse(jugador.getMascotas(), comidaTienda, mascotas[indice], jugador.getNombre() );


            } else {
                System.out.println("Ya no tiene espacio para mas mascotas");
            }

            Util.verMascotas(jugador);
            System.out.println();

            System.out.println("¿Desea seguir adquiriendo más mascotas?\n\t1. Si\t2. No");
            salir = Util.solicitarNumero("Digite la opcion: ", 1, 2);
        } while (salir != 2);

    }

    public static void comprarPorVida(Mascota[] mascotas, Jugador jugador,  Comida [] comidaTienda) {
        ordenarMascotasPorVida(mascotas);
        int salir = 0;

        do {
            Util.verMascotas(jugador);
            System.out.println();

            System.out.println("******** ORDENANDO LAS MASCOTAS POR VIDA ************");
            System.out.println("Seleccione la manera de ordenar las mascotas: ");
            System.out.println("1. De menor a mayor vida\t\t2. De mayor a menor vida");
            int opcion = Util.solicitarNumero("Ingrese la opcion: ", 1, 2);

            if (opcion == 1) {
                imprimirMascotasCrecienteDecreciente(mascotas, 1);
            } else {
                imprimirMascotasCrecienteDecreciente(mascotas, 2);
            }

            int indice = Util.solicitarNumero("Ingrese el indice de la mascota a adquirir: ", 0, mascotas.length - 1);

            if (Util.cantidadMascotas(jugador.getMascotas()) < 4) {
                jugador.setMascota(mascotas[indice]);

                //AQUI IRIA LAS HABILIDADES DE COMPRA
                ActivarHabilidades.habilidadesAlComprarse(jugador.getMascotas(), comidaTienda, mascotas[indice], jugador.getNombre() );


            } else {
                System.out.println("Ya no tiene espacio para mas mascotas");
            }
            Util.verMascotas(jugador);
            System.out.println();

            System.out.println("¿Desea seguir adquiriendo más mascotas?\n\t1. Si\t2. No");
            salir = Util.solicitarNumero("Digite la opcion: ", 1, 2);
        } while (salir != 2);

    }

    public static void comprarPorTier(Mascota[] mascotas, Jugador jugador, Comida [] comidaTienda){
        int salir =0;

        do{
            Util.verMascotas(jugador);
            System.out.println();
            System.out.println("******** ORDENANDO LAS MASCOTAS POR TIER ************");
            int tier = Util.solicitarNumero("Digite el tier de la mascota: ",1,7);
            Mascota[] mascotasTier = ordenarMascotasPorTier(mascotas,tier);

            imprimirMascotasPorTier(mascotasTier);


            int indice = Util.solicitarNumero("Ingrese el indice de la mascota a adquirir: ", 0, Util.cantidadMascotas(mascotasTier));

            if (Util.cantidadMascotas(jugador.getMascotas()) < 4) {
                jugador.setMascota(mascotasTier[indice]);

                //AQUI IRIA LAS HABILIDADES DE COMPRA
                ActivarHabilidades.habilidadesAlComprarse(jugador.getMascotas(), comidaTienda, mascotasTier[indice], jugador.getNombre() );


            } else {
                System.out.println("Ya no tiene espacio para mas mascotas");
            }
            Util.verMascotas(jugador);
            System.out.println();

            System.out.println("¿Desea seguir adquiriendo más mascotas?\n\t1. Si\t2. No");
            salir = Util.solicitarNumero("Digite la opcion: ", 1, 2);
        }while(salir!=2);
    }


    public static void ordenarMascotasPorVida(Mascota[] mascotasJugador) {
        Mascota aux;
        //FORMA CRECIENTE
        for (int i = 0; i < (mascotasJugador.length - 1); i++) {
            for (int j = 0; j < (mascotasJugador.length - 1); j++) {
                if (mascotasJugador[j].getVida() > mascotasJugador[j + 1].getVida()) {
                    aux = mascotasJugador[j];
                    mascotasJugador[j] = mascotasJugador[j + 1];
                    mascotasJugador[j + 1] = aux;
                }
            }
        }
    }

    public static void ordenarMascotasPorDanio(Mascota[] mascotasJugador) {
        Mascota aux;
        //FORMA CRECIENTE
        for (int i = 0; i < (mascotasJugador.length - 1); i++) {
            for (int j = 0; j < (mascotasJugador.length - 1); j++) {
                if (mascotasJugador[j].getAtaque() > mascotasJugador[j + 1].getAtaque()) {
                    aux = mascotasJugador[j];
                    mascotasJugador[j] = mascotasJugador[j + 1];
                    mascotasJugador[j + 1] = aux;
                }
            }
        }
    }

    public static Mascota[] ordenarMascotasPorTier(Mascota[] mascotasJugador, int tier){
        Mascota [] mascotasTier = new Mascota[54];

        for(int i=0; i< mascotasJugador.length; i++){

            if(mascotasJugador[i].getTierMascota() == tier){
                mascotasTier[i] = mascotasJugador[i];
            }
        }
        Util.verificarMascotas(mascotasTier);
        return mascotasTier;
    }

    public static void imprimirMascotasPorTier(Mascota[] mascotasTier){
        for(int i=0; i<=(Util.cantidadMascotas(mascotasTier)); i++){
            if (i % 5 == 0) {
                System.out.println(" ");
            }

            System.out.print(i + "-" + mascotasTier[i].toString() + "\t\t");
        }
        System.out.println();
    }

    public static void imprimirMascotasCrecienteDecreciente(Mascota[] mascotasJugador, int opcionCreciente) {

        if (opcionCreciente == 1) {
            for (int i = 0; i < mascotasJugador.length; i++) {
                if (i % 5 == 0) {
                    System.out.println(" ");
                }
                System.out.print(i + "-" + mascotasJugador[i].toString() + "\t\t");

            }
            System.out.println();
        } else {
            for (int i = (mascotasJugador.length - 1); i >= 0; i--) {

                if (i % 5 == 0) {
                    System.out.println(" ");
                }
                System.out.print(i + "-" + mascotasJugador[i].toString() + "\t\t");

            }
            System.out.println();
        }
    }


}
