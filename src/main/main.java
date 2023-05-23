/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.Semaphore;

/**
 *
 * @author rober
 */
public class main {
    //los valores lo colocamos temporalmente como placeholder
    //la "a" indica que estan en almacen 
    public static volatile int aChasis = 1; 
    public static volatile int aCarrocerias = 1;
    public static volatile int aMotores = 1;
    public static volatile int aRuedas = 5;
    public static volatile int aAccesorios = 1;
    public static volatile boolean tGerente = true;
    public static volatile boolean tDirector = true;
    
     //cantidad producida por dia
    public static volatile int carnet;
    public static volatile float chasis;
    public static volatile float carrocerias;
    public static volatile float motores;
    public static volatile float ruedas;
    public static volatile float accesorios;
    public static volatile float cantChasis;
    public static volatile float cantCarrocerias;
    public static volatile float cantMotores;
    public static volatile float cantRuedas;
    public static volatile float cantAccesorios;
    public static volatile float precio;
    public static volatile float maximoProducto;
    
    //semaforos
    
    public static Semaphore mutexChasis;
    public static Semaphore mutexCarrocerias;
    public static Semaphore mutexMotores;
    public static Semaphore mutexRuedas;
    public static Semaphore mutexAccesorios;
    
    public static Semaphore semProdChasis;
    public static Semaphore semProdCarroceria;
    public static Semaphore semProdMotores;
    public static Semaphore semProdRuedas;
    public static Semaphore semProdAccesorios;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
