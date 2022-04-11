package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadDodo extends Habilidad {


    public HabilidadDodo() {
        super("Dodo", "Division de poder");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionDodo = Util.posicionMascota(mascotasAliadas, this.getNombre());

        if(mascotasAliadas[posicionDodo+1]!=null){
            double ataque = mascotasAliadas[posicionDodo+1].getAtaque();

            switch (nivel){
                case 1:
                    ataque *=0.5;
                    mascotasAliadas[posicionDodo+1].setAtaque(ataque);
                    break;
                case 2:
                    mascotasAliadas[posicionDodo+1].setAtaque(ataque);
                    break;
                case 3:
                    ataque *=1.5;
                    mascotasAliadas[posicionDodo+1].setAtaque(ataque*1.5);
                    break;
            }

            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[posicionDodo+1].getNombre()+
                    " un ataque de : "+ataque;
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

    public void activarHabilidadDodo(Mascota [] mascotasAliadas, int posicion, Mascota dodo){

        try {

            if (mascotasAliadas[posicion + 1] != null) {
                double ataque = mascotasAliadas[posicion + 1].getAtaque();

                switch (dodo.getNivel()) {
                    case 1:
                        ataque *= 0.5;
                        mascotasAliadas[posicion + 1].setAtaque(ataque);
                        break;
                    case 2:
                        mascotasAliadas[posicion + 1].setAtaque(ataque);
                        break;
                    case 3:
                        ataque *= 1.5;
                        mascotasAliadas[posicion + 1].setAtaque(ataque * 1.5);
                        break;
                }

                String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nOtorga a " + mascotasAliadas[posicion + 1].getNombre() +
                        " un ataque de : " + ataque;
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }
    }
}
