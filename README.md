🏨 Hotel Booking System in Java (Console + GUI)
A simple yet functional Hotel Room Booking Management System developed in Java using both Console (CLI) and Swing GUI. The project demonstrates core Object-Oriented Programming (OOP) principles like encapsulation, abstraction, and modular design, and incorporates file persistence using CSV and TXT formats.

📌 Features
✅ Common (Both Console & GUI):
Room types: Single, Double, Deluxe, Suite

Room availability tracking

Booking creation and room price calculation

File-based persistence: Bookings saved to bookings.csv

View all current bookings

Cancel an existing booking

Reset all rooms to "Available"

🖥️ Console Version
The console version provides a text-based interface with a menu-driven system:

Create a new booking

View available rooms

View all bookings

Cancel a booking

Save & load bookings to/from file

Exit application

🖱️ GUI Version (Swing)
Built using Java Swing for an interactive experience:

Horizontal button layout with modern UI styling

Dynamic forms to enter booking data

Scrollable views for displaying rooms and bookings

Auto-generated receipts (receipt_<name>_<room>.txt) after booking

Validation for user inputs

File-based persistence using bookings.csv

📂 File Structure
cpp
Copy
Edit
HotelBookingSystem/
├── HotelGUI.java       // GUI-based version using Swing
├── HotelConsole.java   // Console-based version
├── Booking.java        // Booking model (name, room, nights, total)
├── Room.java           // Room model (number, type, price, availability)
├── bookings.csv        // Stores booking data (persistent)
├── receipt_<name>.txt  // Generated per booking
🛠️ Technologies Used
Java 17+

Java Swing (GUI)

OOP Concepts (Encapsulation, Classes, Methods)

File Handling (CSV, TXT)

Exception Handling

🚀 How to Run
Console Version
bash
Copy
Edit
javac HotelConsole.java
java HotelConsole
GUI Version
bash
Copy
Edit
javac HotelGUI.java
java HotelGUI
Note: Make sure Room.java and Booking.java are in the same directory.

🎯 Future Enhancements (Ideas)
Login system (Admin vs Guest)

Date-based booking (check-in/check-out)

Add payment simulation (dummy payment gateway)

Database integration (MySQL/SQLite)

Sort/filter bookings

Dark mode for GUI
