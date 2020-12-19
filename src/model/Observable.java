package model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public interface Observable {
    public ArrayList<?> observers = new ArrayList<> ();
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void updateObservers() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
