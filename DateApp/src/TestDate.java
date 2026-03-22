public class TestDate {
    public static void main(String[] args) {
        DateOperation op = new DateOperation();

        // 1. Setup the First Date
        System.out.println("--- Setup First Date ---");
        System.out.print("Enter Day: ");
        int d1 = ConsoleInput.getInt();
        System.out.print("Enter Month: ");
        int m1 = ConsoleInput.getInt();
        System.out.print("Enter Year: ");
        int y1 = ConsoleInput.getInt();

        DateCheck date1 = new DateCheck();
        date1.setDate(d1, m1, y1);
        System.out.print("Validated Date 1: ");
        date1.display();

        // 2. Test totalDays (toDays)
        int total1 = op.totalDays(date1);
        System.out.println("Total days since 01/01/0001: " + total1);

        System.out.println("\n--------------------------");

        // 3. Test Add Days functionality
        System.out.print("How many days do you want to add to Date 1? ");
        int daysToAdd = ConsoleInput.getInt();
        DateCheck futureDate = op.addDays(date1, daysToAdd);
        System.out.print("New Date after adding " + daysToAdd + " days: ");
        futureDate.display();

        System.out.println("\n--------------------------");

        // 4. Setup a Second Date for Comparison
        System.out.println("--- Setup Second Date (for comparison) ---");
        System.out.print("Enter Day: ");
        int d2 = ConsoleInput.getInt();
        System.out.print("Enter Month: ");
        int m2 = ConsoleInput.getInt();
        System.out.print("Enter Year: ");
        int y2 = ConsoleInput.getInt();

        DateCheck date2 = new DateCheck();
        date2.setDate(d2, m2, y2);
        System.out.print("Validated Date 2: ");
        date2.display();

        // 5. Test Compare Dates
        System.out.println("\n--- Comparison Result ---");
        op.compareDates(date1, date2);
    }
}