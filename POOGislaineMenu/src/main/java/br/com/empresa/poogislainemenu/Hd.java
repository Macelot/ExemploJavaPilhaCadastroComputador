package br.com.empresa.poogislainemenu;

import java.io.Serializable;

class Hd implements Serializable{
    private String marca;
    private int capacidade;

    Hd (String marca, int capacidade){
        this.marca = marca;
        this.capacidade = capacidade;
    }

    String getMarca(){
        return this.marca;
    }
    void setMarca(String marca){
        this.marca = marca;
    }

    int getCapacidade(){
        return this.capacidade;
    }
    
    void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }
}
