package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadQuetzal extends Habilidad {


    public HabilidadQuetzal() {
        super("Quetzal", " ");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionQuetzal = Util.posicionMascota(mascotasAliadas, this.getNombre());
        try {
            if (posicionQuetzal != -1) {
                double vida = 0;
                double danio = 0;
                String mensajeEfecto = "";

                if (nivel == 1) {
                    vida = vidaAves(mascotasAliadas);

                    mascotasAliadas[posicionQuetzal].setVida(vida);
                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida;
                } else if (nivel == 2) {
                    vida = vidaAves(mascotasAliadas);
                    danio = danioAves(mascotasAliadas);

                    mascotasAliadas[posicionQuetzal].setVida(vida);
                    mascotasAliadas[posicionQuetzal].setAtaque(danio);
                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida +
                            " y tambien adquiere un ataque de: +" + danio;
                } else if (nivel == 3) {
                    vida = vidaAnimales(mascotasAliadas);
                    danio = danioAnimales(mascotasAliadas);

                    mascotasAliadas[posicionQuetzal].setVida(vida);
                    mascotasAliadas[posicionQuetzal].setAtaque(danio);
                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida +
                            " y tambien adquiere un ataque de: +" + danio;
                }
                Archivos.mensajeEfecto(mensajeEfecto);
            }

        } catch (NullPointerException | ArrayIndexOutOfBoundsException ignore) {

        }
    }

    public void activarHabilidadQuetzal(Mascota [] mascotasAliadas, Mascota quetzal, int posicionQuetzal, String nombreJugador){
        try {
            if (posicionQuetzal != -1) {
                double vida = 0;
                double danio = 0;
                String mensajeEfecto = "";

                if (quetzal.getNivel() == 1) {
                    vida = vidaAves(mascotasAliadas);

                    mascotasAliadas[posicionQuetzal].setVida(vida);
                    mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida;
                } else if (quetzal.getNivel() == 2) {
                    vida = vidaAves(mascotasAliadas);
                    danio = danioAves(mascotasAliadas);

                    mascotasAliadas[posicionQuetzal].setVida(vida);
                    mascotasAliadas[posicionQuetzal].setAtaque(danio);
                    mensajeEfecto ="La mascota del jugador "+nombreJugador+" ---> "+ this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida +
                            " y tambien adquiere un ataque de: +" + danio;
                } else if (quetzal.getNivel() == 3) {
                    vida = vidaAnimales(mascotasAliadas);
                    danio = danioAnimales(mascotasAliadas);

                    mascotasAliadas[posicionQuetzal].setVida(vida);
                    mascotasAliadas[posicionQuetzal].setAtaque(danio);
                    mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida +
                            " y tambien adquiere un ataque de: +" + danio;
                }
                Archivos.mensajeEfectosInicio(mensajeEfecto);
            }

        } catch (NullPointerException | ArrayIndexOutOfBoundsException ignore) {

        }
    }

    private double vidaAves(Mascota[] mascotas){

        double sumaAves = 0;

        try {
            for (int i = 0; i < mascotas.length; i++) {
                if (mascotas[i] != null) {
                    String[] tipo = mascotas[i].getTipo();
                    for (int j = 0; j < mascotas[i].getTipo().length; j++) {
                        if (tipo[j] != null) {
                            if (tipo[j].equalsIgnoreCase("volador")) {
                                sumaAves += mascotas[i].getVida();
                            }
                        }
                    }
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }

        return sumaAves;
    }

    private double danioAves(Mascota[] mascotas){

        double danioAves = 0;

        try {
            for (int i = 0; i < mascotas.length; i++) {
                if (mascotas[i] != null) {
                    String[] tipo = mascotas[i].getTipo();
                    for (int j = 0; j < mascotas[i].getTipo().length; j++) {
                        if (tipo[j] != null) {
                            if (tipo[j].equalsIgnoreCase("volador")) {
                                danioAves += mascotas[i].getAtaque();
                            }
                        }
                    }
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }

        return danioAves;
    }

    private double vidaAnimales(Mascota[] mascotas){
        double vida=0;
        try {
            for (int i = 0; i < mascotas.length; i++) {
                if (mascotas[i] != null) {
                    vida += mascotas[i].getVida();
                }
            }
        }catch (NullPointerException ignore){

        }

        return vida;
    }

    private double danioAnimales(Mascota[] mascotas){
        double danio=0;

        try {
            for (int i = 0; i < mascotas.length; i++) {
                if (mascotas[i] != null) {
                    danio += mascotas[i].getAtaque();
                }
            }
        }catch (NullPointerException ignore){

        }

        return danio;
    }
}
