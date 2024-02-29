/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daiane
 */
public class Produtor implements Runnable{
    private String nome;
    private String estado="aguardando";
    private Fila fila;
    
    public Produtor(String nome, Fila fila){
        this.nome = nome;
        this.fila = fila;
    }
    
    
    public void produzir() throws InterruptedException{
       estado = "produzindo";
       System.out.println(nome +" "+ estado);
       Double p = 1.0;
       fila.addProduto(p);
       
    }
    @Override
    public void run() {
        while(true){
            System.out.println(nome +" "+ estado);
            if(!fila.estaCheia()){
                try {
                    produzir();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                estado = "dormindo";
                System.out.println(nome +" "+ estado);
                fila.dormirProd();
                //fila.acordarCons();
            }
        }
    }
    
}
