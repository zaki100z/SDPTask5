# Smart Home Observer Pattern Implementation

![Java](https://img.shields.io/badge/Java-17-blue)
![Design Patterns](https://img.shields.io/badge/Pattern-Observer-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A comprehensive implementation of the **Observer Design Pattern** demonstrating a smart home notification system where various devices observe and react to changes in a central home hub.

## Overview
This project implements the **Observer Design Pattern** through a practical **Smart Home Notification System**. The system consists of a central `SmartHomeHub` (Subject) that notifies various smart devices (Observers) when important home events occur, such as temperature changes, security status updates, or door events.

### Architecture
- **Subject**: `SmartHomeHub` - Central hub managing state and observers
- **Observers**:
    - `SmartThermostat` - Reacts to temperature changes
    - `SecurityPanel` - Monitors security events
    - `MobileApp` - Provides user notifications

## Pattern Explanation

The **Observer Pattern** establishes a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

### Key Characteristics:
- **Loose Coupling** - Subjects know only about observer interfaces
-  **Dynamic Relationships** - Observers can be added/removed at runtime
- **Automatic Updates** - State changes propagate automatically
- **Extensibility** - Easy to add new observer types

## Features

### Core Functionality
- **Real-time notifications** for home state changes
- **Selective observation** - devices react only to relevant events
- **Dynamic observer management** - add/remove devices at runtime
- **Comprehensive logging** - event history and security logs

## Installation & Usage

### Prerequisites
- Java JDK 8 or higher
- IntelliJ IDEA (recommended) or any Java IDE

### Quick Start

1. **Clone the repository**
```
git clone https://github.com/yourusername/smart-home-observer-pattern.git
cd smart-home-observer-pattern
```

2. **Import into IntelliJ IDEA**
    - Open IntelliJ IDEA
    - Select `Open or Import`
    - Choose the project directory
    - Wait for project indexing

3. **Run the demo**
    - Navigate to `src/com/observerpattern/demo/SmartHomeDemo.java`
    - Right-click and select `Run 'SmartHomeDemo.main()'`

## Clean Code Principles


### Code Quality Features
- **Intention-revealing interfaces**
- **Minimal method parameters**
- **Clear separation of concerns**
- **Comprehensive documentation**

## Theoretical Foundation

### Design Pattern Benefits Demonstrated

1. **Loose Coupling**
    - Subject knows only about Observer interface
    - No dependencies on concrete implementations
    - Easy to test and maintain




## Author


- Course: Software Design Patterns
- Assignment: 7 - Observer Pattern Implementation

