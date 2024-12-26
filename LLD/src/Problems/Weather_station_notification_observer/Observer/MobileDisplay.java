package Problems.Weather_station_notification_observer.Observer;

import Problems.Weather_station_notification_observer.Observable.Observable;

public class MobileDisplay implements DisplayObserver {
    Observable observable;
    String email;

    public MobileDisplay(String email, Observable observable){
        this.observable = observable;
        this.email = email;
    }

    public void update(){
        System.out.println("Mobile phone updated!" + observable.getData());
    }
}
