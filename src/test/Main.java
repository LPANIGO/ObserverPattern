/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controler.*;
import display.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        WeatherData weatherData = new WeatherData();
        
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        
        weatherData.setChanges(80, 65, 30.4f);
        weatherData.setChanges(82, 70, 29.2f);
        weatherData.setChanges(78, 90, 29.2f);  
    }
    
}
