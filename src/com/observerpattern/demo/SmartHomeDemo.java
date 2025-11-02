package com.observerpattern.demo;

import com.observerpattern.subjects.SmartHomeHub;
import com.observerpattern.observers.SmartThermostat;
import com.observerpattern.observers.SecurityPanel;
import com.observerpattern.observers.MobileApp;

public class SmartHomeDemo {
    public static void main(String[] args) {
        System.out.println("=== SMART HOME OBSERVER PATTERN DEMO ===\n");

        // Create the subject (Smart Home Hub)
        SmartHomeHub homeHub = new SmartHomeHub();

        // Create observers
        SmartThermostat livingRoomThermo = new SmartThermostat("Living Room Thermostat");
        SmartThermostat bedroomThermo = new SmartThermostat("Bedroom Thermostat");
        SecurityPanel securityPanel = new SecurityPanel();
        MobileApp parentApp = new MobileApp("Parent");
        MobileApp childApp = new MobileApp("Child");

        // Register observers
        System.out.println("=== REGISTERING OBSERVERS ===");
        homeHub.addObserver(livingRoomThermo);
        homeHub.addObserver(bedroomThermo);
        homeHub.addObserver(securityPanel);
        homeHub.addObserver(parentApp);
        homeHub.addObserver(childApp);

        // Show initial state
        homeHub.showObservers();

        // Simulate home events
        System.out.println("\n=== SIMULATING HOME EVENTS ===");

        homeHub.setTemperature(23.5);
        homeHub.setSecurityStatus("Armed");
        homeHub.setDoorStatus("Front door opened");
        homeHub.setTemperature(19.0);
        homeHub.setDoorStatus("Front door closed");
        homeHub.setSecurityStatus("Disarmed");

        // Demonstrate dynamic addition/removal of observers
        System.out.println("\n=== DYNAMIC OBSERVER MANAGEMENT ===");

        MobileApp guestApp = new MobileApp("Guest");
        homeHub.addObserver(guestApp);
        homeHub.setTemperature(21.0);

        homeHub.removeObserver(childApp);
        homeHub.setDoorStatus("Back door opened");

        // Show observer-specific data
        System.out.println("\n=== OBSERVER SPECIFIC DATA ===");
        securityPanel.showSecurityLog();
        parentApp.showNotificationHistory();

        // Final state
        homeHub.showObservers();

        System.out.println("\n=== DEMO COMPLETED ===");
    }
}