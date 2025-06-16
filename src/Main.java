import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel myHotel = new Hotel();

        myHotel.addRoom(new Room(101, "Single", 1500.0));
        myHotel.addRoom(new Room(102, "Double", 2500.0));
        myHotel.addRoom(new Room(103, "Suite", 4000.0));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hotel Menu ---");
            System.out.println("1. Show all rooms");
            System.out.println("2. Book a room");
            System.out.println("3. View All Bookings");
            System.out.println("4. Cancel booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    myHotel.displayAllRooms();
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = sc.nextInt();
                    sc.nextLine(); // clear newline

                    // Check if the room exists and is available
                    boolean isRoomValid = false;
                    for (Room room : myHotel.getRooms()) {
                        if (room.getRoomNumber() == roomNumber) {
                            if (room.isAvailable()) {
                                isRoomValid = true;
                            } else {
                                System.out.println("Room is already booked.");
                            }
                            break;
                        }
                    }

                    if (isRoomValid) {
                        System.out.print("Enter your name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter your contact number: ");
                        String contact = sc.nextLine();
                        myHotel.bookRoom(roomNumber, name, contact);
                    } else {
                        System.out.println("Room not found or unavailable. Try again.");
                    }
                    break;
                case 3:
                    myHotel.displayallBookings();
                    break;

                case 4:
                    System.out.print("Enter room number to cancel booking: ");
                    int cancelRoom = sc.nextInt();
                    sc.nextLine();
                    myHotel.cancelBooking(cancelRoom);
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;


                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
