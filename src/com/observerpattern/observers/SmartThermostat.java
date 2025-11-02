package com.observerpattern.observers;

import com.observerpattern.interfaces.Observer;

public class SmartThermostat implements Observer {
    private double currentTemperature;
    private String name;

    public SmartThermostat(String name) {
        this.name = name;
        this.currentTemperature = 0.0;
    }

    @Override
    public void update(double temperature, String securityStatus, String doorStatus) {
        if (this.currentTemperature != temperature) {
            this.currentTemperature = temperature;
            display();
        }
    }

    public void display() {
        System.out.println("[" + name + "] Current temperature: " + currentTemperature + "°C | "
                + (currentTemperature > 25 ? "🔥 Cooling needed" : "❄️ Heating needed"));
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }
}