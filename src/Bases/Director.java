/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bases;

import main.main;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Vito
 */
public class Director extends Thread {
    
    Semaphore mutex;
    Semaphore mutexCarros;
    
    float supervisando;
    float trabajando;
    float horasTrabajo;
    Semaphore mutexTrabajando;
    Semaphore mutexEntregas;
    
    public Director(Semaphore mutex, Semaphore mutexCarros, Semaphore mutexTrabajando, Semaphore mutexEntregas) {
        this.mutex = mutex;
        this.mutexCarros = mutexCarros;
        this.mutexTrabajando = mutexTrabajando;
        this.mutexEntregas = mutexEntregas;
        this.horasTrabajo = 0;
        this.trabajando = ((float) ThreadLocalRandom.current().nextInt(0, 24)* main.Datos[0] / 24);
        this.supervisando = ((float) 25 * main.Datos[0] * 1000 / 1440);
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (trabajando * 1000));
                
                if (Gerente.diaEntrega >= 1){ //No tiene que realizar entregas
                    this.mutex.release();
                    this.mutexTrabajando.acquire();
                    //System.out.println("trabajando director");
                    main.tRRDirector = true;
                    this.mutexTrabajando.release();
                    //revisar porque no entra al if
                    if (main.tRRGerente = false){
                        //System.out.println(main.tGerente);
                        main.RRsemSalGerente.acquire();
                        main.RRsalGerente -= 50;
                        main.RRsemSalGerente.release();
                    }   
                } else {
                    //System.out.println("entregando");
                    Gerente.diaEntrega = main.Datos[1];
                    this.mutex.release();
                    this.mutexEntregas.acquire();
                    main.RRentregas++;
                    //System.out.println(main.entregas);
                    this.mutexEntregas.release();
                    this.mutexTrabajando.acquire();
                    main.tRRDirector = false;
                    this.mutexTrabajando.release();
                    Thread.sleep((long) (supervisando));
                }
            }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error director", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            }
        }
    }
}
