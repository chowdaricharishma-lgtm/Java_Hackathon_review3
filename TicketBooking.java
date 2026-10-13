class TicketBooking {
    private String customerName;
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    private String bookingStatus;
    private double totalAmount;
    private double discount;
    private double finalAmount;

    // Default constructor
    public TicketBooking() {
        customerName = "";
        movieName = "";
        ticketPrice = 0.0;
        numberOfTickets = 0;
        bookingStatus = "Pending";
    }

    // Parameterized constructor
    public TicketBooking(String customerName, String movieName,
                         double ticketPrice, int numberOfTickets) {
        this.customerName = customerName.toUpperCase();
        this.movieName = movieName.toUpperCase();
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        processBooking();
    }

    // Overloaded method with default ticket price
    public void bookTicket(String customerName, String movieName,
                           int numberOfTickets) {
        this.customerName = customerName.toUpperCase();
        this.movieName = movieName.toUpperCase();
        this.ticketPrice = 200.00;
        this.numberOfTickets = numberOfTickets;
        processBooking();
    }

    // Overloaded method with custom ticket price
    public void bookTicket(String customerName, String movieName,
                           double ticketPrice, int numberOfTickets) {
        this.customerName = customerName.toUpperCase();
        this.movieName = movieName.toUpperCase();
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        processBooking();
    }

    // Calculate booking amount
    private void processBooking() {
        if (numberOfTickets <= 0 || ticketPrice <= 0) {
            bookingStatus = "Booking Failed: Invalid Details";
            totalAmount = 0.0;
            discount = 0.0;
            finalAmount = 0.0;
            return;
        }

        bookingStatus = "Booking Successful";
        totalAmount = ticketPrice * numberOfTickets;

        if (numberOfTickets >= 5) {
            discount = totalAmount * 0.10;
        } else {
            discount = 0.0;
        }

        finalAmount = totalAmount - discount;
    }

    public boolean compareCustomerName(String otherName) {
        return customerName.equalsIgnoreCase(otherName.trim());
    }

    // Display complete summary
    public void displaySummary() {
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Movie Name      : " + movieName);

        if (numberOfTickets == 5) {
            System.out.printf("Ticket Price    : Rs. %.2f%n", ticketPrice);
        }

        System.out.println("Number of Tickets: " + numberOfTickets);

        if (bookingStatus.equals("Booking Successful")) {
            System.out.println("Booking Status  : " + bookingStatus);
            System.out.printf("Total Amount    : Rs. %.2f%n", totalAmount);
            System.out.printf("Discount        : Rs. %.2f%n", discount);
            System.out.printf("Final Amount    : Rs. %.2f%n", finalAmount);
        } else {
            System.out.println("Booking Status  : " + bookingStatus);
        }

        System.out.println();
    }

    // Display only basic booking details
    public void displayBasicDetails() {
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Movie Name      : " + movieName);
        System.out.println("Number of Tickets: " + numberOfTickets);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("========== CINEMA TICKET BOOKING ==========");
        System.out.println();
        TicketBooking booking1 =
            new TicketBooking("sneha", "avatar", 200.00, 5);

        booking1.displaySummary();
        TicketBooking booking2 = new TicketBooking();
        booking2.bookTicket("arjun", "avatar", 2);

        booking2.displayBasicDetails();
        boolean result = booking1.compareCustomerName("SNEHA");
        System.out.println();
        System.out.println("Customer name matches: " + result);
    }
}
