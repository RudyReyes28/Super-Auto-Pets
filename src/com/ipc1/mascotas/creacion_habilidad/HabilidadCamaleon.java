package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadCamaleon extends Habilidad {


    public HabilidadCamaleon() {
        super("Camaleon", " ");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionC = Util.posicionMascota(mascotasAliadas, this.getNombre());
        try {
            if (posicionC != -1) {
                double vida = 0;
                double danio = 0;
                String mensajeEfecto = "";

                if (nivel == 1) {
                    vida = copiarVida(mascotasEnemigas);

                    mascotasAliadas[posicionC].setVida(vida);
                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida;
                } else if (nivel == 2) {
                    vida = copiarVida(mascotasEnemigas);
                    danio = copiarDanio(mascotasEnemigas);

                    mascotasAliadas[posicionC].setVida(vida);
                    mascotasAliadas[posicionC].setAtaque(danio);
                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida +
                            " y tambien adquiere un ataque de: +" + danio;
                } else if (nivel == 3) {

                    vida = copiarVida(mascotasEnemigas);
                    danio = copiarDanio(mascotasEnemigas);

                    int enemigo = enemigoMasFuerte(mascotasEnemigas);
                    Habilidad copiHabilidad = null;

                    if(mascotasEnemigas[enemigo]!= null){
                        copiHabilidad =  mascotasEnemigas[enemigo].getHabilidad();
                    }

                    mascotasAliadas[posicionC].setVida(vida);
                    mascotasAliadas[posicionC].setAtaque(danio);

                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida +
                            " y tambien adquiere un ataque de: +" + danio;
                    if(copiHabilidad!=null) {
                        copiHabilidad.activarHabilidad(mascotasAliadas, mascotasEnemigas, null, nivel);
                        mensajeEfecto+= " Y activa la habilidad "+copiHabilidad.getNombreHabilidad();
                    }

                }
                Archivos.mensajeEfecto(mensajeEfecto);
            }

        } catch (NullPointerException | ArrayIndexOutOfBoundsException ignore) {

        }
    }

    public void activarHabilidadCamaleon(Mascota[] mascotasEnemigas, int nivel, Mascota [] mascotasAliadas, int posicionC){
        try {
            if (posicionC != -1) {
                double vida = 0;
                double danio = 0;
                String mensajeEfecto = "";

                if (nivel == 1) {
                    vida = copiarVida(mascotasEnemigas);

                    mascotasAliadas[posicionC].setVida(vida);
                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida;
                } else if (nivel == 2) {
                    vida = copiarVida(mascotasEnemigas);
                    danio = copiarDanio(mascotasEnemigas);

                    mascotasAliadas[posicionC].setVida(vida);
                    mascotasAliadas[posicionC].setAtaque(danio);
                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida +
                            " y tambien adquiere un ataque de: +" + danio;
                } else if (nivel == 3) {

                    vida = copiarVida(mascotasEnemigas);
                    danio = copiarDanio(mascotasEnemigas);

                    int enemigo = enemigoMasFuerte(mascotasEnemigas);
                    Habilidad copiHabilidad = null;

                    if(mascotasEnemigas[enemigo]!= null){
                        copiHabilidad =  mascotasEnemigas[enemigo].getHabilidad();
                    }

                    mascotasAliadas[posicionC].setVida(vida);
                    mascotasAliadas[posicionC].setAtaque(danio);

                    mensajeEfecto = this.getNombre() + " activa su habilidad y adquiere una vida de: +" + vida +
                            " y tambien adquiere un ataque de: +" + danio;
                    if(copiHabilidad!=null) {
                        copiHabilidad.activarHabilidad(mascotasAliadas, mascotasEnemigas, null, nivel);
                        mensajeEfecto+= " Y activa la habilidad "+copiHabilidad.getNombreHabilidad();
                    }

                }
                Archivos.mensajeEfecto(mensajeEfecto);
            }

        } catch (NullPointerException | ArrayIndexOutOfBoundsException ignore) {

        }
    }

    private double copiarVida(Mascota[] mascotas){

        double vida=0;
        try {
            for (int i = 0; i < mascotas.length; i++) {
                if (mascotas[i] != null) {
                    if (vida < mascotas[i].getVida()) {
                        vida = mascotas[i].getVida();
                    }
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }

        return vida;
    }

    private double copiarDanio(Mascota[] mascotas){

        double danio=0;
        try {
            for (int i = 0; i < mascotas.length; i++) {
                if (mascotas[i] != null) {
                    if (danio < mascotas[i].getAtaque()) {
                        danio = mascotas[i].getAtaque();
                    }
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }

        return danio;
    }

    private int enemigoMasFuerte(Mascota[] mascotas){
        int enemigo=0;
        double danio=0;
        try {
            for (int i = 0; i < mascotas.length; i++) {
                if (mascotas[i] != null) {
                    if (danio < mascotas[i].getAtaque()) {
                        danio = mascotas[i].getAtaque();
                        enemigo=i;
                    }
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }

        return enemigo;
    }
}
