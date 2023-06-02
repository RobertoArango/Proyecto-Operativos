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
import Interfaz.Menu;
import java.util.concurrent.Semaphore;

/**
 *
 * @author rober
 */
public class main {
    
    //variable para datos iniciales de la simulacion 
    public static int[] Datos;
    public static String empresaRR = "RR";
    public static String empresaM = "M";
    public static volatile float RRprecio = 450000;
    public static volatile float RRprecioPlus = 900000;
    public static volatile float Mprecio = 350000;
    public static volatile float MprecioPlus = 700000;
    public static volatile int carnetRober = 8;
    public static volatile int carnetVito = 8;
    public static volatile int RRprodMax = 10 + carnetRober;
    public static volatile int MprodMax = 10 + carnetVito;
    
    //almacen para Rolls Royce
    //la "a" indica que estan en almacen 
    public static volatile int aRRChasis = 0; 
    public static volatile int aRRCarrocerias = 0;
    public static volatile int aRRMotores = 0;
    public static volatile int aRRRuedas = 0;
    public static volatile int aRRAccesorios = 0;
    public static volatile boolean tRRGerente = true;
    public static volatile boolean tRRDirector = true;
    public static volatile int RRcarros = 0;
    public static volatile int RRcarrosTotal = 0;
    public static volatile int RRcarrosPlus = 0;
    public static volatile int RRcarrosTotalPlus = 0;
    public static volatile int RRentregas = 0;
    
    //almacen para Maserati
    
    public static volatile int aMChasis = 0; 
    public static volatile int aMCarrocerias = 0;
    public static volatile int aMMotores = 0;
    public static volatile int aMRuedas = 0;
    public static volatile int aMAccesorios = 0;
    public static volatile boolean tMGerente = true;
    public static volatile boolean tMDirector = true;
    public static volatile int Mcarros = 0;
    public static volatile int McarrosTotal = 0;
    public static volatile int McarrosPlus = 0;
    public static volatile int McarrosTotalPlus = 0;
    public static volatile int Mentregas = 0;
    
    //cantidad producida por dia Rolls Royce    
    public static volatile float RRchasis;
    public static volatile float RRcarrocerias;
    public static volatile float RRmotores;
    public static volatile float RRruedas;
    public static volatile float RRaccesorios;
    
    //cantidad producida por dia Maserati
    public static volatile float Mchasis;
    public static volatile float Mcarrocerias;
    public static volatile float Mmotores;
    public static volatile float Mruedas;
    public static volatile float Maccesorios;
    
    //cantidad de piezas necesarias para fabircar el carro Rolls Royce 
    public static volatile float RRcantChasis;
    public static volatile float RRcantCarrocerias;
    public static volatile float RRcantMotores;
    public static volatile float RRcantRuedas;
    public static volatile float RRcantAccesorios;
    public static volatile float RRmaximoProducto;
    
    //cantidad de piezas necesaria para fabricar el carro Maserati
    public static volatile float McantChasis;
    public static volatile float McantCarrocerias;
    public static volatile float McantMotores;
    public static volatile float McantRuedas;
    public static volatile float McantAccesorios;
    public static volatile float MmaximoProducto;
    
    //semaforos
    
    public static Semaphore RRmutexChasis;
    public static Semaphore MmutexChasis;
    public static Semaphore RRmutexCarrocerias;
    public static Semaphore MmutexCarrocerias;
    public static Semaphore RRmutexMotores;
    public static Semaphore MmutexMotores;
    public static Semaphore RRmutexRuedas;
    public static Semaphore MmutexRuedas;
    public static Semaphore RRmutexAccesorios;
    public static Semaphore MmutexAccesorios;
    public static Semaphore RRmutexCarros;
    public static Semaphore MmutexCarros;
    public static Semaphore RRmutexDiasEntrega;
    public static Semaphore MmutexDiasEntrega;
    public static Semaphore RRmutexGerenteT; //trabajando
    public static Semaphore MmutexGerenteT;
    public static Semaphore RRmutexDirectorT;
    public static Semaphore MmutexDirectorT;
    public static Semaphore RRmutexEntregas;
    public static Semaphore MmutexEntregas;
    
