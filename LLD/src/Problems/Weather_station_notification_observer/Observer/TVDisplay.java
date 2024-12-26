package Problems.Weather_station_notification_observer.Observer;

import Problems.Weather_station_notification_observer.Observable.Observable;

public class TVDisplay implements DisplayObserver {
    Observable observable;
    String email;

    public TVDisplay(String email, Observable observable){
        this.observable = observable;
        this.email = email;
    }

    public void update(){
        System.out.println("TV Displat updated!" + observable.getData());
    };
}
