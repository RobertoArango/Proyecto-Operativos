/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import main.main;

/**
 *
 * @author Vito
 */
public class lectorTXT {
    
    //Funcion para asegurar que lo datos que se entren por "leer()" sean unicamente numericos
    
    public static boolean esInt(String n){
        try {
            Integer.parseInt(n);
            return true;
        } catch (Exception e){
            return false;
        }       
    }
    
    //Funcion que lee los datos de "Datos.txt" en el paquete "Test"
    
    public static void leer() {
        
        String paquete = "test\\Datos.txt";
        String s;
        File archivo = new File(paquete);
        
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;

            while ((s = br.readLine()) != null) {
                if (esInt(s)) {
                    main.Datos[i] = Integer.parseInt(s);
                    i++;
                }
            }
            br.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    //Funcion que escribe/actualiza los datos que se pueden cambiar por interfaz grafica
    
    public static void escribir() {
        try {
            String nuevosDatos = "Conversion dias/seg RR:\n" + Integer.toString(main.Datos[0])
                    + "\nDia de entrega de vehiculos RR:\n" + Integer.toString(main.Datos[1])
                    + "\nCapacidad max en almacen RR - Chasis:\n" + Integer.toString(main.Datos[2])
                    + "\nCapacidad max en almacen RR - Carrocerias:\n" + Integer.toString(main.Datos[3])
                    + "\nCapacidad max en almacen RR - Motores:\n" + Integer.toString(main.Datos[4])
                    + "\nCapacidad max en almacen RR - Ruedas:\n" + Integer.toString(main.Datos[5])
                    + "\nCapacidad max en almacen RR - Accesorios:\n" + Integer.toString(main.Datos[6])
                    + "\nProductores RR - Chasis:\n" + Integer.toString(main.Datos[7])
                    + "\nProductores RR - Carrocerias:\n" + Integer.toString(main.Datos[8])
                    + "\nProductores RR - Motores:\n" + Integer.toString(main.Datos[9])
                    + "\nProductores RR - Ruedas:\n" + Integer.toString(main.Datos[10])
                    + "\nProductores RR - Accesorios:\n" + Integer.toString(main.Datos[11])
                    + "\nEnsambladores RR:\n" + Integer.toString(main.Datos[12])
                    + "\nConversion dias/seg Mase:\n" + Integer.toString(main.Datos[13])
                    + "\nDia de entrega de vehiculos Mase:\n" + Integer.toString(main.Datos[14])
                    + "\nCapacidad max en almacen Mase - Chasis:\n" + Integer.toString(main.Datos[15])
                    + "\nCapacidad max en almacen Mase - Carrocerias:\n" + Integer.toString(main.Datos[16])
                    + "\nCapacidad max en almacen Mase - Motores:\n" + Integer.toString(main.Datos[17])
                    + "\nCapacidad max en almacen Mase - Ruedas:\n" + Integer.toString(main.Datos[18])
                    + "\nCapacidad max en almacen Mase - Accesorios:\n" + Integer.toString(main.Datos[19])
                    + "\nProductores Mase - Chasis:\n" + Integer.toString(main.Datos[20])
                    + "\nProductores Mase - Carrocerias:\n" + Integer.toString(main.Datos[21])
                    + "\nProductores Mase - Motores:\n" + Integer.toString(main.Datos[22])
                    + "\nProductores Mase - Ruedas:\n" + Integer.toString(main.Datos[23])
                    + "\nProductores Mase - Accesorios:\n" + Integer.toString(main.Datos[24])
                    + "\nEnsambladores Mase:\n" + Integer.toString(main.Datos[25]);
            
            PrintWriter pw = new PrintWriter("test\\Datos.txt");
            pw.print(nuevosDatos);
            pw.close();
            JOptionPane.showMessageDialog(null, "Los datos iniciales se han actualizado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
