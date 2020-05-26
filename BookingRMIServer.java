import java.rmi.Naming;

public class BookingRMIServer {
	public BookingRMIServer() {
	     try {
	      BookingInterface bookingObjectToReturn = new  BookingInterfaceImplementation();
	      
	       Naming.rebind("rmi://192.168.43.212:1099/BookingService", bookingObjectToReturn);
			System.out.println("Server started...");

	     } catch (Exception e) {
	       System.out.println("Trouble:::: " + e);
	     }
	   }

	   public static void main(String args[]) {
	     new BookingRMIServer();
	   }

}
