/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package produtorconsumidor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daiane
 */
public class ProdutorConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fila f = new Fila(20);
        Consumidor c = new Consumidor("consumidor", f);
        Produtor p = new Produtor("produtor", f);
        for(int i = 0; i < 20; i++){
            new Thread(c).start();
            new Thread(p).start();
        }
    }
    
}
