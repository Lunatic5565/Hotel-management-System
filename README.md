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

------------------------------------------------------------

INSTALLATION & SETUP

Step 1: Clone or Download the Project
```
git clone https://github.com/Lunatic5565/Hotel-management-System.git
cd Hotel-management-System
```
Alternatively, download the ZIP file from GitHub and extract it.

------------------------------------------------------------

Step 2: Compile the Program

Using Terminal:
```
javac Booking.java Room.java HotelConsole.java HotelGUI.java
```
Using IDE:
- Open the project in IntelliJ IDEA or VS Code
- Configure JDK 17 or above
- Build the project

------------------------------------------------------------

Step 3: Run the Program

Run GUI Version:
```
java HotelGUI
```
Run Console Version:
```
java HotelConsole
```
------------------------------------------------------------

DATA STORAGE

- bookings.csv is created automatically on the first booking
- Booking data is saved and loaded between program runs
- No external database is required

------------------------------------------------------------

🔮 FUTURE ENHANCEMENTS

- Integration with a database (MySQL / PostgreSQL)
- User authentication and admin roles
- Online booking functionality
- Payment and billing module
- Improved UI using JavaFX
- Booking reports and analytics

------------------------------------------------------------

🤝 CONTRIBUTING

Contributions are welcome!

If you would like to improve this project:
- Fork the repository
- Create a new feature branch  
  (```git checkout -b feature/YourFeatureName```)
- Commit your changes  
  (```git commit -m "Add new feature"```)
- Push the branch  
  (```git push origin feature/YourFeatureName```)
- Open a Pull Request

------------------------------------------------------------

📝 LICENSE

This project is created as a mini project for educational purposes.
You are free to use, modify, and share this project for learning
and academic use.

------------------------------------------------------------

👨‍💻 AUTHOR

Jitesh Bagale  
GitHub: https://github.com/Lunatic5565

------------------------------------------------------------

🙏 ACKNOWLEDGMENTS

- Thanks to all contributors and supporters
- Inspired by real-world hotel management systems
- Built as a learning project to strengthen Java OOP concepts
