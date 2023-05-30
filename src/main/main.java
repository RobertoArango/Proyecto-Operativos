/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Bases.Director;
import Bases.Ensamblador;
import Bases.Gerente;
import Bases.cAccesorios;
import Bases.cCarroceria;
import Bases.cChasis;
import Bases.cMotor;
import Bases.cRuedas;
import Bases.lectorTXT;
import java.util.concurrent.Semaphore;

/**
 *
 * @author rober
 */
public class main {
    
    //variable para datos iniciales de la simulacion 
    public static int[] Datos;
    
    //los valores lo colocamos temporalmente como placeholder
    //la "a" indica que estan en almacen 
    public static volatile int aChasis = 1; 
    public static volatile int aCarrocerias = 1;
    public static volatile int aMotores = 1;
    public static volatile int aRuedas = 5;
    public static volatile int aAccesorios = 1;
    public static volatile boolean tGerente = true;
    public static volatile boolean tDirector = true;
    public static volatile int carros = 0;
    public static volatile int carrosTotal = 0;
    public static volatile int entregas = 0;
    
    //cantidad producida por dia
    public static volatile int carnet;
    public static volatile float chasis;
    public static volatile float carrocerias;
    public static volatile float motores;
    public static volatile float ruedas;
    public static volatile float accesorios;
    
    //cantidad de piezas necesarias para fabircar el carro 
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
    public static Semaphore mutexCarros;
    public static Semaphore mutexDiasEntrega;
    public static Semaphore mutexGerenteT; //trabajando
    public static Semaphore mutexDirectorT; 
    public static Semaphore mutexEntregas;
    
    public static Semaphore semProdChasis;
    public static Semaphore semProdCarroceria;
    public static Semaphore semProdMotores;
    public static Semaphore semProdRuedas;
    public static Semaphore semProdAccesorios;
    
    public static Semaphore semEnsamChasis;
    public static Semaphore semEnsamCarroceria;
    public static Semaphore semEnsamMotores;
    public static Semaphore semEnsamRuedas;
    public static Semaphore semEnsamAccesorios;
    
    public static Semaphore semSalChasis;
    public static Semaphore semSalCarroceria;
    public static Semaphore semSalMotores;
    public static Semaphore semSalRuedas;
    public static Semaphore semSalAccesorios;
    public static Semaphore semSalEnsamblador;
    public static Semaphore semSalGerente;
    public static Semaphore semSalDirector;
    
    //cantidad de productores en los sectores
    
    public static volatile int cantProdChasis;
    public static volatile int cantProdCarroceria;
    public static volatile int cantProdMotores;
    public static volatile int cantProdRuedas;
    public static volatile int cantProdAccesorios;
    public static volatile int cantProdEnsamblador;
    
    //cantidad de productores trabajando
    
    public static volatile cChasis tProdChasis[];
    public static volatile cCarroceria tProdCarroceria[];
    public static volatile cMotor tProdMotor[];
    public static volatile cRuedas tProdRuedas[];
    public static volatile cAccesorios tProdAccesorios[];
    public static volatile Ensamblador tProdEnsamblador[];
    
    //variables salarios trabajadores
    
    public static volatile float salChasis = 0;
    public static volatile float salCarroceria = 0;
    public static volatile float salMotores = 0;
    public static volatile float salRuedas = 0;
    public static volatile float salAccesorios = 0;
    public static volatile float salEnsamblador = 0;
    public static volatile float salGerente = 0;
    public static volatile float salDirector = 0;
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //se crea la cantidad de datos que existiran en el txt - se llama a la funcion para crear el txt (prueba)
        
        Datos = new int[25];
        lectorTXT.leer();
        
        System.out.println(Datos[0]);
        System.out.println(Datos[1]);
        System.out.println(Datos[2]);
        System.out.println(Datos[3]);
        System.out.println(Datos[4]);
        System.out.println(Datos[5]);
        System.out.println(Datos[6]);
        System.out.println(Datos[7]);
        System.out.println(Datos[8]);
        System.out.println(Datos[9]);
        System.out.println(Datos[10]);
        System.out.println(Datos[11]);
        System.out.println(Datos[12]);
        System.out.println(Datos[13]);
        System.out.println(Datos[14]);
        System.out.println(Datos[15]);
        System.out.println(Datos[16]);
        System.out.println(Datos[17]);
        System.out.println(Datos[18]);
        System.out.println(Datos[19]);
        System.out.println(Datos[20]);
        System.out.println(Datos[21]);
        System.out.println(Datos[22]);
        System.out.println(Datos[23]);
        System.out.println(Datos[24]);
        
        
        //valores para carros fabricados
        
        mutexCarros = new Semaphore (1);
        
