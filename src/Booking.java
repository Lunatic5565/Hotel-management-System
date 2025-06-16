public class Booking {
    private String customerName;
    private int roomNumber;
    private int nights;
    private double total;

    public Booking(String customerName, int roomNumber, int nights, double total) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNights() {
        return nights;
    }

    public double getTotal() {
        return total;
    }

    public String toCSV() {
        return customerName + "," + roomNumber + "," + nights + "," + total;
    }

    public static Booking fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid booking CSV line: " + line);
        }

        String name = parts[0].trim();
        int roomNumber = Integer.parseInt(parts[1].trim());
        int nights = Integer.parseInt(parts[2].trim());
        double total = Double.parseDouble(parts[3].trim());
        return new Booking(name, roomNumber, nights, total);
    }
}
