package com.ipc1.batallas.menu_batallas;

import com.ipc1.comida.Comidas;
import com.ipc1.comida.activar_efecto.AlimentoSinEfecto;
import com.ipc1.comida.caracter.Comida;
import com.ipc1.comida.crear_comidas.*;
import com.ipc1.jugador.Jugador;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class CompraComida {

    public static void mostrarComidaTienda(Comida [] comidasTienda, Jugador jugador, Mascota[] mascotasTienda){
        System.out.println("\n\t************* BIENVENIDO A LA TIENDA DE ALIMENTOS ***********");


        if(Util.cantidadAlimentos(comidasTienda)>=0 && Util.cantidadMascotas(jugador.getMascotas())>=0){
            System.out.println("ESTAS SON LOS ALIMENTOS DISPONIBLES\n");
            if(jugador.getOro()>=3){
                for(int i=0; i<comidasTienda.length; i++){
                    if(comidasTienda[i]!=null){
                        System.out.print(i+"-"+comidasTienda[i].getNombre()+" ");
                    }
                }
                System.out.println((Util.cantidadAlimentos(comidasTienda)+1)+"- Cancelar");

                int opcionCompra = Util.solicitarNumero("Digite el alimento a comprar: ",0,Util.cantidadAlimentos(comidasTienda)+1);

                if(opcionCompra!= (Util.cantidadAlimentos(comidasTienda)+1)){
                    System.out.println();
                    Util.verMascotas(jugador);

                    int opcionMascota = Util.solicitarNumero("Digite la mascota que le dará el alimento: ",0,Util.cantidadMascotas(jugador.getMascotas()));

                    //AQUÍ IRIA LAS HABILIDADES DE COMER
                    //TENGO QUE PEDIR EL ARREGLO DE LAS MASCOTAS DE LA TIENDA(El que pedi anteriormente era para todas las mascotas)

                    if(comidasTienda[opcionCompra].isTipoEfecto()){
                        darComidaEfecto(comidasTienda,opcionCompra,jugador,opcionMascota);
                    }else{
                        AlimentoSinEfecto.activarAlimentoSinEfecto(comidasTienda[opcionCompra], jugador.getMascotas(),opcionMascota,mascotasTienda, jugador);
                        comidasTienda[opcionCompra]=null;

                        Util.verificarAlimentos(comidasTienda);
                    }
                }

            }else{
                System.out.println("No tiene oro suficiente para comprar alimentos\n");
            }
        }else{

            System.out.println(Util.cantidadAlimentos(comidasTienda)<0? "Ya no hay más alimentos en la tienda\n": "No tiene mascotas para alimentar\n");
        }

    }

    public static void llenarComida(Comida[] comidasTienda, int tier){
        Comidas comidas = new Comidas();

        for(int i=0; i<comidasTienda.length; i++){
            int comidaAleatoria = Util.generarRandom(0,desbloqueoTier(tier));

            comidasTienda[i] = comidas.getComida(comidaAleatoria);

        }
    }

    private static int desbloqueoTier(int tier){
        int desbloqueo=0;

        switch (tier){
            case 1:
                desbloqueo=2;
                break;
            case 2:
                desbloqueo= 5;
                break;
            case 3:
                desbloqueo = 9;
                break;
            case 4:
                desbloqueo= 12;
                break;
            case 5:
                desbloqueo= 14;
                break;
            case 6:
                desbloqueo= 16;
                break;
            case 7:
                desbloqueo= 17;
                break;
        }


        return desbloqueo;
    }

    private static void darComidaEfecto(Comida [] comidasTienda, int opcionComida, Jugador jugador, int opcionMascota){

        if(comidasTienda[opcionComida] instanceof Naranja){
            jugador.getMascota(opcionMascota).setEfectoComida(new Naranja());
            comidasTienda[opcionComida] = null;
            jugador.setOro(-3);

            Util.verificarAlimentos(comidasTienda);
        }else if(comidasTienda[opcionComida] instanceof Miel){
            jugador.getMascota(opcionMascota).setEfectoComida(new Miel());
            comidasTienda[opcionComida] = null;
            jugador.setOro(-3);

            Util.verificarAlimentos(comidasTienda);
        }else if(comidasTienda[opcionComida] instanceof HuesoDeCarne){
            jugador.getMascota(opcionMascota).setEfectoComida(new HuesoDeCarne());
            comidasTienda[opcionComida] = null;
            jugador.setOro(-3);

            Util.verificarAlimentos(comidasTienda);
        }else if(comidasTienda[opcionComida] instanceof Ajo){
            jugador.getMascota(opcionMascota).setEfectoComida(new Ajo());
            comidasTienda[opcionComida] = null;
            jugador.setOro(-3);

            Util.verificarAlimentos(comidasTienda);
        }else if(comidasTienda[opcionComida] instanceof Chile){
            jugador.getMascota(opcionMascota).setEfectoComida(new Chile());
            comidasTienda[opcionComida] = null;
            jugador.setOro(-3);

            Util.verificarAlimentos(comidasTienda);
        }else if(comidasTienda[opcionComida] instanceof Melon){
            jugador.getMascota(opcionMascota).setEfectoComida(new Melon());
            comidasTienda[opcionComida] = null;
            jugador.setOro(-3);

            Util.verificarAlimentos(comidasTienda);
        }else if(comidasTienda[opcionComida] instanceof Hongo){
            jugador.getMascota(opcionMascota).setEfectoComida(new Hongo());
            comidasTienda[opcionComida] = null;
            jugador.setOro(-3);

            Util.verificarAlimentos(comidasTienda);
        }else if(comidasTienda[opcionComida] instanceof Carne){
            jugador.getMascota(opcionMascota).setEfectoComida(new Carne());
            comidasTienda[opcionComida] = null;
            jugador.setOro(-3);

            Util.verificarAlimentos(comidasTienda);
        }
    }

}
