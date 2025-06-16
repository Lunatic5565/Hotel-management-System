import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class HotelGUI {
    private static final String FILE_NAME = "bookings.csv";

    static ArrayList<Booking> bookings = new ArrayList<>();

    static ArrayList<Room> rooms = new ArrayList<>();

    static {
        rooms.add(new Room(101, "Single", 1000));
        rooms.add(new Room(102, "Double", 1500));
        rooms.add(new Room(103, "Suite", 2500));
        rooms.add(new Room(104, "Deluxe", 2000));
    }


    public static String getRoomType(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                return r.getRoomtype();
            }
        }
        return "Unknown";
    }


    public static void cancelBooking() {
        JFrame cancelFrame = new JFrame("Cancel Booking");
        cancelFrame.setSize(350, 200);
        cancelFrame.setLocationRelativeTo(null);

        JPanel cancelPanel = new JPanel();
        cancelPanel.setLayout(new GridLayout(3, 2, 10, 10));
        cancelPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        cancelPanel.add(new JLabel("Customer Name: "));
        JTextField nameField = new JTextField();
        cancelPanel.add(nameField);

        cancelPanel.add(new JLabel("Room Number: "));
        JTextField roomField = new JTextField();
        cancelPanel.add(roomField);

        JButton cancelButton = new JButton("Cancel Booking");
        cancelButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String roomStr = roomField.getText().trim();

            if (name.isEmpty() || roomStr.isEmpty()) {
                JOptionPane.showMessageDialog(cancelFrame, "Please fill all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int roomNumber = Integer.parseInt(roomStr);
                boolean bookingFound = false;

                for (int i = 0; i < bookings.size(); i++) {
                    Booking booking = bookings.get(i);
                    if (booking.getCustomerName().equalsIgnoreCase(name) && booking.getRoomNumber() == roomNumber) {
                        bookings.remove(i);
                        for (Room room : rooms) {
                            if (room.getRoomNumber() == roomNumber) {
                                room.setAvailable(true);
                                break;
                            }
                        }
                        saveBookingsToFile(); // ✅ Add this line
                        bookingFound = true;
                        saveBookingsToFile(); // Save updated bookings list to CSV
                        JOptionPane.showMessageDialog(cancelFrame, "✅ Booking cancelled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                }

                if (!bookingFound) {
                    JOptionPane.showMessageDialog(cancelFrame, "Booking not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(cancelFrame, "Room number must be a number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelPanel.add(cancelButton);
        cancelFrame.add(cancelPanel);
        cancelFrame.setVisible(true);
    }

    public static void saveBookingsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Booking booking : bookings) {
                writer.println(booking.toCSV());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving bookings: " + e.getMessage());
        }
    }

    public static void loadBookingsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip blank lines
                try {
                    Booking b = Booking.fromCSV(line);
                    bookings.add(b);

                    // Also mark the room as unavailable
                    for (Room r : rooms) {
                        if (r.getRoomNumber() == b.getRoomNumber()) {
                            r.setAvailable(false);
                            break;
                        }
                    }

                } catch (Exception ex) {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading bookings: " + e.getMessage());
        }
    }



    public static void showAllBookings() {
        JFrame frame = new JFrame("All Bookings");
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(false);

        if (bookings.isEmpty()) {
            textArea.setText("No bookings yet.");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Name         Room  Nights  Total\n");
            sb.append("-------------------------------------\n");
            for (Booking b : bookings) {
                sb.append(String.format("%-12s %-5d %-7d ₹%.2f\n",
                        b.getCustomerName(),
                        b.getRoomNumber(),
                        b.getNights(),
                        b.getTotal()));
            }
            textArea.setText(sb.toString());
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public static void generateRecipt(Booking booking){
        String fileName = "recipt_" + booking.getCustomerName().replaceAll("\\s+", "_") +
                "_"+ booking.getRoomNumber() + ".txt";

        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            writer.println("\uD83C\uDFE8 Hotel Booking Receipt");
            writer.println("==============================");
            writer.println("Customer Name : " + booking.getCustomerName());
            writer.println("Room Number   : " + booking.getRoomNumber());
            writer.println("Room Type     : " + getRoomType(booking.getRoomNumber()));
            writer.println("Nights        : " + booking.getNights());
            writer.println("Total Amount  : ₹" + booking.getTotal());
            writer.println("==============================");
            writer.println("Thank you for choosing our hotel!");
            JOptionPane.showMessageDialog(null, "🧾 Receipt saved as: " + fileName, "Receipt Generated", JOptionPane.INFORMATION_MESSAGE);
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing receipt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void BookingForm() {
        JFrame formFrame = new JFrame("Room Booking Form");
        formFrame.setSize(350, 300);
        formFrame.setLocationRelativeTo(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Customer Name: "));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Room Number: "));
        JTextField roomField = new JTextField();
        formPanel.add(roomField);

        formPanel.add(new JLabel("Nights to Stay: "));
        JTextField nightsField = new JTextField();
        formPanel.add(nightsField);

        JButton bookButton = new JButton("Book Room");
        bookButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String roomStr = roomField.getText().trim();
            String nightsStr = nightsField.getText().trim();

            if (name.isEmpty() || roomStr.isEmpty() || nightsStr.isEmpty()) {
                JOptionPane.showMessageDialog(formFrame, "Please fill all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int roomNumber = Integer.parseInt(roomStr);
                int nights = Integer.parseInt(nightsStr);

                Room selectedRoom = null;
                for (Room r : rooms) {
                    if (r.getRoomNumber() == roomNumber) {
                        selectedRoom = r;
                        break;
                    }
                }

                if (selectedRoom == null) {
                    JOptionPane.showMessageDialog(formFrame, "Room not found!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!selectedRoom.isAvailable()) {
                    JOptionPane.showMessageDialog(formFrame, "Room is already booked!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedRoom.setAvailable(false);
                    double total = selectedRoom.getPricePerNight() * nights;
                    Booking newBooking = new Booking(name, roomNumber, nights, total);
                    bookings.add(newBooking);
                    generateRecipt(newBooking); // NEW: Save receipt to file
                    saveBookingsToFile(); // Save the booking to CSV


                    String message = "✅ Booking Successful!\n"
                            + "Name: " + name + "\n"
                            + "Room No: " + roomNumber + "\n"
                            + "Room Type: " + selectedRoom.getRoomtype() + "\n"
                            + "Nights: " + nights + "\n"
                            + "Total: ₹" + total;

                    JOptionPane.showMessageDialog(formFrame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(formFrame, "Room and Nights must be numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        formPanel.add(bookButton);
        formFrame.add(formPanel);
        formFrame.setVisible(true);
    }

    public static void resetRoomAvailability() {
        for (Room r : rooms) {
            r.setAvailable(true);
        }
        JOptionPane.showMessageDialog(null, "All rooms have been reset to available!", "Reset Successful", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showAllRooms() {
        JFrame viewFrame = new JFrame("All Rooms");
        viewFrame.setSize(400, 300);
        viewFrame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append("Room No  Type     Price   Available\n");
        sb.append("-------------------------------------\n");
        for (Room r : rooms) {
            sb.append(String.format("%-8d %-8s ₹%-8.2f %-10s\n",
                    r.getRoomNumber(),
                    r.getRoomtype(),
                    r.getPricePerNight(),
                    r.isAvailable() ? "Yes" : "No"));
        }

        textArea.setText(sb.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        viewFrame.add(scrollPane);
        viewFrame.setVisible(true);
    }

    public static void main(String[] args) {
        loadBookingsFromFile();
        JFrame frame = new JFrame("Hotel Booking System");
        frame.setSize(1100, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel welcomelabel = new JLabel("Welcome to Hotel Booking System", JLabel.CENTER);
        welcomelabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(welcomelabel, BorderLayout.NORTH);

        JButton startbutton = new JButton("Start Booking");
        startbutton.setFont(new Font("Arial", Font.BOLD, 18));
        startbutton.setBackground(new Color(30, 144, 255));
        startbutton.setForeground(Color.WHITE);
        startbutton.setFocusPainted(false);
        startbutton.setPreferredSize(new Dimension(200, 50));
        startbutton.addActionListener(e -> BookingForm());

        JButton viewRoomsButton = new JButton("View All Rooms");
        viewRoomsButton.setFont(new Font("Arial", Font.BOLD, 18));
        viewRoomsButton.setBackground(new Color(34, 139, 34));
        viewRoomsButton.setForeground(Color.WHITE);
        viewRoomsButton.setFocusPainted(false);
        viewRoomsButton.setPreferredSize(new Dimension(200, 50));
        viewRoomsButton.addActionListener(e -> showAllRooms());

        JButton resetRoomsButton = new JButton("Reset Rooms");
        resetRoomsButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetRoomsButton.setBackground(new Color(178, 34, 34));
        resetRoomsButton.setForeground(Color.WHITE);
        resetRoomsButton.setFocusPainted(false);
        resetRoomsButton.setPreferredSize(new Dimension(200, 50));
        resetRoomsButton.addActionListener(e -> resetRoomAvailability());

        JButton viewBookingsButton = new JButton("View Bookings");
        viewBookingsButton.setFont(new Font("Arial", Font.BOLD, 18));
        viewBookingsButton.setBackground(new Color(255, 140, 0)); // Dark Orange
        viewBookingsButton.setForeground(Color.WHITE);
        viewBookingsButton.setFocusPainted(false);
        viewBookingsButton.setPreferredSize(new Dimension(200, 50));

        JButton cancelBookingButton = new JButton("Cancel Booking");
        cancelBookingButton.setFont(new Font("Arial", Font.BOLD, 18));
        cancelBookingButton.setBackground(new Color(255, 165, 0));  // Orange
        cancelBookingButton.setForeground(Color.WHITE);
        cancelBookingButton.setFocusPainted(false);
        cancelBookingButton.setPreferredSize(new Dimension(200, 50));
        cancelBookingButton.addActionListener(e -> cancelBooking());




        JPanel buttonPanel = new JPanel(new GridLayout(1,4,10,10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        buttonPanel.add(startbutton);
        buttonPanel.add(viewRoomsButton);
        buttonPanel.add(resetRoomsButton);
        buttonPanel.add(viewBookingsButton);
        buttonPanel.add(cancelBookingButton);  // Add to button panel


        viewBookingsButton.addActionListener(e -> showAllBookings());



        panel.add(buttonPanel, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);

        Dimension buttonSize = new Dimension(180, 50);
        startbutton.setPreferredSize(buttonSize);
        viewRoomsButton.setPreferredSize(buttonSize);
        resetRoomsButton.setPreferredSize(buttonSize);
        cancelBookingButton.setPreferredSize(buttonSize); // optional

    }
}
