package br.com.empresa.poogislainemenu;

import java.io.Serializable;

class Computador implements Serializable{
    private Memoria memoria;
    private Hd hd;

    Computador (Memoria memoria, Hd hd){
        this.memoria = memoria;
        this.hd = hd;
    }

    Memoria getMemoria(){
        return this.memoria;
    }
    void setMemoria(Memoria memoria){
        this.memoria = memoria;
    }

    Hd getHd(){
        return this.hd;
    }
    void setHd(Hd hd){
        this.hd = hd;
    }
    
    @Override
    public String toString(){
        String resultado="";
        resultado += " MHZ " + this.getMemoria().getMhz();
        resultado += " GB " + this.getMemoria().getGb();
        resultado += " Marca " + this.getHd().getMarca();
        resultado += " Capacidade " + this.getHd().getCapacidade()+"\n";
        return resultado;
    
    }

	
}
