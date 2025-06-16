import java.util.*;
public class Room {
    private int roomNumber;
    private String Roomtype;
    private double PricePerNight;
    private boolean isAvailable;

    public Room(int roomNumber,String Roomtype,double PricePerNight){
        this.roomNumber=roomNumber;
        this.Roomtype=Roomtype;
        this.PricePerNight=PricePerNight;
        this.isAvailable= true;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public String getRoomtype(){
        return Roomtype;
    }
    public double getPricePerNight(){
        return PricePerNight;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void setAvailable(boolean available){
        isAvailable=available;
    }
    public void displayInfo(){
        System.out.println("Room "+ roomNumber +" | Type: " + Roomtype +" | Price $"+ PricePerNight+" | Available: " + (isAvailable ? "Yes":"No"));
    }
}
