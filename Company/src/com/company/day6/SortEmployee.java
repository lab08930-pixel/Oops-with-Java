package com.company.day6;
import src.org.oops.utils.*;
public class SortEmployee {

    /**
     * Master Sort Method: Handles both Ascending and Descending logic
     */
    private static void sortEmployees(Employee[] arr, int size, boolean ascending) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                int comparison = arr[j].getName().compareTo(arr[j + 1].getName());
                
                // If ascending, swap if j > j+1. If descending, swap if j < j+1.
                boolean shouldSwap = ascending ? (comparison > 0) : (comparison < 0);

                if (shouldSwap) {
                    Employee temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public static void filterSortAndDisplay(LinkedList objList, String typeLabel) {
        Employee[] filtered = new Employee[objList.maxCount];
        int count = 0;

        for (int i = 0; i < objList.maxCount; i++) {
            Employee emp = (Employee) objList.getNode(i);
            boolean match = false;

            // Manual type checking to avoid Class<?> reflection
            if (typeLabel.equalsIgnoreCase("Manager") && emp instanceof Manager) match = true;
            else if (typeLabel.equalsIgnoreCase("Engineer") && emp instanceof Engineer) match = true;
            else if (typeLabel.equalsIgnoreCase("SalesPerson") && emp instanceof SalesPerson) match = true;

            if (match) {
                filtered[count++] = emp;
            }
        }

        if (count == 0) {
            System.out.println("No " + typeLabel.toLowerCase() + "s found in the list!\n");
            return;
        }

        sortEmployees(filtered, count, true); // Default to ascending for specific types

        System.out.println("\n===== Sorted " + typeLabel + "s (by Name) =====");
        for (int i = 0; i < count; i++) {
            System.out.println(filtered[i].display());
        }
        System.out.println();
    }

    public static void sortAndDisplayAll(LinkedList objList, boolean ascending) {
        if (objList.maxCount == 0) {
            System.out.println("No employees to sort!\n");
            return;
        }

        Employee[] allEmployees = new Employee[objList.maxCount];
        for (int i = 0; i < objList.maxCount; i++) {
            allEmployees[i] = (Employee) objList.getNode(i);
        }

        sortEmployees(allEmployees, objList.maxCount, ascending);

        String orderLabel = ascending ? "Ascending" : "Descending";
        System.out.println("\n===== All Employees (" + orderLabel + " Order) =====");
        for (int i = 0; i < objList.maxCount; i++) {
            System.out.println(allEmployees[i].display());
        }
        System.out.println();
    }
}