    public static Semaphore RRsemProdChasis;
    public static Semaphore MsemProdChasis;
    public static Semaphore RRsemProdCarroceria;
    public static Semaphore MsemProdCarroceria;
    public static Semaphore RRsemProdMotores;
    public static Semaphore MsemProdMotores;
    public static Semaphore RRsemProdRuedas;
    public static Semaphore MsemProdRuedas;
    public static Semaphore RRsemProdAccesorios;
    public static Semaphore MsemProdAccesorios;
    
    public static Semaphore RRsemEnsamChasis;
    public static Semaphore MsemEnsamChasis;
    public static Semaphore RRsemEnsamCarroceria;
    public static Semaphore MsemEnsamCarroceria;
    public static Semaphore RRsemEnsamMotores;
    public static Semaphore MsemEnsamMotores;
    public static Semaphore RRsemEnsamRuedas;
    public static Semaphore MsemEnsamRuedas;
    public static Semaphore RRsemEnsamAccesorios;
    public static Semaphore MsemEnsamAccesorios;
    
    public static Semaphore RRsemSalChasis;
    public static Semaphore MsemSalChasis;
    public static Semaphore RRsemSalCarroceria;
    public static Semaphore MsemSalCarroceria;
    public static Semaphore RRsemSalMotores;
    public static Semaphore MsemSalMotores;
    public static Semaphore RRsemSalRuedas;
    public static Semaphore MsemSalRuedas;
    public static Semaphore RRsemSalAccesorios;
    public static Semaphore MsemSalAccesorios;
    public static Semaphore RRsemSalEnsamblador;
    public static Semaphore MsemSalEnsamblador;
    public static Semaphore RRsemSalGerente;
    public static Semaphore MsemSalGerente;
    public static Semaphore RRsemSalDirector;
    public static Semaphore MsemSalDirector;
    
    //cantidad de productores en los sectores
    
    public static volatile int RRcantProdChasis;
    public static volatile int McantProdChasis;
    public static volatile int RRcantProdCarroceria;
    public static volatile int McantProdCarroceria;
    public static volatile int RRcantProdMotores;
    public static volatile int McantProdMotores;
    public static volatile int RRcantProdRuedas;
    public static volatile int McantProdRuedas;
    public static volatile int RRcantProdAccesorios;
    public static volatile int McantProdAccesorios;
    public static volatile int RRcantProdEnsamblador;
    public static volatile int McantProdEnsamblador;
    
    //cantidad de productores trabajando
    
    public static volatile cChasis RRtProdChasis[];
    public static volatile cChasis MtProdChasis[];
    public static volatile cCarroceria RRtProdCarroceria[];
    public static volatile cCarroceria MtProdCarroceria[];
    public static volatile cMotor RRtProdMotor[];
    public static volatile cMotor MtProdMotor[];
    public static volatile cRuedas RRtProdRuedas[];
    public static volatile cRuedas MtProdRuedas[];
    public static volatile cAccesorios RRtProdAccesorios[];
    public static volatile cAccesorios MtProdAccesorios[];
    public static volatile Ensamblador RRtProdEnsamblador[];
    public static volatile Ensamblador MtProdEnsamblador[];
    
    //variables salarios trabajadores
    
    public static volatile float RRsalChasis = 0;
    public static volatile float MsalChasis = 0;
    public static volatile float RRsalCarroceria = 0;
    public static volatile float MsalCarroceria = 0;
    public static volatile float RRsalMotores = 0;
    public static volatile float MsalMotores = 0;
    public static volatile float RRsalRuedas = 0;
    public static volatile float MsalRuedas = 0;
    public static volatile float RRsalAccesorios = 0;
    public static volatile float MsalAccesorios = 0;
    public static volatile float RRsalEnsamblador = 0;
    public static volatile float MsalEnsamblador = 0;
    public static volatile float RRsalGerente = 0;
    public static volatile float MsalGerente = 0;
    public static volatile float RRsalDirector = 0;
    public static volatile float MsalDirector = 0;
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //se crea la cantidad de datos que existiran en el txt - se llama a la funcion para crear el txt (prueba)
        
