package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadPanda extends Habilidad {


    public HabilidadPanda() {
        super("Panda", "Fortaleza");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {

        int cantMascotaEnemigas = Util.cantidadMascotas(mascotasEnemigas);
        int posicionPanda = Util.posicionMascota(mascotasAliadas,this.getNombre());
        double absorber = 0.5;

        if(nivel==2){
            absorber = 0.6;
        }else if(nivel == 3){
            absorber = 0.8;
        }
        try{
            if(cantMascotaEnemigas!=-1 && posicionPanda != -1){
                double ataqueAbsorbido = mascotasEnemigas[cantMascotaEnemigas].getAtaque() * absorber;

                mascotasAliadas[posicionPanda].setVida(ataqueAbsorbido);

                String mensajeEfecto = this.getNombre() + " activa la habilidad: " + getNombreHabilidad() + "\nY absorbe un total " +
                        " un daño de: +" +ataqueAbsorbido;
                Archivos.mensajeEfecto(mensajeEfecto);

            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }

    public void activarHabilidadPanda(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota panda){
        int cantMascotaEnemigas = Util.cantidadMascotas(mascotasEnemigas);
        int posicionPanda = Util.cantidadMascotas(mascotasAliadas);
        double absorber = 0.5;

        if(panda.getNivel()==2){
            absorber = 0.6;
        }else if(panda.getNivel() == 3){
            absorber = 0.8;
        }
        try{
            if(cantMascotaEnemigas!=-1 && posicionPanda != -1){
                if(mascotasAliadas[posicionPanda].getNombre().equalsIgnoreCase(panda.getNombre())) {
                    double ataqueAbsorbido = mascotasEnemigas[cantMascotaEnemigas].getAtaque() * absorber;

                    mascotasAliadas[posicionPanda].setVida(ataqueAbsorbido);

                    String mensajeEfecto = this.getNombre() + " activa la habilidad: " + getNombreHabilidad() + "\nY absorbe un total " +
                            " un daño de: +" + ataqueAbsorbido;
                    Archivos.mensajeEfecto(mensajeEfecto);
                }

            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }
}
