# 🏨 Hotel Management System - Java (Console + GUI)

This project is a Hotel Management System developed in Java, featuring both a
Console-based version and a fully functional GUI version using Swing.

It allows hotel administrators to:
- Manage room bookings
- View room availability
- Cancel bookings
- Save & load bookings from files
- View all bookings in a formatted way
- Reset room availability

--------------------------------------------------

FEATURES

Console Version:
- Book a room by entering customer name, room number, and nights
- Show available rooms with price and type
- Cancel an existing booking
- View all current bookings
- Reset all room availability
- Simple command-line based interaction
- Ideal for terminal-based systems

GUI Version (Java Swing):
- Java Swing based graphical interface
- Horizontal layout buttons for better UX
- Dynamic room booking form
- Booking cancellation form
- View all bookings in a scrollable window
- Show room status with availability
- Persistent storage using bookings.csv
- Automatic file loading and saving
- Real-time room availability updates

--------------------------------------------------

## 📁 Project Structure

```text
HotelManagementSystem/
├── Booking.java        # Booking class (customer name, room, nights, total)
├── Room.java           # Room class (room number, type, price, availability)
├── HotelConsole.java   # Console version of the system
├── HotelGUI.java       # GUI version (main application)
├── bookings.csv        # Saved bookings data (auto-generated)
└── README.md             - This file
```
--------------------------------------------------

TECHNOLOGIES USED

- Java (JDK 17+)
- Java Swing
- File I/O (CSV)
- Object Oriented Programming
- IntelliJ IDEA / VS Code / Any Java IDE

--------------------------------------------------

GETTING STARTED

Requirements:
- Java installed (check using: java -version)
- Any Java IDE or terminal

Run GUI Version:
```
javac HotelGUI.java
java HotelGUI
```
Run Console Version:
```
javac HotelConsole.java
java HotelConsole
```
--------------------------------------------------

NOTES

- bookings.csv is auto-generated on first booking
- Data persists between runs
- Both versions share core logic
