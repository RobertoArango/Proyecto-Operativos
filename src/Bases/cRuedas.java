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
public class cRuedas extends Productores {
    
    public cRuedas(float pDia, float salario, Semaphore mutex, Semaphore semProduccion, Semaphore semSalario) {
        super(pDia, salario, mutex, semProduccion, semSalario);
    }
    
}
