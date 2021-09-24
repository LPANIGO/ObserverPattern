/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package display;

import controler.Subject;
import controler.WeatherData;
//java.util.Observer interface
/*
As usual, implement the Observer interface (this time the java.util.Observer
interface) and call addObserver() on any Observable object. Likewise, to remove
yourself as an observer just call deleteObserver(). 
*/



public class CurrentConditionsDisplay extends Observer implements Display {
    
    private float temperature;
    private float humidity;
    private Subject weatherData;
    
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void update(Subject s) {
        if (s instanceof WeatherData){
            WeatherData w = (WeatherData) s;
            this.temperature = w.getTemperature();
            this.humidity = w.getHumidity();
            display(); 
        }
         
    }
    
    public void display() {
        System.out.println("Current conditions: " + temperature 
            + "F degrees and " + humidity + " humidity");
    }
    
}
