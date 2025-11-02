package com.observerpattern.interfaces;

public interface Observer {
    void update(double temperature, String securityStatus, String doorStatus);
}