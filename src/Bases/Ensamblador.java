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
public class Ensamblador extends Thread {
    
    boolean activo;
    float tEnsam;
    int RRcontador;
    int Mcontador;
    String empresa;
    Semaphore mutexChasis;
    Semaphore mutexCarrocerias;
    Semaphore mutexMotores;
    Semaphore mutexRuedas;
    Semaphore mutexAccesorios;
    volatile boolean estado;

    Semaphore mutexCarros;

    Semaphore semEnsamChasis;
    Semaphore semEnsamCarrocerias;
    Semaphore semEnsamMotores;
    Semaphore semEnsamRuedas;
    Semaphore semEnsamAccesorios;

    Semaphore semProdChasis;
    Semaphore semProdCarrocerias;
    Semaphore semProdMotores;
    Semaphore semProdRuedas;
    Semaphore semProdAccesorios;
    
    public Ensamblador(Semaphore mutexChasis,
            Semaphore mutexCarrocerias,
            Semaphore mutexMotores,
            Semaphore mutexRuedas,
            Semaphore mutexAccesorios,
            Semaphore mutexCarros,
            Semaphore semEnsamChasis,
            Semaphore semEnsamCarrocerias,
            Semaphore semEnsamMotores,
            Semaphore semEnsamRuedas,
            Semaphore semEnsamAccesorios,
            Semaphore semProdChasis,
            Semaphore semProdCarrocerias,
            Semaphore semProdMotores,
            Semaphore semProdRuedas,
            Semaphore semProdAccesorios,
            String empresa) 
    {
        this.tEnsam = (float) main.Datos[0] * 1000 * 2;
        this.mutexChasis = mutexChasis;
        this.mutexCarrocerias = mutexCarrocerias;
        this.mutexMotores = mutexMotores;
        this.mutexRuedas = mutexRuedas;
        this.mutexAccesorios = mutexAccesorios;
        this.mutexCarros = mutexCarros;
        this.semEnsamChasis = semEnsamChasis;
        this.semEnsamCarrocerias = semEnsamCarrocerias;
        this.semEnsamMotores = semEnsamMotores;
        this.semEnsamRuedas = semEnsamRuedas;
        this.semEnsamAccesorios = semEnsamAccesorios;
        this.semProdChasis = semProdChasis;
        this.semProdCarrocerias = semProdCarrocerias;
        this.semProdMotores = semProdMotores;
        this.semProdRuedas = semProdRuedas;
        this.semProdAccesorios = semProdAccesorios;
        this.empresa = empresa;
        this.activo = true;
        this.RRcontador = 0;
        this.Mcontador = 0;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }    
     
