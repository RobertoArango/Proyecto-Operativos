/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Bases.cAccesorios;
import Bases.cCarroceria;
import Bases.cChasis;
import Bases.cMotor;
import Bases.cRuedas;
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
    
    //cantidad de piesas para fabircar el carro
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
    
    public static Semaphore semSalChasis;
    public static Semaphore semSalCarroceria;
    public static Semaphore semSalMotores;
    public static Semaphore semSalRuedas;
    public static Semaphore semSalAccesorios;
    
    //cantidad de productores en los sectores
    
    public static volatile int cantProdChasis;
    public static volatile int cantProdCarroceria;
    public static volatile int cantProdMotores;
    public static volatile int cantProdRuedas;
    public static volatile int cantProdAccesorios;
    
    //cantidad de productores trabajando
    
    public static volatile cChasis tProdChasis[];
    public static volatile cCarroceria tProdCarroceria[];
    public static volatile cMotor tProdMotor[];
    public static volatile cRuedas tProdRuedas[];
    public static volatile cAccesorios tProdAccesorios[];
    
    //variables salarios trabajadores
    
    public static volatile float salChasis = 0;
    public static volatile float salCarroceria = 0;
    public static volatile float salMotores = 0;
    public static volatile float salRuedas = 0;
    public static volatile float salAccesorios = 0;
    public static volatile float salGerente = 0;
    public static volatile float salDirector = 0;
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //parametros por marca
        
        
        
        chasis = 1; //lo que se produce por dia
        cantChasis = 2; //lo que se requiere para fabricar un carro
        
        // TODO code application logic here
        
        for (int i = 0; i < cantProdChasis; i++) {
            tProdChasis[i] = new cChasis(chasis, salChasis, mutexChasis, semProdChasis, semSalChasis);
            tProdChasis[i].start();
        }  
    }
    
}
