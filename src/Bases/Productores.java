/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bases;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Vito
 */
public abstract class Productores extends Thread{
    
    float tProduccion;  //tiempo de produccion
    float pDia; //produccion por dia
    float salario;
    Semaphore mutex;
    Semaphore semProduccion; 
    Semaphore semSalario;
    Semaphore semEnsam;
       
    public Productores(float pDia, float salario, Semaphore mutex, Semaphore semProduccion, Semaphore semSalario, Semaphore semEnsam ) {
        
        this.tProduccion = (float)1/this.pDia*1000;
        this.pDia = pDia;
        this.salario = salario;
        this.mutex = mutex;
        this.semProduccion = semProduccion;
        this.semSalario = semSalario;
        this.semEnsam = semEnsam;
        
    }

    @Override
    public void run() {
    }

}

