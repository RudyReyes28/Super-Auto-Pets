package com.ipc1.jugador;

import com.ipc1.mascotas.caracter.Mascota;

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
        this.vida = vida;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMascota(Mascota mascota){
        if(contadorMascotas<this.mascotas.length) {
            this.mascotas[contadorMascotas] = new Mascota(mascota);
            this.contadorMascotas++;
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
            mascotas[i].habilidad(mascotas,mascotasEnemigas);
        }catch (NullPointerException e){

        }
    }
}
