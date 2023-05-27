/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bases;

import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
import main.main;

/**
 *
 * @author Vito
 */
public class Ensamblador extends Thread {
    
    float tEnsam;
    Semaphore mutexChasis;
    Semaphore mutexCarrocerias;
    Semaphore mutexMotores;
    Semaphore mutexRuedas;
    Semaphore mutexAccesorios;
    volatile boolean estado;

    Semaphore mutexCarros;

    Semaphore semEnsamChasis;
    Semaphore semEnsamCarrocerias;
    Semaphore semEnsamMotores;
    Semaphore semEnsamRuedas;
    Semaphore semEnsamAccesorios;

    Semaphore semProdChasis;
    Semaphore semProdCarrocerias;
    Semaphore semProdMotores;
    Semaphore semProdRuedas;
    Semaphore semProdAccesorios;
    
    public Ensamblador(Semaphore mutexChasis,
            Semaphore mutexCarrocerias,
            Semaphore mutexMotores,
            Semaphore mutexRuedas,
            Semaphore mutexAccesorios,
            Semaphore mutexCarros,
            Semaphore semEnsamChasis,
            Semaphore semEnsamCarrocerias,
            Semaphore semEnsamMotores,
            Semaphore semEnsamRuedas,
            Semaphore semEnsamAccesorios,
            Semaphore semProdChasis,
            Semaphore semProdCarrocerias,
            Semaphore semProdMotores,
            Semaphore semProdRuedas,
            Semaphore semProdAccesorios) 
    {
        this.tEnsam = (float) 1 * 1000 * 2;
        this.mutexChasis = mutexCarrocerias;
        this.mutexCarrocerias = mutexCarrocerias;
        this.mutexMotores = mutexMotores;
        this.mutexRuedas = mutexRuedas;
        this.mutexAccesorios = mutexAccesorios;
        this.mutexCarros = mutexCarros;
        this.semEnsamChasis = semEnsamChasis;
        this.semEnsamCarrocerias = semEnsamCarrocerias;
        this.semEnsamMotores = semEnsamMotores;
        this.semEnsamRuedas = semEnsamRuedas;
        this.semEnsamAccesorios = semEnsamAccesorios;
        this.semProdChasis = semProdChasis;
        this.semProdCarrocerias = semProdCarrocerias;
        this.semProdMotores = semProdMotores;
        this.semProdRuedas = semProdRuedas;
        this.semProdAccesorios = semProdAccesorios;
        
    }
    public void run() {
        try {
            estado = (((int) main.cantChasis > this.semEnsamChasis.availablePermits()) 
                    && (int) main.cantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                    && ((int) main.cantMotores > this.semEnsamMotores.availablePermits())
                    && ((int) main.cantRuedas > this.semEnsamRuedas.availablePermits()));
            
            while ((((int) main.cantChasis > this.semEnsamChasis.availablePermits())
                    && (int) main.cantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                    && ((int) main.cantMotores > this.semEnsamMotores.availablePermits())
                    && ((int) main.cantRuedas > this.semEnsamRuedas.availablePermits()))) {
                
                Thread.sleep((long) (1 * 1000 / 24));
                main.semSalEnsamblador.acquire();
                main.salEnsamblador += 25;
                main.semSalEnsamblador.release();
                
                estado = (((int) main.cantChasis >= this.semEnsamChasis.availablePermits())
                        && (int) main.cantCarrocerias >= this.semEnsamCarrocerias.availablePermits()
                        && ((int) main.cantMotores >= this.semEnsamMotores.availablePermits())
                        && ((int) main.cantRuedas >= this.semEnsamRuedas.availablePermits()));
            }
            System.out.println("armando");
            Thread.sleep((long) this.tEnsam);
            this.semEnsamChasis.acquire((int) main.cantChasis); 
            this.semEnsamCarrocerias.acquire((int) main.cantCarrocerias);
            this.semEnsamMotores.acquire((int) main.cantMotores);
            this.semEnsamRuedas.acquire((int) main.cantRuedas);

            this.mutexChasis.acquire();
            this.mutexCarrocerias.acquire();
            this.mutexMotores.acquire();
            this.mutexRuedas.acquire();
            this.mutexCarros.acquire();
            
            Main.semSalEnsanmblador.acquire();
            
            main.carrosTotal++;
            main.aChasis = main.aChasis - (int) main.cantChasis;
            main.aCarrocerias = main.aCarrocerias - (int) main.cantCarrocerias;
            main.aMotores = main.aMotores - (int) main.cantMotores;
            main.aRuedas = main.aRuedas - (int) main.cantRuedas; 

            main.salEnsamblador += ((this.tEnsam / 1000 * 24) * 6);

            main.semSalEnsanmblador.release();
            
            this.mutexChasis.release();
            this.mutexCarrocerias.release();
            this.mutexMotores.release();
            this.mutexRuedas.release();
            this.mutexCarros.release();

            this.semProdChasis.release((int) main.cantChasis); 
            this.semProdCarrocerias.release((int) main.cantCarrocerias);
            this.semProdMotores.release((int) main.cantMotores);
            this.semProdRuedas.release((int) main.cantRuedas);
            
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la ejecución del Ass-embler.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