        Datos = new int[26];
        lectorTXT.leer();
        
        //valores para carros fabricados
        
        RRmutexCarros = new Semaphore (1);
        MmutexCarros = new Semaphore (1);
        
        //valores por chasis Rolls Royce
        
        RRchasis = (float)0.25; //lo que se produce por dia
        RRcantChasis = 3; //lo que se requiere para fabricar un carro
        RRcantProdChasis = Datos[7];
        RRtProdChasis = new cChasis[Datos[7]]; //productores en el sector chasis pasado como parametro a la clase
        RRsemSalChasis = new Semaphore(1);
        RRsemProdChasis = new Semaphore(Datos[2]);//semaforo para el limite maximo de chasis en almacen
        RRmutexChasis = new Semaphore(1);
        RRsemEnsamChasis = new Semaphore(0);
        
        //valores por chasis Maserati
        
        Mchasis = (float)0.25; //lo que se produce por dia
        McantChasis = 1; //lo que se requiere para fabricar un carro
        McantProdChasis = Datos[20];
        MtProdChasis = new cChasis[Datos[20]]; //productores en el sector chasis pasado como parametro a la clase
        MsemSalChasis = new Semaphore(1);
        MsemProdChasis = new Semaphore(Datos[15]);//semaforo para el limite maximo de chasis en almacen
        MmutexChasis = new Semaphore(1);
        MsemEnsamChasis = new Semaphore(0);
        
        //valores por carroceria Rolls Royce
        
        RRcarrocerias = (float)0.25; //lo que se produce por dia
        RRcantCarrocerias = 2; //lo que se requiere para fabricar un carro
        RRcantProdCarroceria = Datos[8];
        RRtProdCarroceria = new cCarroceria[Datos[8]]; //productores en el sector chasis pasado como parametro a la clase
        RRsemSalCarroceria = new Semaphore(1);
        RRsemProdCarroceria = new Semaphore(Datos[3]); //semaforo para el limite maximo de chasis en almacen
        RRmutexCarrocerias = new Semaphore (1);
        RRsemEnsamCarroceria = new Semaphore(0);
        
        //valores por carroceria Maserati
        
        Mcarrocerias = (float)0.25; //lo que se produce por dia
        McantCarrocerias = 1; //lo que se requiere para fabricar un carro
        McantProdCarroceria = Datos[21];
        MtProdCarroceria = new cCarroceria[Datos[21]]; //productores en el sector chasis pasado como parametro a la clase
        MsemSalCarroceria = new Semaphore(1);
        MsemProdCarroceria = new Semaphore(Datos[16]); //semaforo para el limite maximo de chasis en almacen
        MmutexCarrocerias = new Semaphore (1);
        MsemEnsamCarroceria = new Semaphore(0);
        
        //valores por motores Rolls Royce
        
        RRmotores = 1;
        RRcantMotores = 4;
        RRcantProdMotores = Datos[9];
        RRtProdMotor = new cMotor[Datos[9]];
        RRsemSalMotores = new Semaphore(1);
        RRsemProdMotores = new Semaphore(Datos[4]);
        RRmutexMotores = new Semaphore (1);
        RRsemEnsamMotores = new Semaphore(0);
        
        //valores por motores Maserati
        
        Mmotores = 1;
        McantMotores = 2;
        McantProdMotores = Datos[22];
        MtProdMotor = new cMotor[Datos[22]];
        MsemSalMotores = new Semaphore(1);
        MsemProdMotores = new Semaphore(Datos[17]);
        MmutexMotores = new Semaphore (1);
        MsemEnsamMotores = new Semaphore(0);
        
        //valores por ruedas Rolls Royce
        
        RRruedas = 5;
        RRcantRuedas = 6;
        RRcantProdRuedas = Datos[10];
        RRtProdRuedas = new cRuedas[Datos[10]];
        RRsemSalRuedas = new Semaphore(1);
        RRsemProdRuedas = new Semaphore(Datos[5]);
        RRmutexRuedas = new Semaphore (1);
        RRsemEnsamRuedas = new Semaphore(0);
        
        //valores por ruedas Maserati
        
