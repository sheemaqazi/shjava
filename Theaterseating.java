import java.util.Scanner;

public class Theaterseating {
    static char[][] seats = new char[5][6]; // 5 rows and 6 seats per row

    // Initialize seating chart
    public static void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'A'; // 'A' stands for Available seat
            }
        }
    }

    // Display seating chart
    public static void displaySeats() {
        System.out.println("Seating Chart:");
        System.out.println("Seat 1 Seat 2 Seat 3 Seat 4 Seat 5 Seat 6");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i + 1) + " ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + "      ");
            }
            System.out.println();
        }
    }

    // Book a seat
    public static void bookSeat(int row, int seat) {
        if (seats[row - 1][seat - 1] == 'B') {
            System.out.println("Sorry, this seat is already booked!");
        } else {
            seats[row - 1][seat - 1] = 'B'; // 'B' stands for Booked seat
            System.out.println("Seat booked successfully!");
        }
    }

    // Cancel a booking
    public static void cancelBooking(int row, int seat) {
        if (seats[row - 1][seat - 1] == 'A') {
            System.out.println("This seat is already available.");
        } else {
            seats[row - 1][seat - 1] = 'A'; // Make the seat available again
            System.out.println("Booking canceled successfully!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSeats(); // Initialize the seating chart

        while (true) {
            System.out.println("--- Theater Seating Management ---");
            System.out.println("1. Display Seating Chart");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    System.out.print("Enter Row Number to book (1-5): ");
                    int rowToBook = scanner.nextInt();
                    System.out.print("Enter Seat Number to book (1-6): ");
                    int seatToBook = scanner.nextInt();
                    bookSeat(rowToBook, seatToBook);
                    break;
                case 3:
                    System.out.print("Enter Row Number to cancel (1-5): ");
                    int rowToCancel = scanner.nextInt();
                    System.out.print("Enter Seat Number to cancel (1-6): ");
                    int seatToCancel = scanner.nextInt();
                    cancelBooking(rowToCancel, seatToCancel);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}