/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rosch;

import java.lang.Math;
/**
 *
 * @author Вадим
 */
public class Schet {
    
    private double a=0.0;
    private double b=0.0;

    public static double sum(double a, double b){
        return a+b;
    }
    
    public static double substract(double a, double b){
        return a-b;
    }
    
    public static double multiply (double a, double b){
        return a*b;
    }
    
    public static double divade(double a, double b){
        return a/b;
    }
    
     public static double kor(double a){
        return (double) Math.sqrt(a);
     }
    
     public static double step(double a, double b){
        return (double) Math.pow(a, b);
     
     }
     
     public static double proc (double a){
         return a/100;
     }
     
   }
