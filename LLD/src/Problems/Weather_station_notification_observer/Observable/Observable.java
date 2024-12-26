package Problems.Weather_station_notification_observer.Observable;

import Problems.Weather_station_notification_observer.Observer.DisplayObserver;

public interface Observable {
    void add(DisplayObserver obj);
    void remove(DisplayObserver obj);
    void notify_observers();
    int getData();
    void setData(int val);
}
