package br.com.empresa.poogislainemenu;

import java.io.*;		
import java.util.Scanner;
import javax.swing.JOptionPane;

class ProgramaCadastro {
    static void salvar(Pilha cadastro) {
       FileOutputStream fo;        
       ObjectOutputStream oo;
       try {
           //fo = new FileOutputStream("D:\\Faculdade\\terceiro periodo\\Programacao_Orientada_a_Objeto\\aps2\\aps2\\src\\aps2.obj");
           fo = new FileOutputStream("D:\\aps2.obj");
           oo = new ObjectOutputStream(fo);
           oo.writeObject(cadastro);
           oo.close();
           JOptionPane.showMessageDialog(null, "O cadastro foi salvo em arquivo.");
       } catch(IOException e) {
           JOptionPane.showMessageDialog(null, "Não foi poss�vel salvar o cadastro em arquivo!");
       }
   }
    
    static Pilha ler() {
       FileInputStream fi;        
       ObjectInputStream oi;        
       Pilha cadastroLido;
       
       try {
           //fi = new FileInputStream("D:\\Faculdade\\terceiro periodo\\Programacao_Orientada_a_Objeto\\aps2\\aps2\\src\\aps2.obj");
           fi = new FileInputStream("D:\\aps2.obj");
           oi = new ObjectInputStream(fi);
           cadastroLido = (Pilha) oi.readObject();
           oi.close();
           JOptionPane.showMessageDialog(null, "O cadastro foi lido do arquivo.");
       } catch(Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível ler o cadastro do arquivo!");
           cadastroLido = new Pilha();
       }
       return cadastroLido;
   }
    
    static void inserirComputador(Pilha cadastro) {
       String resposta,marca,respostaGb,respostaCapacidade;        
       int mhz,gb,capacidade;        
       Computador com; 
       Memoria memoria; 
       Hd hd;
       
       marca = JOptionPane.showInputDialog("Digite a marca do HD");
       resposta = JOptionPane.showInputDialog("Digite a quantidade de Mhz da memoria");
       mhz = Integer.parseInt(resposta);
       respostaGb = JOptionPane.showInputDialog("Digite a quantidade de Gb da memoria");
       gb = Integer.parseInt(respostaGb);
       respostaCapacidade = JOptionPane.showInputDialog("Digite a capacidade do Hd"); 
       capacidade = Integer.parseInt(respostaCapacidade);
       memoria = new Memoria(mhz, gb);
       hd = new Hd(marca, capacidade);
       com = new Computador (memoria,hd);
       try {
           cadastro.inserir(com);
           JOptionPane.showMessageDialog(null, "O dados do computador foram inseridos no cadastro.");
       } catch(PilhaCheiaException e) {
           JOptionPane.showMessageDialog(null, "Cadastro cheio!!!");
       } 
   }

    static void removerComputador(Pilha cadastro) {
       Computador com; Memoria memoria = null ;
        Hd hd = null;
       
       try {
           com = cadastro.remover();
           JOptionPane.showMessageDialog(null,
               "Foi removido o computador abaixo:\n" +
               "- Nome: " + memoria.getMhz() +
               "\n- Telefone: " + memoria.getGb()+
               "- Nome: " + hd.getCapacidade() +
               "\n- Telefone: " + hd.getMarca());
       } catch(PilhaVaziaException e) {
           JOptionPane.showMessageDialog(null, "Cadastro vazio!!!");
       }
   }
    
    public static void main(String[] args) {
        Pilha cadastro;        
        String opcao;

        //testes
        Pilha pilha;
        pilha = new Pilha();
        String[] marca={"Asus","Dell","Samsung","Lenovo","Positivo","Apple","ThinkPad","Acer","Avell","HP"};        
        int mhz,gb,capacidade;        
        Computador com; 
        Memoria memoria; 
        Hd hd;

        for (int i = 0; i < 10; i++) {
            mhz = 3*(i+1);
            gb = 30*(i+1);
            capacidade = 300*(i+1);
            memoria = new Memoria(mhz, gb);
            hd = new Hd(marca[i], capacidade);
            com = new Computador (memoria,hd);
            try {
                pilha.inserir(com);
                salvar(pilha);
                //JOptionPane.showMessageDialog(null, "O dados do computador foram inseridos no cadastro.");
            } catch(PilhaCheiaException e) {
                JOptionPane.showMessageDialog(null, "Cadastro cheio!!!");
            } 
        }
        //listar apenas o primeiro
        Pilha cadastroLido = ler();
        //System.out.println("....."+cadastroLido.getVetor()[0].getHd().getMarca());
        //fazendo toString em Computador
        System.out.println("....."+cadastroLido.getVetor()[0].toString());
        
        //listar todos, usando o toString de Pilha
        listarComputadores();
       
      
       cadastro = new Pilha();
       for(;;){
           opcao = JOptionPane.showInputDialog("Digite a opção:\n" +
                   "1 - Salvar o cadastro no arquivo.\n" +
                   "2 - Ler um cadastro do arquivo.\n" +
                   "3 - Inserir um computador no cadastro.\n" +
                   "4 - Remover um computador do cadastro.\n" +
                   "5 - Listar Computadores Op.\n" +
                   "6 - Terminar o programa");
           if(opcao == null || opcao.equals("6"))
               break;
           else if(opcao.equals("1"))
                salvar(cadastro);
           else if(opcao.equals("2"))
                cadastro = ler();
           else if(opcao.equals("3"))
               inserirComputador(cadastro);
           else if(opcao.equals("4"))
               removerComputador(cadastro);
           else if(opcao.equals("5"))
               listarComputadores();
       }
   }

    private static void listarComputadores() {
        try {
            FileInputStream fo = new FileInputStream("D:\\aps2.obj");
            ObjectInputStream oo = new ObjectInputStream(fo);
            Pilha pilha = (Pilha) oo.readObject();
            System.out.println(".."+pilha.toString());    
            oo.close();
        }catch (Exception e){
            System.out.println("Erro "+e.getMessage());
        }
       
    }
}
