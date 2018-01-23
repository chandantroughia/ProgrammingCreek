package design.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState(){
        return this.state;
    }

    public void setState(int newState){
        this.state = newState;
        notifyAllObservers();
    }

    public void attachObservers(Observer newObserver){
        observers.add(newObserver);
    }

    public void notifyAllObservers(){
        for(Observer O : observers){
            O.update();
        }
    }
}