        Mruedas = 5;
        McantRuedas = 4;
        McantProdRuedas = Datos[23];
        MtProdRuedas = new cRuedas[Datos[23]];
        MsemSalRuedas = new Semaphore(1);
        MsemProdRuedas = new Semaphore(Datos[18]);
        MmutexRuedas = new Semaphore (1);
        MsemEnsamRuedas = new Semaphore(0);
        
        //valores por accesorios Rolls Royce
        
        RRaccesorios = (float)0.5;
        RRcantAccesorios = 5;
        RRcantProdAccesorios = Datos[11];
        RRtProdAccesorios = new cAccesorios[Datos[11]];
        RRsemSalAccesorios = new Semaphore(1);
        RRsemProdAccesorios = new Semaphore (Datos[6]);
        RRmutexAccesorios = new Semaphore (1);
        RRsemEnsamAccesorios = new Semaphore(0);
        
        //valores por accesorios Maserati
        
        Maccesorios = (float)0.5;
        McantAccesorios = 3;
        McantProdAccesorios = Datos[24];
        MtProdAccesorios = new cAccesorios[Datos[24]];
        MsemSalAccesorios = new Semaphore(1);
        MsemProdAccesorios = new Semaphore (Datos[19]);
        MmutexAccesorios = new Semaphore (1);
        MsemEnsamAccesorios = new Semaphore(0);
         
        //valores gerente Rolls Royce
        RRmutexGerenteT = new Semaphore (1);
        RRsemSalGerente = new Semaphore (1);
        RRmutexDiasEntrega = new Semaphore (1);
        
        //valores gerente Maserati
        
        MmutexGerenteT = new Semaphore (1);
        MsemSalGerente = new Semaphore (1);
        MmutexDiasEntrega = new Semaphore (1);
        
        //valores director Rolls Royce
        RRmutexDirectorT = new Semaphore (1);
        RRsemSalDirector = new Semaphore (1);
        RRmutexEntregas = new Semaphore (1);
        
        //valores director Maserati
        MmutexDirectorT = new Semaphore (1);
        MsemSalDirector = new Semaphore (1);
        MmutexEntregas = new Semaphore (1);
        
        // TODO code application logic here
        
        RRtProdEnsamblador = new Ensamblador[Datos[12]];
        RRcantProdEnsamblador = Datos[12];
        RRsemSalEnsamblador = new Semaphore(1);
        MtProdEnsamblador = new Ensamblador[Datos[25]];
        McantProdEnsamblador = Datos[25];
        MsemSalEnsamblador = new Semaphore(1);
        
        //for para producir chasis RR y M
        for (int i = 0; i < RRcantProdChasis; i++) {
            RRtProdChasis[i] = new cChasis(RRchasis, RRmutexChasis, RRsemProdChasis, RRsemSalChasis, RRsemEnsamChasis, empresaRR);
            RRtProdChasis[i].start();
        }  
        
        for (int i = 0; i < McantProdChasis; i++) {
            MtProdChasis[i] = new cChasis(Mchasis, MmutexChasis, MsemProdChasis, MsemSalChasis, MsemEnsamChasis, empresaM );
            MtProdChasis[i].start();
        }  
         
        
        //for para producir carroceias RR y M
          for (int i = 0; i < RRcantProdCarroceria; i++) {
            RRtProdCarroceria[i] = new cCarroceria(RRcarrocerias, RRmutexCarrocerias, RRsemProdCarroceria, RRsemSalCarroceria, RRsemEnsamCarroceria, empresaRR);
            RRtProdCarroceria[i].start();
        }
        
        for (int i = 0; i < McantProdCarroceria; i++) {
            MtProdCarroceria[i] = new cCarroceria(Mcarrocerias, MmutexCarrocerias, MsemProdCarroceria, MsemSalCarroceria, MsemEnsamCarroceria, empresaM);
            MtProdCarroceria[i].start();
        }
        
        
        //for para producir motores RR y M
        for (int i = 0; i < RRcantProdMotores; i++) {
            RRtProdMotor[i] = new cMotor(RRmotores, RRmutexMotores, RRsemProdMotores, RRsemSalMotores, RRsemEnsamMotores, empresaRR);
            RRtProdMotor[i].start();
        }
        
