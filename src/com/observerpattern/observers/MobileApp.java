package com.observerpattern.observers;

import com.observerpattern.interfaces.Observer;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MobileApp implements Observer {
    private final List<String> notifications;
    private final String user;

    public MobileApp(String user) {
        this.user = user;
        this.notifications = new ArrayList<>();
    }

    @Override
    public void update(double temperature, String securityStatus, String doorStatus) {
        String notification = createNotification(temperature, securityStatus, doorStatus);
        notifications.add(notification);
        showLatestNotification();
    }

    private String createNotification(double temperature, String securityStatus, String doorStatus) {
        return String.format("[%s] Home Update - Temp: %.1f°C | Security: %s | Doors: %s",
                LocalTime.now(), temperature, securityStatus, doorStatus);
    }

    private void showLatestNotification() {
        if (!notifications.isEmpty()) {
            String latest = notifications.get(notifications.size() - 1);
            System.out.println("📱 Mobile App for " + user + ": " + latest);
        }
    }

    public void showNotificationHistory() {
        System.out.println("\n--- Notification History for " + user + " ---");
        notifications.forEach(System.out::println);
    }

    public void clearNotifications() {
        notifications.clear();
        System.out.println("All notifications cleared for " + user);
    }
}