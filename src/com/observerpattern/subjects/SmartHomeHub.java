package com.observerpattern.subjects;

import com.observerpattern.interfaces.Subject;
import com.observerpattern.interfaces.Observer;
import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub implements Subject {
    private final List<Observer> observers;
    private double temperature;
    private String securityStatus;
    private String doorStatus;

    public SmartHomeHub() {
        this.observers = new ArrayList<>();
        this.temperature = 22.0;
        this.securityStatus = "Disarmed";
        this.doorStatus = "All doors closed";
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("New observer added: " + observer.getClass().getSimpleName());
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer removed: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, securityStatus, doorStatus);
        }
    }

    public void setTemperature(double temperature) {
        if (this.temperature != temperature) {
            this.temperature = temperature;
            System.out.println("\n--- Temperature changed to: " + temperature + "°C ---");
            notifyObservers();
        }
    }

    public void setSecurityStatus(String securityStatus) {
        if (!this.securityStatus.equals(securityStatus)) {
            this.securityStatus = securityStatus;
            System.out.println("\n--- Security status changed to: " + securityStatus + " ---");
            notifyObservers();
        }
    }

    public void setDoorStatus(String doorStatus) {
        if (!this.doorStatus.equals(doorStatus)) {
            this.doorStatus = doorStatus;
            System.out.println("\n--- Door status changed: " + doorStatus + " ---");
            notifyObservers();
        }
    }

    public void showObservers() {
        System.out.println("\nCurrent observers (" + observers.size() + "):");
        for (Observer observer : observers) {
            System.out.println(" - " + observer.getClass().getSimpleName());
        }
    }
}