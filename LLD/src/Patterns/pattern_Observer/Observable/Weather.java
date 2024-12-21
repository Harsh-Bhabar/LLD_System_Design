package Patterns.pattern_Observer.Observable;

import Patterns.pattern_Observer.Observer.DisplayObserver;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Observable{

    List<DisplayObserver> displayObserverList;
    int temp;

    public Weather(int temp){
        displayObserverList = new ArrayList<>();
        this.temp = temp;
    }

    @Override
    public void add(DisplayObserver displayObserver){
        displayObserverList.add(displayObserver);
    }
    @Override
    public void remove(DisplayObserver displayObserver){
        displayObserverList.remove(displayObserver);
    }
    @Override
    public void notify_observers(){
        for(DisplayObserver observer: displayObserverList){
            observer.update();
        }
    }

    @Override
    public void setData(int newTemp){
        this.temp = newTemp;
        notify_observers();
    }

    @Override
    public int getData(){
        return temp;
    }
}
