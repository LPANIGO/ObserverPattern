/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import display.Observer;
//extend java.util.Observable superclass
/*
First of all you need to be Observable by extending the java.util.Observable
superclass. From there it is a two step process:
You first must call the setChanged() method to signify
that the state has changed in your object
Then, call one of two notifyObservers() methods:
either notifyObservers() or notifyObservers(Object arg)
*/

public interface Subject {
    
    public abstract void registerObserver(Observer o);
    
    public abstract void deletObserver(Observer o);
    
    public abstract void notifyObserver();
    
    public abstract void setMeasurements(float temperature, float humidity, float pressure);
}

