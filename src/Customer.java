public class Customer {
    private String name;
    private String contact;
    private int bookedRoomNumber;
    private int nightsStayed;

    public Customer(String name, String contact, int bookedRoomNumber,int nightsStayed){
        this.name=name;
        this.contact=contact;
        this.bookedRoomNumber=bookedRoomNumber;
        this.nightsStayed=nightsStayed;
    }
    public int getBookedRoomNumber(){
        return bookedRoomNumber;
    }
    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public int getNightsStayed(){
        return nightsStayed;
    }

    public void displayInfo(){
        System.out.println("Customer: "+ name+ ", Contact: "+ contact+ ", Room Number: "+bookedRoomNumber+ ", Nights: "+ nightsStayed);
    }
}
