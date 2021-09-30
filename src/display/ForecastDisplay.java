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
public class ForecastDisplay implements Observer, Display {
    
    private Subject weatherData; 
    private float currentPressure = 29.92f;
    private float lastPressure;
    
    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(Subject sb) {
        if (sb instanceof WeatherData) {
            WeatherData w = (WeatherData) sb;
            lastPressure = currentPressure;
            currentPressure = w.getPressure();
            display();
        }
    }
    
    public void display() {
        System.out.println("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure ) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
