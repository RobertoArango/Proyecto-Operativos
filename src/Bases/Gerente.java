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
        this.intervaloVT = ((float) 30 * main.Datos[0] * 1000 / 960); //intervalo 
        this.horasTrabajo = 0;
    }
    
    public void run(){
        try {
            while (true) {
                
                //trabajando
                
                if (horasDia <= ((float) main.Datos[0]/16)){
                    this.mutexTrabajando.acquire();
                    main.tGerente = true;
                    this.mutexTrabajando.release();
                    Thread.sleep((long)(intervaloVT));
                    horasTrabajo += (intervaloVT/1000);
                    horasDia += (intervaloVT/1000);
                    
                //viendo Formula 1
                    this.mutexTrabajando.acquire();
                    main.tGerente = false;
                    this.mutexTrabajando.release();
                    Thread.sleep((long)(intervaloVT));
                    horasTrabajo += (intervaloVT/1000);
                    horasDia += (intervaloVT/1000);
                }
                //las 8 horas restantes que solamente trabaja
                if (horasDia > ((float) main.Datos[0]/16)){
                    this.mutexTrabajando.acquire();
                    main.tGerente = true;
                    this.mutexTrabajando.release();
                    Thread.sleep((long)(intervaloVT));
                    horasTrabajo += (intervaloVT/1000);
                    horasDia += (intervaloVT/1000);
                }
                //reinicio del día y se le suma el sueldo
                else if (horasDia >= ((float) main.Datos[0]/24)){
                    
                    main.semSalGerente.acquire();
                    main.salGerente += (20*24);
                    main.semSalGerente.release();
                    horasDia = 0;
                }
                
                this.mutex.acquire();
                this.diaEntrega--;
                horasTrabajo = 0;
                this.mutex.release();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }   
    }
}
