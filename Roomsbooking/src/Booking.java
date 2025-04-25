
import java.util.InputMismatchException;
import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   // Example service class
        Customer cu = new Customer();
        Hotel hot = new Hotel ();
        Review rev = new Review ();
        Admin ad = new Admin();
        
        while (true) {
         try {
        	System.out.println("\nHotel Booking System:");
            System.out.println("1. Register Customer");
            System.out.println("2. Login Customer");
            System.out.println("3. View Hotels");
            System.out.println("4. Available Rooms");
            System.out.println("5. Book Room");
            System.out.println("6. Leave a Review");
            System.out.println("7. admin login");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            // Consume newline
         
        	 
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    cu.registerCustomer( name, email, phone,password);
                    break;
                
                case 2:
                    System.out.print("Enter Email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();
                    cu.loginCustomer(loginEmail, loginPassword);
                    break;

                case 3:
                    hot.listHotels();
                    break;
                    
                case 4:
                	hot.checkRoomAvailability(choice);
                	break;

                case 5:
                	Room rm = new Room();
                    System.out.print("Enter Hotel ID: ");
                    int hotelId = scanner.nextInt();
                    System.out.print("Enter Room ID: ");
                    scanner.nextLine(); // Consume newline
                    int roomId = scanner.nextInt();
                    rm.bookRoom(hotelId,roomId);
                    break;

                case 6:
                    System.out.print("Enter Hotel ID: ");
                    int reviewHotelId = scanner.nextInt();
                    System.out.print("Enter Rating (1-5): ");
                    int rating = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Comment: ");
                    String comment = scanner.nextLine();
                    rev.viewReviews(reviewHotelId);
                    break;

                case 7:
                	 System.out.print("Enter Admin Email: ");
                     String email1 = scanner.nextLine();
                     System.out.print("Enter Admin Password: ");
                     String password1 = scanner.nextLine();
                     ad.loginAdmin( email1, password1);
                     ad.viewAllCustomers();
                     
                   
                     break;
                
                case 8:
                   System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 8.");
                    break;
                                 
            }
          }
            catch(InputMismatchException e)
            {
            	System.out.println("invalid input , please  enter number");
                 scanner.next();
            }
            

              
            }
        }
    }



