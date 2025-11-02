package com.observerpattern.observers;

import com.observerpattern.interfaces.Observer;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SecurityPanel implements Observer {
    private String currentSecurityStatus;
    private final List<String> securityLog;

    public SecurityPanel() {
        this.currentSecurityStatus = "Disarmed";
        this.securityLog = new ArrayList<>();
    }

    @Override
    public void update(double temperature, String securityStatus, String doorStatus) {
        if (!this.currentSecurityStatus.equals(securityStatus)) {
            this.currentSecurityStatus = securityStatus;
            alert();
        }

        if (doorStatus.contains("opened") || doorStatus.contains("closed")) {
            logEvent("Door event: " + doorStatus);
        }
    }

    private void alert() {
        String alertMessage = "SECURITY ALERT: System is now " + currentSecurityStatus.toUpperCase();
        System.out.println("🚨 " + alertMessage);
        logEvent(alertMessage);
    }

    private void logEvent(String event) {
        securityLog.add("[" + LocalTime.now() + "] " + event);
    }

    public void showSecurityLog() {
        System.out.println("\n--- Security Log ---");
        securityLog.forEach(System.out::println);
    }

    public String getCurrentSecurityStatus() {
        return currentSecurityStatus;
    }
}