/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtorconsumidor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daiane
 */
public class Fila {
    private int tamanho;
    private final BlockingQueue<Double> fila = new LinkedBlockingDeque<>(20);
    private final Object predicadoProdut = new Object();
    private final Object predicadoConsum = new Object();
    
    public Fila(int tamanho){
      this.tamanho = tamanho;  
    }
    
    public boolean estaCheia(){
        return fila.size() == tamanho;      
    }
    public boolean estaVazia(){

        return fila.isEmpty();
    }
    
    
    public Double retirarProduto(){
        Double temp = fila.poll();
        acordarProd();
        return temp;
    }
    
    public  void addProduto(Double p) throws InterruptedException{
        if(fila == null){
            System.out.println("ENTROU");
            System.exit(0);
        }
        fila.put(p);
        
        acordarCons();
    }
    
    public void dormirProd(){
        synchronized(predicadoProdut){
        try {
            predicadoProdut.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fila.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public void acordarProd(){
        synchronized(predicadoProdut){
            predicadoProdut.notifyAll();
        }
    }
    
    public void dormirCons(){
        synchronized(predicadoConsum){
            try {
                predicadoConsum.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Fila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void acordarCons(){
        synchronized(predicadoConsum){
            predicadoConsum.notifyAll(); 
        }
    }
}
