package Patterns.pattern_Observer.Observer;

import Patterns.pattern_Observer.Observable.Observable;

public class TVDisplay implements DisplayObserver{
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
