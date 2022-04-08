package com.ipc1.jugador;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Jugador {

    private int vida;
    private int oro;
    private int victorias;
    private int derrotas;
    private String nombre;
    private Mascota[] mascotas = new Mascota[10];
    private int contadorMascotas;

    public Jugador(String nombre) {
        this.vida = 10;
        this.oro = 10;
        this.victorias = 0;
        this.derrotas = 0;
        this.nombre = nombre;
        this.contadorMascotas = 0;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida += vida;
        if(this.vida<=0){
            this.vida = 0;
        }
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro += oro;
    }

    public void reiniciarOro(){
        this.oro = 10;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias() {
        this.victorias ++;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas() {
        this.derrotas ++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMascota(Mascota mascota){
        if(contadorMascotas<5) {
            this.mascotas[contadorMascotas] = new Mascota(mascota);
            this.contadorMascotas++;

        }else{
            System.out.println("Ya no se pueden añadir más mascotas");
        }
    }

    public void setContadorMascotas(int contadorMascotas) {
        this.contadorMascotas += contadorMascotas;
    }

    public void reiniciarMascotas(Mascota [] mascotas){
        for(int i=0; i<mascotas.length; i++){
            if(mascotas[i]!=null){
                this.mascotas[i] = new Mascota(mascotas[i]);
            }
        }
    }

    public void moverMascota(Mascota mascota, int posicion){
        mascotas[posicion] = mascota;
    }

    public void eliminarMascota(int i){
        mascotas[i] = null;
    }

    public Mascota getMascota(int i){
        return this.mascotas[i];
    }

    public Mascota [] getMascotas(){
        return mascotas;
    }

    public void activarHabilidad(int i, Mascota[] mascotasEnemigas){
        try {
            mascotas[i].activarHabilidad(mascotas,mascotasEnemigas,null);
        }catch (NullPointerException ignored){

        }
    }

    public void pelear(Jugador enemigo){
        int posicionMascota = Util.cantidadMascotas(this.getMascotas());
        int posicionEnemigo = Util.cantidadMascotas(enemigo.getMascotas());

        if(posicionMascota!=-1){
            double ataque = mascotas[posicionMascota].getAtaque();

            if(posicionEnemigo!=-1) {

                String danioRealizadoMascotas=  "La mascota "+this.getMascota(posicionMascota).getNombre() +
                        " del jugador "+ this.getNombre()+ " ha atacado a "+enemigo.getMascota(posicionEnemigo).getNombre()+" || Daño: "+ataque;

                String danioRecibidoMascotas = "La mascota "+enemigo.getMascota(posicionEnemigo).getNombre()
                        +" del jugador "+enemigo.getNombre()+ " recibió daño de: "+
                        ataque+" tenia una vida de: "+enemigo.getMascota(posicionEnemigo).getVida();

                enemigo.getMascota(posicionEnemigo).setVida(-ataque);

                danioRecibidoMascotas += " y ahora tiene una vida de " + enemigo.getMascota(posicionEnemigo).getVida()+
                ", la mascota "+(enemigo.getMascota(posicionEnemigo).getVida()<=0? "se ha debilitado":"aun puede pelear");


                Archivos.mensajeDanioRealizado(danioRealizadoMascotas);
                Archivos.mensajeDanioRecibido(danioRecibidoMascotas);
            }


        }
    }
}
