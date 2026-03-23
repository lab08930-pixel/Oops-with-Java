/*public class TestDate {
    public static void main(String[] args) {
      //  DateOperation op = new DateOperation();
        Date currentDate = new Date();
        boolean exit = false;

        System.out.println("=== Advanced Date Management System ===");
        
        // Initial setup of a date
        System.out.println("\n--- Initial Date Setup ---");
        System.out.print("Enter Day: ");
        int day = ConsoleInput.getInt();
        System.out.print("Enter Month: ");
        int month = ConsoleInput.getInt();
        System.out.print("Enter Year: ");
        int year = ConsoleInput.getInt();
        currentDate.setDate(day, month, year);

        while (!exit) {
            System.out.println("\n----------------------------------");
            System.out.print("CURRENT DATE: ");
        //    currentDate.display();
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
                    currentDate = currentDate.addMonths(currentDate, monthsToAdd);
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
}*/

public class TestDate {
    public static void main(String[] args) {
        Date currentDate = new Date();
        boolean exit = false;

        System.out.println("=== Advanced Date Management System ===");
        
        System.out.println("\n--- Initial Date Setup ---");
        System.out.print("Enter Day: ");
        int day = ConsoleInput.getInt();
        System.out.print("Enter Month: ");
        int month = ConsoleInput.getInt();
        System.out.print("Enter Year: ");
        int year = ConsoleInput.getInt();
        currentDate.setDate(day, month, year);
        
        while (!exit) {
            System.out.println("\n----------------------------------");
            System.out.print("CURRENT DATE: ");
            System.out.println(currentDate.getDay()+"/"+currentDate.getMonth()+"/"+currentDate.getYear());
            System.out.println("----------------------------------");
            System.out.println("1. Add Days");
            System.out.println("2. Add Months");
            System.out.println("3. Add Years");
            System.out.println("4. Compare with another Date");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = ConsoleInput.getInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter days to add: ");
                    currentDate = currentDate.addDays(ConsoleInput.getInt());
                    System.out.print("Updated Date: ");
                    display(currentDate);
                    break;

                case 2:
                    System.out.print("Enter months to add: ");
                    currentDate = currentDate.addMonths(ConsoleInput.getInt());
                    System.out.print("Updated Date: ");
                    display(currentDate);
                    break;

                case 3:
                    System.out.print("Enter years to add: ");
                    currentDate = currentDate.addYears(ConsoleInput.getInt());
                    System.out.print("Updated Date: ");
                    display(currentDate);
                    break;

                case 4:
                    System.out.println("\n--- Enter Date to Compare ---");
                    Date otherDate = new Date();
                    System.out.print("Day: "); int d2 = ConsoleInput.getInt();
                    System.out.print("Month: "); int m2 = ConsoleInput.getInt();
                    System.out.print("Year: "); int y2 = ConsoleInput.getInt();
                    otherDate.setDate(d2, m2, y2);
                    
                    long diff = currentDate.getDifference(otherDate);
                    System.out.println("Difference: " + diff + " days.");
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting System!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    

    public static void display(Date currentDate) {
        System.out.print("CURRENT DATE: ");
        System.out.println(currentDate.getDay() + "/" + currentDate.getMonth() + "/" + currentDate.getYear());
    }
}