package br.com.empresa.poogislainemenu;

import java.io.Serializable;
class Pilha implements Serializable {
	
    private static int base = 0, limite = 199;
    private int topo;
    private Computador[] vetor;

    public Computador[] getVetor() {
        return vetor;
    }

    public void setVetor(Computador[] vetor) {
        this.vetor = vetor;
    }
    
    

    Pilha() {
        topo = base - 1;
        vetor = new Computador[limite - base + 1];
    }
    void inserir(Computador com) throws PilhaCheiaException {
        if(topo < limite)
        {
            topo = topo + 1;
            vetor[topo] = com;
        }
        else
            throw new PilhaCheiaException();
    }
    Computador remover() throws PilhaVaziaException{
        Computador com;


        if(topo >= base)
        {
            com = vetor[topo];
            vetor[topo] = null;
            topo = topo - 1;
            return com; 
        }
        else
            throw new PilhaVaziaException();
    }
    
    @Override
    public String toString(){
        String resultado="";
        for (int i = 0; i < topo; i++) {
            resultado += vetor[i].toString();
        }
        return resultado;
    
    }
}
