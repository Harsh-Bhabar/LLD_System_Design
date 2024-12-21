package Patterns.pattern_Observer.Observable;

import Patterns.pattern_Observer.Observer.DisplayObserver;

public interface Observable {
    void add(DisplayObserver obj);
    void remove(DisplayObserver obj);
    void notify_observers();
    int getData();
    void setData(int val);
}
