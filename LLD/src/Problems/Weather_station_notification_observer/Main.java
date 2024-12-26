package Problems.Weather_station_notification_observer;

import Problems.Weather_station_notification_observer.Observable.Weather;
import Problems.Weather_station_notification_observer.Observer.DisplayObserver;
import Problems.Weather_station_notification_observer.Observer.MobileDisplay;
import Problems.Weather_station_notification_observer.Observer.TVDisplay;

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
