/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Bases.Gerente;
import Bases.lectorTXT;
import java.awt.Image;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import main.main;

/**
 *
 * @author Vito
 */
public class Menu extends javax.swing.JFrame {

    Semaphore RRmutexChasis;
    Semaphore MmutexChasis;
    Semaphore RRmutexCarrocerias;
    Semaphore MmutexCarrocerias;
    Semaphore RRmutexMotores;
    Semaphore MmutexMotores;
    Semaphore RRmutexRuedas;
    Semaphore MmutexRuedas;
    Semaphore RRmutexAccesorios;
    Semaphore MmutexAccesorios;
    Semaphore RRmutexCarros;
    Semaphore MmutexCarros;
    
    Semaphore RRmutexDiasEntrega;
    Semaphore MmutexDiasEntrega;
    
    boolean tRRGerente;
    boolean tMGerente;
    boolean tRRDirector;
    boolean tMDirector;
    Semaphore RRmutexGerenteT;
    Semaphore MmutexGerenteT;
    Semaphore RRmutexDirectorT;
    Semaphore MmutexDirectorT;
    
    Semaphore RRmutexEntregas;
    Semaphore MmutexEntregas;
    
    int RRcantProdChasis;
    int McantProdChasis;
    int RRcantProdCarroceria;
    int McantProdCarroceria;
    int RRcantProdMotores;
    int McantProdMotores;
    int RRcantProdRuedas;
    int McantProdRuedas;
    int RRcantProdAccesorios;
    int McantProdAccesorios;
    int RRcantProdEnsamblador;
    int McantProdEnsamblador;
    float gananciasRRTotal;
    float gananciasMTotal;
        
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.RRmutexChasis = main.RRmutexChasis;
        this.MmutexChasis = main.MmutexChasis;
        this.RRmutexCarrocerias = main.RRmutexCarrocerias;
        this.MmutexCarrocerias = main.MmutexCarrocerias;
        this.RRmutexMotores = main.RRmutexMotores;
        this.MmutexMotores = main.MmutexMotores;
        this.RRmutexRuedas = main.RRmutexRuedas;
        this.MmutexRuedas = main.MmutexRuedas;
        this.RRmutexAccesorios = main.RRmutexAccesorios;
        this.MmutexAccesorios = main.MmutexAccesorios;
        this.RRmutexCarros = main.RRmutexCarros;
        this.MmutexCarros = main.MmutexCarros;
        
        this.RRmutexDiasEntrega = main.RRmutexDiasEntrega;
        this.MmutexDiasEntrega = main.MmutexDiasEntrega;
        
        this.tRRGerente = main.tRRGerente;
        this.tMGerente = main.tMGerente;
        this.tRRDirector = main.tRRDirector;
        this.tMDirector = main.tMDirector;
        
        this.RRmutexGerenteT = main.RRmutexGerenteT;
        this.MmutexGerenteT = main.MmutexGerenteT;
        this.RRmutexDirectorT = main.RRmutexDirectorT;
        this.MmutexDirectorT = main.MmutexDirectorT;
        
        this.RRmutexEntregas = main.RRmutexEntregas;
        this.MmutexEntregas = main.MmutexEntregas;
        
