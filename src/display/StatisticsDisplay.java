/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package display;

import controler.Subject;
import controler.WeatherData;

public class StatisticsDisplay implements Observer, Display {
    
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;
    
    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void update(Subject sb) {
        WeatherData w = (WeatherData) sb;
        float temp = w.getTemperature();
        
        tempSum += temp;
        numReadings++;
        
        if (temp > maxTemp) {
            maxTemp = temp;
        }
        if (temp < minTemp) {
            minTemp = temp;
        }
        
        display();
    }
    
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum/numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }
}
