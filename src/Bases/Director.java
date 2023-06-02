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
    
    float supervisandoRR;
    float supervisandoM;
    float trabajandoRR;
    float trabajandoM;
    float horasTrabajoRR;
    float horasTrabajoM;
    String empresa;
    Semaphore mutexTrabajando;
    Semaphore mutexEntregas;
    
    public Director(Semaphore mutex, Semaphore mutexCarros, Semaphore mutexTrabajando, Semaphore mutexEntregas, String empresa) {
        this.mutex = mutex;
        this.mutexCarros = mutexCarros;
        this.mutexTrabajando = mutexTrabajando;
        this.mutexEntregas = mutexEntregas;
        this.horasTrabajoRR = 0;
        this.horasTrabajoM = 0;
        this.empresa = empresa;
        this.trabajandoRR = ((float) ThreadLocalRandom.current().nextInt(0, 24)* main.Datos[0] / 24);
        this.trabajandoM = ((float) ThreadLocalRandom.current().nextInt(0, 24)* main.Datos[0] / 24);
        this.supervisandoRR = ((float) 25 * main.Datos[0] * 1000 / 1440);
        this.supervisandoM = ((float) 25 * main.Datos[0] * 1000 / 1440);
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                if ("RR".equals(empresa)) {
                    Thread.sleep((long) (trabajandoRR * 1000));

                    if (Gerente.diaEntrega >= 1) {//No tiene que realizar entregas
                        this.mutex.release();
                        this.mutexTrabajando.acquire();
                        //System.out.println("trabajando director");
                        main.tRRDirector = true;
                        this.mutexTrabajando.release();
                        //revisar porque no entra al if
                        if (main.tRRGerente = false) {
                            //System.out.println(main.tGerente);
                            main.RRsemSalGerente.acquire();
                            main.RRsalGerente -= 50;
                            main.RRsemSalGerente.release();
                        }
                    } else {
                        //System.out.println("entregando");
                        Gerente.diaEntrega = main.Datos[1];
                        this.mutex.release();
                        
                        this.mutexCarros.acquire();
                        main.RRcarros = main.RRcarros + main.RRcarrosTotal;
                        main.RRcarrosTotal = 0;
                        main.RRcarrosPlus = main.RRcarrosPlus + main.RRcarrosTotalPlus;
                        main.RRcarrosTotalPlus = 0;
                        this.mutexCarros.release();
                        
                        this.mutexEntregas.acquire();
                        main.RRentregas++;
                        //System.out.println(main.entregas);
                        this.mutexEntregas.release();
                        this.mutexTrabajando.acquire();
                        main.tRRDirector = false;
                        this.mutexTrabajando.release();
                        Thread.sleep((long) (supervisandoRR));
                    }
                }
                if ("M".equals(empresa)) {
                    Thread.sleep((long) (trabajandoM * 1000));

                    if (Gerente.diaEntrega >= 1) {//No tiene que realizar entregas
                        this.mutex.release();
                        this.mutexTrabajando.acquire();
                        //System.out.println("trabajando director");
                        main.tMDirector = true;
                        this.mutexTrabajando.release();
                        //revisar porque no entra al if
                        if (main.tMGerente = false) {
                            //System.out.println(main.tGerente);
                            main.MsemSalGerente.acquire();
                            main.MsalGerente -= 50;
                            main.MsemSalGerente.release();
                        }
                    } else {
                        //System.out.println("entregando");
                        Gerente.diaEntrega = main.Datos[1];
                        this.mutex.release();
                        
                        this.mutexCarros.acquire();
                        main.Mcarros = main.Mcarros + main.McarrosTotal;
                        main.McarrosTotal = 0;
                        main.McarrosPlus = main.McarrosPlus + main.McarrosTotalPlus;
                        main.McarrosTotalPlus = 0;
                        this.mutexCarros.release();
                        
                        this.mutexEntregas.acquire();
                        main.Mentregas++;
                        //System.out.println(main.entregas);
                        this.mutexEntregas.release();
                        this.mutexTrabajando.acquire();
                        main.tMDirector = false;
                        this.mutexTrabajando.release();
                        Thread.sleep((long)(supervisandoM));
                    }
                }
            }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error director", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            }
        }
    }
}