        //valores por chasis
        
        chasis = (float)0.25; //lo que se produce por dia
        cantChasis = 3; //lo que se requiere para fabricar un carro
        cantProdChasis = Datos[7];
        tProdChasis = new cChasis[Datos[7]]; //productores en el sector chasis pasado como parametro a la clase
        semSalChasis = new Semaphore(1);
        semProdChasis = new Semaphore(Datos[2]);//semaforo para el limite maximo de chasis en almacen
        mutexChasis = new Semaphore(1);
        
        //valores por carroceria
        
        carrocerias = (float)0.25; //lo que se produce por dia
        cantCarrocerias = 2; //lo que se requiere para fabricar un carro
        cantProdCarroceria = Datos[8];
        tProdCarroceria = new cCarroceria[Datos[7]]; //productores en el sector chasis pasado como parametro a la clase
        semSalCarroceria = new Semaphore(1);
        semProdCarroceria = new Semaphore(Datos[3]); //semaforo para el limite maximo de chasis en almacen
        mutexCarrocerias = new Semaphore (1);
        
        //valores por motores
        
        motores = 1;
        cantMotores = 4;
        cantProdMotores = Datos[8];
        tProdMotor = new cMotor[Datos[8]];
        semSalMotores = new Semaphore(1);
        semProdMotores = new Semaphore(Datos[4]);
        mutexMotores = new Semaphore (1);
        
        //valores por ruedas
        
        ruedas = 5;
        cantRuedas = 6;
        cantProdRuedas = Datos[9];
        tProdRuedas = new cRuedas[Datos[7]];
        semSalRuedas = new Semaphore(1);
        semProdRuedas = new Semaphore(Datos[5]);
        mutexRuedas = new Semaphore (1);
        
        //valores por accesorios
        
        accesorios = (float)0.5;
        cantAccesorios = 5;
        cantProdAccesorios = Datos[10];
        tProdAccesorios = new cAccesorios[Datos[10]];
        semSalAccesorios = new Semaphore(1);
        semProdAccesorios = new Semaphore (Datos[6]);
        mutexAccesorios = new Semaphore (1);
         
        //valores gerente
        mutexGerenteT = new Semaphore (1);
        semSalGerente = new Semaphore (1);
        mutexDiasEntrega = new Semaphore (1);
        
        //valores director
        mutexDirectorT = new Semaphore (1);
        semSalDirector = new Semaphore (1);
        mutexEntregas = new Semaphore (1);
        
        // TODO code application logic here
        
        for (int i = 0; i < cantProdChasis; i++) {
            tProdChasis[i] = new cChasis(chasis, salChasis, mutexChasis, semProdChasis, semSalChasis, semEnsamChasis );
            tProdChasis[i].start();
        }  
        
        for (int i = 0; i < cantProdCarroceria; i++) {
            tProdCarroceria[i] = new cCarroceria(carrocerias, salCarroceria, mutexCarrocerias, semProdCarroceria, semSalCarroceria, semEnsamCarroceria);
            tProdCarroceria[i].start();
        }
        
        for (int i = 0; i < cantProdMotores; i++) {
            tProdMotor[i] = new cMotor(motores, salMotores, mutexMotores, semProdMotores, semSalMotores, semEnsamMotores);
            tProdMotor[i].start();
        }
        
        for (int i = 0; i < cantProdRuedas; i++) {
            tProdRuedas[i] = new cRuedas(ruedas, salRuedas, mutexRuedas, semProdRuedas, semSalRuedas, semEnsamRuedas);
            tProdRuedas[i].start();
        }
        
        for (int i = 0; i < cantProdAccesorios; i++) {
            tProdAccesorios[i] = new cAccesorios(accesorios, salAccesorios, mutexAccesorios, semProdAccesorios, semSalAccesorios, semEnsamAccesorios);
            tProdAccesorios[i].start();
        }
        
        for (int i = 0; i < cantProdEnsamblador; i++) {
            tProdEnsamblador[i] = new Ensamblador(mutexChasis, mutexCarrocerias, mutexMotores, mutexRuedas, mutexAccesorios, mutexCarros,
                    semEnsamChasis, semEnsamCarroceria, semEnsamMotores, semEnsamRuedas, semEnsamAccesorios,
                    semProdChasis, semProdCarroceria, semProdMotores, semProdRuedas, semProdAccesorios);
            tProdEnsamblador[i].start();
        }
        
        Gerente g = new Gerente(Datos[1], mutexDiasEntrega, mutexGerenteT);
        g.start();
        Director d = new Director(mutexDiasEntrega, mutexCarros, mutexDirectorT, mutexEntregas);
        d.start();
    }
    
}
