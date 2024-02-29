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
public class Consumidor implements Runnable{
    private String nome;
    private String estado="aguardando";
    private Fila fila;
    
    public Consumidor(String nome, Fila fila){
        this.nome = nome;
        this.fila = fila;
    }
    
    
    public void remover(){
       estado = "removendo produto";
       System.out.println(nome +" "+ estado);
       Produto p = new Produto();
       fila.retirarProduto();
    }
    @Override
    public void run() {
        while(true){
            System.out.println(nome +" "+ estado);
            if(!fila.estaVazia()){
                remover();
            }else{
                estado = "dormindo";
                System.out.println(nome +" "+ estado+" - Fila vazia");
                fila.dormirCons();
                //fila.acordarProd();
            }
        }   
    }
    
}
