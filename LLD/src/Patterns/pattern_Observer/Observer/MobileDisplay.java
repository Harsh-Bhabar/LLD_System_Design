package Patterns.pattern_Observer.Observer;

import Patterns.pattern_Observer.Observable.Observable;

public class MobileDisplay implements DisplayObserver{
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
