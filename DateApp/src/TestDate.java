public class TestDate {
    public static void main(String[] args) {
        DateOperation op = new DateOperation();
        DateCheck currentDate = new DateCheck();
        boolean exit = false;

        System.out.println("=== Advanced Date Management System ===");
        
        // Initial setup of a date
        System.out.println("\n--- Initial Date Setup ---");
        System.out.print("Enter Day: ");
        int d = ConsoleInput.getInt();
        System.out.print("Enter Month: ");
        int m = ConsoleInput.getInt();
        System.out.print("Enter Year: ");
        int y = ConsoleInput.getInt();
        currentDate.setDate(d, m, y);

        while (!exit) {
            System.out.println("\n----------------------------------");
            System.out.print("CURRENT DATE: ");
            currentDate.display();
            System.out.println("----------------------------------");
            System.out.println("1. Add Days");
            System.out.println("2. Add Months");
            System.out.println("3. Compare with another Date");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = ConsoleInput.getInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of days to add: ");
                    int daysToAdd = ConsoleInput.getInt();
                    currentDate = op.addDays(currentDate, daysToAdd);
                    System.out.print("Success! New Date: ");
                    currentDate.display();
                    break;

                case 2:
                    System.out.print("Enter number of months to add: ");
                    int monthsToAdd = ConsoleInput.getInt();
                    currentDate = op.addMonths(currentDate, monthsToAdd);
                    System.out.print("Success! New Date: ");
                    currentDate.display();
                    break;

                case 3:
                    System.out.println("\n--- Setup Second Date for Comparison ---");
                    System.out.print("Enter Day: ");
                    int d2 = ConsoleInput.getInt();
                    System.out.print("Enter Month: ");
                    int m2 = ConsoleInput.getInt();
                    System.out.print("Enter Year: ");
                    int y2 = ConsoleInput.getInt();
                    
                    DateCheck date2 = new DateCheck();
                    date2.setDate(d2, m2, y2);
                    
                    System.out.println("\n--- Comparison Result ---");
                    op.compareDates(currentDate, date2);
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting System!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}