        for (int i = 0; i < McantProdMotores; i++) {
            MtProdMotor[i] = new cMotor(Mmotores, MmutexMotores, MsemProdMotores, MsemSalMotores, MsemEnsamMotores, empresaM);
            MtProdMotor[i].start();
        }
        
        //for para proudicr ruedas RR y M
        for (int i = 0; i < RRcantProdRuedas; i++) {
            RRtProdRuedas[i] = new cRuedas(RRruedas, RRmutexRuedas, RRsemProdRuedas, RRsemSalRuedas, RRsemEnsamRuedas, empresaRR);
            RRtProdRuedas[i].start();
        }
        
        for (int i = 0; i < McantProdRuedas; i++) {
            MtProdRuedas[i] = new cRuedas(Mruedas, MmutexRuedas, MsemProdRuedas, MsemSalRuedas, MsemEnsamRuedas, empresaM);
            MtProdRuedas[i].start();
        }
        
        //for para producir accesorios RR y M
        for (int i = 0; i < RRcantProdAccesorios; i++) {
            RRtProdAccesorios[i] = new cAccesorios(RRaccesorios, RRmutexAccesorios, RRsemProdAccesorios, RRsemSalAccesorios, RRsemEnsamAccesorios, empresaRR);
            RRtProdAccesorios[i].start();
        }
        
        for (int i = 0; i < McantProdAccesorios; i++) {
            MtProdAccesorios[i] = new cAccesorios(Maccesorios, MmutexAccesorios, MsemProdAccesorios, MsemSalAccesorios, MsemEnsamAccesorios, empresaM);
            MtProdAccesorios[i].start();
        }
        
        
        //for para ensamblar los carros RR y M
        for (int i = 0; i < RRcantProdEnsamblador; i++) {
            RRtProdEnsamblador[i] = new Ensamblador(
                    RRmutexChasis, 
                    RRmutexCarrocerias, 
                    RRmutexMotores, 
                    RRmutexRuedas, 
                    RRmutexAccesorios, 
                    RRmutexCarros,
                    RRsemEnsamChasis, 
                    RRsemEnsamCarroceria, 
                    RRsemEnsamMotores, 
                    RRsemEnsamRuedas, 
                    RRsemEnsamAccesorios,
                    RRsemProdChasis, 
                    RRsemProdCarroceria, 
                    RRsemProdMotores, 
                    RRsemProdRuedas, 
                    RRsemProdAccesorios, 
                    empresaRR);
            RRtProdEnsamblador[i].start();
        }
        
        for (int i = 0; i < McantProdEnsamblador; i++) {
            MtProdEnsamblador[i] = new Ensamblador(
                    MmutexChasis, 
                    MmutexCarrocerias, 
                    MmutexMotores, 
                    MmutexRuedas, 
                    MmutexAccesorios, 
                    MmutexCarros,
                    MsemEnsamChasis, 
                    MsemEnsamCarroceria, 
                    MsemEnsamMotores, 
                    MsemEnsamRuedas, 
                    MsemEnsamAccesorios,
                    MsemProdChasis, 
                    MsemProdCarroceria, 
                    MsemProdMotores, 
                    MsemProdRuedas, 
                    MsemProdAccesorios, 
                    empresaM);
            MtProdEnsamblador[i].start();
        }
        
        //gerente RR
        Gerente grr = new Gerente(Datos[1], RRmutexDiasEntrega, RRmutexGerenteT, empresaRR);
        grr.start();
        
        //gerente M
        Gerente gm = new Gerente(Datos[14], MmutexDiasEntrega, MmutexGerenteT, empresaM);
        gm.start();
        
        //director RR
        Director drr = new Director(RRmutexDiasEntrega, RRmutexCarros, RRmutexDirectorT, RRmutexEntregas, empresaRR);
        drr.start();
        
        //director M
        Director dm = new Director(MmutexDiasEntrega, MmutexCarros, MmutexDirectorT, MmutexEntregas, empresaM);
        dm.start();
        
        Menu m = new Menu();
    }
    
}
