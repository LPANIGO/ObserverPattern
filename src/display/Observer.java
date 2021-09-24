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
public abstract class Observer {
   
    public abstract void update(Subject s);

}
