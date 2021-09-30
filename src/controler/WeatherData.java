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
    private boolean changed;
    
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
    
    public void notifyObserver() {
        if (changed) {
            for (Observer o: observers) {
                o.update(this);
            }
            System.out.println();
            changed = false;
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
        setChanged();
        notifyObserver();
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
    private void setChanged() {
        changed = true;
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
