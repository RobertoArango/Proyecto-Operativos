/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bases;
import java.util.concurrent.Semaphore;
import main.main;

/**
 *
 * @author Vito
 */
public abstract class Productores extends Thread{
    
    float tProduccion;  //tiempo de produccion
    float pDia; //produccion por dia
    boolean activo;
    String empresa;
    Semaphore mutex;
    Semaphore semProduccion; 
    Semaphore semSalario;
    Semaphore semEnsam;
       
    public Productores(float pDia, Semaphore mutex, Semaphore semProduccion, Semaphore semSalario, Semaphore semEnsam, String empresa) {
        
        this.empresa = empresa;
        this.pDia = pDia;
        this.tProduccion = (float)main.Datos[0]/this.pDia*1000;
        this.mutex = mutex;
        this.semProduccion = semProduccion;
        this.semSalario = semSalario;
        this.semEnsam = semEnsam;
        this.activo = true;
        
        
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public void run() {
    }

}

