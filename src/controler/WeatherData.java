/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import java.util.List;
import java.util.ArrayList;
import display.Observer;

/**
 * 
 * @author 
 */
public class WeatherData implements Subject {
    
    private float temperature;
    private float humidity;
    private float pressure;
    
    private List<Observer> observers;
    
    public WeatherData() {
        observers = new ArrayList<>();
    }
    
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    
    public void deletObserver(Observer o) {
        observers.remove(o);
    }
    /*
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
        observers.remove(i);
        }
    }
    */
    
    public void notifyObserver() {
        for (Observer o: observers) {
            o.update(this);
        }
    }
    /*
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }*/
    
    public void measurementsChanged() {
        notifyObserver();
    }
    
    public void setChanges(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
    
    
}
