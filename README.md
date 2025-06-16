# 🏨 Hotel Management System - Java (Console + GUI)

This project is a **Hotel Management System** developed in **Java**, featuring both a **Console-based** version and a fully functional **GUI version using Swing**.

It allows hotel administrators to:
- Manage room bookings
- View room availability
- Cancel bookings
- Save & load bookings from files
- View all bookings in a formatted way
- Reset room availability

---

## 🔧 Features

### ✅ Console Version
- Book a room by entering customer name, room number, and nights
- Show available rooms with price and type
- Cancel an existing booking
- View all current bookings
- Reset all room availability
- Simple command-line based interaction
- Ideal for terminal-based systems

### 🖥️ GUI Version (Java Swing)
- Beautifully designed Java Swing interface
- Horizontal layout buttons for better UX
- Dynamic room booking form
- Booking cancellation form
- View all bookings in a scrollable window
- Show room status with availability
- Persistent storage of bookings via `bookings.csv`
- Automatic file loading and saving
- Real-time updates to room availability and booking data

---

## 📁 Project Structure
HotelManagementSystem/
│
├── Booking.java # Booking class (customer name, room, nights, total)
├── Room.java # Room class (room number, type, price, availability)
├── HotelConsole.java # Console version of the system
├── HotelGUI.java # GUI version (main application)
├── bookings.csv # Saved bookings data (auto-generated)
├── README.md # You're reading it!


---

## 💡 Technologies Used

- Java (JDK 17+)
- Java Swing (GUI)
- File I/O (CSV for persistence)
- IntelliJ IDEA / VS Code / Any Java IDE
- OOP principles

---

## 🚀 Getting Started

### 🛠 Requirements
- Java installed (`java -version`)
- Any Java IDE or terminal

### ▶️ Run the GUI Version
```bash
Run HotelGUI.java in your IDE

▶️ Run the Console Version

Run main.java in your IDE or terminal