        Runnable r = new Runnable() {
            @Override
            public void run() {
                float tfinal = (float)main.Datos[0]/70*1000;
                while (true) {                
                    try {
                        RRmutexChasis.acquire();
                            chasisRR.setText(Integer.toString(main.aRRChasis));
                        RRmutexChasis.release();
                        
                        RRmutexCarrocerias.acquire();
                            carroceriasRR.setText(Integer.toString(main.aRRCarrocerias));
                        RRmutexCarrocerias.release();
                        
                        RRmutexMotores.acquire();
                            motoresRR.setText(Integer.toString(main.aRRMotores));
                        RRmutexMotores.release();
                        
                        RRmutexRuedas.acquire();
                            ruedasRR.setText(Integer.toString(main.aRRRuedas));
                        RRmutexRuedas.release();
                        
                        RRmutexAccesorios.acquire();
                            accesoriosRR.setText(Integer.toString(main.aRRAccesorios));
                        RRmutexAccesorios.release();
                        
                        prodChasisRR.setText(Integer.toString(main.Datos[7]));
                        prodCarroceriasRR.setText(Integer.toString(main.Datos[8]));
                        prodMotoresRR.setText(Integer.toString(main.Datos[9]));
                        prodRuedasRR.setText(Integer.toString(main.Datos[10]));
                        prodAccesoriosRR.setText(Integer.toString(main.Datos[11]));
                        
                        RRmutexCarros.acquire();
                            carrosRR.setText(Integer.toString(main.RRcarrosTotal));
                            carrosAccRR.setText(Integer.toString(main.RRcarrosTotalPlus));
                            entregadosRR.setText(Integer.toString(main.RRcarros));
                        RRmutexCarros.release();
                        
                        RRmutexDiasEntrega.acquire();
                            entregaRR.setText(Integer.toString(Gerente.diaEntrega));
                        RRmutexDiasEntrega.release();
                        
                        RRmutexGerenteT.acquire();
                            if (main.tRRGerente){                          
                                gerenteRR.setText("Trabajando");
                            }else{
                                gerenteRR.setText("Viendo F1");
                            }
                        RRmutexGerenteT.release();
                        
                        RRmutexDirectorT.acquire();
                        if (main.tRRDirector){
                            directorRR.setText("Trabajando");
                        }else{
                            directorRR.setText("Vigilando");
                        }
                        RRmutexDirectorT.release();
                        
                        gananciasRRTotal = (float) ((main.RRcarros * main.RRprecio)+(main.RRcarrosPlus * main.RRprecioPlus));
                        
                        main.RRsemSalChasis.acquire();
                        main.RRsemSalCarroceria.acquire();
                        main.RRsemSalMotores.acquire();
                        main.RRsemSalRuedas.acquire();
                        main.RRsemSalAccesorios.acquire();
                        main.RRsemSalEnsamblador.acquire();
                        main.RRsemSalGerente.acquire();
                        main.RRsemSalDirector.acquire();
                        gananciasRRTotal -= (main.RRsalChasis + 
                                main.RRsalCarroceria + 
                                main.RRsalMotores + 
                                main.RRsalRuedas + 
                                main.RRsalAccesorios + 
                                main.RRsalEnsamblador + 
                                main.RRsalGerente+ 
                                main.RRsalDirector);
                        gananciasRR.setText(Float.toString(gananciasRRTotal));
                        main.RRsemSalChasis.release();
                        main.RRsemSalCarroceria.release();
                        main.RRsemSalMotores.release();
                        main.RRsemSalRuedas.release();
                        main.RRsemSalAccesorios.release();
                        main.RRsemSalEnsamblador.release();
                        main.RRsemSalGerente.release();
                        main.RRsemSalDirector.release();
                        
                        
                        
                        
                        Thread.sleep((long)tfinal);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Error mostrando datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    }
                }               
            }
        };
        Thread start = new Thread(r);
        start.start();
        
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Inicio = new javax.swing.JPanel();
        iniciar = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        dataMaserati = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        inicialProdAccesoriosMase = new javax.swing.JTextField();
        inicialProdChasisMase = new javax.swing.JTextField();
        inicialProdMotoresMase = new javax.swing.JTextField();
        inicialProdCarroceriasMase = new javax.swing.JTextField();
        inicialProdRuedasMase = new javax.swing.JTextField();
        actProdChasisMase = new javax.swing.JButton();
        actProdCarroceriasMase = new javax.swing.JButton();
        actProdMotoresMase = new javax.swing.JButton();
        actProdRuedasMase = new javax.swing.JButton();
        actProdAccesoriosMase = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        actEnsamMase = new javax.swing.JButton();
        inicialEnsamMase = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        actTiempoMase = new javax.swing.JButton();
        inicialTiempoMase = new javax.swing.JTextField();
        inicialDeadlineMase = new javax.swing.JTextField();
        actDeadlineMase = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        actMaxChasisMase = new javax.swing.JButton();
        inicialMaxChasisMase = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        actMaxCarroceriasMase = new javax.swing.JButton();
        inicialMaxCarroceriasMase = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        actMaxMotoresMase = new javax.swing.JButton();
        inicialMaxMotoresMase = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        actMaxRuedasMase = new javax.swing.JButton();
        inicialMaxRuedasMase = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        inicialMaxAccesoriosMase = new javax.swing.JTextField();
        actMaxAccesoriosMase = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        BG_dMase = new javax.swing.JLabel();
        Maserati = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chasisMase = new javax.swing.JLabel();
        carroceriasMase = new javax.swing.JLabel();
        motoresMase = new javax.swing.JLabel();
        ruedasMase = new javax.swing.JLabel();
        accesoriosMase = new javax.swing.JLabel();
        upProdChasisMase = new javax.swing.JButton();
        downProdChasisMase = new javax.swing.JButton();
        prodChasisMase = new javax.swing.JLabel();
        upProdCarroceriasMase = new javax.swing.JButton();
        downProdCarroceriasMase = new javax.swing.JButton();
        prodCarroceriasMase = new javax.swing.JLabel();
        upProdMotoresMase = new javax.swing.JButton();
        downProdMotoresMase = new javax.swing.JButton();
        prodMotoresMase = new javax.swing.JLabel();
        upProdRuedasMase = new javax.swing.JButton();
        downProdRuedasMase = new javax.swing.JButton();
        prodRuedasMase = new javax.swing.JLabel();
        downProdAccesoriosMase = new javax.swing.JButton();
        upProdAccesoriosMase = new javax.swing.JButton();
        prodAccesoriosMase = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        upEnsamMase = new javax.swing.JButton();
        downEnsamMase = new javax.swing.JButton();
        ensamMase = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        carrosMase = new javax.swing.JLabel();
        gerenteMase = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        directorMase = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        entregaMase = new javax.swing.JLabel();
        entregadosMase = new javax.swing.JLabel();
        ganaciasMase = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        carrosAccMase = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        zBG_Mase = new javax.swing.JLabel();
        dataRolllsRoyce = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        actProdChasisRR = new javax.swing.JButton();
        inicialProdChasisRR = new javax.swing.JTextField();
        inicialProdCarroceriasRR = new javax.swing.JTextField();
        actProdCarroceriasRR = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        inicialEnsamRR = new javax.swing.JTextField();
        actEnsamRR = new javax.swing.JButton();
        actTiempoRR = new javax.swing.JButton();
        inicialTiempoRR = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        actProdMotoresRR = new javax.swing.JButton();
        inicialProdMotoresRR = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        inicialProdRuedasRR = new javax.swing.JTextField();
        actProdRuedasRR = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        inicialProdAccesoriosRR = new javax.swing.JTextField();
        actProdAccesoriosRR = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        inicialDeadlineRR = new javax.swing.JTextField();
        actDeadlineRR = new javax.swing.JButton();
        inicialMaxAccesoriosRR = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        actMaxChasisRR = new javax.swing.JButton();
        inicialMaxChasisRR = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        actMaxCarroceriaRR = new javax.swing.JButton();
        inicialMaxCarroceriasRR = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        actMaxMotoresRR = new javax.swing.JButton();
        inicialMaxMotoresRR = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        actMaxRuedasRR = new javax.swing.JButton();
        inicialMaxRuedasRR = new javax.swing.JTextField();
        actMaxAccesoriosRR = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        BG_dRR = new javax.swing.JLabel();
        RollsRoyce = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        chasisRR = new javax.swing.JLabel();
        carroceriasRR = new javax.swing.JLabel();
        motoresRR = new javax.swing.JLabel();
        ruedasRR = new javax.swing.JLabel();
        accesoriosRR = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        upProdChasisRR = new javax.swing.JButton();
        downProdChasisRR = new javax.swing.JButton();
        prodChasisRR = new javax.swing.JLabel();
        upProdCarroceriasRR = new javax.swing.JButton();
        downProdCarroceriasRR = new javax.swing.JButton();
        prodCarroceriasRR = new javax.swing.JLabel();
        upProdMotoresRR = new javax.swing.JButton();
        downProdMotoresRR = new javax.swing.JButton();
        prodMotoresRR = new javax.swing.JLabel();
        upProdRuedasRR = new javax.swing.JButton();
        downProdRuedasRR = new javax.swing.JButton();
        prodRuedasRR = new javax.swing.JLabel();
        upProdAccesoriosRR = new javax.swing.JButton();
        downProdAccesoriosRR = new javax.swing.JButton();
        prodAccesoriosRR = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        upEnsamRR = new javax.swing.JButton();
        downEnsamRR = new javax.swing.JButton();
        ensamRR = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        carrosRR = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        gerenteRR = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        entregaRR = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        entregadosRR = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        directorRR = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        gananciasRR = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        carrosAccRR = new javax.swing.JLabel();
        BG_RR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 720));

        Inicio.setMaximumSize(new java.awt.Dimension(1280, 720));
        Inicio.setMinimumSize(new java.awt.Dimension(1280, 720));
        Inicio.setPreferredSize(new java.awt.Dimension(1280, 720));
        Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        iniciar.setText("Iniciar simulacion");
        Inicio.add(iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 620, -1, -1));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BG RR.png"))); // NOI18N
        Inicio.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 690));

        jTabbedPane1.addTab("Inicio", Inicio);

        dataMaserati.setMaximumSize(new java.awt.Dimension(1280, 720));
        dataMaserati.setMinimumSize(new java.awt.Dimension(1280, 720));
        dataMaserati.setPreferredSize(new java.awt.Dimension(1280, 720));
        dataMaserati.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Datos iniciales Maserati");
        dataMaserati.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Chasis");
        dataMaserati.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 80, 50));

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Carrocerias");
        dataMaserati.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 120, 50));

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Motores");
        dataMaserati.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 90, 50));

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Ruedas");
        dataMaserati.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 80, 50));

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Accesorios");
        dataMaserati.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 130, 110, 50));

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Piezas maximas en almacen");
        dataMaserati.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        inicialProdAccesoriosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdAccesoriosMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdAccesoriosMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialProdAccesoriosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 190, 110, -1));

        inicialProdChasisMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdChasisMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdChasisMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialProdChasisMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 110, -1));

        inicialProdMotoresMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdMotoresMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdMotoresMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialProdMotoresMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 110, -1));

        inicialProdCarroceriasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdCarroceriasMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdCarroceriasMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialProdCarroceriasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 110, -1));

        inicialProdRuedasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdRuedasMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdRuedasMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialProdRuedasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 110, -1));

        actProdChasisMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdChasisMase.setText("↑");
        actProdChasisMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdChasisMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actProdChasisMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        actProdCarroceriasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdCarroceriasMase.setText("↑");
        actProdCarroceriasMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdCarroceriasMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actProdCarroceriasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        actProdMotoresMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdMotoresMase.setText("↑");
        actProdMotoresMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdMotoresMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actProdMotoresMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, -1, -1));

        actProdRuedasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdRuedasMase.setText("↑");
        actProdRuedasMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdRuedasMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actProdRuedasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, -1, -1));

        actProdAccesoriosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdAccesoriosMase.setText("↑");
        actProdAccesoriosMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdAccesoriosMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actProdAccesoriosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 190, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Ensambladores iniciales ");
        dataMaserati.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        actEnsamMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actEnsamMase.setText("↑");
        actEnsamMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actEnsamMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actEnsamMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        inicialEnsamMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialEnsamMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialEnsamMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialEnsamMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 110, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Deadline");
        dataMaserati.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, -1, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Tiempo dias en segundos");
        dataMaserati.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        actTiempoMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actTiempoMase.setText("↑");
        actTiempoMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actTiempoMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actTiempoMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, -1));

        inicialTiempoMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialTiempoMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialTiempoMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialTiempoMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 110, -1));

        inicialDeadlineMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialDeadlineMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialDeadlineMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialDeadlineMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 360, 110, -1));

        actDeadlineMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actDeadlineMase.setText("↑");
        actDeadlineMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actDeadlineMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actDeadlineMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, -1, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Productores iniciales por sector");
        dataMaserati.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        actMaxChasisMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxChasisMase.setText("↑");
        actMaxChasisMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxChasisMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actMaxChasisMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        inicialMaxChasisMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxChasisMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxChasisMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialMaxChasisMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 110, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Chasis");
        dataMaserati.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 80, 50));

        actMaxCarroceriasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxCarroceriasMase.setText("↑");
        actMaxCarroceriasMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxCarroceriasMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actMaxCarroceriasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, -1));

        inicialMaxCarroceriasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxCarroceriasMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxCarroceriasMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialMaxCarroceriasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 110, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Carrocerias");
        dataMaserati.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 120, 50));

        actMaxMotoresMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxMotoresMase.setText("↑");
        actMaxMotoresMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxMotoresMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actMaxMotoresMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 560, -1, -1));

        inicialMaxMotoresMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxMotoresMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxMotoresMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialMaxMotoresMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 110, -1));

        jLabel53.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Motores");
        dataMaserati.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 90, 50));

        actMaxRuedasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxRuedasMase.setText("↑");
        actMaxRuedasMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxRuedasMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actMaxRuedasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, -1, -1));

        inicialMaxRuedasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxRuedasMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxRuedasMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialMaxRuedasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 110, -1));

        jLabel54.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Ruedas");
        dataMaserati.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 80, 50));

        inicialMaxAccesoriosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxAccesoriosMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxAccesoriosMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(inicialMaxAccesoriosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, 110, -1));

        actMaxAccesoriosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxAccesoriosMase.setText("↑");
        actMaxAccesoriosMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxAccesoriosMaseActionPerformed(evt);
            }
        });
        dataMaserati.add(actMaxAccesoriosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 560, -1, -1));

        jLabel55.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Accesorios");
        dataMaserati.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 500, 110, 50));

        BG_dMase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BG mase.png"))); // NOI18N
        dataMaserati.add(BG_dMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 690));

        jTabbedPane1.addTab("Data M", dataMaserati);

        Maserati.setMaximumSize(new java.awt.Dimension(1280, 720));
        Maserati.setPreferredSize(new java.awt.Dimension(1280, 720));
        Maserati.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chasis");
        Maserati.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 80, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Carrocerias");
        Maserati.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 120, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Motores");
        Maserati.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 90, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ruedas");
        Maserati.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 80, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Productores");
        Maserati.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 130, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Accesorios");
        Maserati.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 110, 50));

        chasisMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        chasisMase.setForeground(new java.awt.Color(255, 255, 255));
        chasisMase.setText("0");
        Maserati.add(chasisMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 40, 50));

        carroceriasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        carroceriasMase.setForeground(new java.awt.Color(255, 255, 255));
        carroceriasMase.setText("0");
        Maserati.add(carroceriasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 40, 50));

        motoresMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        motoresMase.setForeground(new java.awt.Color(255, 255, 255));
        motoresMase.setText("0");
        Maserati.add(motoresMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 40, 50));

        ruedasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        ruedasMase.setForeground(new java.awt.Color(255, 255, 255));
        ruedasMase.setText("0");
        Maserati.add(ruedasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 80, 40, 50));

        accesoriosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        accesoriosMase.setForeground(new java.awt.Color(255, 255, 255));
        accesoriosMase.setText("0");
        Maserati.add(accesoriosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, 40, 50));

        upProdChasisMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdChasisMase.setText("↑");
        Maserati.add(upProdChasisMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        downProdChasisMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdChasisMase.setText("↓");
        Maserati.add(downProdChasisMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        prodChasisMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodChasisMase.setForeground(new java.awt.Color(255, 255, 255));
        prodChasisMase.setText("1");
        Maserati.add(prodChasisMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 40, 50));

        upProdCarroceriasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdCarroceriasMase.setText("↑");
        Maserati.add(upProdCarroceriasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        downProdCarroceriasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdCarroceriasMase.setText("↓");
        Maserati.add(downProdCarroceriasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        prodCarroceriasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodCarroceriasMase.setForeground(new java.awt.Color(255, 255, 255));
        prodCarroceriasMase.setText("1");
        Maserati.add(prodCarroceriasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 40, 50));

        upProdMotoresMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdMotoresMase.setText("↑");
        Maserati.add(upProdMotoresMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, -1));

        downProdMotoresMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdMotoresMase.setText("↓");
        downProdMotoresMase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downProdMotoresMaseActionPerformed(evt);
            }
        });
        Maserati.add(downProdMotoresMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, -1));

        prodMotoresMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodMotoresMase.setForeground(new java.awt.Color(255, 255, 255));
        prodMotoresMase.setText("1");
        Maserati.add(prodMotoresMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 40, 50));

        upProdRuedasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdRuedasMase.setText("↑");
        Maserati.add(upProdRuedasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, -1, -1));

        downProdRuedasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdRuedasMase.setText("↓");
        Maserati.add(downProdRuedasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, -1, -1));

        prodRuedasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodRuedasMase.setForeground(new java.awt.Color(255, 255, 255));
        prodRuedasMase.setText("1");
        Maserati.add(prodRuedasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 180, 40, 50));

        downProdAccesoriosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdAccesoriosMase.setText("↓");
        Maserati.add(downProdAccesoriosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 210, -1, -1));

        upProdAccesoriosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdAccesoriosMase.setText("↑");
        Maserati.add(upProdAccesoriosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 170, -1, -1));

        prodAccesoriosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodAccesoriosMase.setForeground(new java.awt.Color(255, 255, 255));
        prodAccesoriosMase.setText("1");
        Maserati.add(prodAccesoriosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 180, 40, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ensamblador");
        Maserati.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 130, 50));

        upEnsamMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upEnsamMase.setText("↑");
        Maserati.add(upEnsamMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        downEnsamMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downEnsamMase.setText("↓");
        Maserati.add(downEnsamMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));

        ensamMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        ensamMase.setForeground(new java.awt.Color(255, 255, 255));
        ensamMase.setText("1");
        Maserati.add(ensamMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 40, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Almacen de vehiculos");
        Maserati.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 220, 50));

        carrosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        carrosMase.setForeground(new java.awt.Color(255, 255, 255));
        carrosMase.setText("-");
        Maserati.add(carrosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 40, 50));

        gerenteMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        gerenteMase.setForeground(new java.awt.Color(255, 255, 255));
        gerenteMase.setText("placeholder");
        Maserati.add(gerenteMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 170, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gerente");
        Maserati.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 80, 50));

        directorMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        directorMase.setForeground(new java.awt.Color(255, 255, 255));
        directorMase.setText("placeholder");
        Maserati.add(directorMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 180, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Director");
        Maserati.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 90, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Vehiculos entregados");
        Maserati.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 220, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ganancias/Perdidas");
        Maserati.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 550, 200, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dia para la entrega ");
        Maserati.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 200, 50));

        entregaMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        entregaMase.setForeground(new java.awt.Color(255, 255, 255));
        entregaMase.setText("-");
        Maserati.add(entregaMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 50, 50));

        entregadosMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        entregadosMase.setForeground(new java.awt.Color(255, 255, 255));
        entregadosMase.setText("-");
        Maserati.add(entregadosMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 420, 50, 50));

        ganaciasMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        ganaciasMase.setForeground(new java.awt.Color(255, 255, 255));
        ganaciasMase.setText("-");
        Maserati.add(ganaciasMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 280, 50));

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Almacen de vehiculos +");
        Maserati.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, 240, 50));

        carrosAccMase.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        carrosAccMase.setForeground(new java.awt.Color(255, 255, 255));
        carrosAccMase.setText("-");
        Maserati.add(carrosAccMase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 300, 40, 50));
        Maserati.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 130));

        zBG_Mase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BG mase.png"))); // NOI18N
        Maserati.add(zBG_Mase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        jTabbedPane1.addTab("Maserati", Maserati);

        dataRolllsRoyce.setMaximumSize(new java.awt.Dimension(1280, 720));
        dataRolllsRoyce.setMinimumSize(new java.awt.Dimension(1280, 720));
        dataRolllsRoyce.setPreferredSize(new java.awt.Dimension(1280, 720));
        dataRolllsRoyce.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Datos iniciales Rolls Royce");
        dataRolllsRoyce.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Productores iniciales por sector");
        dataRolllsRoyce.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Chasis");
        dataRolllsRoyce.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 80, 50));

        actProdChasisRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdChasisRR.setText("↑");
        actProdChasisRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdChasisRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actProdChasisRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        inicialProdChasisRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdChasisRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdChasisRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialProdChasisRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 110, -1));

        inicialProdCarroceriasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdCarroceriasRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdCarroceriasRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialProdCarroceriasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 110, -1));

        actProdCarroceriasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdCarroceriasRR.setText("↑");
        actProdCarroceriasRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdCarroceriasRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actProdCarroceriasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Carrocerias");
        dataRolllsRoyce.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 120, 50));

        jLabel43.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Ensambladores iniciales ");
        dataRolllsRoyce.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        inicialEnsamRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialEnsamRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialEnsamRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialEnsamRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 110, -1));

        actEnsamRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actEnsamRR.setText("↑");
        actEnsamRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actEnsamRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actEnsamRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        actTiempoRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actTiempoRR.setText("↑");
        actTiempoRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actTiempoRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actTiempoRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, -1));

        inicialTiempoRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialTiempoRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialTiempoRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialTiempoRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 110, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Tiempo dias en segundos");
        dataRolllsRoyce.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        actProdMotoresRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdMotoresRR.setText("↑");
        actProdMotoresRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdMotoresRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actProdMotoresRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, -1, -1));

        inicialProdMotoresRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdMotoresRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdMotoresRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialProdMotoresRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 110, -1));

        jLabel45.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Motores");
        dataRolllsRoyce.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 90, 50));

        inicialProdRuedasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdRuedasRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdRuedasRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialProdRuedasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 110, -1));

        actProdRuedasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdRuedasRR.setText("↑");
        actProdRuedasRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdRuedasRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actProdRuedasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Ruedas");
        dataRolllsRoyce.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 80, 50));

        inicialProdAccesoriosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialProdAccesoriosRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialProdAccesoriosRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialProdAccesoriosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 190, 110, -1));

        actProdAccesoriosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actProdAccesoriosRR.setText("↑");
        actProdAccesoriosRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actProdAccesoriosRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actProdAccesoriosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 190, -1, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Accesorios");
        dataRolllsRoyce.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 130, 110, 50));

        jLabel48.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Deadline");
        dataRolllsRoyce.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, -1, -1));

        inicialDeadlineRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialDeadlineRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialDeadlineRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialDeadlineRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 360, 110, -1));

        actDeadlineRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actDeadlineRR.setText("↑");
        actDeadlineRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actDeadlineRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actDeadlineRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, -1, -1));

        inicialMaxAccesoriosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxAccesoriosRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxAccesoriosRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialMaxAccesoriosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, 110, -1));

        jLabel56.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Piezas maximas en almacen");
        dataRolllsRoyce.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        jLabel57.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Chasis");
        dataRolllsRoyce.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 80, 50));

        actMaxChasisRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxChasisRR.setText("↑");
        actMaxChasisRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxChasisRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actMaxChasisRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        inicialMaxChasisRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxChasisRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxChasisRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialMaxChasisRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 110, -1));

        jLabel58.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Carrocerias");
        dataRolllsRoyce.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 120, 50));

        actMaxCarroceriaRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxCarroceriaRR.setText("↑");
        actMaxCarroceriaRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxCarroceriaRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actMaxCarroceriaRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, -1));

        inicialMaxCarroceriasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxCarroceriasRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxCarroceriasRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialMaxCarroceriasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 110, -1));

        jLabel59.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Motores");
        dataRolllsRoyce.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 90, 50));

        actMaxMotoresRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxMotoresRR.setText("↑");
        actMaxMotoresRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxMotoresRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actMaxMotoresRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 560, -1, -1));

        inicialMaxMotoresRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxMotoresRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxMotoresRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialMaxMotoresRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 110, -1));

        jLabel60.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Ruedas");
        dataRolllsRoyce.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 80, 50));

        actMaxRuedasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxRuedasRR.setText("↑");
        actMaxRuedasRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxRuedasRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actMaxRuedasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, -1, -1));

        inicialMaxRuedasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        inicialMaxRuedasRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialMaxRuedasRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(inicialMaxRuedasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 110, -1));

        actMaxAccesoriosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        actMaxAccesoriosRR.setText("↑");
        actMaxAccesoriosRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMaxAccesoriosRRActionPerformed(evt);
            }
        });
        dataRolllsRoyce.add(actMaxAccesoriosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 560, -1, -1));

        jLabel61.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Accesorios");
        dataRolllsRoyce.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 500, 110, 50));

        BG_dRR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BG RR.png"))); // NOI18N
        dataRolllsRoyce.add(BG_dRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1280, 720));

        jTabbedPane1.addTab("Data RR", dataRolllsRoyce);

        RollsRoyce.setMaximumSize(new java.awt.Dimension(1280, 720));
        RollsRoyce.setMinimumSize(new java.awt.Dimension(1280, 720));
        RollsRoyce.setPreferredSize(new java.awt.Dimension(1280, 720));
        RollsRoyce.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Chasis");
        RollsRoyce.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 80, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Carrocerias");
        RollsRoyce.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 120, 50));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Motores");
        RollsRoyce.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 90, 50));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ruedas");
        RollsRoyce.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 80, 50));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Accesorios");
        RollsRoyce.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 110, 50));

        chasisRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        chasisRR.setForeground(new java.awt.Color(255, 255, 255));
        chasisRR.setText("0");
        RollsRoyce.add(chasisRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 40, 50));

        carroceriasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        carroceriasRR.setForeground(new java.awt.Color(255, 255, 255));
        carroceriasRR.setText("0");
        RollsRoyce.add(carroceriasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 40, 50));

        motoresRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        motoresRR.setForeground(new java.awt.Color(255, 255, 255));
        motoresRR.setText("0");
        RollsRoyce.add(motoresRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 40, 50));

        ruedasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        ruedasRR.setForeground(new java.awt.Color(255, 255, 255));
        ruedasRR.setText("0");
        RollsRoyce.add(ruedasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 80, 40, 50));

        accesoriosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        accesoriosRR.setForeground(new java.awt.Color(255, 255, 255));
        accesoriosRR.setText("0");
        RollsRoyce.add(accesoriosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, 40, 50));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Productores");
        RollsRoyce.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 130, 50));

        upProdChasisRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdChasisRR.setText("↑");
        RollsRoyce.add(upProdChasisRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        downProdChasisRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdChasisRR.setText("↓");
        RollsRoyce.add(downProdChasisRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        prodChasisRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodChasisRR.setForeground(new java.awt.Color(255, 255, 255));
        prodChasisRR.setText("1");
        RollsRoyce.add(prodChasisRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 40, 50));

        upProdCarroceriasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdCarroceriasRR.setText("↑");
        RollsRoyce.add(upProdCarroceriasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        downProdCarroceriasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdCarroceriasRR.setText("↓");
        RollsRoyce.add(downProdCarroceriasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        prodCarroceriasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodCarroceriasRR.setForeground(new java.awt.Color(255, 255, 255));
        prodCarroceriasRR.setText("1");
        RollsRoyce.add(prodCarroceriasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 40, 50));

        upProdMotoresRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdMotoresRR.setText("↑");
        RollsRoyce.add(upProdMotoresRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, -1));

        downProdMotoresRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdMotoresRR.setText("↓");
        downProdMotoresRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downProdMotoresRRActionPerformed(evt);
            }
        });
        RollsRoyce.add(downProdMotoresRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, -1));

        prodMotoresRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodMotoresRR.setForeground(new java.awt.Color(255, 255, 255));
        prodMotoresRR.setText("1");
        RollsRoyce.add(prodMotoresRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 40, 50));

        upProdRuedasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdRuedasRR.setText("↑");
        RollsRoyce.add(upProdRuedasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, -1, -1));

        downProdRuedasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdRuedasRR.setText("↓");
        RollsRoyce.add(downProdRuedasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, -1, -1));

        prodRuedasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodRuedasRR.setForeground(new java.awt.Color(255, 255, 255));
        prodRuedasRR.setText("1");
        RollsRoyce.add(prodRuedasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 180, 40, 50));

        upProdAccesoriosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upProdAccesoriosRR.setText("↑");
        RollsRoyce.add(upProdAccesoriosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 170, -1, -1));

        downProdAccesoriosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downProdAccesoriosRR.setText("↓");
        RollsRoyce.add(downProdAccesoriosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 210, -1, -1));

        prodAccesoriosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        prodAccesoriosRR.setForeground(new java.awt.Color(255, 255, 255));
        prodAccesoriosRR.setText("1");
        RollsRoyce.add(prodAccesoriosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 180, 40, 50));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Ensamblador");
        RollsRoyce.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 130, 50));

        upEnsamRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        upEnsamRR.setText("↑");
        RollsRoyce.add(upEnsamRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        downEnsamRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        downEnsamRR.setText("↓");
        RollsRoyce.add(downEnsamRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));

        ensamRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        ensamRR.setForeground(new java.awt.Color(255, 255, 255));
        ensamRR.setText("1");
        RollsRoyce.add(ensamRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 40, 50));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Almacen de vehiculos");
        RollsRoyce.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 220, 50));

        carrosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        carrosRR.setForeground(new java.awt.Color(255, 255, 255));
        carrosRR.setText("-");
        RollsRoyce.add(carrosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 40, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Gerente");
        RollsRoyce.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 80, 50));

        gerenteRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        gerenteRR.setForeground(new java.awt.Color(255, 255, 255));
        gerenteRR.setText("placeholder");
        RollsRoyce.add(gerenteRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 170, 50));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Dia para la entrega ");
        RollsRoyce.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 200, 50));

        entregaRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        entregaRR.setForeground(new java.awt.Color(255, 255, 255));
        entregaRR.setText("-");
        RollsRoyce.add(entregaRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 50, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Vehiculos entregados");
        RollsRoyce.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 220, 50));

        entregadosRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        entregadosRR.setForeground(new java.awt.Color(255, 255, 255));
        entregadosRR.setText("-");
        RollsRoyce.add(entregadosRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 420, 50, 50));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Director");
        RollsRoyce.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 90, 50));

        directorRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        directorRR.setForeground(new java.awt.Color(255, 255, 255));
        directorRR.setText("placeholder");
        RollsRoyce.add(directorRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 180, 50));

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Ganancias/Perdidas");
        RollsRoyce.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 550, 200, 50));

        gananciasRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        gananciasRR.setForeground(new java.awt.Color(255, 255, 255));
        gananciasRR.setText("-");
        RollsRoyce.add(gananciasRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 280, 50));

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Almacen de vehiculos +");
        RollsRoyce.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, 240, 50));

        carrosAccRR.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        carrosAccRR.setForeground(new java.awt.Color(255, 255, 255));
        carrosAccRR.setText("-");
        RollsRoyce.add(carrosAccRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 300, 40, 50));

        BG_RR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BG RR.png"))); // NOI18N
        RollsRoyce.add(BG_RR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        jTabbedPane1.addTab("Rolls Royce", RollsRoyce);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downProdMotoresMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downProdMotoresMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_downProdMotoresMaseActionPerformed

    private void downProdMotoresRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downProdMotoresRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_downProdMotoresRRActionPerformed

    private void inicialProdAccesoriosMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdAccesoriosMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdAccesoriosMaseActionPerformed

    private void inicialProdChasisMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdChasisMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdChasisMaseActionPerformed

    private void inicialProdMotoresMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdMotoresMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdMotoresMaseActionPerformed

    private void inicialProdCarroceriasMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdCarroceriasMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdCarroceriasMaseActionPerformed

    private void inicialProdRuedasMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdRuedasMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdRuedasMaseActionPerformed

    private void inicialEnsamMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialEnsamMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialEnsamMaseActionPerformed

    private void inicialTiempoMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialTiempoMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialTiempoMaseActionPerformed

    private void inicialDeadlineMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialDeadlineMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialDeadlineMaseActionPerformed

    private void inicialProdChasisRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdChasisRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdChasisRRActionPerformed

    private void inicialProdCarroceriasRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdCarroceriasRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdCarroceriasRRActionPerformed

    private void inicialEnsamRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialEnsamRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialEnsamRRActionPerformed

    private void inicialTiempoRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialTiempoRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialTiempoRRActionPerformed

    private void inicialProdMotoresRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdMotoresRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdMotoresRRActionPerformed

    private void inicialProdRuedasRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdRuedasRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdRuedasRRActionPerformed

    private void inicialProdAccesoriosRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialProdAccesoriosRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialProdAccesoriosRRActionPerformed

    private void inicialDeadlineRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialDeadlineRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialDeadlineRRActionPerformed

    private void inicialMaxChasisMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxChasisMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxChasisMaseActionPerformed

    private void inicialMaxCarroceriasMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxCarroceriasMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxCarroceriasMaseActionPerformed

    private void inicialMaxMotoresMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxMotoresMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxMotoresMaseActionPerformed

    private void inicialMaxRuedasMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxRuedasMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxRuedasMaseActionPerformed

    private void inicialMaxAccesoriosMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxAccesoriosMaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxAccesoriosMaseActionPerformed

    private void inicialMaxAccesoriosRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxAccesoriosRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxAccesoriosRRActionPerformed

    private void inicialMaxChasisRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxChasisRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxChasisRRActionPerformed

    private void inicialMaxCarroceriasRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxCarroceriasRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxCarroceriasRRActionPerformed

    private void inicialMaxMotoresRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxMotoresRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxMotoresRRActionPerformed

    private void inicialMaxRuedasRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialMaxRuedasRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicialMaxRuedasRRActionPerformed

    private void actProdChasisMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdChasisMaseActionPerformed
        
        if(inicialProdChasisMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdChasisMaseInput = inicialProdChasisMase.getText();
            int inicialProdChasisMaseInt;
            inicialProdChasisMaseInt = Integer.parseInt(inicialProdChasisMaseInput);
            main.Datos[20] = inicialProdChasisMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdChasisMaseActionPerformed

    private void actProdCarroceriasMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdCarroceriasMaseActionPerformed
        
        if(inicialProdCarroceriasMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdCarroceriasMaseInput = inicialProdCarroceriasMase.getText();
            int inicialProdCarroceriasMaseInt;
            inicialProdCarroceriasMaseInt = Integer.parseInt(inicialProdCarroceriasMaseInput);
            main.Datos[21] = inicialProdCarroceriasMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdCarroceriasMaseActionPerformed

    private void actProdMotoresMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdMotoresMaseActionPerformed
        
        if(inicialProdMotoresMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdMotoresMaseInput = inicialProdMotoresMase.getText();
            int inicialProdMotoresMaseInt;
            inicialProdMotoresMaseInt = Integer.parseInt(inicialProdMotoresMaseInput);
            main.Datos[22] = inicialProdMotoresMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdMotoresMaseActionPerformed

    private void actProdRuedasMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdRuedasMaseActionPerformed
        
        if(inicialProdRuedasMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdRuedasMaseInput = inicialProdRuedasMase.getText();
            int inicialProdRuedasMaseInt;
            inicialProdRuedasMaseInt = Integer.parseInt(inicialProdRuedasMaseInput);
            main.Datos[23] = inicialProdRuedasMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdRuedasMaseActionPerformed

    private void actProdAccesoriosMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdAccesoriosMaseActionPerformed
        
        if(inicialProdAccesoriosMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdAccesoriosMaseInput = inicialProdAccesoriosMase.getText();
            int inicialProdAccesoriosMaseInt;
            inicialProdAccesoriosMaseInt = Integer.parseInt(inicialProdAccesoriosMaseInput);
            main.Datos[24] = inicialProdAccesoriosMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdAccesoriosMaseActionPerformed

    private void actEnsamMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actEnsamMaseActionPerformed
        
        if(inicialEnsamMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialEnsamMaseInput = inicialEnsamMase.getText();
            int inicialEnsamMaseInt;
            inicialEnsamMaseInt = Integer.parseInt(inicialEnsamMaseInput);
            main.Datos[25] = inicialEnsamMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actEnsamMaseActionPerformed

    private void actMaxChasisMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxChasisMaseActionPerformed

        if(inicialMaxChasisMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxChasisMaseInput = inicialMaxChasisMase.getText();
            int inicialMaxChasisMaseInt;
            inicialMaxChasisMaseInt = Integer.parseInt(inicialMaxChasisMaseInput);
            main.Datos[15] = inicialMaxChasisMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actMaxChasisMaseActionPerformed

    private void actMaxCarroceriasMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxCarroceriasMaseActionPerformed
        
        if(inicialMaxCarroceriasMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxCarroceriasMaseInput = inicialMaxCarroceriasMase.getText();
            int inicialMaxCarroceriasMaseInt;
            inicialMaxCarroceriasMaseInt = Integer.parseInt(inicialMaxCarroceriasMaseInput);
            main.Datos[16] = inicialMaxCarroceriasMaseInt;
            lectorTXT.escribir();
        }
               
    }//GEN-LAST:event_actMaxCarroceriasMaseActionPerformed

    private void actMaxMotoresMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxMotoresMaseActionPerformed
        
        if(inicialMaxMotoresMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxMotoresMaseInput = inicialMaxMotoresMase.getText();
            int inicialMaxMotoresMaseInt;
            inicialMaxMotoresMaseInt = Integer.parseInt(inicialMaxMotoresMaseInput);
            main.Datos[17] = inicialMaxMotoresMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actMaxMotoresMaseActionPerformed

    private void actMaxRuedasMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxRuedasMaseActionPerformed
        
        if(inicialMaxRuedasMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxRuedasMaseInput = inicialMaxRuedasMase.getText();
            int inicialMaxRuedasMaseInt;
            inicialMaxRuedasMaseInt = Integer.parseInt(inicialMaxRuedasMaseInput);
            main.Datos[18] = inicialMaxRuedasMaseInt;
            lectorTXT.escribir();
        }        
       
    }//GEN-LAST:event_actMaxRuedasMaseActionPerformed

    private void actMaxAccesoriosMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxAccesoriosMaseActionPerformed
        
        if(inicialMaxAccesoriosMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxAccesoriosMaseInput = inicialMaxAccesoriosMase.getText();
            int inicialMaxAccesoriosMaseInt;
            inicialMaxAccesoriosMaseInt = Integer.parseInt(inicialMaxAccesoriosMaseInput);
            main.Datos[19] = inicialMaxAccesoriosMaseInt;
            lectorTXT.escribir();
        } 
        
    }//GEN-LAST:event_actMaxAccesoriosMaseActionPerformed

    private void actTiempoMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actTiempoMaseActionPerformed
        
        if(inicialTiempoMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialTiempoMaseInput = inicialTiempoMase.getText();
            int inicialTiempoMaseInt;
            inicialTiempoMaseInt = Integer.parseInt(inicialTiempoMaseInput);
            main.Datos[13] = inicialTiempoMaseInt;
            lectorTXT.escribir();
        } 
        
    }//GEN-LAST:event_actTiempoMaseActionPerformed

    private void actDeadlineMaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actDeadlineMaseActionPerformed
        
        if(inicialDeadlineMase.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialDeadlineMaseInput = inicialDeadlineMase.getText();
            int inicialDeadlineMaseInt;
            inicialDeadlineMaseInt = Integer.parseInt(inicialDeadlineMaseInput);
            main.Datos[14] = inicialDeadlineMaseInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actDeadlineMaseActionPerformed

    private void actProdChasisRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdChasisRRActionPerformed
        
        if(inicialProdChasisRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdChasisRRInput = inicialProdChasisRR.getText();
            int inicialProdChasisRRInt;
            inicialProdChasisRRInt = Integer.parseInt(inicialProdChasisRRInput);
            main.Datos[7] = inicialProdChasisRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdChasisRRActionPerformed

    private void actProdCarroceriasRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdCarroceriasRRActionPerformed
        
        if(inicialProdCarroceriasRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdCarroceriasRRInput = inicialProdCarroceriasRR.getText();
            int inicialProdCarroceriasRRInt;
            inicialProdCarroceriasRRInt = Integer.parseInt(inicialProdCarroceriasRRInput);
            main.Datos[8] = inicialProdCarroceriasRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdCarroceriasRRActionPerformed

    private void actProdMotoresRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdMotoresRRActionPerformed
        
        if(inicialProdMotoresRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdMotoresRRInput = inicialProdMotoresRR.getText();
            int inicialProdMotoresRRInt;
            inicialProdMotoresRRInt = Integer.parseInt(inicialProdMotoresRRInput);
            main.Datos[9] = inicialProdMotoresRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdMotoresRRActionPerformed

    private void actProdRuedasRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdRuedasRRActionPerformed
        
        if(inicialProdRuedasRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdRuedasRRInput = inicialProdRuedasRR.getText();
            int inicialProdRuedasRRInt;
            inicialProdRuedasRRInt = Integer.parseInt(inicialProdRuedasRRInput);
            main.Datos[10] = inicialProdRuedasRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdRuedasRRActionPerformed

    private void actProdAccesoriosRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actProdAccesoriosRRActionPerformed
        
        if(inicialProdAccesoriosRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialProdAccesoriosRRInput = inicialProdAccesoriosRR.getText();
            int inicialProdAccesoriosRRInt;
            inicialProdAccesoriosRRInt = Integer.parseInt(inicialProdAccesoriosRRInput);
            main.Datos[11] = inicialProdAccesoriosRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actProdAccesoriosRRActionPerformed

    private void actMaxChasisRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxChasisRRActionPerformed
        
        if(inicialMaxChasisRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxChasisRRinput = inicialMaxChasisRR.getText();
            int inicialMaxChasisRRInt;
            inicialMaxChasisRRInt = Integer.parseInt(inicialMaxChasisRRinput);
            main.Datos[2] = inicialMaxChasisRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actMaxChasisRRActionPerformed

    private void actMaxCarroceriaRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxCarroceriaRRActionPerformed
        
        if(inicialMaxCarroceriasRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxCarroceriasRRInput = inicialMaxCarroceriasRR.getText();
            int inicialMaxCarroceriasRRInt;
            inicialMaxCarroceriasRRInt = Integer.parseInt(inicialMaxCarroceriasRRInput);
            main.Datos[3] = inicialMaxCarroceriasRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actMaxCarroceriaRRActionPerformed

    private void actMaxMotoresRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxMotoresRRActionPerformed
        
        if(inicialMaxMotoresRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxMotoresRRInput = inicialMaxMotoresRR.getText();
            int inicialMaxMotoresRRInt;
            inicialMaxMotoresRRInt = Integer.parseInt(inicialMaxMotoresRRInput);
            main.Datos[4] = inicialMaxMotoresRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actMaxMotoresRRActionPerformed

    private void actMaxRuedasRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxRuedasRRActionPerformed
        
        if(inicialMaxRuedasRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxRuedasRRInput = inicialMaxRuedasRR.getText();
            int inicialMaxRuedasRRInt;
            inicialMaxRuedasRRInt = Integer.parseInt(inicialMaxRuedasRRInput);
            main.Datos[5] = inicialMaxRuedasRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actMaxRuedasRRActionPerformed

    private void actMaxAccesoriosRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMaxAccesoriosRRActionPerformed
        
        if(inicialMaxAccesoriosRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialMaxAccesoriosRRinput = inicialMaxAccesoriosRR.getText();
            int inicialMaxAccesoriosRRInt;
            inicialMaxAccesoriosRRInt = Integer.parseInt(inicialMaxAccesoriosRRinput);
            main.Datos[6] = inicialMaxAccesoriosRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actMaxAccesoriosRRActionPerformed

    private void actEnsamRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actEnsamRRActionPerformed
        
        if(inicialEnsamRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialEnsamRRInput = inicialEnsamRR.getText();
            int inicialEnsamRRInt;
            inicialEnsamRRInt = Integer.parseInt(inicialEnsamRRInput);
            main.Datos[12] = inicialEnsamRRInt;
            lectorTXT.escribir();
        }
               
    }//GEN-LAST:event_actEnsamRRActionPerformed

    private void actTiempoRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actTiempoRRActionPerformed
        
        if(inicialTiempoRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialTiempoRRInput = inicialTiempoRR.getText();
            int inicialTiempoRRInt;
            inicialTiempoRRInt = Integer.parseInt(inicialTiempoRRInput);
            main.Datos[0] = inicialTiempoRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actTiempoRRActionPerformed

    private void actDeadlineRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actDeadlineRRActionPerformed
        
        if(inicialDeadlineRR.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Asegurese que el campo no este vacio");
        }
        else{
            String inicialDeadlineRRInput = inicialDeadlineRR.getText();
            int inicialDeadlineRRInt;
            inicialDeadlineRRInt = Integer.parseInt(inicialDeadlineRRInput);
            main.Datos[1] = inicialDeadlineRRInt;
            lectorTXT.escribir();
        }
        
    }//GEN-LAST:event_actDeadlineRRActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    private void SetImageLabel(JLabel labelName, String root){
        ImageIcon image = new ImageIcon (root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG_RR;
    private javax.swing.JLabel BG_dMase;
    private javax.swing.JLabel BG_dRR;
    private javax.swing.JPanel Inicio;
    private javax.swing.JPanel Maserati;
    private javax.swing.JPanel RollsRoyce;
    private javax.swing.JLabel accesoriosMase;
    private javax.swing.JLabel accesoriosRR;
    private javax.swing.JButton actDeadlineMase;
    private javax.swing.JButton actDeadlineRR;
    private javax.swing.JButton actEnsamMase;
    private javax.swing.JButton actEnsamRR;
    private javax.swing.JButton actMaxAccesoriosMase;
    private javax.swing.JButton actMaxAccesoriosRR;
    private javax.swing.JButton actMaxCarroceriaRR;
    private javax.swing.JButton actMaxCarroceriasMase;
    private javax.swing.JButton actMaxChasisMase;
    private javax.swing.JButton actMaxChasisRR;
    private javax.swing.JButton actMaxMotoresMase;
    private javax.swing.JButton actMaxMotoresRR;
    private javax.swing.JButton actMaxRuedasMase;
    private javax.swing.JButton actMaxRuedasRR;
    private javax.swing.JButton actProdAccesoriosMase;
    private javax.swing.JButton actProdAccesoriosRR;
    private javax.swing.JButton actProdCarroceriasMase;
    private javax.swing.JButton actProdCarroceriasRR;
    private javax.swing.JButton actProdChasisMase;
    private javax.swing.JButton actProdChasisRR;
    private javax.swing.JButton actProdMotoresMase;
    private javax.swing.JButton actProdMotoresRR;
    private javax.swing.JButton actProdRuedasMase;
    private javax.swing.JButton actProdRuedasRR;
    private javax.swing.JButton actTiempoMase;
    private javax.swing.JButton actTiempoRR;
    private javax.swing.JLabel carroceriasMase;
    private javax.swing.JLabel carroceriasRR;
    private javax.swing.JLabel carrosAccMase;
    private javax.swing.JLabel carrosAccRR;
    private javax.swing.JLabel carrosMase;
    private javax.swing.JLabel carrosRR;
    private javax.swing.JLabel chasisMase;
    private javax.swing.JLabel chasisRR;
    private javax.swing.JPanel dataMaserati;
    private javax.swing.JPanel dataRolllsRoyce;
    private javax.swing.JLabel directorMase;
    private javax.swing.JLabel directorRR;
    private javax.swing.JButton downEnsamMase;
    private javax.swing.JButton downEnsamRR;
    private javax.swing.JButton downProdAccesoriosMase;
    private javax.swing.JButton downProdAccesoriosRR;
    private javax.swing.JButton downProdCarroceriasMase;
    private javax.swing.JButton downProdCarroceriasRR;
    private javax.swing.JButton downProdChasisMase;
    private javax.swing.JButton downProdChasisRR;
    private javax.swing.JButton downProdMotoresMase;
    private javax.swing.JButton downProdMotoresRR;
    private javax.swing.JButton downProdRuedasMase;
    private javax.swing.JButton downProdRuedasRR;
    private javax.swing.JLabel ensamMase;
    private javax.swing.JLabel ensamRR;
    private javax.swing.JLabel entregaMase;
    private javax.swing.JLabel entregaRR;
    private javax.swing.JLabel entregadosMase;
    private javax.swing.JLabel entregadosRR;
    private javax.swing.JLabel ganaciasMase;
    private javax.swing.JLabel gananciasRR;
    private javax.swing.JLabel gerenteMase;
    private javax.swing.JLabel gerenteRR;
    private javax.swing.JTextField inicialDeadlineMase;
    private javax.swing.JTextField inicialDeadlineRR;
    private javax.swing.JTextField inicialEnsamMase;
    private javax.swing.JTextField inicialEnsamRR;
    private javax.swing.JTextField inicialMaxAccesoriosMase;
    private javax.swing.JTextField inicialMaxAccesoriosRR;
    private javax.swing.JTextField inicialMaxCarroceriasMase;
    private javax.swing.JTextField inicialMaxCarroceriasRR;
    private javax.swing.JTextField inicialMaxChasisMase;
    private javax.swing.JTextField inicialMaxChasisRR;
    private javax.swing.JTextField inicialMaxMotoresMase;
    private javax.swing.JTextField inicialMaxMotoresRR;
    private javax.swing.JTextField inicialMaxRuedasMase;
    private javax.swing.JTextField inicialMaxRuedasRR;
    private javax.swing.JTextField inicialProdAccesoriosMase;
    private javax.swing.JTextField inicialProdAccesoriosRR;
    private javax.swing.JTextField inicialProdCarroceriasMase;
    private javax.swing.JTextField inicialProdCarroceriasRR;
    private javax.swing.JTextField inicialProdChasisMase;
    private javax.swing.JTextField inicialProdChasisRR;
    private javax.swing.JTextField inicialProdMotoresMase;
    private javax.swing.JTextField inicialProdMotoresRR;
    private javax.swing.JTextField inicialProdRuedasMase;
    private javax.swing.JTextField inicialProdRuedasRR;
    private javax.swing.JTextField inicialTiempoMase;
    private javax.swing.JTextField inicialTiempoRR;
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel motoresMase;
    private javax.swing.JLabel motoresRR;
    private javax.swing.JLabel prodAccesoriosMase;
    private javax.swing.JLabel prodAccesoriosRR;
    private javax.swing.JLabel prodCarroceriasMase;
    private javax.swing.JLabel prodCarroceriasRR;
    private javax.swing.JLabel prodChasisMase;
    private javax.swing.JLabel prodChasisRR;
    private javax.swing.JLabel prodMotoresMase;
    private javax.swing.JLabel prodMotoresRR;
    private javax.swing.JLabel prodRuedasMase;
    private javax.swing.JLabel prodRuedasRR;
    private javax.swing.JLabel ruedasMase;
    private javax.swing.JLabel ruedasRR;
    private javax.swing.JButton upEnsamMase;
    private javax.swing.JButton upEnsamRR;
    private javax.swing.JButton upProdAccesoriosMase;
    private javax.swing.JButton upProdAccesoriosRR;
    private javax.swing.JButton upProdCarroceriasMase;
    private javax.swing.JButton upProdCarroceriasRR;
    private javax.swing.JButton upProdChasisMase;
    private javax.swing.JButton upProdChasisRR;
    private javax.swing.JButton upProdMotoresMase;
    private javax.swing.JButton upProdMotoresRR;
    private javax.swing.JButton upProdRuedasMase;
    private javax.swing.JButton upProdRuedasRR;
    private javax.swing.JLabel zBG_Mase;
    // End of variables declaration//GEN-END:variables
}
