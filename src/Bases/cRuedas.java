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
    
    public cRuedas(float pDia, Semaphore mutex, Semaphore semProduccion, Semaphore semSalario, Semaphore semEnsam, String empresa) {
        super(pDia, mutex, semProduccion, semSalario, semEnsam, empresa);
    }
    
    @Override
    public void run() {
        while (activo) {
            try {
                while (this.semProduccion.availablePermits() == 0) {
                    Thread.sleep((long) (main.Datos[0] * 1000 / 24));
                    this.semSalario.acquire();
                    
                    if (empresa == "RR") {
                        main.RRsalRuedas += 8;
                    } else {
                        main.MsalRuedas += 8;
                    }
                    
                    this.semSalario.release();
                }
                Thread.sleep((long) this.tProduccion);
                this.semProduccion.acquire();
                this.mutex.acquire();
                this.semSalario.acquire();
                
                if (empresa == "RR") {
                    main.RRsalRuedas += ((tProduccion / 1000) * 8);
                    main.aRRRuedas++;
                    //System.out.println("Ruedas RR: " + main.aRRRuedas);
                } else {
                    main.MsalRuedas += ((tProduccion / 1000) * 8);
                    main.aMRuedas++;
                    //System.out.println("Ruedas M: " + main.aMRuedas);

                }
                
                this.mutex.release();
                this.semSalario.release();
                this.semEnsam.release();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
    }
    
}
