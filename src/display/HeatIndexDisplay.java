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
public class HeatIndexDisplay implements Observer, Display {
    
    float heatIndex = 0.0f;
    private WeatherData weatherData;
    private float temperature;
    private float humidity;    

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
        
    public void update(Subject s) {
        if (s instanceof WeatherData){
            WeatherData w = (WeatherData) s;
            this.temperature = w.getTemperature();
            this.humidity = w.getHumidity();
            heatIndex = computeHeatIndex(temperature, humidity);
            display(); 
        }      
    }

    private float computeHeatIndex(float t, float rh) {
        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
            (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
            (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
            (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *  
            (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
            (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +     
            0.000000000843296 * (t * t * rh * rh * rh)) -
            (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }
    
     public void display() {
        System.out.println("Heat index is " + heatIndex);
    }
     
}
