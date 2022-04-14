package com.ipc1.mascotas.caracter;

import com.ipc1.comida.activar_efecto.AlimentosConEfecto;
import com.ipc1.comida.caracter.Comida;

public class  Mascota {

    private String nombre;
    private double ataque;
    private double vida;
    private String [] tipo = new String[3];
    private int nivel;
    private int exp;
    private Habilidad habilidad;
    private Comida efectoComida;
    private int tierMascota;

    public Mascota(String nombre, double ataque, double vida, String tipo1, String tipo2, String tipo3, Habilidad habilidad, int tierMascota) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.vida = vida;
        this.tipo [0] = tipo1;
        this.tipo [1] = tipo2;
        this.tipo [2] = tipo3;
        this.nivel = 1;
        this.exp = 0;
        this.habilidad = habilidad;
        efectoComida = null;
        this.tierMascota = tierMascota;
    }

    public Mascota(Mascota mascota) {
        this.nombre = mascota.getNombre();
        this.ataque = mascota.getAtaque();
        this.vida = mascota.getVida();
        this.tipo [0] = mascota.getTipo(0);
        this.tipo [1] =  mascota.getTipo(1);
        this.tipo [2] =  mascota.getTipo(2);
        this.nivel = mascota.getNivel();
        this.exp = mascota.getExp();
        this.habilidad = mascota.getHabilidad();
        efectoComida = null;
        this.tierMascota = mascota.getTierMascota();
    }

    public String getNombre() {
        return nombre;
    }


    public double getAtaque() {
        return ataque;
    }

    public double getAtaqueEfectos(Mascota [] mascotasEnemigas, String nombreJugador){
        double ataqueEfecto = this.getAtaque();
        if(efectoComida!=null){
            ataqueEfecto+= AlimentosConEfecto.activarALimentosConRetornoDanio(mascotasEnemigas,this, nombreJugador);
        }

        return ataqueEfecto;
    }

    public void setAtaque(double ataque) {
        this.ataque += ataque;
    }

    public void reiniciarVida(double vida){
        this.vida = vida;
    }

    public void reiniciarAtaque(double ataque){
        this.ataque = ataque;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida += vida;
        if(this.vida<0){
            this.vida=0;
        }
    }

    public void setVidaEfectos(double vida, Mascota[] mascotasAliadas,Mascota[] mascotasEnemigas, String nombreJugador) {
        this.vida += vida;
        if(this.vida<0){
            this.vida=0;
        }

        if(efectoComida!=null && vida<0){
            this.vida+= AlimentosConEfecto.activarAlimentosConRetornoVida(this,vida, nombreJugador);
            AlimentosConEfecto.activarAlimentosSinRetorno(mascotasAliadas,mascotasEnemigas,this, nombreJugador);
        }
    }

    public String getTipo(int i) {
        return tipo[i];
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(int posicion, String nombreTipo){
        tipo[posicion] = nombreTipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp += exp;

        if(nivel==1 && this.exp == 2 ){
            this.setNivel(2);
            this.exp = 0;
        }else if(nivel==2 && this.exp == 3){
            this.setNivel(3);
            this.exp = 0;
        }else if(nivel == 3){
            System.out.println("Esta mascota está a nivel maximo");
            this.exp = 0;
        }
    }

    public int getTierMascota() {
        return tierMascota;
    }

    public Habilidad getHabilidad(){
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad){this.habilidad=habilidad;}

    @Override
    public String toString(){
        return nombre+"("+(int)ataque+"/"+(int)vida+") ";
    }

    public void activarHabilidad(Mascota [] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda){
        habilidad.activarHabilidad(mascotasAliadas,mascotasEnemigas,mascotasTienda,this.getNivel());
    }

    public Comida getEfectoComida() {
        return efectoComida;
    }

    public void setEfectoComida(Comida efectoComida) {
        this.efectoComida = efectoComida;
    }
}