    public void run() {
        while (activo) {
            try {
                if ("RR".equals(empresa)){
                    if (RRcontador == 6) {
                        estado = (((int) main.RRcantChasis > this.semEnsamChasis.availablePermits())
                                && (int) main.RRcantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                                && ((int) main.RRcantMotores > this.semEnsamMotores.availablePermits())
                                && ((int) main.RRcantRuedas > this.semEnsamRuedas.availablePermits())
                                && ((int) main.RRcantAccesorios > this.semEnsamAccesorios.availablePermits()));

                        while ((((int) main.RRcantChasis > this.semEnsamChasis.availablePermits())
                                && (int) main.RRcantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                                && ((int) main.RRcantMotores > this.semEnsamMotores.availablePermits())
                                && ((int) main.RRcantRuedas > this.semEnsamRuedas.availablePermits())
                                && ((int) main.RRcantAccesorios > this.semEnsamAccesorios.availablePermits()))) {

                            Thread.sleep((long) (main.Datos[0] * 1000 / 24));
                            main.RRsemSalEnsamblador.acquire();
                            main.RRsalEnsamblador += 25;
                            main.RRsemSalEnsamblador.release();

                            estado = (((int) main.RRcantChasis >= this.semEnsamChasis.availablePermits())
                                    && (int) main.RRcantCarrocerias >= this.semEnsamCarrocerias.availablePermits()
                                    && ((int) main.RRcantMotores >= this.semEnsamMotores.availablePermits())
                                    && ((int) main.RRcantRuedas >= this.semEnsamRuedas.availablePermits())
                                    && ((int) main.RRcantAccesorios >= this.semEnsamAccesorios.availablePermits()));
                        }
                        //Se revisa que se tenga la cantidad necesaria de piezas para el ensamblador
                        Thread.sleep((long) this.tEnsam);
                        this.semEnsamChasis.acquire((int) main.RRcantChasis);
                        this.semEnsamCarrocerias.acquire((int) main.RRcantCarrocerias);
                        this.semEnsamMotores.acquire((int) main.RRcantMotores);
                        this.semEnsamRuedas.acquire((int) main.RRcantRuedas);
                        this.semEnsamAccesorios.acquire((int) main.RRcantAccesorios);

                        this.mutexChasis.acquire();
                        this.mutexCarrocerias.acquire();
                        this.mutexMotores.acquire();
                        this.mutexRuedas.acquire();
                        this.mutexAccesorios.acquire();
                        this.mutexCarros.acquire();
                        main.RRsemSalEnsamblador.acquire();

                        main.RRcarrosTotalPlus++; // se suma el carro que salga de ensamblador 
                        System.out.println("carros totales plus RR: " + main.RRcarrosTotalPlus);

                        //Se restan las piezas del almacen que fueron utilizadas en el ensamblador
                        main.aRRChasis = main.aRRChasis - (int) main.RRcantChasis;
                        main.aRRCarrocerias = main.aRRCarrocerias - (int) main.RRcantCarrocerias;
                        main.aRRMotores = main.aRRMotores - (int) main.RRcantMotores;
                        main.aRRRuedas = main.aRRRuedas - (int) main.RRcantRuedas;
                        main.aRRAccesorios = main.aRRAccesorios - (int) main.RRcantAccesorios;

                        main.RRsalEnsamblador += ((this.tEnsam / 1000 * 24) * 25);

                        main.RRsemSalEnsamblador.release();

                        this.mutexChasis.release();
                        this.mutexCarrocerias.release();
                        this.mutexMotores.release();
                        this.mutexRuedas.release();
                        this.mutexAccesorios.release();
                        this.mutexCarros.release();

                        this.semProdChasis.release((int) main.RRcantChasis);
                        this.semProdCarrocerias.release((int) main.RRcantCarrocerias);
                        this.semProdMotores.release((int) main.RRcantMotores);
                        this.semProdRuedas.release((int) main.RRcantRuedas);
                        this.semProdAccesorios.release((int) main.RRcantAccesorios);

                        this.RRcontador = 0;

                    } else {
                        estado = (((int) main.RRcantChasis > this.semEnsamChasis.availablePermits())
                                && (int) main.RRcantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                                && ((int) main.RRcantMotores > this.semEnsamMotores.availablePermits())
                                && ((int) main.RRcantRuedas > this.semEnsamRuedas.availablePermits()));

                        while ((((int) main.RRcantChasis > this.semEnsamChasis.availablePermits())
                                && (int) main.RRcantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                                && ((int) main.RRcantMotores > this.semEnsamMotores.availablePermits())
                                && ((int) main.RRcantRuedas > this.semEnsamRuedas.availablePermits()))) {

                            Thread.sleep((long) (main.Datos[0] * 1000 / 24));
                            main.RRsemSalEnsamblador.acquire();
                            main.RRsalEnsamblador += 25;
                            main.RRsemSalEnsamblador.release();

                            estado = (((int) main.RRcantChasis >= this.semEnsamChasis.availablePermits())
                                    && (int) main.RRcantCarrocerias >= this.semEnsamCarrocerias.availablePermits()
                                    && ((int) main.RRcantMotores >= this.semEnsamMotores.availablePermits())
                                    && ((int) main.RRcantRuedas >= this.semEnsamRuedas.availablePermits()));
                        }
                        //Se revisa que se tenga la cantidad necesaria de piezas para el ensamblador
                        Thread.sleep((long) this.tEnsam);
                        this.semEnsamChasis.acquire((int) main.RRcantChasis);                       
                        this.semEnsamCarrocerias.acquire((int) main.RRcantCarrocerias);
                        this.semEnsamMotores.acquire((int) main.RRcantMotores);
                        this.semEnsamRuedas.acquire((int) main.RRcantRuedas);

                        this.mutexChasis.acquire();
                        this.mutexCarrocerias.acquire();
                        this.mutexMotores.acquire();
                        this.mutexRuedas.acquire();
                        this.mutexCarros.acquire();
                        main.RRsemSalEnsamblador.acquire();

                        main.RRcarrosTotal++; // se suma el carro que salga de ensamblador 
                        System.out.println("carros totales RR: " + main.RRcarrosTotal);

                        //Se restan las piezas del almacen que fueron utilizadas en el ensamblador
                        main.aRRChasis = main.aRRChasis - (int) main.RRcantChasis;
                        main.aRRCarrocerias = main.aRRCarrocerias - (int) main.RRcantCarrocerias;
                        main.aRRMotores = main.aRRMotores - (int) main.RRcantMotores;
                        main.aRRRuedas = main.aRRRuedas - (int) main.RRcantRuedas;

                        main.RRsalEnsamblador += ((this.tEnsam / 1000 * 24) * 25);

                        main.RRsemSalEnsamblador.release();

                        this.mutexChasis.release();
                        this.mutexCarrocerias.release();
                        this.mutexMotores.release();
                        this.mutexRuedas.release();
                        this.mutexCarros.release();

                        this.semProdChasis.release((int) main.RRcantChasis);
                        this.semProdCarrocerias.release((int) main.RRcantCarrocerias);
                        this.semProdMotores.release((int) main.RRcantMotores);
                        this.semProdRuedas.release((int) main.RRcantRuedas);
                        this.RRcontador++;
                    }
                    
                } if ("M".equals(empresa)) {
                    if (Mcontador == 2) {
                        estado = (((int) main.McantChasis > this.semEnsamChasis.availablePermits())
                                && (int) main.McantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                                && ((int) main.McantMotores > this.semEnsamMotores.availablePermits())
                                && ((int) main.McantRuedas > this.semEnsamRuedas.availablePermits())
                                && ((int) main.McantAccesorios > this.semEnsamAccesorios.availablePermits()));

                        while ((((int) main.McantChasis > this.semEnsamChasis.availablePermits())
                                && (int) main.McantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                                && ((int) main.McantMotores > this.semEnsamMotores.availablePermits())
                                && ((int) main.McantRuedas > this.semEnsamRuedas.availablePermits())
                                && ((int) main.McantAccesorios > this.semEnsamAccesorios.availablePermits()))) {

                            Thread.sleep((long) (main.Datos[0] * 1000 / 24));
                            main.MsemSalEnsamblador.acquire();
                            main.MsalEnsamblador += 25;
                            main.MsemSalEnsamblador.release();

                            estado = (((int) main.McantChasis >= this.semEnsamChasis.availablePermits())
                                    && (int) main.McantCarrocerias >= this.semEnsamCarrocerias.availablePermits()
                                    && ((int) main.McantMotores >= this.semEnsamMotores.availablePermits())
                                    && ((int) main.McantRuedas >= this.semEnsamRuedas.availablePermits())
                                    && ((int) main.McantAccesorios >= this.semEnsamAccesorios.availablePermits()));
                        }
                        //Se revisa que se tenga la cantidad necesaria de piezas para el ensamblador
                        Thread.sleep((long) this.tEnsam);
                        this.semEnsamChasis.acquire((int) main.McantChasis);
                        this.semEnsamCarrocerias.acquire((int) main.McantCarrocerias);
                        this.semEnsamMotores.acquire((int) main.McantMotores);
                        this.semEnsamRuedas.acquire((int) main.McantRuedas);
                        this.semEnsamAccesorios.acquire((int) main.McantAccesorios);

                        this.mutexChasis.acquire();
                        this.mutexCarrocerias.acquire();
                        this.mutexMotores.acquire();
                        this.mutexRuedas.acquire();
                        this.mutexAccesorios.acquire();
                        this.mutexCarros.acquire();
                        main.MsemSalEnsamblador.acquire();

                        main.McarrosTotalPlus++; // se suma el carro que salga de ensamblador 
                        System.out.println("carros totales plus M: " + main.McarrosTotalPlus);

                        //Se restan las piezas del almacen que fueron utilizadas en el ensamblador
                        main.aMChasis = main.aMChasis - (int) main.McantChasis;
                        main.aMCarrocerias = main.aMCarrocerias - (int) main.McantCarrocerias;
                        main.aMMotores = main.aMMotores - (int) main.McantMotores;
                        main.aMRuedas = main.aMRuedas - (int) main.McantRuedas;
                        main.aMAccesorios = main.aMAccesorios - (int) main.McantAccesorios;

                        main.MsalEnsamblador += ((this.tEnsam / 1000 * 24) * 25);

                        main.MsemSalEnsamblador.release();

                        this.mutexChasis.release();
                        this.mutexCarrocerias.release();
                        this.mutexMotores.release();
                        this.mutexRuedas.release();
                        this.mutexAccesorios.release();
                        this.mutexCarros.release();

                        this.semProdChasis.release((int) main.McantChasis);
                        this.semProdCarrocerias.release((int) main.McantCarrocerias);
                        this.semProdMotores.release((int) main.McantMotores);
                        this.semProdRuedas.release((int) main.McantRuedas);
                        this.semProdAccesorios.release((int) main.McantAccesorios);

                        this.Mcontador = 0;

                    } else {
                        estado = (((int) main.McantChasis > this.semEnsamChasis.availablePermits())
                                && (int) main.McantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                                && ((int) main.McantMotores > this.semEnsamMotores.availablePermits())
                                && ((int) main.McantRuedas > this.semEnsamRuedas.availablePermits()));

                        while ((((int) main.McantChasis > this.semEnsamChasis.availablePermits())
                                && (int) main.McantCarrocerias > this.semEnsamCarrocerias.availablePermits()
                                && ((int) main.McantMotores > this.semEnsamMotores.availablePermits())
                                && ((int) main.McantRuedas > this.semEnsamRuedas.availablePermits()))) {

                            Thread.sleep((long) (main.Datos[0] * 1000 / 24));
                            main.MsemSalEnsamblador.acquire();
                            main.MsalEnsamblador += 25;
                            main.MsemSalEnsamblador.release();

                            estado = (((int) main.McantChasis >= this.semEnsamChasis.availablePermits())
                                    && (int) main.McantCarrocerias >= this.semEnsamCarrocerias.availablePermits()
                                    && ((int) main.McantMotores >= this.semEnsamMotores.availablePermits())
                                    && ((int) main.McantRuedas >= this.semEnsamRuedas.availablePermits()));
                        }
                        //Se revisa que se tenga la cantidad necesaria de piezas para el ensamblador
                        Thread.sleep((long) this.tEnsam);
                        this.semEnsamChasis.acquire((int) main.McantChasis);
                        this.semEnsamCarrocerias.acquire((int) main.McantCarrocerias);
                        this.semEnsamMotores.acquire((int) main.McantMotores);
                        this.semEnsamRuedas.acquire((int) main.McantRuedas);
                        
                        this.mutexCarrocerias.acquire();
                        this.mutexMotores.acquire();
                        this.mutexRuedas.acquire();
                        this.mutexCarros.acquire();
                        main.MsemSalEnsamblador.acquire();

                        main.McarrosTotal++; // se suma el carro que salga de ensamblador 
                        System.out.println("carros totales M: " + main.McarrosTotal);

                        //Se restan las piezas del almacen que fueron utilizadas en el ensamblador
                        main.aMChasis = main.aMChasis - (int) main.McantChasis;
                        main.aMCarrocerias = main.aMCarrocerias - (int) main.McantCarrocerias;
                        main.aMMotores = main.aMMotores - (int) main.McantMotores;
                        main.aMRuedas = main.aMRuedas - (int) main.McantRuedas;

                        main.MsalEnsamblador += ((this.tEnsam / 1000 * 24) * 25);

                        main.MsemSalEnsamblador.release();

                        this.mutexChasis.release();
                        this.mutexCarrocerias.release();
                        this.mutexMotores.release();
                        this.mutexRuedas.release();
                        this.mutexCarros.release();

                        this.semProdChasis.release((int) main.McantChasis);
                        this.semProdCarrocerias.release((int) main.McantCarrocerias);
                        this.semProdMotores.release((int) main.McantMotores);
                        this.semProdRuedas.release((int) main.McantRuedas);
                        this.Mcontador++;
                    }                 
                }
                
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "error", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            
        }       
    }
}
