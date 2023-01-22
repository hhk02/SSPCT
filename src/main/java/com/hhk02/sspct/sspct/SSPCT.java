/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hhk02.sspct.sspct;
/**
 *
 * @author harold
 */
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SSPCT {
    public static Scanner scan = new Scanner(System.in);
    
    static int horasel = scan.nextInt();
    static int minsel = scan.nextInt();

    
    public static void Comprobar()
    {
        
        var reloj = LocalTime.now();
        if (System.getProperty("os.name").equals("Linux"))
        {
            if(reloj.getHour() <= horasel  & reloj.getMinute() >= minsel)
            {
                ApagarEquipo();
            }
        }
        if (System.getProperty("os.name").equals("Windows"))
        {
            if(reloj.getHour() <= horasel  & reloj.getMinute() >= minsel)
            {
                ApagarEquipo();
            }
        }
        
    }
    public static void ApagarEquipo()
    {
        var cmd = Runtime.getRuntime();
        try {
            cmd.exec("systemctl poweroff");
        } catch (IOException ex) {
            Logger.getLogger(SSPCT.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Shutting down computer...");
        
        
    }
    public static void main(String[] args) {
        
        var isRunning = true;
        System.out.println(System.getProperty("os.name"));
        while(isRunning)
        {
            try {
                Thread.sleep(1200, 1200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            Comprobar();
        }
    }
}
