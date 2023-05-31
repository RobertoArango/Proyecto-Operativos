/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bases;

import main.main;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/**
 *
 * @author Vito
 */
public class Gerente extends Thread {
    
    public static volatile int diaEntrega;
    Semaphore mutex;
    Semaphore mutexTrabajando;
    float intervaloVT; //el tiempo que debe pasar para que trabaje/vea Formula 1
    float horasTrabajo;
    float horasDia;
    
    public Gerente (int diaEntrega, Semaphore mutex, Semaphore mutexTrabajando) {
        this.diaEntrega = diaEntrega;
        this.mutex = mutex;
        this.mutexTrabajando = mutexTrabajando;
        this.intervaloVT = ((float) 30*main.Datos[0]*1000/960); //intervalo 
        this.horasTrabajo = 0;
    }
    
      public void run(){
        while(true) { 
            try {
                while(horasTrabajo <= (float) (main.Datos[0])) {
                    System.out.println(diaEntrega);
                    //las primeras 16 horas que varia entre trabajar y ver Formula 1
                    //if (horasDia <= (float) main.Datos[0]/16){
                    
                    //trabajando
                    //System.out.println(horasDia + "trabajo");
                    this.mutexTrabajando.acquire();
                    main.tGerente = true;
                    this.mutexTrabajando.release();
                    Thread.sleep((long) (intervaloVT));
                    horasTrabajo += (intervaloVT / 1000);
                    horasDia += (intervaloVT / 1000);

                    //viendo Formula 1
                    //System.out.println(horasDia + "viendo");
                    this.mutexTrabajando.acquire();
                    main.tGerente = false;
                    this.mutexTrabajando.release();
                    Thread.sleep((long) (intervaloVT));
                    horasTrabajo += (intervaloVT / 1000);
                    horasDia += (intervaloVT / 1000);
                    //}
                    
                    //las 8 horas restantes que solamente trabaja
                    if (horasDia >= ((float) main.Datos[0])/16){
                        //System.out.println(horasDia + "potente");
                        
                        this.mutexTrabajando.acquire();
                        main.tGerente = true;
                        this.mutexTrabajando.release();
                        Thread.sleep((long)(intervaloVT));
                        horasTrabajo += (intervaloVT/1000);
                        horasDia += (intervaloVT/1000);
                    }
                    //reinicio del día y se le suma el sueldo
                    if (horasDia >= ((float) main.Datos[0]) / 24) {
                        //System.out.println(horasDia + "reinicio");

                        main.semSalGerente.acquire();
                        main.salGerente += 20;
                        main.semSalGerente.release();
                        horasDia = 0;
                    }
                }
                
                this.mutex.acquire();
                this.diaEntrega--;
                System.out.println(diaEntrega);
                horasTrabajo = 0;
                this.mutex.release();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error gerente", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
           
    }
}
