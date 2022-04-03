package com.ipc1.mascotas.caracter;

public class  Mascota {

    private String nombre;
    private double ataque;
    private double vida;
    private String [] tipo = new String[3];
    private int nivel;
    private int exp;
    private Habilidad habilidad;

    public Mascota(String nombre, double ataque, double vida, String tipo1, String tipo2, String tipo3, Habilidad habilidad) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.vida = vida;
        this.tipo [0] = tipo1;
        this.tipo [1] = tipo2;
        this.tipo [2] = tipo3;
        this.nivel = 1;
        this.exp = 0;
        this.habilidad = habilidad;
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
    }

    public String getNombre() {
        return nombre;
    }


    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque += ataque;
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

    public String getTipo(int i) {
        return tipo[i];
    }

    public String[] getTipo() {
        return tipo;
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
        this.exp = exp;
    }

    public Habilidad getHabilidad(){
        return habilidad;
    }


    @Override
    public String toString(){
        return nombre+"("+(int)ataque+"/"+(int)vida+") ";
    }

    public void activarHabilidad(Mascota [] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda){
        habilidad.activarHabilidad(mascotasAliadas,mascotasEnemigas,mascotasTienda,this.getNivel());
    }


}
