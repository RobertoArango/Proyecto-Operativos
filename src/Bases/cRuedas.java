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
public class cRuedas extends Productores {
    
    public cRuedas(float pDia, float salario, Semaphore mutex, Semaphore semProduccion, Semaphore semSalario) {
        super(pDia, salario, mutex, semProduccion, semSalario);
    }
    
    @Override
    public void run() {
        try {
            while (this.semProduccion.availablePermits() == 0) {
                Thread.sleep((long) (1* 1000 / 24));
                this.semSalario.acquire();
                salario += 8;
                this.semSalario.release();
            }
            Thread.sleep((long) this.tProduccion);
            this.semProduccion.acquire();
            this.mutex.acquire();
            this.semSalario.acquire();
            salario += ((tProduccion/1000)*8);
            main.aRuedas++;
            //System.out.println("Ruedas:" + main.aRuedas);
            this.mutex.release();
            this.semSalario.release();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
   }
    
}
