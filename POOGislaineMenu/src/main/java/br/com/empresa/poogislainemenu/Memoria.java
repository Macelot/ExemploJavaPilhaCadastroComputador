package br.com.empresa.poogislainemenu;

import java.io.Serializable;

class Memoria implements Serializable{
    private int mhz;
    private int gb;

    Memoria (int mhz, int gb){
	this.mhz = mhz;
	this.gb = gb;
    }

    int getGb(){
	return this.gb;
    }
    
    void setGb(int gb){
	this.gb = gb;
    }

    int getMhz(){
	return this.mhz;
    }
    
    void setMb(int mhz){
	this.mhz = mhz;
    }
}

