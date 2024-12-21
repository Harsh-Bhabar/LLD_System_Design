package Patterns.pattern_Observer;

import Patterns.pattern_Observer.Observable.Weather;
import Patterns.pattern_Observer.Observer.DisplayObserver;
import Patterns.pattern_Observer.Observer.MobileDisplay;
import Patterns.pattern_Observer.Observer.TVDisplay;

public class Main {
    public static void main(String[] args){
        Weather weatherNotification = new Weather(100);

        DisplayObserver tvObserver = new TVDisplay("harsh.bhabar", weatherNotification);
        DisplayObserver tvObserver2 = new TVDisplay("pankaj.bhabar", weatherNotification);
        DisplayObserver mobileObserver = new MobileDisplay("mrinal.satya", weatherNotification);

        weatherNotification.add(tvObserver);
        weatherNotification.add(tvObserver2);
        weatherNotification.add(mobileObserver);

        weatherNotification.setData(100);

        weatherNotification.setData(500);


    }
}
