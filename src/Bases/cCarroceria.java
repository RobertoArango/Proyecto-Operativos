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
public class cCarroceria extends Productores {
    
    public cCarroceria(float tProduccion, float pDia, float salario, Semaphore mutex, Semaphore semProduccion, Semaphore semSalario) {
        super(tProduccion, pDia, salario, mutex, semProduccion, semSalario);
    }
    
}
