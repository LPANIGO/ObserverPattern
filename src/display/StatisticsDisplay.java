/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package display;

import controler.Subject;
import controler.WeatherData;

/**
 * 
 * @author 
 */
public class StatisticsDisplay extends Observer implements Display {
    
    public void display() {
        
    }
    
     public void update(Subject s) {
        display();  
    }
   
}