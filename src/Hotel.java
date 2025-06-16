import java.util.*;
public class Hotel {
    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;

    public ArrayList<Room> getRooms() {
        return rooms;
    }


    public Hotel(){
        rooms = new ArrayList<>();
        customers = new ArrayList<>();
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public void displayAllRooms(){
        System.out.println("------Rooms------");
        for(Room room:rooms){
            room.displayInfo();
        }
    }
    public boolean bookRoom(int roomNumber,String customerName,String contact){
        Scanner sc = new Scanner(System.in);
        for(Room room:rooms){
            if(room.getRoomNumber()==roomNumber && room.isAvailable()){
                System.out.println("Enter the number of nights: ");
                int nights = sc.nextInt();
                room.setAvailable(false);
                Customer customer  = new Customer(customerName,contact,roomNumber,nights);
                customers.add(customer);
                printInvoice(customer, room);
                System.out.println("Booking Successful!");
                customer.displayInfo();

                double totalCost = room.getPricePerNight()*nights;
                System.out.println("Total Bill: $" + totalCost);
                return true;
            }
        }
        System.out.println("Booking Failed: Room is either not available or does not exist.");
        return false;
    }

    public boolean cancelBooking(int roomNumber){
        for(Room room : rooms){
            if(room.getRoomNumber()==roomNumber){
                if(room.isAvailable()){
                    System.out.println("Room is already available, No booking to cancel");
                    return false;
                }
                room.setAvailable(true);

            Iterator<Customer> iterator = customers.iterator();
            while(iterator.hasNext()){
                Customer customer=iterator.next();
                if(customer.getBookedRoomNumber()==roomNumber){
                    iterator.remove();
                    System.out.println("Bookin for Room"+ roomNumber+" has been cancelled");
                    return true;
                }
            }
            System.out.println("No customer found for this room");
            return false;
            }
        }
        System.out.println("Room number not found");
        return false;
    }


    public void displayallBookings(){
        if(customers.isEmpty()){
            System.out.println("No Bookings yet!");
        }else{
            System.out.println("\n All Bookings");
            for(Customer customer : customers){
                customer.displayInfo();
            }
        }
    }

    public void printInvoice(Customer customer, Room room) {
        System.out.println("\n====== Booking Invoice ======");
        System.out.println("Customer Name : " + customer.getName());
        System.out.println("Contact Number: " + customer.getContact());
        System.out.println("Room Number   : " + room.getRoomNumber());
        System.out.println("Room Type     : " + room.getRoomtype());
        System.out.println("Rate per Night: ₹" + room.getPricePerNight());
        System.out.println("Nights Stayed : " + customer.getNightsStayed());
        System.out.println("-----------------------------");
        double total = room.getPricePerNight() * customer.getNightsStayed();
        System.out.println("Total Bill    : ₹" + total);
        System.out.println("=============================");
    }

}
